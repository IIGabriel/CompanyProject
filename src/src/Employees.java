import java.util.List;

public class Employees {
    private int ID;
    private String name, role;
    private double wage;
    private Dependents[] dependents;

    public Employees(int ID, String name, String role, double wage, Dependents[] dependents) {
        this.ID = ID;
        this.name = name;
        this.role = role;
        this.wage = wage;
        this.dependents = dependents;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public double getWage() {
        return wage;
    }

    public double getBonus() {
        return (0.02 * this.wage) * this.dependents.length;
    }

    public void setWage(double wage) {
        this.wage = wage;
    }

    public Dependents[] getDependents() {
        return dependents;
    }
    public int getDependentsLength() {
        return dependents.length;
    }

    public void setDependents(Dependents[] dependents) {
        this.dependents = dependents;
    }

}
