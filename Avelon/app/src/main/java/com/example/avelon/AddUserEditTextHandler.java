package com.example.avelon;

import android.content.Context;
import android.view.ViewGroup;
import android.widget.EditText;

public class AddUserEditTextHandler {
    private Context context;

    public AddUserEditTextHandler(Context context) {
        this.context = context;
    }
    public EditText userAdder(Context context , int id){
        final ViewGroup.LayoutParams layoutParams = new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT , ViewGroup.LayoutParams.WRAP_CONTENT);
        final EditText editText = new EditText(context);
        editText.setLayoutParams(layoutParams);
        editText.setId(id);
        editText.setHint(context.getString(R.string.player_hint , id +1));
        return editText;

    }
}
