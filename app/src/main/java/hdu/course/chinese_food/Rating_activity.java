package hdu.course.chinese_food;

import android.annotation.SuppressLint;
import android.content.SharedPreferences;
import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;
import android.view.View;
import android.widget.RatingBar;
import android.widget.RatingBar.OnRatingBarChangeListener;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

public class Rating_activity extends AppCompatActivity {
    TextView textView;
    RatingBar ratingBar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.rating_page);
        ratingBar = (RatingBar) findViewById(R.id.ratingBar);
        ratingBar.setRating(load());
        textView = (TextView) findViewById(R.id.rateView);
        ratingBar.setOnRatingBarChangeListener(new OnRatingBarChangeListener() {
            @Override
            public void onRatingChanged(RatingBar ratingBar, float v, boolean b) {
                textView.setText("" + v);
                save(v);
            }
        });
    }

    public void save(float f) {
        SharedPreferences sharedPreferences = getSharedPreferences("folder", MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putFloat("rating", f);
        editor.commit();
    }

    public float load() {
        SharedPreferences sharedPreferences = getSharedPreferences("folder", MODE_PRIVATE);
        float f = sharedPreferences.getFloat("rating", 0f);
        return f;

    }

    public void onCustomToggleClick(View view) {
        Toast.makeText(this, "Thank you for liking my app", Toast.LENGTH_LONG).show();
    }
    @Override
    protected void onStart() {
        super.onStart();
        Toast.makeText(this,"Starting Rating Activity",Toast.LENGTH_SHORT).show();
    }
}

