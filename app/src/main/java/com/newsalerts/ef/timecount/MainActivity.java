package com.newsalerts.ef.timecount;

import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {
    private ProgressBar progressBarCircle;
    TextView time;
//    Button pause;
    CountDownTimer countDownTimer;
    long timeMilleSecond = 10000; //10mints
    boolean timeIsRunning;
    CardView cardView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        cardView = (CardView)findViewById(R.id.cardView);
        time = (TextView) findViewById(R.id.textView);
        progressBarCircle = (ProgressBar) findViewById(R.id.progressBarCircle);

        cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startStop();
            }
        });
    }

    private void startStop() {
        if(timeIsRunning){
            stopTimer();
        }else{
            stratTimer();
        }
    }

    private void stratTimer() {
        countDownTimer = new CountDownTimer(timeMilleSecond, 1000) {
            @Override
            public void onTick(long l) {
                timeMilleSecond = l;
                updateTimer();
            }

            @Override
            public void onFinish() {

            }
        }.start();
        time.setText("PAUSE");
        timeIsRunning = true;
    }

    private void stopTimer() {
        countDownTimer.cancel();
        time.setText("START");
        timeIsRunning = false;
    }

    private void updateTimer() {
        int minites = (int)timeMilleSecond / 1000;

        String timeLeft;
        timeLeft = "" + minites;

        time.setText(timeLeft);
        progressBarCircle.setProgress(Integer.parseInt(timeLeft));
    }
}
