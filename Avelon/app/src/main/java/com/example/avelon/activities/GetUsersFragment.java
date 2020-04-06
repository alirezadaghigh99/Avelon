package com.example.avelon.activities;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.avelon.R;
import com.example.avelon.adapters.RecyclerViewAdapter;
import com.example.avelon.model.User;

import java.util.ArrayList;
import java.util.List;

public class GetUsersFragment extends Fragment  {
    EditText editText;
    RecyclerView recyclerView;
    Button button;
    private List<User> lstUser;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.first_page_fragment , container , false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        editText = view.findViewById(R.id.edit_txt);
        button = view.findViewById(R.id.btn);
        lstUser = new ArrayList<>();
        recyclerView = view.findViewById(R.id.recycle);

        final RecyclerViewAdapter myAdapter = new RecyclerViewAdapter(getActivity(), lstUser);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));

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
