package com.orathai.mysqlapplication;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by User on 10/2/2560.
 */

public class DBHelper  extends SQLiteOpenHelper{
    private  static final String databaseName = "dbtodolList.sqllite";
    private static final int databaseVersion =1;
    Context myContext;

    private static final String SQLCreateTable =
            "CREATE TABLE tbtodo_list("+
                    "taskid INTEGER PRIMARY KEY AUTOINCREMENT,"+
                    "taskname TEXT)";
    public DBHelper(Context context){

        super(context, databaseName,null,databaseVersion);
        this.myContext = context;

    }
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(SQLCreateTable);
        String insertData1 = "INSERT INTO tbtodo_list (taskname) VALUES ('one')";
        String insertData2 = "INSERT INTO tbtodo_list (taskname) VALUES ('two')";
        String insertData3 = "INSERT INTO tbtodo_list (taskname) VALUES ('three')";
        String insertData4 = "INSERT INTO tbtodo_list (taskname) VALUES ('four')";
        String insertData5 = "INSERT INTO tbtodo_list (taskname) VALUES ('five')";
        db.execSQL(insertData1);
        db.execSQL(insertData2);
        db.execSQL(insertData3);
        db.execSQL(insertData4);
        db.execSQL(insertData5);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}

