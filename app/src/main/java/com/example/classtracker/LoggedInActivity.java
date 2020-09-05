package com.example.classtracker;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

public class LoggedInActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_logged_in);
    }

    public static Intent getIntent(Context context, String username){
        Intent intent = new Intent(context, LoggedInActivity.class);
        intent.putExtra("INTENT_EXTRA_VALUE", username);
        return intent;
    }
}