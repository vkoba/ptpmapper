package ru.vkoba.ptpmapper;

import java.lang.reflect.Method;

/**
 * Created by IntelliJ IDEA.
 * User: Ricoshet
 * Date: 25.11.12
 * Time: 0:14
 * To change this template use File | Settings | File Templates.
 */
public class PTPMapperImpl<T, K> implements PTPMapper {
    MapTable mapTable;

    public PTPMapperImpl() {
        mapTable = new FakeMapTable();
    }

    @Override
    public Object map(Object fromObject, Class toMapClass) {
        try {
            Object resultObject = toMapClass.newInstance();
            Class fromMapClass = fromObject.getClass();

            Method[] methods = fromMapClass.getMethods();
            for (Method fromMethod : methods) {

                if (!isObjectMethod(fromMethod) && (fromMethod.getName().substring(0, 3).equals("get") ||
                        fromMethod.getName().substring(0, 2).equals("is"))) {
                    String fromFieldName = getFieldNameFromSetter(fromMethod.getName());
                    String toFieldName = mapTable.getMapping(fromFieldName);
                    String toMethodName = getSetterFromFieldName(toFieldName);
                    Method toMethod = toMapClass.getMethod(toMethodName, fromMethod.getReturnType());
                    toMethod.invoke(resultObject, new Object[]{fromMethod.invoke(fromObject)});
                }
            }
            return (K) resultObject;
        } catch (Exception e) {
            throw new RuntimeException("Ошибка маппинга! Подробности:", e);
        }
    }

    private boolean isObjectMethod(Method fromMethod) {
        String methodName = fromMethod.getName();
        if (!methodName.equals("getClass")) {
            return false;
        }
        return true;
    }

    private String getFieldNameFromSetter(String methodName) {
        methodName = methodName.toLowerCase();
        boolean isIs = methodName.substring(0, 2).equals("is");
        if (isIs) {
            return methodName.substring(2);
        } else {
            return methodName.substring(3);
        }
    }

    private String getSetterFromFieldName(String fieldName) {
        String correctMethodName = getSetterName(fieldName);
        return correctMethodName;
    }

    private String getSetterName(String fieldName) {
        String firstLetter = fieldName.substring(0, 1);
        String otherLetter = fieldName.substring(1);
        String correctMethodName = firstLetter.toUpperCase() + otherLetter;
        String fullMethodName = "set" + correctMethodName;
        return fullMethodName;
    }
}
