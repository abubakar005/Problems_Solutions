public class HaversineDistance {

    /**
     * @param args
     * arg 1- latitude 1
     * arg 2 — latitude 2
     * arg 3 — longitude 1
     * arg 4 — longitude 2
     */
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        final int R = 6371; // Radius of the earth
        Double lat1 = 52.3756755;
        Double lon1 = 4.8668628;

        // destination
        Double lat2 = 53.4788305;
        Double lon2 = -2.2484721;

        Double latDistance = toRad(lat2-lat1);
        Double lonDistance = toRad(lon2-lon1);

        Double a = Math.sin(latDistance / 2) * Math.sin(latDistance / 2) +
                Math.cos(toRad(lat1)) * Math.cos(toRad(lat2)) *
                        Math.sin(lonDistance / 2) * Math.sin(lonDistance / 2);

        Double c = 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1-a));
        Double distance = R * c;

        System.out.println("The distance between two lat and long is (KM)::" + distance);

    }

    private static Double toRad(Double value) {
        return value * Math.PI / 180;
    }
}
