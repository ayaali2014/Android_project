package com.example.project;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import com.example.project.Controller.BooksAdapter;

import com.example.project.Model.Book;
import com.example.project.Account;
import com.example.project.Controller.BooksAdapter;
import com.example.project.Model.Book;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import java.util.ArrayList;
import java.util.List;


import com.google.android.material.bottomnavigation.BottomNavigationView;

import java.util.ArrayList;
import java.util.List;

public class Main extends AppCompatActivity {
    List<Book> bookList=new ArrayList<>();
    RecyclerView recyclerView;
    BooksAdapter booksAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        BottomNavigationView bottomNavigationView =findViewById(R.id.bottomNavigationView);
        bottomNavigationView.setSelectedItemId(R.id.home);
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()){
                    case R.id.feedback:
                        startActivity(new Intent(Main.this, FeedActivity.class));
                        break;
                    case R.id.myAccount:
                        Intent intent = new Intent(getApplicationContext(),Account.class);
                        intent.putExtra("user",getIntent().getExtras().getString("user"));
                        startActivity(intent);
                        break;
                }
                return true;
            }
        });
        recyclerView=findViewById(R.id.recyclerview);
        recyclerView.setLayoutManager((new LinearLayoutManager(this)));
        recyclerView.setHasFixedSize(true);
        BookData();
        booksAdapter=new BooksAdapter(bookList,this);
        recyclerView.setAdapter(booksAdapter);

    }
    private void BookData() {
        Book book1=new Book("انا","سيرة ذاتية","4.9","{مجانا}",R.drawable.playstore);
        bookList.add(book1);
        Book book2=new Book("عبقرية محمد","كتاب عربى يتناول جوانب شخصية الرسول صلى الله عليه وسلم","4.9","{مجانا}",R.drawable.playstore1);
        bookList.add(book2);
        Book book3=new Book("عبقرية الصديق","كتاب عربى يتناول جوانب شخصية سيدنا ابى بكر الصديق رضي الله عنه","4.9","{مجانا}",R.drawable.playstore2);
        bookList.add(book3);
        Book book4=new Book("عبقرية المسيح","كتاب عربى يتناول جوانب شخصية سيدنا المسيح عليه السلام","4.9","{مجانا}",R.drawable.playstore3);
        bookList.add(book4);
    }
}