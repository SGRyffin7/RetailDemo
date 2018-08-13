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

public class SignUpPage extends Activity{
    private EditText Name;
    private EditText Password;
    private EditText PassCheck;
    private TextView Info;
    private Button SignUp;

    DBHelper db = new DBHelper(SignUpPage.this);
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up_page);

        Name = (EditText)findViewById(R.id.UserNameTxtIn_su);
        Password = (EditText)findViewById(R.id.PasswordTxtIn_su);
        PassCheck = (EditText)findViewById(R.id.PassCheckTxtIn_su);
        SignUp = (Button)findViewById(R.id.SignUpButton_su);

       SignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String nm = Name.getText().toString();
                String ps = Password.getText().toString();
                String psc = PassCheck.getText().toString();
                ((EditText) findViewById(R.id.UserNameTxtIn_su)).setText("");
                ((EditText) findViewById(R.id.PasswordTxtIn_su)).setText("");
                ((EditText) findViewById(R.id.PassCheckTxtIn_su)).setText("");
                validate(nm, ps, psc);
            }
        });
    }

    private void validate(String userName, String userPassword, String userPasswordCheck){

        if(db.doesExist(userName)){
            Context context = getApplicationContext();
            CharSequence text = "UserName is taken. Please try another username";
            int duration = Toast.LENGTH_SHORT;

            Toast toast = Toast.makeText(context, text, duration);
            toast.show();

        }
        else{
            if(userPasswordCheck.equals(userPassword)){

                db.insertItem(userName,userPassword);

                Intent intent = new Intent(SignUpPage.this, MainActivity.class);
                startActivity(intent);

            }
            else{
                Context context = getApplicationContext();
                CharSequence text = "Oops Passwords Don't Match!";
                int duration = Toast.LENGTH_SHORT;

                Toast toast = Toast.makeText(context, text, duration);
                toast.show();
            }
        }

    }
}

