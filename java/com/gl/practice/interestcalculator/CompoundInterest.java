package com.gl.practice.interestcalculator;

public class CompoundInterest extends Interest {

    float calculateInterest(float principal, float timePeriod, float interestRate){

        float answer;

        float value = 1 + (interestRate/100);
        value = (float) Math.pow(value,timePeriod);
        answer = principal * value;

        return answer;
    }
}
