package ru.javarush.operation;

import org.yaml.snakeyaml.Yaml;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Alphabets {
    private static Alphabets INSTANCE;
    private Map<String, Object> mapOfAlphabets = new HashMap<>();
    private static final String PATH_TO_ALPHABETS = "src/main/resources/alphabets.yaml";
    private Alphabets() {}

    {
        InputStream inputStream = null;
        try{
            inputStream = new FileInputStream(PATH_TO_ALPHABETS);
            Yaml yaml = new Yaml();
            mapOfAlphabets = yaml.load(inputStream);
        } catch(FileNotFoundException e) {
            System.out.println("Not found file with alphabets " + e);
        }
    }

    public static Alphabets getInstance() {
        if(INSTANCE == null) {
            INSTANCE = new Alphabets();
        }
        return INSTANCE;
    }

    public Map<String, Object> getMapOfAlphabets() {
        return mapOfAlphabets;
    }

    public List<Character> getListAlphabetByKey(String key) {
        List<Character> resultList = new ArrayList<>();
        List<String> stringList = (List<String>) mapOfAlphabets.get(key);
        for(String s : stringList) {
            resultList.add(s.charAt(0));
        }
        return resultList;
    }
}
