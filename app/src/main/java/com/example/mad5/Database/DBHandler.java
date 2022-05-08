package com.example.mad5.Database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.provider.BaseColumns;

import java.util.ArrayList;
import java.util.List;

//DBHandler
public class DBHandler extends SQLiteOpenHelper {
    // If you change the database schema, you must increment the database version.
    public static final int DATABASE_VERSION = 1;
    public static final String DATABASE_NAME = "FeedReader.db";

    public DBHandler(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(SQL_CREATE_ENTRIES);
    }
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // This database is only a cache for online data, so its upgrade policy is
        // to simply to discard the data and start over
        db.execSQL(SQL_DELETE_ENTRIES);
        onCreate(db);
    }
    public void onDowngrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        onUpgrade(db, oldVersion, newVersion);
    }


    private static final String SQL_CREATE_ENTRIES =
            "CREATE TABLE " + createDeli.delivers.TABLE_NAME + " (" +
                    createDeli.delivers._ID + " INTEGER PRIMARY KEY," +
                    createDeli.delivers.COLUMN_1 + " TEXT," +
                    createDeli.delivers.COLUMN_2 + " TEXT," +
                    createDeli.delivers.COLUMN_3 + " TEXT," +
                    createDeli.delivers.COLUMN_4 + " TEXT," +
                    createDeli.delivers.COLUMN_5 + " TEXT)";

    private static final String SQL_DELETE_ENTRIES =
            "DROP TABLE IF EXISTS " + createDeli.delivers.TABLE_NAME;


    //Add Function
    public long addInfo(String name,String phone,String address,String location,String type){

        // Gets the data repository in write mode
        SQLiteDatabase db = getWritableDatabase();

// Create a new map of values, where column names are the keys
        ContentValues values = new ContentValues();
        values.put(createDeli.delivers.COLUMN_1, name);
        values.put(createDeli.delivers.COLUMN_2, phone);
        values.put(createDeli.delivers.COLUMN_3, address);
        values.put(createDeli.delivers.COLUMN_4, location);
        values.put(createDeli.delivers.COLUMN_5, type);

// Insert the new row, returning the primary key value of the new row
        long newRowId = db.insert(createDeli.delivers.TABLE_NAME, null, values);
        return newRowId;

    }
    //Update Function

    public boolean updateInfo(String name,String phone,String address,String location,String type){

        SQLiteDatabase db = getWritableDatabase();

// New value for one column

        ContentValues values = new ContentValues();
        values.put(createDeli.delivers.COLUMN_1, name);
        values.put(createDeli.delivers.COLUMN_2, phone);
        values.put(createDeli.delivers.COLUMN_3,address);
        values.put(createDeli.delivers.COLUMN_4, location);
        values.put(createDeli.delivers.COLUMN_5, type);


// Which row to update, based on the title
        String selection = createDeli.delivers.COLUMN_1 + " LIKE ?";
        String[] selectionArgs = { name };

        int count = db.update(
                createDeli.delivers.TABLE_NAME,
                values,
                selection,
                selectionArgs);
           if(count>=1){

                return true;

           }else{

                return false;

           }

    }

    //Delete

    public void deliteInfo(String name){
        SQLiteDatabase db = getWritableDatabase();
        // Define 'where' part of query.
        String selection = createDeli.delivers.COLUMN_1 + " LIKE ?";
// Specify arguments in placeholder order.
        String[] selectionArgs = { name };
// Issue SQL statement.
        int deletedRows = db.delete(createDeli.delivers.TABLE_NAME, selection, selectionArgs);


    }


   //Read all

    public List readAllInfo(){

     String name="sithum";
        SQLiteDatabase db = getReadableDatabase();

// Define a projection that specifies which columns from the database
// you will actually use after this query.
        String[] projection = {
                BaseColumns._ID,
                createDeli.delivers.COLUMN_1,
                createDeli.delivers.COLUMN_2,
                createDeli.delivers.COLUMN_3,
                createDeli.delivers.COLUMN_4,
                createDeli.delivers.COLUMN_5,





        };

// Filter results WHERE "title" = 'My Title'
        String selection = createDeli.delivers.COLUMN_1 + " = ?";
        String[] selectionArgs = { name };

// How you want the results sorted in the resulting Cursor
        String sortOrder =
               createDeli.delivers.COLUMN_1 + " ASC";

        Cursor cursor = db.query(
                createDeli.delivers.TABLE_NAME,   // The table to query
                projection,             // The array of columns to return (pass null to get all)
                null,              // The columns for the WHERE clause
                null,          // The values for the WHERE clause
                null,                   // don't group the rows
                null,                   // don't filter by row groups
                sortOrder               // The sort order
        );


        List usernames = new ArrayList<>();
        while(cursor.moveToNext()) {
            String user = cursor.getString(
                    cursor.getColumnIndexOrThrow(createDeli.delivers.COLUMN_1));
            usernames.add(user);
        }
        cursor.close();
        return usernames;

    }



//Override

    public List readAllInfo(String name){


        SQLiteDatabase db = getReadableDatabase();

// Define a projection that specifies which columns from the database
// you will actually use after this query.
        String[] projection = {
                BaseColumns._ID,
                createDeli.delivers.COLUMN_1,
                createDeli.delivers.COLUMN_2,
                createDeli.delivers.COLUMN_3,
                createDeli.delivers.COLUMN_4,
                createDeli.delivers.COLUMN_5,





        };

// Filter results WHERE "title" = 'My Title'
        String selection = createDeli.delivers.COLUMN_1 + " LIKE ?";
        String[] selectionArgs = { name };

// How you want the results sorted in the resulting Cursor
        String sortOrder =
                createDeli.delivers.COLUMN_1 + " ASC";

        Cursor cursor = db.query(
                createDeli.delivers.TABLE_NAME,   // The table to query
                projection,             // The array of columns to return (pass null to get all)
                selection,              // The columns for the WHERE clause
                selectionArgs,          // The values for the WHERE clause
                null,                   // don't group the rows
                null,                   // don't filter by row groups
                sortOrder               // The sort order
        );


        List userinfo = new ArrayList<>();
        while(cursor.moveToNext()) {
            String user = cursor.getString(cursor.getColumnIndexOrThrow(createDeli.delivers.COLUMN_1));
            String phone = cursor.getString(cursor.getColumnIndexOrThrow(createDeli.delivers.COLUMN_2));
            String address = cursor.getString(cursor.getColumnIndexOrThrow(createDeli.delivers.COLUMN_3));
            String location = cursor.getString(cursor.getColumnIndexOrThrow(createDeli.delivers.COLUMN_4));
            String type = cursor.getString(cursor.getColumnIndexOrThrow(createDeli.delivers.COLUMN_5));

            userinfo.add(user);//0
            userinfo.add(phone);//1
            userinfo.add(address);//2
            userinfo.add(location);//3
            userinfo.add(type);//4
        }
        cursor.close();
        return userinfo;

    }

}