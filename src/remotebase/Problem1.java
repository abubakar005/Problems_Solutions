package remotebase;

import java.util.*;
import java.util.stream.Collectors;

public class Problem1 {
}

class Chat {

    List<String> members;
    List<Integer> files;
    Map<Integer, String> message;

    public Chat() {
        members = new ArrayList();
        files = new ArrayList();
        message = new HashMap<>();
    }

    void add(String[] names) {
        members.addAll(Arrays.asList(names));
    }

    void add(int[] ids) {
        files.addAll(Arrays.stream(ids).boxed().collect(Collectors.toList()));
    }

    void add(int id, String newMessage) {
        message.put(id, newMessage);
    }

    void remove(String[] names) {

        Arrays.stream(names)
                .forEach(name -> {
                    if(members.contains(name))
                        members.remove(name);
                    else
                        System.out.println(String.format("Member with name %s does not exist ", name));
                });
    }

    void remove(int[] ids) {
        Arrays.stream(ids)
                .forEach(id -> {

                    int index = files.indexOf(id);

                    if(index != -1) {
                        files.remove(index);
                    } else
                        System.out.println(String.format("File with id %s does not exist ", id));
                });
    }

    void remove(int id) {
        if(message.containsKey(id)) {
            message.remove(id);
        } else
            System.out.println(String.format("Message with id %s does not exist ", id));
    }

    void printConversation() {

        System.out.println("Total number of members in the conversation are " + members.size());
        System.out.println("The names of these members are " + String.join(" ", members));
        System.out.println("Total number of files in the conversation are " + files.size());

        String messages = message.entrySet()
                .stream()
                .map(e -> "'" + e.getValue() + "'")
                .collect(Collectors.joining(" "));

        System.out.println("The messages in the conversation are " + messages);
    }
}
