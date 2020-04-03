package com.example.avelon;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.Fragment;

import java.util.List;

public class AddUserFragment extends Fragment {
    private LinearLayout mlayout;
    private Button button;
    private AddUserEditTextHandler addUserHandler;
    private static final int MAX_PLAYER = 10;
    private boolean isFinished = false;
    private final int[] id = new int[1];
    private Button nextPageButton;
    private EditText editText;
    private List<User> users;

    public List<User> getUsers() {
        return users;
    }

    @Nullable
    @Override

    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_add_user, container, false);

    }


    @Override
    public void onViewCreated(@NonNull final View view, @Nullable Bundle savedInstanceState) {
        findView(view);
        configure();
        checkStatement(id[0]);

        nextPageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (id[0] < 4) {
                    Toast.makeText(getActivity(), "Not enough player", Toast.LENGTH_LONG).show();
                } else {
                    //TODO
                }
            }
        });


    }

    private void configure() {
        if (isFinished)
            return;

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!isFinished) {
                    addUserHandler = new AddUserEditTextHandler(getActivity());

                    if (id[0] == 0 || !isEmpty(editText)) {


                        editText = addUserHandler.userAdder(getActivity(), id[0]);

                        mlayout.addView(editText);
                        id[0] = id[0] + 1;
                        Log.d("tttta", "id is" + id[0]);
                        checkStatement(id[0]);
                    } else {
                        Toast.makeText(getActivity(), "no name added", Toast.LENGTH_LONG);
                    }
                }


            }

        });
    }

    private void findView(View view) {
        mlayout = view.findViewById(R.id.edit_text_container);
        button = view.findViewById(R.id.add_user_button);
        nextPageButton = view.findViewById(R.id.go_to_game_button);
    }

    private void checkStatement(int id) {
        if (id == MAX_PLAYER)
            isFinished = true;
        configure();
    }

    private boolean isEmpty(EditText etText) {
        if (etText.getText().toString().trim().length() > 0)
            return false;
        String name = editText.getText().toString();
        users.add(new User(name));
        return true;
    }


}



