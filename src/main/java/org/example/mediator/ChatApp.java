package org.example.mediator;

import javafx.application.Application;
import javafx.stage.Stage;

public class ChatApp extends Application {

    @Override
    public void start(Stage primaryStage) {
        MessageMediator mediator = new MessageMediator();

        ChatClient client1 = new ChatClient("Alice", mediator);
        ChatClient client2 = new ChatClient("Bob", mediator);
        ChatClient client3 = new ChatClient("Charlie", mediator);

        client1.start(new Stage());
        client2.start(new Stage());
        client3.start(new Stage());
    }

    public static void main(String[] args) {
        launch(args);
    }
}
