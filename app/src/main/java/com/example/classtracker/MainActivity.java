package com.example.classtracker;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.room.Dao;
import androidx.room.Room;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.classtracker.DB.AppDataBase;
import com.example.classtracker.DB.DAO;
import com.example.classtracker.DB.User;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    List<User> mUsers;

    EditText mUserName;
    EditText mPassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        User u = new User("din_djarin", "baby_yoda_ftw");
        DAO mDao = AppDataBase.getInstance(MainActivity.this).dao();
        mDao.addUser(u);
        mUsers = AppDataBase.getInstance(MainActivity.this).dao().getAllUsers();

        mUserName = findViewById(R.id.username);
        mPassword = findViewById(R.id.password);
        Button sign_in_button = findViewById(R.id.sign_in_button);

        sign_in_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                validateUser();

            }
        });
    }

    //CHECK USER
    void validateUser() {
        String username = mUserName.getText().toString();
        String password = mPassword.getText().toString();

        if(username.equals("") || password.equals("")){
            Toast.makeText(this, "Fields cannot be empty", Toast.LENGTH_SHORT).show();
            return;
        }

        if(mUsers.isEmpty()){
            Toast.makeText(this, "No accounts logged, try creating an account", Toast.LENGTH_SHORT).show();
            return;
        }

        try {
            for(User user : mUsers){
                if(user.getUsername().equals(username) && user.getPassword().equals(password)){
                    Toast.makeText(this, "Welcome " + username, Toast.LENGTH_SHORT).show();
                    Intent intent = LoggedInActivity.getIntent(getApplicationContext(), username);
                    startActivity(intent);
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
            Toast.makeText(this, "Incorrect username or password", Toast.LENGTH_SHORT).show();
        }
    }
}
