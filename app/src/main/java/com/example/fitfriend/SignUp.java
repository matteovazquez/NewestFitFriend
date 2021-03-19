package com.example.fitfriend;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class SignUp extends Activity {

    DatabaseHelper helper = new DatabaseHelper(this);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.signup);
    }

    public void onSignUpClick(View v) {

        EditText email =  (EditText)findViewById(R.id.TFemail);
        EditText password1 =  (EditText)findViewById(R.id.TFpassword1);
        EditText password2 =  (EditText)findViewById(R.id.TFpassword2);

        String emailstr = email.getText().toString();
        String password1str = password1.getText().toString();
        String password2str = password2.getText().toString();

        if(!password1str.equals(password2str)){

            //makes a message that says the passwords don't match

            Toast password = Toast.makeText(SignUp.this, "Passwords don't match.", +
                    Toast.LENGTH_SHORT);
            password.show();
        }
        else {
            //puts data in database

            Contact c = new Contact();
            c.setEmail(emailstr);
            c.setPassword(password1str);

            helper.insertContact(c);
        }
    }
}
