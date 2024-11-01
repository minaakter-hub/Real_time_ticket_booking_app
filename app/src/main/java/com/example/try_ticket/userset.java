package com.example.try_ticket;

import android.content.Intent;
import android.os.Bundle;
import android.widget.EditText;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class userset extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.userinfo);


        Intent intent = getIntent();

        String username = intent.getStringExtra("USERNAME");
        String email = intent.getStringExtra("EMAIL");
        String contact = intent.getStringExtra("CONTACT");
        String password = intent.getStringExtra("PASSWORD");

        // Find the EditText fields and set their text
        EditText usernameView = findViewById(R.id.user);
        EditText emailView = findViewById(R.id.email);
        EditText contactView = findViewById(R.id.contact);
        EditText passwordView = findViewById(R.id.password);

        usernameView.setText("Username :"+username);
        emailView.setText("Email:"+email);
        contactView.setText("Contact:"+contact);
        passwordView.setText("Password:"+password); //
    }
}