package models.viewer;

import javafx.scene.Node;
import javafx.scene.web.WebView;
import javafx.scene.web.WebEngine;

/**
 * Класс отображает чат в виде объекта {@link WebView}
 */
public class WebViewChatView implements IChatViewer {
    /** Объект WebView для отображения чата*/
    public WebView chatView;
    /** Объект WebEngine для отображения чата*/
    private WebEngine chatViewEngine;
    /** Текст заголовка страницы чата*/
    private String chatListHTMLHead;
    /** Текст окончания страницы чата*/
    private String chatListHTMLFoot;
    /** Текст середины страницы чата*/
    private String chatListHTMLBody;

    /**
     * Конструктор класса
     */
    public WebViewChatView(){
        chatListHTMLHead = "<html><head><title>Ku Ku Chat</title></head><body>";
        chatListHTMLFoot = "</body></html>";
        chatListHTMLBody = "";
        chatView = new WebView();
        chatViewEngine = chatView.getEngine();
    }

    /**
     * Отдает объект для отображения
     * @return - объект отображения чата
     */
    @Override
    public Node getViewerNode() {
        return chatView;
    }

    /**
     * Добавляет сообщение в чат
     * @param messageDTLabel - метка времени сообщения
     * @param message - текст сообщения
     */
    @Override
    public void appendMess(String messageDTLabel, String userName, String message) {
        chatListHTMLBody = chatListHTMLBody + messageDTLabel+"<b>"+ userName+"</b> &raquo; "+message+"<hr>";
        chatViewEngine.loadContent(chatListHTMLHead+chatListHTMLBody+chatListHTMLFoot);
    }
}
