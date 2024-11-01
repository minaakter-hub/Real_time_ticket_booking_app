package com.example.try_ticket;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class love_moviebook extends AppCompatActivity {
    ImageView dialshare,dialcall;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_love_moviebook);

        dialshare=findViewById(R.id.share);
        dialcall=findViewById(R.id.call);
        dialcall.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(ContextCompat.checkSelfPermission(love_moviebook.this, android.Manifest.permission.CALL_PHONE)!= PackageManager.PERMISSION_GRANTED){
                    ActivityCompat.requestPermissions(love_moviebook.this,new String[]{Manifest.permission.CALL_PHONE},1);

                }
                else
                {
                    Intent iDial= new Intent(Intent.ACTION_CALL);
                    iDial.setData(Uri.parse("tel:01617735858"));
                    startActivity(iDial);
                }
            }
        });
        dialshare.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent isms=new Intent(Intent.ACTION_SEND);
                isms.setType("text/plain");
                isms.putExtra(Intent.EXTRA_TEXT,"https://www.youtube.com/watch?v=Go8nTmfrQd8");
                startActivity(Intent.createChooser(isms,"SEND BY"));
            }
        });
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }
}