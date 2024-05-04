package com.lina.tracker;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DatabaseHelper extends SQLiteOpenHelper {

    private static final String DATABASE_NAME = "UserData.db";
    private static final int DATABASE_VERSION = 1;
    private static final String TABLE_NAME = "users";
    private static final String COLUMN_ID = "id";
    private static final String COLUMN_FULL_NAME = "full_name";
    private static final String COLUMN_PHONE_NUMBER = "phone_number";
    private static final String COLUMN_EMAIL = "email";
    private static final String COLUMN_ROLE = "role";
    private static final String COLUMN_GENDER = "gender";
    private static final String COLUMN_PASSWORD = "password";

    private static final String CREATE_TABLE_USERS = "CREATE TABLE " + TABLE_NAME +
            "(" +
            COLUMN_ID + " TEXT PRIMARY KEY," +
            COLUMN_FULL_NAME + " TEXT," +
            COLUMN_PHONE_NUMBER + " TEXT," +
            COLUMN_EMAIL + " TEXT," +
            COLUMN_ROLE + " TEXT," +
            COLUMN_GENDER + " TEXT," +
            COLUMN_PASSWORD + " TEXT" +
            ")";

    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREATE_TABLE_USERS);
        insertDefaultUsers(db);
    }

    private void insertDefaultUsers(SQLiteDatabase db) {
        // Insert default student account
        ContentValues studentValues = new ContentValues();
        studentValues.put(COLUMN_ID, "601006000");
        studentValues.put(COLUMN_FULL_NAME, "rado no");
        studentValues.put(COLUMN_PHONE_NUMBER, "0123456789");
        studentValues.put(COLUMN_EMAIL, "student@gmail.com");
        studentValues.put(COLUMN_ROLE, "student");
        studentValues.put(COLUMN_GENDER, "male");
        studentValues.put(COLUMN_PASSWORD, "12345");
        db.insert(TABLE_NAME, null, studentValues);

        // Insert default teacher account
        ContentValues teacherValues = new ContentValues();
        teacherValues.put(COLUMN_ID, "601006001");
        teacherValues.put(COLUMN_FULL_NAME, "Teacher Name");
        teacherValues.put(COLUMN_PHONE_NUMBER, "0123456789");
        teacherValues.put(COLUMN_EMAIL, "teacher@gmail.com");
        teacherValues.put(COLUMN_ROLE, "teacher");
        teacherValues.put(COLUMN_GENDER, "female");
        teacherValues.put(COLUMN_PASSWORD, "11111");
        db.insert(TABLE_NAME, null, teacherValues);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(db);
    }

    // Method to add a new user to the database
    public long addUser(String id, String fullName, String phoneNumber, String email, String gender, String password, String role) {
        if (email.isEmpty() || password.isEmpty()) {
            // Email or password is empty, return -1 to indicate failure
            return -1;
        }

        if (checkEmailExists(email)) {
            // Email already exists, return -1 to indicate failure
            return -1;
        }

        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(COLUMN_ID, id);
        values.put(COLUMN_FULL_NAME, fullName);
        values.put(COLUMN_PHONE_NUMBER, phoneNumber);
        values.put(COLUMN_EMAIL, email);
        values.put(COLUMN_GENDER, gender);
        values.put(COLUMN_ROLE, role);
        values.put(COLUMN_PASSWORD, password);

        long result = db.insert(TABLE_NAME, null, values);
        db.close();
        return result;
    }

    // Method to check if the email already exists in the database
    private boolean checkEmailExists(String email) {
        SQLiteDatabase db = this.getReadableDatabase();
        String query = "SELECT * FROM " + TABLE_NAME + " WHERE " + COLUMN_EMAIL + "=?";
        Cursor cursor = db.rawQuery(query, new String[]{email});
        boolean emailExists = cursor.getCount() > 0;
        cursor.close();
        return emailExists;
    }

    // Method to authenticate a user
    public boolean authenticateUser(String email, String password, String role) {
        SQLiteDatabase db = this.getReadableDatabase();
        String query = "SELECT " + COLUMN_PASSWORD + " FROM " + TABLE_NAME + " WHERE " + COLUMN_EMAIL + "=? AND " + COLUMN_ROLE + "=?";
        Cursor cursor = db.rawQuery(query, new String[]{email, role});

        boolean isValid = false;

        if (cursor.moveToFirst()) {
            String storedPassword = cursor.getString(cursor.getColumnIndex(COLUMN_PASSWORD));

            if (password.equals(storedPassword)) {
                isValid = true;
            }
        }

        cursor.close();
        return isValid;
    }


    // Method to get user's role based on email
    public String getUserRole(String email) {
        SQLiteDatabase db = this.getReadableDatabase();
        String query = "SELECT " + COLUMN_ROLE + " FROM " + TABLE_NAME + " WHERE " + COLUMN_EMAIL + "=?";
        Cursor cursor = db.rawQuery(query, new String[]{email});

        String role = "";

        if (cursor.moveToFirst()) {
            role = cursor.getString(cursor.getColumnIndex(COLUMN_ROLE));
        }

        cursor.close();
        return role;
    }
}
