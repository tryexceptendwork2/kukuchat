package chat.application;

import javafx.event.ActionEvent;
import javafx.scene.control.TextField;
import javafx.scene.web.WebView;
import javafx.scene.web.WebEngine;
import models.ChatAppication;

public class Controller {
    public static ChatAppication chatAppication;

    public WebView lsChat;
    public TextField tbMessage;

    public void btSendMessage(ActionEvent actionEvent) {
        chatAppication.FormatedString(tbMessage.getText(),null);
        WebEngine webEngine = lsChat.getEngine();
        webEngine.loadContent(chatAppication.getChatListHTML());
    }
}
