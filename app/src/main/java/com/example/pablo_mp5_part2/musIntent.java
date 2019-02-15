package com.example.pablo_mp5_part2;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.Random;
//import android.widget.Toast;

public class musIntent extends AppCompatActivity {

    int score;
    int choice;
    Random r = new Random();
    private static final String answers[] = {"True", "False", "True"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.randlayout);
        Intent receive = getIntent();
        score = Integer.parseInt(receive.getStringExtra("score"));

        TextView lofi = (TextView) findViewById(R.id.lofi);
        TextView beat = (TextView) findViewById(R.id.beat);
        TextView sp = (TextView) findViewById(R.id.sp);

        choice = r.nextInt(3);

        if(choice == 0) {
            lofi.setVisibility(View.VISIBLE);
        } else if(choice == 1) {
            beat.setVisibility(View.VISIBLE);
        } else if(choice == 2) {
            sp.setVisibility(View.VISIBLE);
        }
    }

    public void muscheck(View view) {
        Button butt = (Button)view;

        TextView lofi = (TextView) findViewById(R.id.lofi);
        TextView beat = (TextView) findViewById(R.id.beat);
        TextView sp = (TextView) findViewById(R.id.sp);

        if(butt.getId() == R.id.randf && butt.getText().toString().equals(answers[choice])) {
            score = score + 1;
        } else if(butt.getId() == R.id.randt && butt.getText().toString().equals(answers[choice])) {
            score = score + 1;
        }

        //return score and go back to calling activity
        if(choice == 0) {
            lofi.setVisibility(View.INVISIBLE);
        } else if(choice == 1) {
            beat.setVisibility(View.INVISIBLE);
        } else if(choice == 2) {
            sp.setVisibility(View.INVISIBLE);
        }

        Intent back = new Intent();
        back.putExtra("score", Integer.toString(score));
        setResult(RESULT_OK,back);
        finish();
    }
}
