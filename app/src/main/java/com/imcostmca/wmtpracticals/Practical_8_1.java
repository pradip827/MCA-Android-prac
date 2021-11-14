package com.imcostmca.wmtpracticals;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RatingBar;

import com.sdsmdg.tastytoast.TastyToast;

public class Practical_8_1 extends AppCompatActivity {

    RatingBar rateStar;
    Button btnRate;
    float ratings;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_practical81);

        rateStar = findViewById(R.id.ratingStars);
        btnRate = findViewById(R.id.btnStarRate);

        rateStar.setRating(3.5F);

        btnRate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ratings = rateStar.getRating();

                TastyToast.makeText(getApplicationContext(), "You rate with " + ratings + " stars", TastyToast.LENGTH_SHORT, TastyToast.SUCCESS);
            }
        });
    }
}