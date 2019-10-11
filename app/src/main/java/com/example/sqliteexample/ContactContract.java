package com.example.sqliteexample;

import android.provider.BaseColumns;

public final class ContactContract {

    //constructor
    private ContactContract(){}


    //inner class
    public static class ContactEntry implements BaseColumns {

        //specify database schema: first table name
        public static final String TABLE_NAME = "contact_info";
        public static final String CONTACT_ID = "contact_id";
        public static final String NAME = "name";
        public static final String EMAIL = "email";
    }
}
