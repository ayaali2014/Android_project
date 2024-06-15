package com.example.project;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.project.Model.Book;

public class Details extends AppCompatActivity {
    private TextView title1,desc1,rate1,cost1;
    private ImageView imageView;
    private Bundle extras;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);
        title1=findViewById(R.id.mytitle);
        desc1=findViewById(R.id.mydesc);
        rate1=findViewById(R.id.myrate);
        imageView.findViewById(R.id.imageView2);

        if(getIntent().hasExtra("Book")){
            Book book=getIntent().getParcelableExtra("Book");
            title1.setText(book.getTitle());
            desc1.setText(book.getDesc());
            rate1.setText(book.getRate());
        }
        Button btn=findViewById(R.id.ForBook);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String ch=title1.getText().toString(),send="";
                if(ch.equals("انا")){
                    send="ana.pdf";
                }
                else if(ch.equals("عبقرية محمد")){
                    send="mohamed.pdf";
                }
                else if(ch.equals("عبقرية الصديق")){
                    send="sadek.pdf";
                }
                else{
                    send="mseh.pdf";
                }
                Intent intent=new Intent(Details.this, AnaBook.class);
                intent.putExtra("pdf", send);
                startActivity(intent);
            }
        });
    }
}