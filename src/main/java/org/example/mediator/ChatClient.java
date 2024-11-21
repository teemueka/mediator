package org.example.mediator;

import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.scene.control.TextField;

public class ChatClient {
    private String username;
    private Mediator mediator;
    private TextArea chatArea;

    public ChatClient(String username, Mediator mediator) {
        this.username = username;
        this.mediator = mediator;
        this.mediator.registerClient(this);
    }

    public String getUsername() {
        return username;
    }

    public void receiveMessage(String sender, String message) {
        chatArea.appendText(sender + ": " + message + "\n");
    }

    public void start(Stage stage) {
        stage.setTitle("Chat - " + username);

        VBox root = new VBox(10);
        chatArea = new TextArea();
        chatArea.setEditable(false);

        TextField recipientField = new TextField();
        recipientField.setPromptText("Recipient username");

        TextField messageField = new TextField();
        messageField.setPromptText("Type your message here");

        Button sendButton = new Button("Send");

        sendButton.setOnAction(e -> {
            String recipient = recipientField.getText();
            String message = messageField.getText();
            if (!recipient.isEmpty() && !message.isEmpty()) {
                mediator.forwardMessage(message, username, recipient);
                chatArea.appendText("You to " + recipient + ": " + message + "\n");
                messageField.clear();
            }
        });

        root.getChildren().addAll(chatArea, recipientField, messageField, sendButton);

        stage.setScene(new Scene(root, 400, 300));
        stage.show();
    }
}
