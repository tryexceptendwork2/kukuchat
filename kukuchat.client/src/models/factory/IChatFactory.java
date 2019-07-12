package models.factory;

import models.setting.ILocalizationSetting;
import models.viewer.IChatViewer;

/**
 * Абстрактная фабрика для построения чата.
 * @autor Михаил
 * @version 0.1
 */
public interface IChatFactory {
    /**
     * Метод создания поля с настройками по местному времени и языку
     * @return объект соответствующий интефейсу {@link ILocalizationSetting}
     */
    ILocalizationSetting createLocalizationSetting();
    IChatViewer createChatView();
}