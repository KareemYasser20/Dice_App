package com.example.appdise2;

import androidx.appcompat.app.AppCompatActivity;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.daimajia.androidanimations.library.Techniques;
import com.daimajia.androidanimations.library.YoYo;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final ImageView imgDice1=findViewById(R.id.imgdice1);
        final ImageView imgDice2=findViewById(R.id.imgdice2);
        final int [] diceImeges= {R.drawable.dice1,R.drawable.dice2,R.drawable.dice3,R.drawable.dice4,R.drawable.dice5,R.drawable.dice6};

        final MediaPlayer mp=MediaPlayer.create(this,R.raw.dice_sound);

        Button btnrollObject=findViewById(R.id.btnroll);
        btnrollObject.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Random randomObject=new Random();
                int myRandomNumbers=randomObject.nextInt(6);   //ygebly 3dd el elemnts elly mtsgla mn 0 to 5 ..y3ny ha5znhom fe array .. see line 18

                imgDice1.setImageResource(diceImeges[myRandomNumbers]);
                int myRandomNumbers2=randomObject.nextInt(6);
                imgDice2.setImageResource(diceImeges[myRandomNumbers2]);
                YoYo.with(Techniques.Shake)
                        .duration(500)
                        .repeat(5)
                        .playOn(findViewById(R.id.imgdice2));
                YoYo.with(Techniques.Shake)
                        .duration(500)
                        .repeat(5)
                        .playOn(findViewById(R.id.imgdice1));
                mp.start();
            }
        });
    }
}
