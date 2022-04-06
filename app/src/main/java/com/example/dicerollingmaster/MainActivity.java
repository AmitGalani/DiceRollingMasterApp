package com.example.dicerollingmaster;

import androidx.appcompat.app.AppCompatActivity;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import java.util.Random;

public class MainActivity extends AppCompatActivity {


    TextView textView,nm,score1,score2;
    ImageView imagebtn,exitbtn,dice1,dice2;
    MediaPlayer mediaPlayer1,mediaPlayer2,mp1,mp2,mp3;
    //array to store dice images
    final int dice[]={R.drawable.dice_1,R.drawable.dice_2,R.drawable.dice_3,R.drawable.dice_4,R.drawable.dice_5,R.drawable.dice_6};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        //linking rollbtn with it's id
        imagebtn = findViewById(R.id.playbtn);

        //linking exitbutton with it's id
        exitbtn = findViewById(R.id.exitbtn);

        //Linling the result textView of from it's id
        textView = findViewById(R.id.result);

        //linking both dice imageViews with it's id..
        dice1 = findViewById(R.id.dice1);
        dice2 = findViewById(R.id.dice2);

        //linking both scores with it's id..
        score1 = findViewById(R.id.score1);
        score2 = findViewById(R.id.score2);

        mediaPlayer1 = MediaPlayer.create(this,R.raw.dice);
        mediaPlayer2 = MediaPlayer.create(this,R.raw.dice);
        mp1 = MediaPlayer.create(this,R.raw.win_bit);
        mp2 = MediaPlayer.create(this,R.raw.win_bit);
        mp3 = MediaPlayer.create(this,R.raw.win_bit);

        String name = getIntent().getStringExtra("uname");
        nm = findViewById(R.id.player1);
        nm.setText(name);

        //call the on click function
        imagebtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //generate two randome numbers
                Random random1 = new Random();
                mediaPlayer1.start();
                int num1 = random1.nextInt(6);
                Random random2 = new Random();
                mediaPlayer2.start();
                int num2 = random2.nextInt(6);

                //Convert data int to string
                String sc1 = String.valueOf(num1 + 1);
                String sc2 = String.valueOf(num2 + 1);

                score1.setText(sc1);
                score2.setText(sc2);

                if(num1 > num2)
                {
                    mp1.start();
                    textView.setText("WINNER : "+name);
                }
                else if(num2 > num1)
                {
                    mp2.start();
                    textView.setText("WINNER : System");
                }
                else
                {
                    mp3.start();
                    textView.setText("RESULT : Draw");
                }

                //set the images from the array by the index
                //position of the numbers genrated

                dice1.setImageResource(dice[num1]);
                dice2.setImageResource(dice[num2]);
            }
        });

        exitbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                moveTaskToBack(true);
                android.os.Process.killProcess(android.os.Process.myPid());
                System.exit(1);
            }
        });

    }
}