package com.example.gainzjournal;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.database.Cursor;
import android.widget.ListAdapter;
import java.util.ArrayList;
import android.widget.Toast;

public class ExercisesView extends AppCompatActivity {

    DatabaseHelper db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.view_exercises);

        db = new DatabaseHelper(this);
        ListView exercise_list = (ListView) findViewById(R.id.exercise_list);

        ArrayList<String> theList = new ArrayList<>();
        Cursor exercises = db.getExercises();

        if (exercises.getCount() == 0) {
            Toast.makeText(ExercisesView.this, "Database empty :(", Toast.LENGTH_LONG).show();
        } else {
            while (exercises.moveToNext()) {
                theList.add(exercises.getString(1));
                ListAdapter listAdapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, theList);
                exercise_list.setAdapter(listAdapter);
            }
        }
    }
}
