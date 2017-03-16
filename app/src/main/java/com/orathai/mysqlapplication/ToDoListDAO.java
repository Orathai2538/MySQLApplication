package com.orathai.mysqlapplication;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import java.util.ArrayList;

/**
 * Created by orathai on 10/2/2560.
 */

public class ToDoListDAO {
    private SQLiteDatabase database;
    private DBHelper dbHelper;

    public ToDoListDAO(Context context){
        dbHelper = new DBHelper(context);
    }

    public void open(){
        database = dbHelper.getWritableDatabase();
    }

    public  void close(){
        dbHelper.close();
    }
    public ArrayList<ToDoList> getAlltodoList(){
        ArrayList<ToDoList> todoList = new ArrayList<ToDoList>();
        Cursor cursor = database.rawQuery("SELECT * FROM tbtodo_list;",null);
        cursor.moveToFirst();

        ToDoList todoList1;
        while (!cursor.isAfterLast()){

            todoList1 = new ToDoList();
            todoList1.setTaskid(cursor.getInt(0));
            todoList1.setTaskname(cursor.getString(1));

            todoList.add(todoList1);
            cursor.moveToNext();
        }
        cursor.close();
        return todoList;
    }

    public void add(ToDoList todolist){

        ContentValues values = new ContentValues();

        values.put("taskname", todolist.getTaskname());
        this.database.insert("dbtodo_list",null,values);
        Log.d("To Do List Demo:::","Add OK");
    }
    public void update(ToDoList todoList){
        ToDoList updateTodoList = todoList;
        ContentValues values = new ContentValues();
        values.put("taskname", updateTodoList.getTaskname());
        values.put("taskid",updateTodoList.getTaskid());
        String where = "taskid=" + updateTodoList.getTaskid();
        this.database.update("tbtodo_list", values, where, null);

        Log.d("Todo List Demo :::", "Update OK");

    }
    public void delete(ToDoList todoList){
        ToDoList delTodoList = todoList;

        String sqlText = "DELETE FROM tbtodo_list WHERE taskid=" +delTodoList.getTaskid();
        this.database.execSQL(sqlText);
    }
}


