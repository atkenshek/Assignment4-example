package com.company;

import controllers.Controller;

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
            System.out.println("Choose one option \n 1) Search for any medicine by name\n 2) Search for any medicine by manufacturer\n 3) Add medicine\n 4) Remove medicine from DB\n 5) Get medicine by ID\n 6) Show all medicines...\n 7) Update the price of medicine\n 0) Exit\n");
            int choise = scanner.nextInt();

            if(choise == 1){
                searchMedicineByNameMenu();
            }
            else if (choise == 2){
                searchMedicineByManufacturerMenu();

            }
            else if (choise == 3){
                addMedicineMenu();
            }
            else if (choise == 4){
                removeMedicineByIdMenu();
            }
            else if (choise == 5){
                getMedicineByIdMenu();

            }
            else if (choise == 6){
                showMedicine();
            }
            else if (choise == 7){
                updatePriceByIdMenu();
            }
            else {
                break;
            }
            System.out.println("**********************************");
        }
    }
    public void searchMedicineByNameMenu(){
        System.out.println("Please, write name of medicine below!");
        String name = scanner.next();
        String result = controller.searchMedicineByName(name);
        System.out.println(result);

    }
    public void showMedicine(){
        System.out.println(controller.showMedicine());
    }

    public void getMedicineByIdMenu(){
        System.out.println("Please, write ID of medicine below!");
        int id = scanner.nextInt();
        String result = controller.getMedicineByID(id);
        System.out.println(result);
    }
    public void updatePriceByIdMenu(){
        System.out.println("Please, write ID of medicine, which you want to change the price!");
        int id = scanner.nextInt();
        String result = controller.updatePriceByID(id);
        System.out.println(result);
    }

    public void addMedicineMenu(){
        System.out.println("Write the name of medicine!");
        String name = scanner.next();
        System.out.println("Write medicine's price!");
        double price = scanner.nextDouble();
        System.out.println("Write manufacturer!");
        String manufacturer = scanner.next();
        String result = controller.addMedicine(name, price, manufacturer);
        System.out.println(result);

    }
    public void removeMedicineByIdMenu(){
        System.out.println("Write medicine's id!");
        int id = scanner.nextInt();
        String result = controller.removeMedicineByID(id);
        System.out.println(result);
    }
    public void searchMedicineByManufacturerMenu(){
        System.out.println("Please, write name of manufacturer below!");
        String manufacturer = scanner.next();
        String result = controller.searchByManufacturer(manufacturer);
        System.out.println(result);
    }
}
