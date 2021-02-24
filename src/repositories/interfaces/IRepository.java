package repositories.interfaces;
import entities.Medicine;

import java.time.LocalDate;
import java.util.ArrayList;

public interface IRepository {
    public ArrayList<Medicine> searchMedicineByName(String name);
    public Medicine getMedicineByID(int id);
    public Medicine updatePriceByID(int id);
    public boolean addMedicine(Medicine medicine);
    public boolean removeMedicine(int id);
    public ArrayList<Medicine> showMedicine();
    public ArrayList<Medicine> searchMedicineByManufacturer(String manufacturer);
}
