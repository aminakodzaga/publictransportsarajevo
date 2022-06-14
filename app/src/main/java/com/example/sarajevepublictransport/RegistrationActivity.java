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

public class RegistrationActivity extends AppCompatActivity {

    Button registration;
    EditText name, email, password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);

        registration = findViewById(R.id.registration);
        name = findViewById(R.id.name);
        email = findViewById(R.id.email);
        password = findViewById(R.id.password);

        registration.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(!name.getText().toString().equals("") && !email.getText().toString().equals("") && !password.getText().toString().equals("")){
                    User regUser = new User(
                            name.getText().toString(),
                            email.getText().toString(),
                            password.getText().toString()
                    );
                    AppDB.getInstance(getApplicationContext()).usersDao().addUser(regUser);
                    int userID = AppDB.getInstance(getApplicationContext()).usersDao().getUserIdByEmail(regUser.getEmail());
                    Intent intent = new Intent(RegistrationActivity.this, MainActivity.class);
                    intent.putExtra("USER_ID",userID);
                    startActivity(intent);
                }else{
                    Toast.makeText(getApplicationContext(), "Some credentials are empty",Toast.LENGTH_LONG).show();
                }
            }
        });
    }
}