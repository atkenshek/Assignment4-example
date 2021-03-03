package repositories;

import data.interfaces.IDBManager;
import entities.Company;
import repositories.interfaces.IRepository;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class Repository implements IRepository {
    private  IDBManager dbManager;

    public Repository(IDBManager dbManager){
        setDbManager(dbManager);
    }
    public void setDbManager(IDBManager dbManager){
        this.dbManager = dbManager;
    }
    @Override
    public ArrayList<Company> searchEmployeeByName(String name) {
        Connection connection = null;

        try{
            connection = dbManager.getConnection();

            PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM employees WHERE name LIKE '%" + name + "%'");
            ResultSet resultSet = preparedStatement.executeQuery();

            ArrayList<Company> companies = new ArrayList<>();
            while (resultSet.next()){
                Company company = new Company(resultSet.getInt("id"),
                        resultSet.getString("name"),
                        resultSet.getString("position"),
                        resultSet.getDate("dateOfDeadline").toLocalDate(),
                        resultSet.getString("manufacturer"));

                companies.add(company);
            }
            return companies;
        }
        catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }

    @Override
    public Company getEmployeeByID(int id) {
        Connection connection = null;

        try {
            connection = dbManager.getConnection();

            PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM employees WHERE id=?");

            preparedStatement.setInt(1, id);

            ResultSet resultSet = preparedStatement.executeQuery();

            Company company = new Company();

            if (resultSet.next()){
                company.setId(resultSet.getInt("id"));
                company.setName(resultSet.getString("name"));
                company.setPosition(resultSet.getString("position"));
                company.setdateOfDeadline(resultSet.getDate("dateOfDeadline").toLocalDate());
                company.setprojectName(resultSet.getString("projectName"));
            }
            return company;
        }
        catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public boolean addEmployee(Company company) {
        Connection connection = null;

        try {
            connection = dbManager.getConnection();

            PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO employees(name, position, dateofdeadline, projectname) VALUES ( ?, ?, ?, ?)");
            preparedStatement.setString(1, company.getName());
            preparedStatement.setString(2, company.getPosition());
            preparedStatement.setDate(3,  Date.valueOf(company.getdateOfDeadline()));
            preparedStatement.setString(4, company.getprojectName());
            preparedStatement.execute();
            return true;
        }
        catch (Exception e){
            e.printStackTrace();

        }
        return false;
    }

    @Override
    public boolean removeEmployee(int id) {
        Connection connection = null;
        try {
            connection = dbManager.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement("DELETE from employees WHERE id=?");

            preparedStatement.setInt(1, id);
            preparedStatement.execute();
            return true;
            }
        catch (Exception e){
            e.printStackTrace();

        }
        return false;
    }
    @Override
    public ArrayList<Company> showEmployee() {
        Connection connection = null;

        try{
            connection = dbManager.getConnection();

            PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM employees");
            ResultSet resultSet = preparedStatement.executeQuery();

            ArrayList<Company> companies = new ArrayList<>();
            while (resultSet.next()){
                Company company = new Company(resultSet.getInt("id"),
                        resultSet.getString("name"),
                        resultSet.getString("position"),
                        resultSet.getDate("dateOfDeadline").toLocalDate(),
                        resultSet.getString("projectName"));

                companies.add(company);
            }
            return companies;
        }
        catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }


    @Override
    public ArrayList<Company> searchEmployeeByProjectName(String projectName) {
        Connection connection = null;

        try{
            connection = dbManager.getConnection();

            PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM employees WHERE projectname=?");
            ResultSet resultSet = preparedStatement.executeQuery();

            ArrayList<Company> companies = new ArrayList<>();
            while (resultSet.next()){
                Company company = new Company(resultSet.getInt("id"),
                        resultSet.getString("name"),
                        resultSet.getString("position"),
                        resultSet.getDate("dateOfDeadline").toLocalDate(),
                        resultSet.getString("projectName"));

                companies.add(company);
            }
            return companies;
        }
        catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }





}
