package models;

import models.factory.IChatFactory;
import models.setting.ILocalizationSetting;
import models.viewer.IChatViewer;

import javafx.scene.Node;
import java.util.Properties;

/**
 * Класс реализует работу чата.
 */
public class ChatAppication {

    /** Настройки по местному времени*/
    ILocalizationSetting localSetting;
    /** Отображение чата */
    IChatViewer chatView;

    private String userName;
    /**
     * Конструктор класса
     */
    public ChatAppication(){
        userName = "";
    }

    /**
     * Конструктор, в который передается нужная фабрика, создающая нужные объекты
     * @param factory - фабрика, которая создает нужные объекты
     */
    public ChatAppication(IChatFactory factory, Properties prop) {
        localSetting = factory.createLocalizationSetting();
        localSetting.setDateTimeFormatter("HH:mm:ss");
        chatView = factory.createChatView();
    }

    /**
     * Добавляет сообщение в чат
     * @param message - текст сообщения
     */
    public void appendMessage(String message){
        chatView.appendMess(localSetting.getDateTimeMessLabel(),userName,message);
    }

    /**
     * Отдает объект отображения чата
     * @return
     */
    public Node getChatViewer(){
        return chatView.getViewerNode();
    }

    public void setNickname(String nickname){
        userName = nickname;
    }
    public String getNickname(){
        return userName;
    }
}
