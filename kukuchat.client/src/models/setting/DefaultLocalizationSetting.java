package models.setting;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Properties;

/**
 * Класс по умолчанию с локальными настройками. {@link ILocalizationSetting}
 * @autor Михаил
 * @version 0.1
 */
public class DefaultLocalizationSetting implements ILocalizationSetting {

    /** Поле с настроками форматирования */
    private DateTimeFormatter dtFormatter;
    /** Строковое поле для формата метки времени */
    private String strFormatter;

    /**
     * Конструктор по умолчанию
     */
    public DefaultLocalizationSetting(){
        strFormatter = "HH:mm:ss";
        dtFormatter = DateTimeFormatter.ofPattern(strFormatter);
    }
    /**
     * Конструктор по умолчанию
     * @param prop - передаваемые настроки
     */
    public DefaultLocalizationSetting(Properties prop){
        strFormatter = prop.getProperty("FormatDateTimeLabel", "HH:mm:ss");
        dtFormatter = DateTimeFormatter.ofPattern(strFormatter);
    }
    /**
     * Функция возвращает метку времени сообщения в нужном формате
     * @param messTime - метка времени сообщения
     * @return - сформированная строка с меткой времени и разными плюшками
     */
    @Override
    public String getDateTimeMessLabel(LocalDateTime messTime) {
        return "["+messTime.format(dtFormatter)+"] ";
    }
    /**
     * Функция возвращает метку времени сообщения в нужном формате. Берет текущую дату устройства.
     * @return - сформированная строка с меткой времени и разными плюшками
     */
    @Override
    public String getDateTimeMessLabel() {
        return getDateTimeMessLabel(LocalDateTime.now());
    }

    /**
     * Функция задает формат метки времени.
     * @param format - строка которая форматирует метку времени к нужному виду
     */
    @Override
    public void setDateTimeFormatter(String format) {
        if (format ==null || format==""){return;}
        strFormatter = format;
        dtFormatter = DateTimeFormatter.ofPattern(strFormatter);
    }

    /**
     * Функция возвращает строку формата метки времени.
     * @return - строка которая форматирует метку времени к нужному виду
     */
    @Override
    public String getDateTimeFormatter() {
        return strFormatter;
    }
}
