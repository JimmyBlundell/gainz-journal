package com.example.gainzjournal;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class DatabaseHelper extends SQLiteOpenHelper {
    public static final String DB_NAME = "gainz.db";
    public static final String EXERCISE_TABLE = "exercises";
    public static final String ROUTINE_TABLE = "routines";
    public static final String ROUTINE_EXERCISE_TABLE = "routine_exercise";
    public static final String REP_CNT_WEIGHT_TABLE = "rep_cnt_weight";
    public static final String ROUTINE_EXERCISE_REP_CNT_WEIGHT_TABLE = "routine_exercise_rep_cnt_weight";
    public static final String SESSION_TABLE = "sessions";
    public static final String LOG_WORKOUT_TABLE = "log_workout";

    public static final String exercise_name = "exercise_name";
    //public static final String routine_name = "routine_name";

    public DatabaseHelper(Context context) {
        super(context, DB_NAME, null, 1);
        SQLiteDatabase db = this.getWritableDatabase();
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table " + EXERCISE_TABLE + " (id INTEGER PRIMARY KEY AUTOINCREMENT, exercise_name TEXT NOT NULL)");
        db.execSQL("create table " + ROUTINE_TABLE + " (id INTEGER PRIMARY KEY AUTOINCREMENT, routine_name TEXT NOT NULL)");
        db.execSQL("create table " + ROUTINE_EXERCISE_TABLE + " (id INTEGER PRIMARY KEY AUTOINCREMENT, routine_id INTEGER NOT NULL, exercise_id INTEGER NOT NULL, FOREIGN KEY (routine_id) REFERENCES routines(id), FOREIGN KEY (exercise_id) REFERENCES exercises(id))");
        db.execSQL("create table " + REP_CNT_WEIGHT_TABLE + " (id INTEGER PRIMARY KEY AUTOINCREMENT, rep_cnt INTEGER NOT NULL, weight INTEGER NOT NULL)");
        db.execSQL("create table " + ROUTINE_EXERCISE_REP_CNT_WEIGHT_TABLE + " (id INTEGER PRIMARY KEY AUTOINCREMENT, routine_exercise_id INTEGER NOT NULL, rep_cnt_weight_id INTEGER NOT NULL, FOREIGN KEY (routine_exercise_id) REFERENCES routine_exercise(id), FOREIGN KEY (rep_cnt_weight_id) REFERENCES rep_cnt_weight(id))");
        db.execSQL("create table " + SESSION_TABLE + " (id INTEGER PRIMARY KEY AUTOINCREMENT, session_dts TEXT NOT NULL)");
        db.execSQL("create table " + LOG_WORKOUT_TABLE + " (id INTEGER PRIMARY KEY AUTOINCREMENT, session_id INTEGER NOT NULL, routine_exercise_rep_cnt_weight_id, FOREIGN KEY (session_id) REFERENCES sessions(id), FOREIGN KEY (routine_exercise_rep_cnt_weight_id) REFERENCES routine_exercise_rep_cnt_weight_(id))");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
        db.execSQL("DROP TABLE IF EXISTS " + EXERCISE_TABLE);
        db.execSQL("DROP TABLE IF EXISTS " + ROUTINE_TABLE);
        db.execSQL("DROP TABLE IF EXISTS " + ROUTINE_EXERCISE_TABLE);
        db.execSQL("DROP TABLE IF EXISTS " + REP_CNT_WEIGHT_TABLE);
        db.execSQL("DROP TABLE IF EXISTS " + ROUTINE_EXERCISE_REP_CNT_WEIGHT_TABLE);
        db.execSQL("DROP TABLE IF EXISTS " + SESSION_TABLE);
        db.execSQL("DROP TABLE IF EXISTS " + LOG_WORKOUT_TABLE);
        onCreate(db);
    }

    public boolean addExercise(String exercise) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(exercise_name, exercise);

        long result = db.insert(EXERCISE_TABLE, null, contentValues);

        if (result == -1) {
            return false;
        }
        else {
            return true;
        }
    }

    public Cursor getExercises() {
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor data = db.rawQuery("SELECT * FROM " + EXERCISE_TABLE, null);
        return data;
    }
}
