package com.example.prudhvi.signal;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.parse.ParseException;
import com.parse.ParseObject;
import com.parse.ParseQuery;
import com.parse.ParseUser;
import com.parse.SignUpCallback;

import java.util.Random;

public class Credentials extends AppCompatActivity {
    public void signup(View V)
    {
        EditText username=(EditText) findViewById(R.id.signup_username);

        EditText password=(EditText) findViewById(R.id.signup_password);

        Button signupbutton =(Button) findViewById(R.id.signup_button);

        if(username.getText().toString().equals("")||password.getText().toString().equals(""))
        {
            Toast.makeText(this, "Please enter both username and password ", Toast.LENGTH_SHORT).show();
        }
        else
        {
            final ParseUser user = new ParseUser();

            user.setUsername(username.getText().toString());

            user.setPassword(password.getText().toString());

            user.signUpInBackground(new SignUpCallback() {
                @Override
                public void done(ParseException e) {
                    if (e == null) {
                        Toast.makeText(Credentials.this, "SignUp Successful", Toast.LENGTH_SHORT).show();
                        Intent intent =getIntent();

                        String name = intent.getStringExtra("name");
                        String email = intent.getStringExtra("email");
                        String simname = intent.getStringExtra("simname");
                        String simno = intent.getStringExtra("simno");
                        String phoneno = intent.getStringExtra("phoneno");
                        String networktype = intent.getStringExtra("networktype");

                        String id=user.getObjectId().toString();

                        Random rand=new Random();

                        ParseObject customer = new ParseObject("Customer");

                        customer.add("Name",name);
                        customer.add("Reg_Id",id);
                        customer.add("Email",email);
                        customer.add("Aadhar_No",System.currentTimeMillis());
                        customer.add("Age",rand.nextInt(40)+20);

                        customer.saveInBackground();

                        ParseObject sim = new ParseObject("Sim");

                        sim.add("Sim_No",simno);
                        sim.add("Network_Type",networktype);
                        sim.add("Status","Active");
                        sim.add("Reg_Id",id);
                        sim.add("Phone_No",phoneno);

                        sim.saveInBackground();



                        Intent rating = new Intent(getApplicationContext(), Rating.class);
                        startActivity(rating);

                    } else {
                        Toast.makeText(Credentials.this, e.getMessage(), Toast.LENGTH_SHORT).show();
                    }
                }
            });
        }
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_credentials);
    }
}
