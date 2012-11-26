package ru.vkoba.ptpmapper;

/**
 * Created by IntelliJ IDEA.
 * User: Ricoshet
 * Date: 26.11.12
 * Time: 0:26
 * To change this template use File | Settings | File Templates.
 */

/**
 * Интерфейс, отвечает за маппинг названия полей
 *
 */
public interface MapTable {
    /**
     * Возвращает маппинг для поля fromFieldName
     * @param fromFieldName имя поля, для которого ищется маппинг
     * @return
     */
    public String getMapping(String fromFieldName);
}
