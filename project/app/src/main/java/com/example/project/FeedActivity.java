package com.example.project;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RatingBar;
import android.widget.TextView;
import android.widget.Toast;

public class FeedActivity extends AppCompatActivity {
    Button buttonShow;
    TextView textViewResult;
    RatingBar ratingBar ;
    EditText editText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_feed_back);
        textViewResult = findViewById(R.id.textView);
        ratingBar = findViewById(R.id.ratingBar);
        buttonShow = findViewById(R.id.button);
        editText = findViewById(R.id.editText);

        ratingBar.setOnRatingBarChangeListener(new RatingBar.OnRatingBarChangeListener() {
            @Override
            public void onRatingChanged(RatingBar ratingBar, float rating, boolean fromUser) {
                if(rating == 0) {
                    textViewResult.setText("Very Dissatisfied");
                }
                else if(rating == 1) {
                    textViewResult.setText("Dissatisfied");
                }
                else if(rating >= 2&&rating <= 3) {
                    textViewResult.setText("OK");
                }
                else if(rating > 3&&rating<=4) {
                    textViewResult.setText("Satisfied");
                }
                else if(rating >4){
                    textViewResult.setText("Very Satisfied");
                }
            }
        });

        buttonShow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(), "Thanks For You" , Toast.LENGTH_SHORT).show();
                startActivity(new Intent(FeedActivity.this,Main.class));
            }
        });
    }
}