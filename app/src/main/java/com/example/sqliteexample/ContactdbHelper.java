package com.example.sqliteexample;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

public class ContactdbHelper extends SQLiteOpenHelper{

    public static final String DATABASE_NAME = "contact_db";
    public static final int DATABASE_VERSION = 1;

    private static final String SQL_CREATE_ENTRIES = "CREATE TABLE " + ContactContract.ContactEntry.TABLE_NAME +
            " ("+ ContactContract.ContactEntry.CONTACT_ID + " INTEGER PRIMARY KEY ," + ContactContract.ContactEntry.NAME + "TEXT," +
            ContactContract.ContactEntry.EMAIL + "TEXT)";

    private static final String SQL_DELETE_TABLE = "DROP TABLE IF EXISTS "+ ContactContract.ContactEntry.TABLE_NAME;
    public Cursor cursor;

    public ContactdbHelper(Context context){

        super(context, DATABASE_NAME, null, DATABASE_VERSION);
        Log.d("Database Operations","Database created...");
    }


    @Override
    public void onCreate(SQLiteDatabase db) {

        db.execSQL(SQL_CREATE_ENTRIES);
        Log.d("Database Operations","Table created...");

    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

        sqLiteDatabase.execSQL(SQL_DELETE_TABLE);
        onCreate(sqLiteDatabase);

    }

    public void addContact(int id, String name, String email, SQLiteDatabase database){

        ContentValues contentValues = new ContentValues();
        contentValues.put(ContactContract.ContactEntry.CONTACT_ID, id);
        contentValues.put(ContactContract.ContactEntry.NAME, name);
        contentValues.put(ContactContract.ContactEntry.EMAIL, email);

        database.insert(ContactContract.ContactEntry.TABLE_NAME, null, contentValues);
        Log.d("Database Operations", "One Row Inserted...");
    }

    public Cursor readContacts(SQLiteDatabase database){
        String[] projections = {ContactContract.ContactEntry.CONTACT_ID, ContactContract.ContactEntry.NAME, ContactContract.ContactEntry.EMAIL};

        Cursor cursor = database.query(ContactContract.ContactEntry.TABLE_NAME, projections,null, null, null, null, null);
        return cursor;

    }
}
