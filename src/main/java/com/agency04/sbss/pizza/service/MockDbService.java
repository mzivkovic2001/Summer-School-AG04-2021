package com.agency04.sbss.pizza.service;

import com.fasterxml.jackson.core.util.DefaultPrettyPrinter;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;

@Service
public class MockDbService implements IMockDbService {
    private Map<String, Object> jsonData;
    private ObjectMapper mapper;
    private Path pathMap;
    private ObjectWriter writer;

    // reading and saving json file data as a hashmap
    @PostConstruct
    public void initIt() {
        mapper = new ObjectMapper();
        writer = mapper.writer(new DefaultPrettyPrinter());
        try {
            pathMap = Paths.get("../Summer-School-AG04-2021/src/main/resources/mock-data.json");
            jsonData = mapper.readValue(Files.newBufferedReader(
                    pathMap, StandardCharsets.UTF_8), HashMap.class);
        }
        catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    @Override
    public <T> List<T> getData(String key) {
        List<T> dataList = (List<T>) jsonData.get(key);
        return dataList;
    }

    @Override
    public void insertData(String key, Object data) throws IOException {
        List<Object> dataList = (List<Object>) jsonData.get(key);
        dataList.add(data);
        System.out.println(jsonData.get(key));
        try {
            writer.writeValue(pathMap.toFile(), jsonData);
            jsonData = mapper.readValue(Files.newBufferedReader(
                    pathMap, StandardCharsets.UTF_8), HashMap.class);
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    @Override
    public void updateData(String key, String property, Object data, Object value) {
        List<Map<String, Object>> dataList = (List<Map<String, Object>>) jsonData.get(key);
        Map<String, Object> elementForUpdate = dataList.stream()
                .filter((Map<String, Object> element) -> value.equals(element.get(property)))
                .findAny()
                .orElse(null);
        if (!elementForUpdate.isEmpty()) {
            int index = dataList.indexOf(elementForUpdate);
            Map<String, Object> dataToBeUpdated = mapper.convertValue(data, Map.class);
            dataList.set(index, dataToBeUpdated);
            System.out.println(jsonData.get(key));
            try {
                writer.writeValue(pathMap.toFile(), jsonData);
                jsonData = mapper.readValue(Files.newBufferedReader(
                        pathMap, StandardCharsets.UTF_8), HashMap.class);
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        } else {
            System.out.println(">>MockDbService: cannot update json file");
        }
    }

    @Override
    public void deleteData(String key, String property, Object data, Object value) {
        List<Map<String, Object>> dataList = (List<Map<String, Object>>) jsonData.get(key);
        Map<String, Object> elementForUpdate = dataList.stream()
                .filter((Map<String, Object> element) -> value.equals(element.get(property)))
                .findAny()
                .orElse(null);
        if (!elementForUpdate.isEmpty()) {
            int index = dataList.indexOf(elementForUpdate);
            dataList.remove(index);
            System.out.println(jsonData.get(key));
            try {
                writer.writeValue(pathMap.toFile(), jsonData);
                jsonData = mapper.readValue(Files.newBufferedReader(
                        pathMap, StandardCharsets.UTF_8), HashMap.class);
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        } else {
            System.out.println(">>MockDbService: cannot delete from a json file");
        }
    }

    @Override
    public <T> T getDataByPropertyValue(String key, String property, Object value, Class<T> t) {
        List<Map<String, Object>> dataList = (List<Map<String, Object>>) jsonData.get(key);
        Map<String, Object> returnObject = dataList.stream()
                .filter((Map<String, Object> element) -> value.equals(element.get(property)))
                .findAny()
                .orElse(null);
        return mapper.convertValue(returnObject, mapper.getTypeFactory().constructType(t));
    }

    @Override
    public boolean doesDataExists(String key, String property, Object value) {
        List<Map<String, Object>> dataList = (List<Map<String, Object>>) jsonData.get(key);
        boolean doesExist = dataList.stream()
                .anyMatch((Map<String, Object> element) -> value.equals(element.get(property)));
        return doesExist;
    }

    @Override
    public int getNextId(String key) {
        List<Map<String, Object>> dataList = (List<Map<String, Object>>) jsonData.get(key);
        int max = dataList.stream()
                .map(map->map.get("id"))
                .filter(Objects::nonNull)
                .mapToInt(value -> (int)value)
                .max()
                .orElse(0);
        return max + 1;
    }
}
