package com.rambler.app_main;

import com.rambler.service.TaskManagementService;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class App {

    public static void main(String[] args) {

        ClassPathXmlApplicationContext context =
                new ClassPathXmlApplicationContext("applicationContext.xml");

        TaskManagementService service = context.getBean("service", TaskManagementService.class);
        service.logicAppTaskManagement();


        context.close();
    }
}
