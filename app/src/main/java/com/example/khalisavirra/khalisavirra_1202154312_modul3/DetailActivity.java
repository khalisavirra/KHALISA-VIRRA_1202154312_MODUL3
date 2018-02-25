package com.example.khalisavirra.khalisavirra_1202154312_modul3;

import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;


public class DetailActivity extends AppCompatActivity {
    private ImageButton btnPlus, btnMinus;
    private ImageView galonkapasitas;
    private TextView skor;
    private int level =0;

    //Member variables for holding the score
    private int mScore1;

    //Member variable for the two score TextView
    private TextView mScoreText1;

    //Tag to be used as the key in OnSavedInstanceState
    static final String STATE_SCORE_1 = "Score";

    /**
     * Initializes the activity, filling in the data from the Intent.
     *
     * @param savedInstanceState Contains information about the saved state of the activity
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        //Initialize the views
        TextView aquaTitle = (TextView) findViewById(R.id.titleDetail);
        ImageView aquaImage = (ImageView) findViewById(R.id.aquaImageDetail);
        TextView aquaDetail = (TextView) findViewById(R.id.subTitleDetail);

        //Get the drawable
        Drawable drawable = ContextCompat.getDrawable
                (this, getIntent().getIntExtra(Aqua.IMAGE_KEY, 0));

        //Create a placeholder gray scrim while the image loads
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setColor(Color.GRAY);

        //Make it the same size as the image
        if (drawable != null) {
            gradientDrawable.setSize(drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight());
        }

        //Set the text from the Intent extra
        aquaTitle.setText(getIntent().getStringExtra(Aqua.TITLE_KEY));
        Toast.makeText(DetailActivity.this,"Berikut detail dari air mineral merk " + aquaTitle.getText(), Toast.LENGTH_LONG).show();

        //Load the image using the glide library and the Intent extra
        Glide.with(this).load(getIntent().getIntExtra(Aqua.IMAGE_KEY, 0))
                .placeholder(gradientDrawable).into(aquaImage);

        //Set the text from the Intent extra
        aquaDetail.setText(getIntent().getStringExtra(Aqua.DETAIL_KEY));

        btnPlus = (ImageButton) findViewById(R.id.increase);
        btnMinus = (ImageButton) findViewById(R.id.decrease);
        galonkapasitas = (ImageView) findViewById(R.id.galon);
        skor = (TextView) findViewById(R.id.score);

        //Find the TextViews by ID
        mScoreText1 = (TextView) findViewById(R.id.score);

        //Restores the scores if there is savedInstanceState
        if (savedInstanceState != null) {
            mScore1 = savedInstanceState.getInt(STATE_SCORE_1);

            //Set the score text views
            mScoreText1.setText(String.valueOf(mScore1));
        }
    }


    /**
     * Method that handles the onClick of both the decrement buttons
     *
     * @param view The button view that was clicked
     */
    public void decreaseScore(View view) {
        status();
        if(level==0){
            Toast.makeText(this,"Air Terisi Sedikit",Toast.LENGTH_SHORT).show();
            return;
        }
        galonkapasitas.setImageLevel(--level);
    }


    /**
     * Method that handles the onClick of both the increment buttons
     *
     * @param view The button view that was clicked
     */
    public void increaseScore(View view) {
        status();
            if(level==5){
                Toast.makeText(this,"Air Terisi Penuh",Toast.LENGTH_SHORT).show();
                return;
            }
            galonkapasitas.setImageLevel(++level);
        }


    //Method status
    private void status() {
        int i = level + 1;
        skor.setText(""+ i +"L");
    }
 }

