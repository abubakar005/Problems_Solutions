package hacker.rank.ventureDive;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class NumberOfMovies {

    // Not completed, need to check again

    static int getNumberOfMovies(String substr) {
        String url="https://jsonmock.hackerrank.com/api/moviesdata/search/?Title=%s";
        url = String.format(url, substr);

        int movieCount = 0;
        try {
            URL obj = new URL(url);
            HttpURLConnection con = (HttpURLConnection) obj.openConnection();

            // optional default is GET
            con.setRequestMethod("GET");

            int responseCode = con.getResponseCode();
            System.out.println("\nSending 'GET' request to URL : " + url);
            System.out.println("Response Code : " + responseCode);

            BufferedReader in = new BufferedReader(
                    new InputStreamReader(con.getInputStream()));
            String inputLine;
            StringBuffer response = new StringBuffer();

            while ((inputLine = in.readLine()) != null) {
                response.append(inputLine);
            }

            Pattern regex = Pattern.compile("(?<=al\\\"\\:)(.*?)(?=\\,)");
            Matcher m = regex.matcher(response.toString());
            movieCount = Integer.parseInt(m.group());
//            boolean b = m.matches();

        } catch (Exception e) {
            e.printStackTrace();
        }
        return movieCount;
    }

    public static void main(String[] args) throws IOException {
        Scanner in = new Scanner(System.in);
        final String fileName = System.getenv("OUTPUT_PATH");
        BufferedWriter bw = new BufferedWriter(new FileWriter(fileName));
        int res;
        String _substr;
        try {
            _substr = in.nextLine();
        } catch (Exception e) {
            _substr = null;
        }

        res = getNumberOfMovies(_substr);
        bw.write(String.valueOf(res));
        bw.newLine();

        bw.close();
    }

    /*
    static int getNumberOfMovies(String substr) {
        String url="https://jsonmock.hackerrank.com/api/moviesdata/search/?Title=%s";
        url = String.format(url, substr);

        int movieCount = 0;
        try {
            URL obj = new URL(url);
            HttpURLConnection con = (HttpURLConnection) obj.openConnection();

            // optional default is GET
            con.setRequestMethod("GET");

            int responseCode = con.getResponseCode();
            System.out.println("\nSending 'GET' request to URL : " + url);
            System.out.println("Response Code : " + responseCode);

            BufferedReader in = new BufferedReader(
                    new InputStreamReader(con.getInputStream()));
            String inputLine;
            StringBuffer response = new StringBuffer();

            while ((inputLine = in.readLine()) != null) {
                response.append(inputLine);
            }

            JSONObject json = new JSONObject(response.toString());
            String totalCount = json.getString("total");
            movieCount = Integer.parseInt(totalCount);
            in.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
        return movieCount;
    }
    */
}
