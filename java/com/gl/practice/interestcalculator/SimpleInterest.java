package com.gl.practice.interestcalculator;

public class SimpleInterest extends Interest {

    float calculateInterest(float principal, float timePeriod, float interestRate){

        float answer;

        answer = principal + ((principal * timePeriod * interestRate) / 100);

        return answer;
    }
}
