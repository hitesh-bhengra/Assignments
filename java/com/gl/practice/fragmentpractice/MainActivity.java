package com.gl.practice.fragmentpractice;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

  private static final String AppTest = "Apple";

  private static final String USER_EMAIL = "USER_EMAIL";
  private static final String USER_PASS = "USER_PASSWORD";



  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);
    Log.d(AppTest,"onCreate() created");
        /*EditText users = findViewById(R.id.username);
        EditText pass = findViewById(R.id.password);
        String username;
        String password;
        if(savedInstanceState!=null)
        {
            Log.d(AppTest,"onCreate, savedInstanceState is not null");
            username = savedInstanceState.getString(USER_EMAIL);
            password = savedInstanceState.getString(USER_PASS);
            users.setText(username);
            pass.setText(password);
        }
        else
        {
            Log.d(AppTest,"onCreate, savedInstanceState is null");
        }
*/
  }

  @Override
  protected void onStart() {
    super.onStart();
    Log.d(AppTest,"onStart() created");
  }

  @Override
  protected void onResume() {
    super.onResume();
    Log.d(AppTest,"onResume() created");
  }

  @Override
  protected void onPause() {
    super.onPause();
    Log.d(AppTest,"onPause() created");
  }

  @Override
  protected void onStop() {
    super.onStop();
    Log.d(AppTest,"onStop() created");
  }

  @Override
  protected void onDestroy() {
    super.onDestroy();
    Log.d(AppTest,"onDestroy() created");
  }

  @Override
  protected void onRestart() {
    super.onRestart();
    Log.d(AppTest,"onRestart() created");
  }

  @Override
  protected void onSaveInstanceState(Bundle outState){
    super.onSaveInstanceState(outState);

    EditText users = findViewById(R.id.username);
    EditText pass = findViewById(R.id.password);
    String email = users.getText().toString();
    String passcode = pass.getText().toString();
    outState.putString(USER_EMAIL,email);
    outState.putString(USER_PASS,passcode);
    Log.d(AppTest,"onSaveInstanceState");
  }

  @Override
  protected void onRestoreInstanceState(Bundle savedInstanceState){
    super.onRestoreInstanceState(savedInstanceState);

    EditText users = findViewById(R.id.username);
    EditText pass = findViewById(R.id.password);
    String email = savedInstanceState.getString(USER_EMAIL);
    String passcode = savedInstanceState.getString(USER_PASS);

    users.setText(email);
    pass.setText(passcode);
  }

}