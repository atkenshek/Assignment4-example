package com.company;

import controllers.Controller;
import data.DBManager;
import data.interfaces.IDBManager;
import repositories.Repository;
import repositories.interfaces.IRepository;

public class Main {

    public static void main(String[] args) {
        IDBManager dbManager = new DBManager();
        IRepository repository = new Repository(dbManager);
        Controller controller = new Controller(repository);
        MyApplication myApplication = new MyApplication(controller);
        myApplication.appStart();
    }
}
