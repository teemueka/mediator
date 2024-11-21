package org.example.mediator;

import java.util.HashMap;
import java.util.Map;

public class MessageMediator implements Mediator {

    private Map<String, ChatClient> clients = new HashMap<>();

    @Override
    public void forwardMessage(String message, String sender, String recipient) {
        if (clients.containsKey(recipient)) {
            clients.get(recipient).receiveMessage(sender, message);
        } else {
            System.out.println("Recipient not found: " + recipient);
        }
    }

    @Override
    public void registerClient(ChatClient client) {
        clients.put(client.getUsername(), client);
    }
}

