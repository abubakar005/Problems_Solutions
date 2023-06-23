package moniepoint;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class FoodOutletAPI {
    public static List<String> getRelevantFoodOutlets(String city, int maxCost) throws IOException, ParseException {
        List<String> foodOutlets = new ArrayList<>();
        int pageNumber = 1;
        boolean hasNextPage = true;

        while (hasNextPage) {
            String url = "https://jsonmock.hackerrank.com/api/food_outlets?city=" + city + "&page=" + pageNumber;
            URL apiUrl = new URL(url);
            HttpURLConnection connection = (HttpURLConnection) apiUrl.openConnection();
            connection.setRequestMethod("GET");

            StringBuilder response = new StringBuilder();
            try (BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()))) {
                String line;
                while ((line = reader.readLine()) != null) {
                    response.append(line);
                }
            }

            JSONParser parser = new JSONParser();
            JSONObject jsonResponse = (JSONObject) parser.parse(response.toString());
            int totalPages = Integer.parseInt(jsonResponse.get("total_pages").toString());
            JSONArray data = (JSONArray) jsonResponse.get("data");

            for (Object outletObj : data) {
                JSONObject outlet = (JSONObject) outletObj;
                int estimatedCost = Integer.parseInt(outlet.get("estimated_cost").toString());
                if (estimatedCost <= maxCost) {
                    String outletName = outlet.get("name").toString();
                    foodOutlets.add(outletName);
                }
            }

            if (pageNumber >= totalPages) {
                hasNextPage = false;
            } else {
                pageNumber++;
            }
        }

        return foodOutlets;
    }

    public static void main(String[] args) throws ParseException, IOException {
        String city = "Seattle";
        int maxCost = 100;

        try {
            List<String> foodOutlets = getRelevantFoodOutlets(city, maxCost);
            for (String outletName : foodOutlets) {
                System.out.println(outletName);
            }

            foodOutlets = main1(city, maxCost);
            for (String outletName : foodOutlets) {
                System.out.println(outletName);
            }
        } catch (IOException | ParseException e) {
            e.printStackTrace();
        }
    }

    public static List<String> main1(String city, int maxCost) throws IOException {

        List<String> foodOutlets = new ArrayList<>();
        int pageNumber = 1;
        boolean hasNextPage = true;
        String apiUrl;
        URL url;
        JSONObject jsonResponse;
        JSONParser parser = new JSONParser();

        while (hasNextPage) {

            apiUrl = "https://jsonmock.hackerrank.com/api/food_outlets?city="+city+"&page="+pageNumber;
            url = new URL(apiUrl);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");

            try {
                jsonResponse = (JSONObject) parser.parse(getResponseBody(connection));
            } catch (ParseException e) {
                throw new RuntimeException(e);
            }

            int totalPages = Integer.parseInt(jsonResponse.get("total_pages").toString());
            JSONArray data = (JSONArray) jsonResponse.get("data");

            for (Object outletObj : data) {
                JSONObject outlet = (JSONObject) outletObj;
                int estimatedCost = Integer.parseInt(outlet.get("estimated_cost").toString());

                if (estimatedCost <= maxCost)
                    foodOutlets.add(outlet.get("name").toString());
            }

            if(pageNumber >= totalPages)
                hasNextPage = false;

            pageNumber++;
        }

        return foodOutlets;
    }

    private static String getResponseBody(HttpURLConnection connection) throws IOException {
        StringBuilder response = new StringBuilder();

        try (BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()))) {
            String line;
            while ((line = reader.readLine()) != null) {
                response.append(line);
            }
        }
        return response.toString();
    }
}

