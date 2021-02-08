package com.epam.engx.cleancode.errorhandling.task1.stubs;

import com.epam.engx.cleancode.errorhandling.task1.thirdpartyjar.Model;

import java.util.HashMap;
import java.util.Map;

public class ModelStub implements Model {

    private Map<String, String> attributes = new HashMap<>();

    @Override
    public void addAttribute(String name, String s) {
        attributes.put(name, s);
    }

    @Override
    public String getAttribute(String name) {
        return attributes.get(name);
    }
}
