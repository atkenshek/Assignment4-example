package repositories;

import data.DBManager;
import data.interfaces.IDBManager;
import entities.Medicine;
import repositories.interfaces.IRepository;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.time.LocalDate;
import java.util.ArrayList;

import static java.sql.Date.valueOf;

public class Repository implements IRepository {
    private  IDBManager dbManager;

    public Repository(IDBManager dbManager){
        setDbManager(dbManager);
    }
    public void setDbManager(IDBManager dbManager){
        this.dbManager = dbManager;
    }
    @Override
    public ArrayList<Medicine> searchMedicineByName(String name) {
        Connection connection = null;

        try{
            connection = dbManager.getConnection();

            PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM medicines WHERE name LIKE '%" + name + "%'");
            ResultSet resultSet = preparedStatement.executeQuery();

            ArrayList<Medicine> medicines = new ArrayList<>();
            while (resultSet.next()){
                Medicine medicine = new Medicine(resultSet.getInt("id"),
                        resultSet.getString("name"),
                        resultSet.getDouble("price"),
                        resultSet.getDate("expirationDate").toLocalDate(),
                        resultSet.getString("manufacturer"));

                medicines.add(medicine);
            }
            return medicines;
        }
        catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }

    @Override
    public Medicine getMedicineByID(int id) {
        Connection connection = null;

        try {
            connection = dbManager.getConnection();

            PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM medicines WHERE id=?");

            preparedStatement.setInt(1, id);

            ResultSet resultSet = preparedStatement.executeQuery();

            Medicine medicine = new Medicine();

            if (resultSet.next()){
                medicine.setId(resultSet.getInt("id"));
                medicine.setName(resultSet.getString("name"));
                medicine.setPrice(resultSet.getDouble("price"));
                medicine.setExpirationDate(resultSet.getDate("expirationDate").toLocalDate());
                medicine.setManufacturer(resultSet.getString("manufacturer"));
            }
            return medicine;
        }
        catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public boolean addMedicine(Medicine medicine) {
        Connection connection = null;

        try {
            connection = dbManager.getConnection();

            PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO medicines(name, price, expirationdate, manufacturer) VALUES ( ?, ?, ?, ?)");
            preparedStatement.setString(1, medicine.getName());
            preparedStatement.setDouble(2, medicine.getPrice());
            preparedStatement.setDate(3, valueOf(medicine.getExpirationDate()));
            preparedStatement.setString(4, medicine.getManufacturer());
            preparedStatement.execute();
            return true;
        }
        catch (Exception e){
            e.printStackTrace();

        }
        return false;
    }

    @Override
    public boolean removeMedicine(int id) {
        Connection connection = null;
        try {
            connection = dbManager.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement("DELETE from medicines WHERE id=?");

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
    public ArrayList<Medicine> showMedicine() {
        Connection connection = null;

        try{
            connection = dbManager.getConnection();

            PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM medicines");
            ResultSet resultSet = preparedStatement.executeQuery();

            ArrayList<Medicine> medicines = new ArrayList<>();
            while (resultSet.next()){
                Medicine medicine = new Medicine(resultSet.getInt("id"),
                        resultSet.getString("name"),
                        resultSet.getDouble("price"),
                        resultSet.getDate("expirationDate").toLocalDate(),
                        resultSet.getString("manufacturer"));

                medicines.add(medicine);
            }
            return medicines;
        }
        catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }

    @Override
    public ArrayList<Medicine> searchMedicineByManufacturer(String manufacturer) {
        Connection connection = null;

        try{
            connection = dbManager.getConnection();

            PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM medicines WHERE manufacturer=?");
            ResultSet resultSet = preparedStatement.executeQuery();

            ArrayList<Medicine> medicines = new ArrayList<>();
            while (resultSet.next()){
                Medicine medicine = new Medicine(resultSet.getInt("id"),
                        resultSet.getString("name"),
                        resultSet.getDouble("price"),
                        resultSet.getDate("expirationDate").toLocalDate(),
                        resultSet.getString("manufacturer"));

                medicines.add(medicine);
            }
            return medicines;
        }
        catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }



    @Override
    public Medicine updatePriceByID(int id) {
        Connection connection = null;

        try {
            connection = dbManager.getConnection();

            PreparedStatement preparedStatement = connection.prepareStatement("UPDATE medicines SET price=499.99 WHERE id=?");

            preparedStatement.setInt(1, id);

            ResultSet resultSet = preparedStatement.executeQuery();

            Medicine medicine = new Medicine();

            if (resultSet.next()){
                medicine.setId(resultSet.getInt("id"));
                medicine.setName(resultSet.getString("name"));
                medicine.setPrice(resultSet.getDouble("price"));
                medicine.setExpirationDate(resultSet.getDate("expirationDate").toLocalDate());
                medicine.setManufacturer(resultSet.getString("manufacturer"));
            }
            return medicine;
        }
        catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }


}
