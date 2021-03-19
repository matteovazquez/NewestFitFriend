package com.example.fitfriend;

import android.app.Activity;
import android.os.Bundle;

public class main_menu extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_menu);
        String email = getIntent().getStringExtra("email");
    }
}
