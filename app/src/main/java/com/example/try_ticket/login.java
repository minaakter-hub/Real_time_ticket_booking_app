package com.example.try_ticket;

import android.content.Intent;
import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class login extends AppCompatActivity {
    TextView signup;
    Button btnsign;
   networklisten net=new networklisten();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_login);
        signup=findViewById(R.id.signup);
        signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(getApplicationContext(), signup.class);
                startActivity(intent);
            }
        });
        btnsign=findViewById(R.id.btnsignup);
       btnsign.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent=new Intent(getApplicationContext(), signup.class);
                startActivity(intent);
            }
        });}
    @Override
     protected void onStart(){
            IntentFilter filter=new IntentFilter(ConnectivityManager.CONNECTIVITY_ACTION);
            registerReceiver(net,filter);
            super.onStart();

        }
        @Override
        protected void onStop(){

            unregisterReceiver(net);
            super.onStop();

        }


//        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
//        Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
//        v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
//        return insets;
//    });

}