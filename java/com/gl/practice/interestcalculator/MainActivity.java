package com.gl.practice.interestcalculator;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity {

    Float principal;
    Float timePeriod;
    Float interestRate;
    Float final_amount;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final EditText principal_amt = findViewById(R.id.amount);
        final EditText time_period = findViewById(R.id.years);
        final EditText interest_rate = findViewById(R.id.rate);
        final Button simple_calc = findViewById(R.id.but_simple_interest);
        final Button compound_calc = findViewById(R.id.but_compound_interest);
        final TextView ans = findViewById(R.id.answer);



        simple_calc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                principal = Float.valueOf(principal_amt.getText().toString());
                timePeriod = Float.valueOf(time_period.getText().toString());
                interestRate = Float.valueOf(interest_rate.getText().toString());
                SimpleInterest simpleInterest = new SimpleInterest();
                final_amount = simpleInterest.calculateInterest(principal,timePeriod,interestRate);

                ans.setText(String.format("%.2f",final_amount));
                //Toast.makeText(this,Float.toString(final_amount),Toast.LENGTH_SHORT).show();
            }
        });

        compound_calc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                principal = Float.valueOf(principal_amt.getText().toString());
                timePeriod = Float.valueOf(time_period.getText().toString());
                interestRate = Float.valueOf(interest_rate.getText().toString());

                CompoundInterest compoundInterest = new CompoundInterest();
                final_amount = compoundInterest.calculateInterest(principal,timePeriod,interestRate);

                ans.setText(String.format("%.2f",final_amount));
            }
        });



    }
}
