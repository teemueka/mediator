package org.example.mediator;

public interface Mediator {
    void forwardMessage(String message, String sender, String recipient);
    void registerClient(ChatClient client);
}
