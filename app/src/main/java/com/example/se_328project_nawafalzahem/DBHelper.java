package com.example.se_328project_nawafalzahem;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DBHelper extends SQLiteOpenHelper {
    public static final String DATABASE_NAME = "nawaf190290.db";
    public static final String TABLE_NAME = "students";
    public static final String COL1 = "UNI_ID";
    public static final String COL2 = "Fname";
    public static final String COL3 = "Lname";
    public static final String COL4 = "Phone";
    public static final String COL5 = "Email";


    /* Constructor */
    public DBHelper(Context context) {
        super(context, DATABASE_NAME, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String createTable = "CREATE TABLE " + TABLE_NAME +
                " (UNI_ID INTEGER PRIMARY KEY, " +
                " Fname TEXT, Lname TEXT,Phone Text,Email TEXT)";
        db.execSQL(createTable);

    }


    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(db);

    }
    /* Basic function to add data. REMEMBER: The fields
    here, must be in accordance with those in
    the onCreate method above.
 */
    public boolean addData(int UNI_ID, String Fname,String Lname,String Phone,String Email) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(COL1, UNI_ID);
        contentValues.put(COL2, Fname);
        contentValues.put(COL3, Lname);
        contentValues.put(COL4, Phone);
        contentValues.put(COL5, Email);


        long result = db.insert(TABLE_NAME, null, contentValues);

        //if data are inserted incorrectly, it will return -1
        if(result == -1)
        {return false;}

        else

        {return true;}
    }

    public boolean deleteData(int UNI_ID) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(COL1, UNI_ID);

        long result = db.delete(TABLE_NAME, COL1+"= "+UNI_ID, null);

        //if data are Deleted, it will return 1
        if(result == 0)
        {
            return false;
        }

        else

        {
            return true;
        }
    }

    /* Returns only one result */
    public Cursor structuredQuery(int UNI_ID) {
        SQLiteDatabase db = this.getReadableDatabase(); // No need to write
        Cursor cursor = db.query(TABLE_NAME, new String[]{COL1,
                        COL2, COL3,COL4,COL5}, COL1 + "=?",
                new String[]{String.valueOf(UNI_ID)}, null, null, null, null);
        if (cursor != null)
            cursor.moveToFirst();

        return cursor;
    }


    public Cursor getSpecificResult(int UNI_ID){
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor data = db.rawQuery("SELECT * FROM students WHERE UNI_ID="+UNI_ID,null);
        if (data != null)
            data.moveToFirst();
        return data;
    }

    // Return everything inside the dB
    public Cursor getListContents() {
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor data = db.rawQuery("SELECT * FROM students" , null);
        return data;
    }
}

