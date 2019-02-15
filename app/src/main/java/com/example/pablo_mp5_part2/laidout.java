package com.example.pablo_mp5_part2;

import java.util.Random;

//import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
//import android.widget.Toast;

public class laidout extends AppCompatActivity {

    int score;
    int choice;
    String radio;
    Random r = new Random();
    private static final String answers[] = {"True", "True", "False"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.laidlayout);
        Intent receive = getIntent();
        score = Integer.parseInt(receive.getStringExtra("score"));
        radio = receive.getStringExtra("radio");

        TextView sun = (TextView) findViewById(R.id.sun);
        TextView ha = (TextView) findViewById(R.id.ha);
        TextView mo = (TextView) findViewById(R.id.mo);

        TextView tie = (TextView) findViewById(R.id.tie);
        TextView pee = (TextView) findViewById(R.id.pee);
        TextView pro = (TextView) findViewById(R.id.pro);

        TextView lofi = (TextView) findViewById(R.id.lofi);
        TextView beat = (TextView) findViewById(R.id.beat);
        TextView sp = (TextView) findViewById(R.id.sp);

        choice = r.nextInt(3);

        if(radio.equals("Random")) {
            if(choice == 0) {
                sun.setVisibility(View.VISIBLE);
            } else if(choice == 1) {
                ha.setVisibility(View.VISIBLE);
            } else if(choice == 2) {
                mo.setVisibility(View.VISIBLE);
            }
        } else if(radio.equals("Spanish")) {
            if(choice == 0) {
                lofi.setVisibility(View.VISIBLE);
            } else if(choice == 1) {
                beat.setVisibility(View.VISIBLE);
            } else if(choice == 2) {
                sp.setVisibility(View.VISIBLE);
            }
        } else if(radio.equals("Music")) {
            if(choice == 0) {
                tie.setVisibility(View.VISIBLE);
            } else if(choice == 1) {
                pee.setVisibility(View.VISIBLE);
            } else if(choice == 2) {
                pro.setVisibility(View.VISIBLE);
            }
        }

    }

    public void laidcheck(View view) {
        Button butt = (Button)view;

        TextView sun = (TextView) findViewById(R.id.sun);
        TextView ha = (TextView) findViewById(R.id.ha);
        TextView mo = (TextView) findViewById(R.id.mo);

        TextView tie = (TextView) findViewById(R.id.tie);
        TextView pee = (TextView) findViewById(R.id.pee);
        TextView pro = (TextView) findViewById(R.id.pro);

        TextView lofi = (TextView) findViewById(R.id.lofi);
        TextView beat = (TextView) findViewById(R.id.beat);
        TextView sp = (TextView) findViewById(R.id.sp);

        if(butt.getId() == R.id.randf && butt.getText().toString().equals(answers[choice])) {
            score = score + 1;
        } else if(butt.getId() == R.id.randt && butt.getText().toString().equals(answers[choice])) {
            score = score + 1;
        }

        //return score and go back to calling activity
        if(radio.equals("Random")) {
            if(choice == 0) {
                sun.setVisibility(View.INVISIBLE);
            } else if(choice == 1) {
                ha.setVisibility(View.INVISIBLE);
            } else if(choice == 2) {
                mo.setVisibility(View.INVISIBLE);
            }
        } else if(radio.equals("Spanish")) {
            if(choice == 0) {
                lofi.setVisibility(View.INVISIBLE);
            } else if(choice == 1) {
                beat.setVisibility(View.INVISIBLE);
            } else if(choice == 2) {
                sp.setVisibility(View.INVISIBLE);
            }
        } else if(radio.equals("Music")) {
            if(choice == 0) {
                tie.setVisibility(View.INVISIBLE);
            } else if(choice == 1) {
                pee.setVisibility(View.INVISIBLE);
            } else if(choice == 2) {
                pro.setVisibility(View.INVISIBLE);
            }
        }

        Intent back = new Intent();
        //Intent intentParent = getIntent();
        back.putExtra("score", Integer.toString(score));
        //intentParent.putExtra("score",score);
        setResult(RESULT_OK,back);
        //setResult(RESULT_OK,intentParent);
        finish();
    }
}
