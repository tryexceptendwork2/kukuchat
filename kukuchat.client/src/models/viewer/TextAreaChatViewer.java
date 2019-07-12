package models.viewer;

import javafx.scene.Node;
import javafx.scene.control.TextArea;

/**
 * Класс отображает чат в виде объекта {@link TextArea}
 */
public class TextAreaChatViewer implements IChatViewer {
/** Объект TextArea для отображения чата*/
    public TextArea chatView;

    /**
     * Конструктор класса
     */
    public TextAreaChatViewer(){
        chatView = new TextArea();
        chatView.setEditable(false);
    }
    /**
     * Отдает объект отображения чата
     * @return
     */
    @Override
    public Node getViewerNode() {
        return chatView;
    }
    /**
     * Добавляет в чат сообщение для отображения
     * @param messageDTLabel - метка времени сообщения
     * @param message - текст сообщения
     */
    @Override
    public void appendMess(String messageDTLabel, String userName, String message) {
        chatView.appendText(messageDTLabel + userName + ": "+ message);
    }
}
