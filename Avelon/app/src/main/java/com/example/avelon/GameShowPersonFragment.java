package com.example.avelon;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import com.example.avelon.model.User;

import java.util.List;

public class GameShowPersonFragment extends Fragment {
    private User user;
    private List<User> users;

    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }

    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }

    private int index;
    TextView name;
    private ConstraintLayout constraintLayout;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_name_click_role , container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        name = view.findViewById(R.id.user_player_name_before);
        name.setText(user.getName());
        constraintLayout = view.findViewById(R.id.before_layout);

        constraintLayout.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                GameAssaignRoleFragment gameAssaignRoleFragment = new GameAssaignRoleFragment();
                gameAssaignRoleFragment.setIndex(index);
                gameAssaignRoleFragment.setUsers(users);
                FragmentTransaction transaction = getActivity().getSupportFragmentManager().beginTransaction() ;
                transaction.replace(R.id.fragment_container , gameAssaignRoleFragment);
                transaction.addToBackStack(null);
                transaction.commit();


            }
        });

    }
}
