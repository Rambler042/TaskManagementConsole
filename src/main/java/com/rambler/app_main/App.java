package com.rambler.app_main;

import com.rambler.menu.Menu;
import com.rambler.model.Task;
import com.rambler.repository.TaskRepository;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.ArrayList;
import java.util.Scanner;

public class App {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        ClassPathXmlApplicationContext context =
                new ClassPathXmlApplicationContext("applicationContext.xml");

        Menu menu = context.getBean("menu", Menu.class);
        TaskRepository taskRepository = context.getBean("taskRepository", TaskRepository.class);
        ArrayList<Task> tasksList = new ArrayList<>();

        String separator = "/////////////////////////////////////////////";

//____________________________________________________________________________________________________________

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
                    taskRepository.saveTask(tasksList);
                    break;
                case 2:
                    menu.viewing(tasksList);
                    System.out.print("Введите любое число чтобы вернуться -> ");
                    actionUser = sc.nextInt();
                    System.out.println(separator);
                    break;
                case 3:
                    menu.viewing(tasksList);
                    System.out.print("Выберите номер задачи которую хотите редактировать -> ");
                    int idUpdate = sc.nextInt();
                    menu.update(tasksList, idUpdate);
                    System.out.println(separator);
                    break;
                case 4:
                    menu.viewing(tasksList);
                    System.out.print("Выберите номер для удаления -> ");
                    int idDelete = sc.nextInt();
                    menu.delete(tasksList, idDelete);
                    System.out.println("Задача под номером " + idDelete + " удалена!");
                    System.out.println(separator);
                    break;
                case 0:
                    programWorks = false;
                    break;
            }
        }

        context.close();

    }
}
