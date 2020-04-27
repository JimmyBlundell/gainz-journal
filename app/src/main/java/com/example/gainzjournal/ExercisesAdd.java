package com.example.gainzjournal;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;
import android.widget.EditText;

import android.os.Bundle;

public class ExercisesAdd extends AppCompatActivity {

    public DatabaseHelper myDb;
    private Button view_exercises_button;
    private Button add_exercises_button;
    private EditText edit_text_add_exercises;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_exercises_add);

        myDb = new DatabaseHelper(this);
        edit_text_add_exercises = findViewById(R.id.edit_text_add_exercise);

        view_exercises_button = findViewById(R.id.view_exercises_button);
        view_exercises_button.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                openExercisesViewActivity();
            }
        });

        add_exercises_button = findViewById(R.id.add_exercises_button);
        add_exercises_button.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                String newEntry = edit_text_add_exercises.getText().toString();
                if (edit_text_add_exercises.length() != 0) {
                    AddData(newEntry);
                    edit_text_add_exercises.setText("");
                }

                else {
                    Toast.makeText(ExercisesAdd.this, "You must first name your exercise!", Toast.LENGTH_LONG).show();
                }
            }
        });
    }

    public void AddData(String newEntry) {

        boolean insertData = myDb.addExercise(newEntry);
        if (insertData) {
            Toast.makeText(ExercisesAdd.this, "Success!", Toast.LENGTH_LONG).show();
        }
        else {
            Toast.makeText(ExercisesAdd.this, "Failed for whatever reason :(", Toast.LENGTH_LONG).show();
        }
    }

    public void openExercisesViewActivity() {
        Intent intent = new Intent(this, com.example.gainzjournal.ExercisesView.class);
        startActivity(intent);
    }
}
