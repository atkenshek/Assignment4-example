package controllers;

import entities.Company;
import repositories.interfaces.IRepository;

import java.time.LocalDate;

import static java.time.LocalDate.parse;

public class Controller {
    private final IRepository repository;

    public Controller(IRepository repository) {
        this.repository = repository;
    }

    public String searchEmployeeByName(String name){
        String result = repository.searchEmployeeByName(name).toString();
        return result;
    }


    public String getEmployeeByID(int id){
        String result = repository.getEmployeeByID(id).toString();
        return result;
    }


    public String addEmployee(String name, String position, String projectName){
        LocalDate deadline = LocalDate.now();
        boolean added = repository.addEmployee(new Company(name, position, deadline, projectName));
        if(added){
            return "Employee was added successfully! ";
        }
        return "Employee was not added, please try again! ";
    }

    public String removeEmployeeByID(int id){
        boolean removed = repository.removeEmployee(id);
        if(removed){
            return "Employee was removed successfully! ";
        }
        return "Employee was not removed, please try again! ";
    }
    public String showEmployee(){
        String result = repository.showEmployee().toString();
        return result;
    }
    public String searchByProjectName(String projectName){
        String result = repository.searchEmployeeByProjectName(projectName).toString();
        return result;
    }

}
