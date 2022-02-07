package amazon;

import java.util.*;

public class TransactionLogs {

    Map<Integer, Integer> userTransactions = new HashMap<>();
    PriorityQueue<Integer> usersWithAtLeastThreshold = new PriorityQueue<>();
   // Set<Integer> uniqueUsersWithAtLeastThreshold = new HashSet<>();
    int threshold = 1;

    public static void main(String args[]) {

        TransactionLogs transactionLogs = new TransactionLogs();
        String[] logs = {"88 99 200", "88 99 300", "99 32 100", "12 12 15"};

        int[] response = transactionLogs.processLogs(logs);
        System.out.println(Arrays.toString(response));
    }

    public int[] processLogs(String[] logs) {

        int[] response;

        if(logs == null || logs.length == 0)
            return new int[0];

        int sender;
        int receiver;

        for(int i=0; i<logs.length; i++) {

            String[] transaction = logs[i].split(" ");
            sender = Integer.parseInt(transaction[0]);
            receiver = Integer.parseInt(transaction[1]);

            putUserTransaction(sender);

            if(sender != receiver)
                putUserTransaction(receiver);
        }

        response = new int[usersWithAtLeastThreshold.size()];
        int i = 0;

        while(!usersWithAtLeastThreshold.isEmpty())
            response[i++] = usersWithAtLeastThreshold.remove();

        return response;
    }

    private void putUserTransaction(int user) {

        if(userTransactions.containsKey(user)) {

            int transactionCount = userTransactions.get(user)+1;
            userTransactions.put(user, transactionCount);

            if(transactionCount == threshold)
                usersWithAtLeastThreshold.add(user);
        } else {
            userTransactions.put(user, 1);

            if(1 == threshold)
                usersWithAtLeastThreshold.add(user);
        }
    }
}
