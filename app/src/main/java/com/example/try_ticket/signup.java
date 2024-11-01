package com.example.try_ticket;

import android.app.AlertDialog;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class signup extends AppCompatActivity {  // Renamed for clarity
    private Button btn_signup;
    private EditText user, email, contact, pass;  // Changed TextView to EditText

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_signup);

        // Initialize your EditText variables
        user = findViewById(R.id.user);
        email = findViewById(R.id.email);
        contact = findViewById(R.id.contact);
        pass = findViewById(R.id.pass);
        btn_signup = findViewById(R.id.btnsign);

        btn_signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String username = user.getText().toString().trim();
                String emailText = email.getText().toString().trim();
                String contactText = contact.getText().toString().trim();
                String password = pass.getText().toString().trim();


                if (username.isEmpty() || emailText.isEmpty() || contactText.isEmpty() || password.isEmpty()) {
                    Toast.makeText(signup.this, "Please fill in all fields", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(signup.this, "Successfully signed up", Toast.LENGTH_LONG).show();

                    Intent intent = new Intent(signup.this, MainActivity.class);

                    intent.putExtra("USERNAME", username);
                    intent.putExtra("EMAIL", emailText);
                    intent.putExtra("CONTACT", contactText);
                    intent.putExtra("PASSWORD", password);

                    startActivity(intent);

                    finish();

                }
            }
        });

        // Handle window insets
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }

    public static class netwrokchangerlistener extends BroadcastReceiver {
        @Override
        public void onReceive(Context context, Intent intent) {
            if(!Common.isConnectedToInternet(context))
            {
                AlertDialog.Builder builder=new AlertDialog.Builder(context);
                View layout_dialog= LayoutInflater.from(context).inflate(R.layout.forcheckingnet,null);
                builder.setView(layout_dialog);

                AppCompatButton btnretry=layout_dialog.findViewById(R.id.try_again_button);
                AlertDialog dialog=builder.create();
                dialog.show();
                dialog.setCancelable(false);

                dialog.getWindow().setGravity(Gravity.CENTER);
                btnretry.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        dialog.dismiss();
                        onReceive(context,intent);
                    }
                });
            }
        }


    }
}
