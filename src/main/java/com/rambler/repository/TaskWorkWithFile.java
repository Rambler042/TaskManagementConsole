package com.rambler.repository;

import com.rambler.model.Task;

import java.util.List;

public interface TaskWorkWithFile {

    public void saveTask(List<Task> taskList);

    public List<Task> getAllTask();

}
