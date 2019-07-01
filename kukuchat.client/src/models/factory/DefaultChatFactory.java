package models.factory;

import models.setting.DefaultLocalizationSetting;
import models.setting.ILocalizationSetting;

import java.util.Properties;

/**
 * Фабрика по умочанию. Реализует интефейс: {@link IChatFactory}
 * @autor Киса Воробьянинов
 * @version 2.1
 */
public class DefaultChatFactory implements IChatFactory {
    /**
     * Создает объект с настройками местной даты времени
     * @return
     */
    @Override
    public ILocalizationSetting createLocalizationSetting() {
        return new DefaultLocalizationSetting();
    }
}
