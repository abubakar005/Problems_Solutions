import java.util.*;

public class AuthenticationToken {


    public static void main(String[] args) {
        int expiryLimit = 3;
        List list1 = Arrays.asList(0,1,1);
        List list2 = Arrays.asList(1,1,5);
        //List list2 = Arrays.asList(0,2,2);
        List list3 = Arrays.asList(1,1,5);
        List list4 = Arrays.asList(1,2,7);

        String abc = new String();

        abc.replace("abc", "");



        List<List<Integer>> commands = Arrays.asList(list1, list2);

        int res = numberOfTokens(expiryLimit, commands);
        System.out.println(res);
    }

    public static int numberOfTokens(int expiryLimit, List<List<Integer>> commands) {

        if(commands == null || commands.isEmpty()) {
            return 0;
        }

        //maintain tokenid with expiry in a map
        Map<Integer, Integer> tokenIdToTokenExpiry = new HashMap<>();

        for (List<Integer> token : commands) {
            if(token.size() != 3){
                return 0;
            }
            //tokenCommand can be either 0 (get) or 1 (reset)
            Integer tokenCommand = token.get(0);
            Integer tokenId = token.get(1);
            Integer tokenTime = token.get(2);

            if(tokenCommand == 0){
                // Get command
                tokenIdToTokenExpiry.put(tokenId, tokenTime + expiryLimit);
            } else {
                //Reset command
                if(tokenIdToTokenExpiry.containsKey(tokenId)){
                    if(tokenTime <= tokenIdToTokenExpiry.get(tokenId)){
                        //If not expired, update token time with new value
                        tokenIdToTokenExpiry.put(tokenId, tokenTime + expiryLimit);
                    } else {
                        //if expired, remove token from map
                        tokenIdToTokenExpiry.remove(tokenId);
                    }
                }
            }
        }

        //find the last inputed tokentime and filter data based on expiry
        Integer lastTime = commands.get(commands.size() - 1).get(2);
        return (int) tokenIdToTokenExpiry.values().stream().filter(tokenTime ->  tokenTime >= lastTime).count();
    }
}
