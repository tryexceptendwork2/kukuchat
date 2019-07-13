package chat.application;

import chat.application.controllers.Controller;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import models.ChatAppication;
import models.factory.DefaultChatFactory;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        FXMLLoader root = new FXMLLoader(Main.class.getResource("fxmlwindow/chat.application.fxml"));
        AnchorPane page = (AnchorPane)root.load();
        // получить ссылку на контроллер
        Controller controller = root.getController();
        // передать stage в контроллер
        controller.chatAppication = new ChatAppication(new DefaultChatFactory(), null);
        Node nodeView = controller.chatAppication.getChatViewer();
        AnchorPane.setTopAnchor(nodeView,0.0);
        AnchorPane.setRightAnchor(nodeView,25.0);
        AnchorPane.setLeftAnchor(nodeView,0.0);
        AnchorPane.setBottomAnchor(nodeView,25.0);
        nodeView.setLayoutX(0.0);
        nodeView.setLayoutY(0.0);

        page.getChildren().add(nodeView);

        primaryStage.setTitle("Hello World");
        primaryStage.setScene(new Scene(page, 300, 275));

        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
}
