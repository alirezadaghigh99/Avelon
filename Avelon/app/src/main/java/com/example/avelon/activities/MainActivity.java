package com.example.avelon.activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.avelon.R;
import com.example.avelon.adapters.RecyclerViewAdapter;
import com.example.avelon.model.User;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    EditText editText;
    RecyclerView recyclerView;
    Button button;
    private List<User> lstUser;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        editText = findViewById(R.id.edit_txt);
        button = findViewById(R.id.btn);
        lstUser = new ArrayList<>();
        recyclerView = findViewById(R.id.recycle);

        final RecyclerViewAdapter myAdapter = new RecyclerViewAdapter(this, lstUser);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        recyclerView.setAdapter(myAdapter);


        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                User user = new User();
                user.setName(editText.getText().toString());
                user.setRole(null);
                lstUser.add(user);
                myAdapter.notifyItemInserted(lstUser.size() - 1);
                editText.setText("");
            }
        });
    }
}
