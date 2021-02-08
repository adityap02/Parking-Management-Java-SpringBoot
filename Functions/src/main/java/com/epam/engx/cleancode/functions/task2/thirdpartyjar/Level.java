package com.epam.engx.cleancode.functions.task2.thirdpartyjar;

public class Level {

    private String id;

    public Level(String s) {
        id = s;
    }

    public static Level defaultLevel() {
        return new Level("0");
    }

    @Override
    public boolean equals(Object o) {
        if (o instanceof Level)
            return id.equals(((Level) o).id);
        else
            return false;
    }
}
