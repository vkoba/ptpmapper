package ru.vkoba.ptpmapper;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by IntelliJ IDEA.
 * User: Ricoshet
 * Date: 26.11.12
 * Time: 0:25
 * To change this template use File | Settings | File Templates.
 */
public class FakeMapTable implements MapTable {
    private Map<String, String> mapping = new HashMap<String, String>();

    public FakeMapTable() {
        mapping.put("value1", "mapValue1");
        mapping.put("value2", "mapValue2");
        mapping.put("value3", "mapValue3");
        mapping.put("value4", "mapValue4");
    }

    @Override
    public String getMapping(String fromFieldName) {
        return mapping.get(fromFieldName);
    }

    public Map getMapping() {
        return mapping;
    }

    public void setMapping(Map mapping) {
        this.mapping = mapping;
    }
}
