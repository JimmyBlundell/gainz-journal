package com.example.gainzjournal;

import androidx.appcompat.app.AppCompatActivity;

import android.view.View;
import android.content.Intent;
import android.view.View.OnClickListener;
import android.os.Bundle;
import android.widget.ImageButton;

public class MainActivity extends AppCompatActivity {

    private ImageButton exercises_button;
    private ImageButton routines_button;
    private ImageButton logs_button;
    private ImageButton records_button;

    DatabaseHelper myDb;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        myDb = new DatabaseHelper(this);

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        exercises_button = findViewById(R.id.exercises_button);
        exercises_button.setOnClickListener(new OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                  openExercisesAddActivity();
            }
        });

        routines_button = findViewById(R.id.routines_button);
        routines_button.setOnClickListener(new OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                openRoutinesActivity();
            }
        });

        logs_button = findViewById(R.id.logs_button);
        logs_button.setOnClickListener(new OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                openLogsActivity();
            }
        });

        records_button = findViewById(R.id.records_button);
        records_button.setOnClickListener(new OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                openRecordsActivity();
            }
        });

    }

    public void openExercisesAddActivity()
    {
        Intent intent = new Intent(this, ExercisesAdd.class);
        startActivity(intent);
    }

    public void openRoutinesActivity()
    {
        Intent intent = new Intent(this, Routines.class);
        startActivity(intent);
    }

    public void openLogsActivity()
    {
        Intent intent = new Intent(this, Logs.class);
        startActivity(intent);
    }

    public void openRecordsActivity()
    {
        Intent intent = new Intent(this, Records.class);
        startActivity(intent);
    }

}
