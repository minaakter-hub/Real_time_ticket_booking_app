package com.example.try_ticket;

import android.content.ClipData;
import android.os.Bundle;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SearchView;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class movieactivity extends AppCompatActivity {
    SearchView searchView;
    RecyclerView recyclerView;
    List<movieitem> items = new ArrayList<>();
    Myadapter myAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.movie);
         searchView=findViewById(R.id.searchview);
         searchView.clearFocus();
         searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
             @Override
             public boolean onQueryTextSubmit(String query) {
                 return false;
             }

             @Override
             public boolean onQueryTextChange(String newText) {
                 filterlist(newText);
                 return false;
             }
         });
        recyclerView=findViewById(R.id.movierecylce);

        items.add(new movieitem("Patan", "The great movie", R.drawable.patan));
        items.add(new movieitem("3 Idiots", "The greate movie", R.drawable.three));
        items.add(new movieitem("Shershaah", "Pvc Awarded", R.drawable.shersha));
        items.add(new movieitem("Singham Again", "Action,Drama", R.drawable.sing));
        items.add(new movieitem("Dhadak 2", "Romance", R.drawable.dhak));

        items.add(new movieitem("Jigra", "Action", R.drawable.jigra));
        items.add(new movieitem("Megan Thee Stallion", "Documnetray", R.drawable.megan));
        items.add(new movieitem("Martha", "Documentray", R.drawable.martha));
        items.add(new movieitem("Time Cut", "Horror,Thriller", R.drawable.timecut));
        items.add(new movieitem("Dont Move", "Horror,Thriller", R.drawable.timecut1));
        items.add(new movieitem("Hijack", "Drama,Thriller", R.drawable.hijack));

        myAdapter = new Myadapter(this, items);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(myAdapter);
    }

    private void filterlist(String Text) {
        List<movieitem>filteredlist=new ArrayList<>();
        for(movieitem item:items){
            if(item.getTitle().toLowerCase().contains(Text.toLowerCase())){
                filteredlist.add(item);
            }
        }
        if(filteredlist.isEmpty()){
            Toast.makeText(this,"No data found", Toast.LENGTH_SHORT).show();
        }
        else {
           myAdapter.setFilteredList(filteredlist);
        }

    }
}