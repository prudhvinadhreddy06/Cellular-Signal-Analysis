package com.example.prudhvi.signal;

import android.content.Intent;
import android.net.Credentials;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class SignUp extends AppCompatActivity {
    public void next(View V)
    {
        EditText name=(EditText) findViewById(R.id.name);

        EditText email=(EditText) findViewById(R.id.email);

        EditText simname=(EditText) findViewById(R.id.simname);

        EditText simno=(EditText) findViewById(R.id.simno);

        EditText phoneno=(EditText) findViewById(R.id.phoneno);

        EditText networktype=(EditText) findViewById(R.id.networktype);

        Button next =(Button) findViewById(R.id.next);

        if(name.getText().toString().equals("")||email.getText().toString().equals("")||simname.getText().toString().equals("")||simno.getText().toString().equals("")||phoneno.getText().toString().equals(""))
        {
            Toast.makeText(this, "Please fill all the details", Toast.LENGTH_SHORT).show();
        }
        else {
            Intent intent = new Intent(getApplicationContext(), com.example.prudhvi.signal.Credentials.class);
            intent.putExtra("name", name.getText().toString());
            intent.putExtra("email", email.getText().toString());
            intent.putExtra("simname", simname.getText().toString());
            intent.putExtra("simno", simno.getText().toString());
            intent.putExtra("phoneno", phoneno.getText().toString());
            intent.putExtra("networktype",networktype.getText().toString());
            startActivity(intent);
        }

    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);
    }
}
