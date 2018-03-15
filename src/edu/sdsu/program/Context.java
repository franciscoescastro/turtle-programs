package edu.sdsu.program;

import java.util.HashMap;
import java.util.Map;

public class Context {
    private Map<String, Integer> map = new HashMap<String, Integer>();

    public void put(String key, Integer value) {
        map.put(key, value);
    }

    public Integer get(String key) {
        return map.get(key);
    }

    public void remove(String key) {
        map.remove(key);
    }

    public int size() {
        return map.size();
    }
}
