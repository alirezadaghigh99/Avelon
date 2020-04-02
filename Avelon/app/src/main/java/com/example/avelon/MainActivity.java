package com.example.avelon;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        AddUserFragment addUserFragment = new AddUserFragment();
        getSupportFragmentManager().beginTransaction().add(R.id.fragment_container , addUserFragment).addToBackStack(null).commit();
    }
}
