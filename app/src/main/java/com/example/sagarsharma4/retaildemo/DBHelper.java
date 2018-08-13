package com.example.sagarsharma4.retaildemo;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.DatabaseUtils;
import android.database.sqlite.SQLiteOpenHelper;
import android.database.sqlite.SQLiteDatabase;

public class DBHelper extends SQLiteOpenHelper {

    public static final String DATABASE_NAME = "MyDBName.db";
    public static final String ITEMS_TABLE_NAME = "users";
    public static final String ITEMS_COLUMN_ID = "_id";
    public static final String ITEMS_COLUMN_NAME = "name";
    public static final String ITEMS_COLUMN_PASSWORD = "password";
//    public static final String ITEMS_COLUMN_IMAGE_ID = "imageID";
//    public static final String ITEMS_COLUMN_SHORT_DESCP = "short_descp";
//    public static final String ITEMS_COLUMN_LONG_DESCP = "long_descp";

    public DBHelper(Context context) {
        super(context, DATABASE_NAME , null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        // TODO Auto-generated method stub
        db.execSQL(
                "create table " + ITEMS_TABLE_NAME +
                        "("+ITEMS_COLUMN_ID+" integer , "+ITEMS_COLUMN_NAME+" text primary key, "+ITEMS_COLUMN_PASSWORD+
                        " text )"
        );
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // TODO Auto-generated method stub
        db.execSQL("DROP TABLE IF EXISTS items");
        onCreate(db);
    }

    public boolean insertItem (String name, String password) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(ITEMS_COLUMN_NAME, name);
        contentValues.put(ITEMS_COLUMN_PASSWORD, password);
        db.insert(ITEMS_TABLE_NAME, null, contentValues);
        return true;
    }

    public Cursor getData(int id) {
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor res =  db.rawQuery( "select * from "+ITEMS_TABLE_NAME+" where id="+id+"", null );
        return res;
    }

    public int numberOfRows(){
        SQLiteDatabase db = this.getReadableDatabase();
        int numRows = (int) DatabaseUtils.queryNumEntries(db, ITEMS_TABLE_NAME);
        return numRows;
    }

    public boolean updateItems (Integer id, String name, String password) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(ITEMS_COLUMN_NAME, name);
        contentValues.put(ITEMS_COLUMN_PASSWORD, password);
        db.update(ITEMS_TABLE_NAME, contentValues, "id = ? ", new String[] { Integer.toString(id) } );
        return true;
    }

    public Integer deleteItems (Integer id) {
        SQLiteDatabase db = this.getWritableDatabase();
        return db.delete(ITEMS_TABLE_NAME,
                "id = ? ",
                new String[] { Integer.toString(id) });
    }


    public String getUserPass(String nm) {
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor res =  db.rawQuery( "select * from "+ITEMS_TABLE_NAME+" where "+ITEMS_COLUMN_NAME+" = ?", new String[]{nm});
        res.moveToFirst();
        String pass=res.getString(res.getColumnIndex(ITEMS_COLUMN_PASSWORD));
        return pass;
    }

    public boolean doesExist(String nm) {
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor res =  db.rawQuery( "select * from "+ITEMS_TABLE_NAME+" where "+ITEMS_COLUMN_NAME+" = ?", new String[]{nm});
        res.moveToFirst();
        if ((res!=null)&&(res.getCount()>0))
            return true;
        else
            return false;
    }

}