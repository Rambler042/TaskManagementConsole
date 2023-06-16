package com.rambler.menu;

import com.rambler.model.Task;

import java.util.ArrayList;

public interface Menu {

    public void mainMenu();

    public Task addTask(int sizeList);

    public void viewing(ArrayList<Task> taskList);

    public Task update(ArrayList<Task> taskList, int id);

    public void delete(ArrayList<Task> taskList, int id);
}
