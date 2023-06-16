package com.rambler.repository;

import com.rambler.model.Task;
import org.springframework.stereotype.Component;

import java.util.List;

public interface TaskRepository {

    public void saveTask(List<Task> taskList);

    public List<Task> getAllTask();

}
