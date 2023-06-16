package com.rambler.repository;

import com.rambler.model.Task;
import org.springframework.stereotype.Component;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

@Component("taskRepository")
public class TaskRepositoryImpl implements TaskRepository{

    private static final String FILE_PATH = "tasks.txt";

    // Для решения проблемы с переносом строк в файле
    private String transfer = System.lineSeparator();

    @Override
    public void saveTask(List<Task> taskList) {
        try (FileWriter writer = new FileWriter(FILE_PATH, false)){
            for (Task task : taskList) {
                writer.write("Номер: " + task.getId() + transfer +
                        "Название: " + task.getNameTask() + transfer +
                        "Описание: " + task.getDescription() + transfer +
                        "===============================" + transfer);
            }
        } catch (IOException ex){
            ex.printStackTrace();
        }
    }

    @Override
    public List<Task> getAllTask() {
        try (FileReader reader = new FileReader(FILE_PATH)){

        }catch (Exception ex){
            ex.printStackTrace();
        }

        return null;
    }
}
