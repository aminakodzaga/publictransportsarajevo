package com.example.sarajevepublictransport;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.sarajevepublictransport.lines.MainActivity;
import com.example.sarajevepublictransport.users.User;

import java.util.List;

public class LoginActivity extends AppCompatActivity {

    Button login;
    EditText email, password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        login = findViewById(R.id.login);
        email = findViewById(R.id.email);
        password = findViewById(R.id.password);

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if(!email.getText().toString().equals("") && !password.getText().toString().equals("")){
                    User user = AppDB.getInstance(getApplicationContext()).usersDao().checkLogin(email.getText().toString(),
                            password.getText().toString());
                    if(user!=null){
                        Intent intent = new Intent(LoginActivity.this, MainActivity.class);
                        intent.putExtra("USER_ID", user.getId());
                        startActivity(intent);
                    }else{
                        Toast.makeText(getApplicationContext(), "Login incorrect",Toast.LENGTH_LONG).show();
                    }
                }else{
                    Toast.makeText(getApplicationContext(), "Login credentials empty",Toast.LENGTH_LONG).show();
                }


            }
        });
    }
}