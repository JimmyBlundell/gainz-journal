package com.example.gainzjournal;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class DatabaseHelper extends SQLiteOpenHelper {

    public static final String GAINZ_DB = "Gainz.db";
    public static final String WORKOUT_TABLE = "workout_table";
    public static final String EXERCISE_TABLE = "exercise_table";


/*
Write up diagrams of how workout and exercise tables look, and their relations!
Do workouts contain exercises? How does that look in a db? How to differentiate between doing same exercise in different workouts?
How to update PRs for each exercise, especially if they occur in different workouts?
*/



    public DatabaseHelper(@Nullable Context context, @Nullable String name, @Nullable SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }


}
