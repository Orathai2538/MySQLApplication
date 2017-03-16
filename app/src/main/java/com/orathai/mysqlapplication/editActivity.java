package com.orathai.mysqlapplication;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class editActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit);
        final ToDoList editTodoList = (ToDoList) getIntent().getSerializableExtra("editTodoList");

        final EditText editText = (EditText)findViewById(R.id.editText);
        editText.setText(editTodoList.getTaskname());

        Button editBtn = (Button)findViewById(R.id.buttonEdit);
        editBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ToDoList eTodoList = new ToDoList();
                eTodoList.setTaskid(editTodoList.getTaskid());
                eTodoList.setTaskname(String.valueOf(editText.getText()));

                ToDoListDAO todoListDAO = new ToDoListDAO(getApplicationContext());
                todoListDAO.open();
                todoListDAO.update(eTodoList);
                todoListDAO.close();

                finish();
            }
        });
        Button delBtn = (Button) findViewById(R.id.delete);
        delBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ToDoListDAO todoListDAODel = new ToDoListDAO (getApplicationContext());
                todoListDAODel.open();
                todoListDAODel.delete(editTodoList);
                todoListDAODel.close();

                finish();

            }
        });

    }
}
