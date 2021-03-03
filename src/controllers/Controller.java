package controllers;

import entities.Medicine;
import repositories.Repository;
import repositories.interfaces.IRepository;

import java.time.LocalDate;
import java.util.ArrayList;

public class Controller {
    private final IRepository repository;

    public Controller(IRepository repository) {
        this.repository = repository;
    }

    public String searchMedicineByName(String name){
        String result = repository.searchMedicineByName(name).toString();
        return result;
    }


    public String getMedicineByID(int id){
        String result = repository.getMedicineByID(id).toString();
        return result;
    }
    public String updatePriceByID(int id){
        String result = repository.updatePriceByID(id).toString();
        return result;
    }

    public String addMedicine(String name, double price, String manufacturer){
        LocalDate expirationDate = LocalDate.now();
        boolean added = repository.addMedicine(new Medicine(name, price, expirationDate, manufacturer));
        if(added){
            return "Medicine was added successfully! ";
        }
        return "Medicine was not added, please try again! ";
    }

    public String removeMedicineByID(int id){
        boolean removed = repository.removeMedicine(id);
        if(removed){
            return "Medicine was removed successfully! ";
        }
        return "Medicine was not removed, please try again! ";
    }
    public String showMedicine(){
        String result = repository.showMedicine().toString();
        return result;
    }
    public String searchByManufacturer(String manufacturer){
        String result = repository.searchMedicineByManufacturer(manufacturer).toString();
        return result;
    }

}
