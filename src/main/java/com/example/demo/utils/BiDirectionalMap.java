package com.example.demo.utils;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class BiDirectionalMap<KEY, VALUE> {

    public Map<KEY, VALUE> kvmap;
    public Map<VALUE, KEY> vkmap;

    public BiDirectionalMap() {
        this.kvmap = new HashMap<>();
        this.vkmap = new HashMap<>();
    }

    public BiDirectionalMap(Map<KEY, VALUE> kvmap) {
        this();
        for (KEY key : kvmap.keySet()) {
            this.kvmap.put(key, kvmap.get(key));
        }
    }

    public void put(KEY key, VALUE value) {
        this.kvmap.put(key, value);
        this.vkmap.put(value, key);
    }

    public Set<KEY> keys() {
        return this.kvmap.keySet();
    }

    public Set<VALUE> values() {
        return this.vkmap.keySet();
    }

    public VALUE getValueByKey(KEY key) {
        return this.kvmap.get(key);
    }

    public KEY getKeyByValue(VALUE value) {
        return this.vkmap.get(value);
    }

    public boolean containsKey(KEY key) {
        return this.kvmap.containsKey(key);
    }

    public boolean containsValue(VALUE value) {
        return this.vkmap.containsKey(value);
    }
}
