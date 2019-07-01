package models;

import models.factory.IChatFactory;
import models.setting.ILocalizationSetting;

import java.util.Properties;

/**
 * Класс реализует работу чата.
 */
public class ChatAppication {
    /** Текст заголовка страницы чата*/
    private String chatListHTMLHead;
    /** Текст окончания страницы чата*/
    private String chatListHTMLFoot;
    /** Текст середины страницы чата*/
    private String chatListHTMLBody;

    /** Настройки по местному времени*/
    ILocalizationSetting localSetting;

    /**
     * Конструктор класса
     */
    public ChatAppication(){
        chatListHTMLHead = "<html><head><title>Ku Ku Chat</title><body>";
        chatListHTMLFoot = "</body></html>";
        chatListHTMLBody = "";
    }

    /**
     * Конструктор, в который передается нужная фабрика, создающая нужные объекты
     * @param factory - фабрика, которая создает нужные объекты
     */
    public ChatAppication(IChatFactory factory, Properties prop) {
        localSetting = factory.createLocalizationSetting();
        localSetting.setDateTimeFormatter(prop.getProperty("FormatDateTimeLabel", "HH:mm:ss"));
    }

    /**
     * Форматирует сообщение пользователя
     * @param message - текст сообщения
     * @param params - дополнительные параметры на будущее
     * @return - отформатированное сообщение пользователя
     */
    public String FormatedString(String message, Object[] params){
        return chatListHTMLBody = chatListHTMLBody + localSetting.getDateTimeMessLabel()+message+"<p>";
    }

    /**
     * Отдает сформированную страничку HTML для отображения на клиенте
     * @return - текст html
     */
    public String getChatListHTML(){
        return chatListHTMLHead+chatListHTMLBody+chatListHTMLFoot;
    }
}
