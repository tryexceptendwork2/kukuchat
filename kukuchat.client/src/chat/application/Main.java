package chat.application;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import models.ChatAppication;
import models.factory.DefaultChatFactory;

import java.util.Properties;
import java.io.*;

public class Main extends Application {

    private String fStr= "";
    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("chat.application.fxml"));
        primaryStage.setTitle("Hello World");
        primaryStage.setScene(new Scene(root, 300, 275));
        primaryStage.show();
        Properties prop = new Properties();
        prop.setProperty("FormatDateTimeLabel","HH:mm");

        try(InputStream reader = new FileInputStream("config.xml"))
        {
            prop.loadFromXML(reader);
        }
        catch(IOException ex){

            System.out.println(ex.getMessage());
        }

        Controller.chatAppication = new ChatAppication(new DefaultChatFactory(), prop);
    }


    public static void main(String[] args) {
        launch(args);
    }
}
