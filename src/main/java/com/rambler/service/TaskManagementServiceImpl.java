package com.rambler.service;

import com.rambler.model.Task;
import com.rambler.repository.Menu;
import com.rambler.repository.TaskWorkWithFile;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Scanner;

@Component("service")
public class TaskManagementServiceImpl implements TaskManagementService{

    @Autowired
    Menu menu;

    @Autowired
    TaskWorkWithFile taskWorkWithFile;


    @Override
    public void logicAppTaskManagement() {
        Scanner sc = new Scanner(System.in);
        ArrayList<Task> tasksList = (ArrayList<Task>) taskWorkWithFile.getAllTask();
        String separator = "/////////////////////////////////////////////";
        boolean programWorks = true;
        int actionUser;

        while (programWorks){
            menu.mainMenu();
            System.out.print("\nВведите номер пункта -> ");
            actionUser = sc.nextInt();
            System.out.println(separator);

            switch (actionUser){
                case 1:
                    tasksList.add(menu.addTask(tasksList.size()));
                    System.out.println(separator);
                    taskWorkWithFile.saveTask(tasksList);
                    break;
                case 2:
                    menu.viewing(tasksList);
                    System.out.println(separator);
                    break;
                case 3:
                    menu.viewing(tasksList);
                    System.out.print("Выберите номер задачи которую хотите редактировать -> ");
                    int idUpdate = sc.nextInt();
                    tasksList.set(idUpdate-1, menu.update(tasksList, idUpdate));
                    System.out.println(separator);
                    break;
                case 4:
                    menu.viewing(tasksList);
                    System.out.print("Выберите номер для удаления -> ");
                    int idDelete = sc.nextInt();
                    tasksList.remove(idDelete-1);
                    System.out.println("Задача под номером " + idDelete + " удалена!");
                    System.out.println(separator);
                    break;
                case 0:
                    programWorks = false;
                    taskWorkWithFile.saveTask(tasksList);
                    break;
            }
        }
    }
}
