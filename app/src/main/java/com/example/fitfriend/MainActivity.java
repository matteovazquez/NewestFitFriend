package com.example.fitfriend;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    DatabaseHelper helper = new DatabaseHelper(this);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void onButtonClick(View v){
        if (v.getId() == R.id.Blogin){

            EditText a = (EditText)findViewById(R.id.TFemail);
            String str = a.getText().toString();

            EditText b = (EditText)findViewById(R.id.TFpassword);
            String password = b.getText().toString();

            String Password = helper.searchpassword(str);
            if(password.equals(Password)){
                Intent i = new Intent(MainActivity.this, main_menu.class);
                i.putExtra("email", str);
                startActivity(i);
            }
            else{
                Toast temp = Toast.makeText(MainActivity.this, "Email and" +
                        "passwords do not match",
                        Toast.LENGTH_SHORT);
                temp.show();
            }


        }
        if (v.getId() == R.id.Bsignup) {
            Intent i = new Intent(MainActivity.this, SignUp.class);
            startActivity(i);
        }
    }
}
