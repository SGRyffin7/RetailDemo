package com.example.sagarsharma4.retaildemo;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends Activity {

    private EditText Name;
    private EditText Password;
    private TextView Info;
    private Button LogIn;
    private Button SignUp;

    DBHelper dbh = new DBHelper(MainActivity.this);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Name = (EditText)findViewById(R.id.UserNameTxtIn);
        Password = (EditText)findViewById(R.id.PasswordTxtIn);
        LogIn = (Button)findViewById(R.id.LogInButton);
        SignUp = (Button)findViewById(R.id.SignUpButton);

        LogIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String nm = Name.getText().toString();
                String ps = Password.getText().toString();
                ((EditText) findViewById(R.id.UserNameTxtIn)).setText("");
                ((EditText) findViewById(R.id.PasswordTxtIn)).setText("");
                validate(nm, ps);
            }
        });

        SignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, SignUpPage.class);
                startActivity(intent);
            }
        });
    }

    private void validate(String userName, String userPassword){
        if(!dbh.doesExist(userName)) {
            Context context = getApplicationContext();
            CharSequence text = "User is not registered. Please sign up :( ";
            int duration = Toast.LENGTH_SHORT;

            Toast toast = Toast.makeText(context, text, duration);
            toast.show();
        }
        else{
            if((dbh.getUserPass(userName)).equals(userPassword)){

                Intent intent = new Intent(MainActivity.this, HomePage.class);
                startActivity(intent);
            }
            else{
                Context context = getApplicationContext();
                CharSequence text = "Oops Wrong Credentials";
                int duration = Toast.LENGTH_SHORT;

                Toast toast = Toast.makeText(context, text, duration);
                toast.show();
            }
        }


    }
}
