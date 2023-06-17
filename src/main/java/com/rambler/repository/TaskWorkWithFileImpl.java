package com.rambler.repository;

import com.rambler.model.Task;
import org.springframework.stereotype.Component;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Component("taskRepository")
public class TaskWorkWithFileImpl implements TaskWorkWithFile {

    private static final String FILE_PATH = "tasks.txt";
    private static final String FILE_PATH_SYSTEM = "taskSystem.txt";

    // Для решения проблемы с переносом строк в файле
    private String transfer = System.lineSeparator();

    @Override
    public void saveTask(List<Task> taskList) {
        try (FileWriter writer = new FileWriter(FILE_PATH)){
            for (Task task : taskList) {
                writer.write("Номер: " + task.getId() + transfer +
                        "Название: " + task.getNameTask() + transfer +
                        "Описание: " + task.getDescription() + transfer +
                        "===============================" + transfer);
            }
        } catch (IOException ex){
            ex.printStackTrace();
        }
        try (FileWriter writer = new FileWriter(FILE_PATH_SYSTEM)){
            for (Task task : taskList){
                writer.write(task.getId() + "_" + task.getNameTask() + "_" + task.getDescription() + ";");
            }
        } catch (IOException ex){
            ex.printStackTrace();
        }
    }

    @Override
    public ArrayList<Task> getAllTask() {
        try (FileReader reader = new FileReader(FILE_PATH_SYSTEM)){
            int c;
            StringBuilder textFile = new StringBuilder();
            ArrayList<Task> listTaskFromFile = new ArrayList<>();
            while ((c=reader.read()) != -1){
                textFile.append((char) c);
            }
            String textFromFileInString = textFile.toString();
            String[] listTaskOneSeparator = textFromFileInString.split(";");
            for (String s : listTaskOneSeparator){
                String[] listTaskTwoSeparator = s.split("_");
                Task task = new Task();
                task.setId(Integer.parseInt(listTaskTwoSeparator[0]));
                task.setNameTask(listTaskTwoSeparator[1]);
                task.setDescription(listTaskTwoSeparator[2]);
                listTaskFromFile.add(task);
            }
            return listTaskFromFile;
        }catch (Exception ex){
            ex.printStackTrace();
        }
        return null;
    }
}
