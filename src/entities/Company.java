package entities;
import java.lang.String;
import java.time.LocalDate;

public class Company {
    private int id;
    private String name;
    private String position;
    private LocalDate dateOfDeadline;
    private String projectName;

    public Company() {
    }

    public Company(int id, String name, String position, LocalDate dateOfDeadline, String projectName) {
        setId(id);
        setName(name);
        setPosition(position);
        setdateOfDeadline(dateOfDeadline);
        setprojectName(projectName);
    }


    public Company(String name, String position, LocalDate dateOfDeadline, String projectName) {
        setName(name);
        setPosition(position);
        setdateOfDeadline(dateOfDeadline);
        setprojectName(projectName);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDate getdateOfDeadline() {
        return dateOfDeadline;
    }

    public void setdateOfDeadline(LocalDate dateOfDeadline) {
        this.dateOfDeadline = dateOfDeadline;
    }

    public String getprojectName() {
        return projectName;
    }

    public void setprojectName(String projectName) {
        this.projectName = projectName;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public String getPosition() {
        return position;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", dateOfDeadline=" + dateOfDeadline +
                ", projectName='" + projectName + '\'' +
                "\n";
    }
}
