package com.epam.engx.cleancode.functions.task2;


import com.epam.engx.cleancode.functions.task2.thirdpartyjar.Level;
import com.epam.engx.cleancode.functions.task2.thirdpartyjar.NotActivUserException;
import com.epam.engx.cleancode.functions.task2.thirdpartyjar.Review;
import com.epam.engx.cleancode.functions.task2.thirdpartyjar.User;

import java.util.TreeMap;

public abstract class Account implements User {

    private TreeMap<Integer, Level> levelMap = new TreeMap<>();

    public Level getActivityLevel() {
        validateAccountForLevel();

        int reviewAnswers = 0;
        for (Review r : getAllReviews())
            reviewAnswers += r.getAnswers().size();

        return getLevelByReviews(reviewAnswers);

    }

    private void validateAccountForLevel() {
        if (!isRegistered() || getVisitNumber() <= 0)
            throw new NotActivUserException();
    }

    private Level getLevelByReviews(int reviewAnswers) {
        for (Integer threshold : levelMap.keySet()) {
            if (reviewAnswers >= threshold)
                return levelMap.get(threshold);
        }

        return Level.defaultLevel();
    }

    public void setLevelMap(TreeMap<Integer, Level> levelMap) {
        this.levelMap = levelMap;
    }
}
