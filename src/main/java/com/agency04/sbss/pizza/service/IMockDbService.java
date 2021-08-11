package com.agency04.sbss.pizza.service;

import java.io.IOException;
import java.util.List;

public interface IMockDbService {
    <T> List<T> getData(String key);
    void insertData(String key, Object data) throws IOException;
    <T> T getDataByPropertyValue(String key, String property, Object value, Class<T> t);
    boolean doesDataExists(String key, String property, Object value);
    int getNextId(String key);
    void updateData(String key, String property, Object data, Object value);
    void deleteData(String key, String property, Object data, Object value);
}
