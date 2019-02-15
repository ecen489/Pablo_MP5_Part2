package com.example.pablo_mp5_part2;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    // THIS IS THE QUIZ APP

    private static final String[] TOPIC = {"Random", "Spanish", "Music"};
    private int score = 0;
    static final int CODE = 2222;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //attach reference list to listy
        ListView list = (ListView) findViewById(R.id.listy);

        final Intent laidout = new Intent(this,laidout.class);
        //final Intent randintent = new Intent(this,randIntent.class);
        //final Intent spanintent = new Intent(this,spanIntent.class);
        //final Intent musintent = new Intent(this,musIntent.class);

        //Create adapter and attach to topics
        ArrayAdapter<String> myadapter = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,TOPIC);

        //Use myadapter and attach to TOPIC
        list.setAdapter(myadapter);
        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String item = parent.getItemAtPosition(position).toString();

                //System.out.println(item);
                //item = TOPIC[position];
                /*
                if(position == 0) {
                    laidout.putExtra("radio", "Random");
                    //randintent.putExtra("score",Integer.toString(score));
                    //startActivityForResult(randintent,CODE);
                }

                if(position == 1) {
                    laidout.putExtra("radio", "Spanish");
                    //spanintent.putExtra("score",Integer.toString(score));
                    //startActivityForResult(spanintent,CODE);
                }

                if(position == 2) {
                    laidout.putExtra("radio", "Music");
                    //musintent.putExtra("score",Integer.toString(score));
                    //startActivityForResult(musintent,CODE);
                }*/
                laidout.putExtra("radio",item);
                laidout.putExtra("score",Integer.toString(score));
                startActivityForResult(laidout,CODE);
            }
        });
    }

    //back from other activity
    protected void onActivityResult(int requestCode, int resultCode, Intent intent) {
        super.onActivityResult(requestCode,resultCode,intent);
        if(requestCode == CODE && intent != null) {
            score = Integer.parseInt(intent.getStringExtra("score"));
            TextView num = (TextView) findViewById(R.id.scorenum);
            num.setText(Integer.toString(score));
        }
        //Intent backtostart = new Intent(this,MainActivity.class);
        //startActivity(backtostart);
    }

    public void resetti(View view) {
        score = 0;
        TextView num = (TextView) findViewById(R.id.scorenum);
        num.setText(Integer.toString(score));
    }
}
