package com.orathai.mysqlapplication;

import java.io.Serializable;

/**
 * Created by User on 10/2/2560.
 */

public class ToDoList implements Serializable{
    public int taskid;
    public String taskname;

    public int getTaskid() {
        return taskid;
    }

    public void setTaskid(int taskid) {
        this.taskid = taskid;
    }

    public String getTaskname() {
        return taskname;
    }

    public void setTaskname(String taskname) {
        this.taskname = taskname;
    }
}
