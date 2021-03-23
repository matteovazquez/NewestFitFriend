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

        if(v.getId() == R.id.BsignupButton) {

            EditText email = (EditText) findViewById(R.id.TFemail);
            EditText pass1 = (EditText) findViewById(R.id.TFpass1);
            EditText pass2 = (EditText) findViewById(R.id.TFpass2);
            EditText name =  (EditText) findViewById(R.id.TFname);
            EditText uname = (EditText) findViewById(R.id.TFuname);


            String emailstr = email.getText().toString();
            String pass1str = pass1.getText().toString();
            String pass2str = pass2.getText().toString();
            String namestr = name.getText().toString();
            String unamestr = uname.getText().toString();

            if (!pass1str.equals(pass2str)) {

                //makes a message that says the passwords don't match

                Toast pass = Toast.makeText(SignUp.this, "Passwords don't match.", +
                        Toast.LENGTH_SHORT);
                pass.show();
            } else {

                //puts data in database

                Contact c = new Contact();
                c.setEmail(emailstr);
                c.setPass(pass1str);
                c.setName(namestr);
                c.setUname(unamestr);


                helper.insertContact(c);
            }
        }
    }
}
