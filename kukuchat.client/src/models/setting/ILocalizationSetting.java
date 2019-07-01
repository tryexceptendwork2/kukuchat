package models.setting;

import java.time.LocalDateTime;

/**
 * Интерфейс для объектов с настройками по местному времени и возможно языку.
 * @autor Михаил
 * @version 0.1
 */
public interface ILocalizationSetting {
    /**
     * Функция возвращает метку времени сообщения в нужном формате
     * @param messTime - метка времени сообщения
     * @return - сформированная строка с меткой времени и разными плюшками
     */
    String getDateTimeMessLabel(LocalDateTime messTime);
    /**
     * Функция возвращает метку времени сообщения в нужном формате. Берет текущую дату устройства.
     * @return - сформированная строка с меткой времени и разными плюшками
     */
    String getDateTimeMessLabel();
    /**
     * Функция задает формат метки времени.
     * @param format - строка которая форматирует метку времени к нужному виду
     */
    void setDateTimeFormatter(String format);

    /**
     * Функция возвращает строку формата метки времени.
     * @return - строка которая форматирует метку времени к нужному виду
     */
    String getDateTimeFormatter();
}
