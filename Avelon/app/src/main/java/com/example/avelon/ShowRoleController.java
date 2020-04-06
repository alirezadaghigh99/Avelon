package com.example.avelon;

import android.app.Activity;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.Context;

import com.example.avelon.model.User;

import java.util.List;

public class ShowRoleController {
    private int index ;
    private List<User> users;

    private ShowRoleController instance = new ShowRoleController()   ;

    private ShowRoleController() {
    }

    public void setIndex(int index) {
        this.index = index;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }

    public int getIndex() {
        return index;
    }

    public List<User> getUsers() {
        return users;
    }

    public ShowRoleController getInstance() {
        return instance;
    }

    public void Controller(Context context) {
        Activity activity = (Activity) context;
        FragmentManager fragmentManager = activity.getFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        GameShowPersonFragment fragment = new GameShowPersonFragment();
        //fragmentTransaction.add(R.id.fragment_container, fragment);
        fragmentTransaction.commit();
    }
}
