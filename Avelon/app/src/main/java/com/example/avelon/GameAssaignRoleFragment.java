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

public class GameAssaignRoleFragment extends Fragment {
    private int index;
    private List<User> users;
    private TextView userName;
    private TextView role;
    private TextView what;
    private ConstraintLayout constraintLayout;

    public void setIndex(int index) {
        this.index = index;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_see_role , container , false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        userName = view.findViewById(R.id.user_player_name);
        role = view.findViewById(R.id.user_role);
        what = view.findViewById(R.id.user_role_description);
        userName.setText(users.get(index).getName());
        role.setText(users.get(index).getRole());
        what.setText(users.get(index).getName());
        constraintLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                GameShowPersonFragment gameShowPersonFragment = new GameShowPersonFragment();
                gameShowPersonFragment.setIndex(index+1);
                gameShowPersonFragment.setUsers(users);
                FragmentTransaction transaction = getActivity().getSupportFragmentManager().beginTransaction() ;
                transaction.replace(R.id.fragment_container , gameShowPersonFragment);
                transaction.addToBackStack(null);
                transaction.commit();


            }
        });




    }
}
