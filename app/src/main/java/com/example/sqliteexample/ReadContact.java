package com.example.sqliteexample;


import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ScrollView;
import android.widget.TextView;


/**
 * A simple {@link Fragment} subclass.
 */
public class ReadContact extends Fragment {

    private TextView Txt_Display;
    private DBAdapter db;



    public ReadContact() {
        // Required empty public constructor
    }



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_read_contact, container, false);
        Txt_Display = view.findViewById(R.id.txt_display);
        //readContacts();
        return view;
    }

    public void onActvityCreated(Bundle savedInstanceState){

        ScrollView scrollView = getView().findViewById(R.id.txt_display);
        db = new DBAdapter();
    }

    public static void readContacts(ContactdbHelper dbHelper){
        SQLiteDatabase db = dbHelper.getReadableDatabase();
        final String[] nameColumns = {ContactContract.ContactEntry.CONTACT_ID, ContactContract.ContactEntry.NAME, ContactContract.ContactEntry.EMAIL};
        final Cursor courseCursor = db.query(ContactContract.ContactEntry.TABLE_NAME, nameColumns, null, null, null, null, null);

        loadNamesFromDatabase(courseCursor);

    }

    private static void loadNamesFromDatabase(Cursor cursor) {
        int courseIdPos = cursor.getColumnIndex(ContactContract.ContactEntry.CONTACT_ID);
        int courseNamePos = cursor.getColumnIndex(ContactContract.ContactEntry.NAME);
        int courseEmailPos = cursor.getColumnIndex(ContactContract.ContactEntry.EMAIL);

        ReadContact readContact = new ReadContact();
        readContact.getRetainInstance();
        readContact.Txt_Display.cancelLongPress();
        while (cursor.moveToNext()){
            String courseId = cursor.getString(courseIdPos);
            String courseName = cursor.getString(courseNamePos);
            String courseEmail = cursor.getString(courseEmailPos);
            ContactContract.ContactEntry contactEntry = new ContactContract.ContactEntry();
            readContact.Txt_Display.isShown();
        }
        cursor.close();

    }

    /*private void readContacts(){
        ContactdbHelper contactdbHelper = new ContactdbHelper(getActivity());
        SQLiteDatabase database = contactdbHelper.getReadableDatabase();

         Cursor cursor = contactdbHelper.readContacts(database);
        String info ="";

        while (cursor.moveToNext()){

            String id = Integer.toString(cursor.getInt(cursor.getColumnIndex(ContactContract.ContactEntry.CONTACT_ID)));
            String name = cursor.getString(cursor.getColumnIndex(ContactContract.ContactEntry.NAME));
            String email = cursor.getString(cursor.getColumnIndex(ContactContract.ContactEntry.EMAIL));
            info = info + "\n\n" + "Id :" + id + "\nName :" + name  + "\nEmail :" + email;

        }

        Txt_Display.setText(info);

        contactdbHelper.close();*/
    }


