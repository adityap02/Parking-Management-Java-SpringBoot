package com.epam.engx.cleancode.functions.task2.stubs;

import com.epam.engx.cleancode.functions.task2.thirdpartyjar.Answer;
import com.epam.engx.cleancode.functions.task2.thirdpartyjar.Review;

import java.util.Arrays;
import java.util.List;

public class ReviewStub implements Review {

    private int answers;

    public ReviewStub(int answers) {
        this.answers = answers;
    }

    @Override
    public List<Answer> getAnswers() {
        return Arrays.asList(new Answer[answers]);
    }
}
