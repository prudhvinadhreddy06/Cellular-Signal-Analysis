package com.example.prudhvi.signal;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.parse.LogInCallback;
import com.parse.ParseException;
import com.parse.ParseObject;
import com.parse.ParseUser;
import com.parse.SignUpCallback;

public class MainActivity extends AppCompatActivity {

    public void signin(View V)
    {
        EditText username=(EditText) findViewById(R.id.username);

        EditText password=(EditText) findViewById(R.id.password);

        Button signinButton =(Button) findViewById(R.id.signin);

        if(username.getText().toString().equals("")||password.getText().toString().equals(""))
        {
            Toast.makeText(this, "Please enter both username and password ", Toast.LENGTH_SHORT).show();
        }
        else
        {
                ParseUser.logInInBackground(username.getText().toString(), password.getText().toString(), new LogInCallback() {
                    @Override
                    public void done(ParseUser user, ParseException e) {
                        if(user!=null&&e==null)
                        {
                            Toast.makeText(MainActivity.this, "Login Successful", Toast.LENGTH_SHORT).show();
                            Intent intent = new Intent(getApplicationContext(), Rating.class);
                            startActivity(intent);
                        }
                        else
                        {
                            Toast.makeText(MainActivity.this, e.getMessage(), Toast.LENGTH_SHORT).show();
                        }
                    }
                });
            }
    }

    public void signup(View V)
    {
        Button signupButton =(Button) findViewById(R.id.signup);

        Intent intent =new Intent(getApplicationContext(),SignUp.class);
        startActivity(intent);

    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if(ParseUser.getCurrentUser()!=null) {
            Intent intent = new Intent(getApplicationContext(), Rating.class);
            startActivity(intent);
        }

    }
}
