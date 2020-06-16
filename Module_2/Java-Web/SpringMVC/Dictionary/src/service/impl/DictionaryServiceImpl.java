package service.impl;

import service.DictionaryService;

import java.util.HashMap;
import java.util.Map;

public class DictionaryServiceImpl implements DictionaryService {
    private static Map<String, String> dictionary = new HashMap<>();
    static {
        dictionary.put("hello", "xin chào");
        dictionary.put("how", "như nào");
        dictionary.put("bitch", "con đĩ");
        dictionary.put("computer", "máy tính");
    }

    @Override
    public String findByWord(String word) {
        return dictionary.get(word.trim().toLowerCase());
    }
}
