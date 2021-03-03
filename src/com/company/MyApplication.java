package com.company;

import controllers.Controller;

import java.time.LocalDate;
import java.util.Date;
import java.util.Scanner;

public class MyApplication {
    private final Controller controller;
    private final Scanner scanner;

    public MyApplication(Controller controller){
        this.controller = controller;
        scanner = new Scanner(System.in);
    }

    public void appStart(){
        while (true){
            System.out.println("Choose one option \n 1) Search for any employee by name\n 2) Search for any employee by project name\n 3) Add employee\n 4) Remove employee from DB\n 5) Get employee by ID\n 6) Show all employers..\n  0) Exit\n");
            int choise = scanner.nextInt();

            if(choise == 1){
                searchEmployeeByNameMenu();
            }
            else if (choise == 2){
                searchEmployeeByProjectName();

            }
            else if (choise == 3){
                addProjectMenu();
            }
            else if (choise == 4){
                removeEmployeeByIdMenu();
            }
            else if (choise == 5){
                getEmployeeByIdMenu();

            }
            else if (choise == 6){
                showEmployee();
            }

            else {
                break;
            }
            System.out.println("**********************************");
        }
    }
    public void searchEmployeeByNameMenu(){
        System.out.println("Please, write name of employee below!");
        String name = scanner.next();
        String result = controller.searchEmployeeByName(name);
        System.out.println(result);

    }
    public void showEmployee(){
        System.out.println(controller.showEmployee());
    }

    public void getEmployeeByIdMenu(){
        System.out.println("Please, write ID of employee below!");
        int id = scanner.nextInt();
        String result = controller.getEmployeeByID(id);
        System.out.println(result);
    }

    public void addProjectMenu(){
        System.out.println("Write the name of employee!");
        String name = scanner.next();
        System.out.println("Write employee's position!");
        String position = scanner.next();
        System.out.println("Write project name!");
        String projectName = scanner.next();
        String result = controller.addEmployee(name, position, projectName);
        System.out.println(result);

    }
    public void removeEmployeeByIdMenu(){
        System.out.println("Write employee's id!");
        int id = scanner.nextInt();
        String result = controller.removeEmployeeByID(id);
        System.out.println(result);
    }
    public void searchEmployeeByProjectName(){
        System.out.println("Please, write name of Project name below!");
        String projectName = scanner.next();
        String result = controller.searchByProjectName(projectName);
        System.out.println(result);
    }
}
