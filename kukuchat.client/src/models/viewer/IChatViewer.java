package models.viewer;

import javafx.scene.Node;

/**
 * ИНтерфейс объекта отображения чата
 */
public interface IChatViewer {
    /**
     * Отдает объект отображающий чат
     * @return - графический объект отображающий чат
     */
    Node getViewerNode();

    /**
     * Получает сообщение и отображает его
     * @param messageDTLabel - метка времени сообщения
     * @param message - текст сообщения
     */
    void appendMess(String messageDTLabel, String userName, String message);
}
