package com.MainActivity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.Data.MyServerData;
import com.QuizActivity.QuizActivity;
import com.example.andrei.multiplechoicequestions.R;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.app.Activity;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;

import java.text.BreakIterator;


public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_activity_menu);
        Button btnGrile = (Button)findViewById(R.id.question);
        btnGrile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent Quiz = new Intent(getApplicationContext(), QuizActivity.class);
                MyServerData.getInstance().setTestState("inProgress");
                startActivity(Quiz);
            }
        });
    }

}
