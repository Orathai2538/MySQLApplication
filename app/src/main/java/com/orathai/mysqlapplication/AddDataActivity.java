package com.orathai.mysqlapplication;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class AddDataActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_data);
        final EditText newTodoListText = (EditText) findViewById(R.id.editTextAddTask);
        final Button newTodoListButton = (Button) findViewById(R.id.btnAddNewTask);

        newTodoListButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ToDoList todoList = new ToDoList();
                todoList.setTaskname(String.valueOf(newTodoListText.getText()));

                ToDoListDAO todolistdao = new ToDoListDAO(getApplicationContext());

                todolistdao.open();
                todolistdao.add(todoList);
                todolistdao.close();
                finish();
            }
        });
    }

}
