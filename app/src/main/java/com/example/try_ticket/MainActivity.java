package com.example.try_ticket;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {
    ImageButton imgbtn,moviebtn,bookbt,notif;
    ImageView thelove;

    TextView txt;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.home);
        Intent getdata=getIntent();
        String name=getdata.getStringExtra("USERNAME");
        txt=findViewById(R.id.welc);
        bookbt=findViewById(R.id.booking_icon);
        txt.setText("Welcome "+name);
        thelove=findViewById(R.id.thelove);
        imgbtn=findViewById(R.id.profile_icon);
        notif=findViewById(R.id.notifications_icon);
        notif.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(),notification.class);
                startActivity(intent);
            }
        });
        imgbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), profileset.class);
                startActivity(intent);
            }
        });
        bookbt.setOnClickListener(new View.OnClickListener() {
                                      @Override
                                      public void onClick(View v) {
                                          Intent intent = new Intent(getApplicationContext(), booking.class);
                                          startActivity(intent);
                                      }
                                  });

        moviebtn=findViewById(R.id.movies_icon);
       moviebtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(),movieactivity.class);
                startActivity(intent);
            }
        });
       thelove.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               Intent intent=new Intent(getApplicationContext(), love_moviebook.class);
               startActivity(intent);
           }

       });



    }
}