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

public class randIntent extends AppCompatActivity {

    int score;
    int choice;
    Random r = new Random();
    private static final String answers[] = {"True", "True", "False"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.randlayout);
        Intent receive = getIntent();
        score = Integer.parseInt(receive.getStringExtra("score"));

        TextView sun = (TextView) findViewById(R.id.sun);
        TextView ha = (TextView) findViewById(R.id.ha);
        TextView mo = (TextView) findViewById(R.id.mo);

        choice = r.nextInt(3);

        if(choice == 0) {
            sun.setVisibility(View.VISIBLE);
        } else if(choice == 1) {
            ha.setVisibility(View.VISIBLE);
        } else if(choice == 2) {
            mo.setVisibility(View.VISIBLE);
        }
    }

    public void randcheck(View view) {
        Button butt = (Button)view;

        TextView sun = (TextView) findViewById(R.id.sun);
        TextView ha = (TextView) findViewById(R.id.ha);
        TextView mo = (TextView) findViewById(R.id.mo);

        if(butt.getId() == R.id.randf && butt.getText().toString().equals(answers[choice])) {
            score = score + 1;
        } else if(butt.getId() == R.id.randt && butt.getText().toString().equals(answers[choice])) {
            score = score + 1;
        }

        //return score and go back to calling activity
        if(choice == 0) {
            sun.setVisibility(View.INVISIBLE);
        } else if(choice == 1) {
            ha.setVisibility(View.INVISIBLE);
        } else if(choice == 2) {
            mo.setVisibility(View.INVISIBLE);
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
