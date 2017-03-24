package com.MainActivity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.andrei.multiplechoicequestions.R;
import android.os.CountDownTimer;
import android.app.Activity;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;

import static com.example.andrei.multiplechoicequestions.R.id.start_button;



public class Main2Activity extends Activity implements OnClickListener  {
    private santimer timer;
    private Boolean timer_flag=false;
    private final long startTime = 50000;
    private final long interval = 1000;
    private Button start;
    private TextView text,time_eplapsed;
    private long timeElapsed;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.quiz_activity_fragment);
        start = (Button) findViewById(start_button);
        start.setOnClickListener(this);
        text = (TextView) findViewById(R.id.timer);
        time_eplapsed = (TextView) findViewById(R.id.timeElapsed);
        timer = new santimer(startTime, interval);
        text.setText(text.getText() + String.valueOf(startTime));

           }
    @Override
    public void onClick(View v) {
        // TODO Auto-generated method stub
        if (!timer_flag) {
            timer.start();
            timer_flag = true;
            start.setText("Start");
        } else {
            timer.cancel();
            timer_flag = false;
            start.setText("Reset");
        }
    }

    private class santimer extends CountDownTimer {

        public santimer(long millisInFuture, long countDownInterval) {
            super(millisInFuture, countDownInterval);
            // TODO Auto-generated constructor stub

        }

        @Override
        public void onFinish() {
            // TODO Auto-generated method stub
            text.setText("Time's up!");
            time_eplapsed.setText("Time Elapsed: " + String.valueOf(startTime));
        }

        @Override
        public void onTick(long millisUntilFinished) {
            // TODO Auto-generated method stub
            text.setText("Time remain:" + millisUntilFinished);
            timeElapsed = startTime - millisUntilFinished;
            time_eplapsed.setText("Time Elapsed: "
                    + String.valueOf(timeElapsed));
        }

    }

}
