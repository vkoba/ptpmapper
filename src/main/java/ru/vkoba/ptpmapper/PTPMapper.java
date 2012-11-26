package ru.vkoba.ptpmapper;

/**
 * Created by IntelliJ IDEA.
 * User: Ricoshet
 * Date: 24.11.12
 * Time: 12:29
 * To change this template use File | Settings | File Templates.
 */
public interface PTPMapper<T, K> {
    K map(T o1, Class<K> toMapClass);
}
