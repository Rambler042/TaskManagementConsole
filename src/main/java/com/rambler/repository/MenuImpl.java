package com.rambler.repository;

import com.rambler.model.Task;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Scanner;

@Component("menu")
public class MenuImpl implements Menu{

    Scanner sc = new Scanner(System.in);

    @Override
    public void mainMenu() {
        System.out.println("1. Создать задачу");
        System.out.println("2. Просмотреть все задачи");
        System.out.println("3. Обновить задачу");
        System.out.println("4. Удалить задачу");
        System.out.println("0. Выход");
    }

    @Override
    public Task addTask(int sizeList) {

        Task task = new Task();

        System.out.print("Введите название задачи -> ");
        String name = sc.nextLine();
        task.setNameTask(name);

        System.out.print("Введите описание задачи -> ");
        String desc = sc.nextLine();
        task.setDescription(desc);

        task.setId(sizeList+1);

        return task;
    }

    @Override
    public void viewing(ArrayList<Task> taskList) {

        for (Task i : taskList){
            System.out.println("Номер: " + i.getId());
            System.out.println("Задача: " + i.getNameTask());
            System.out.println("Описание: " + i.getDescription());
            System.out.println("==================================");

        }

    }

    @Override
    public Task update(ArrayList<Task> tasksList, int id) {

        Task task = tasksList.get(id-1);

        System.out.println("Номер: " + task.getId());
        System.out.println("Задача: " + task.getNameTask());
        System.out.println("Описание: " + task.getDescription());
        System.out.println("==================================");

        System.out.print("Введите название задачи -> ");
        String name = sc.nextLine();
        task.setNameTask(name);

        System.out.print("Введите описание задачи -> ");
        String desc = sc.nextLine();
        task.setDescription(desc);

        return task;
    }


}
