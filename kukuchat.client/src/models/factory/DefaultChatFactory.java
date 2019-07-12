package models.factory;

import models.setting.DefaultLocalizationSetting;
import models.setting.ILocalizationSetting;
import models.viewer.IChatViewer;
import models.viewer.TextAreaChatViewer;
import models.viewer.WebViewChatView;

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

    @Override
    public IChatViewer createChatView() {
        return new WebViewChatView();
    }
}
