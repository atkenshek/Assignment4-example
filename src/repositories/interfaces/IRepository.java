package repositories.interfaces;
import entities.Company;

import java.util.ArrayList;

public interface IRepository {
    public ArrayList<Company> searchEmployeeByName(String name);
    public Company getEmployeeByID(int id);
    public boolean addEmployee(Company company);
    public boolean removeEmployee(int id);
    public ArrayList<Company> showEmployee();
    public ArrayList<Company> searchEmployeeByProjectName(String projectName);
}
