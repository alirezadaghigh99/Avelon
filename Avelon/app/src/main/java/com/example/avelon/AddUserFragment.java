package com.example.avelon;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.GridLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.Fragment;

import java.util.List;

public class AddUserFragment extends Fragment {
    Button addUserButton;
    TextView firstUser;
    public int numberOfLines = 3;

    private List<User> users;
    ConstraintLayout myLayout = null;
    @Nullable
    @Override

    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_add_user , container , false);

    }
    GridLayout gridLayout;
    Button button;
    AddUserEditTextHandler addUserHandler;
    @Override
    public void onViewCreated(@NonNull final View view, @Nullable Bundle savedInstanceState) {
    gridLayout = view.findViewById(R.id.edit_text_container);
    button = view.findViewById(R.id.add_user_button);
        final int[] id = new int[1];
        id[0] = 0;
    button.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            addUserHandler = new AddUserEditTextHandler(getActivity());
            gridLayout.addView(addUserHandler.userAdder(getActivity() , id[0]));
            id[0] = id[0] + 1;


        }
    });

    }


    }



