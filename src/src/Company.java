import java.util.ArrayList;
import java.util.List;

public class Company {
    private List<Employees> employeesList = new ArrayList<>();

    public void register(Employees employees) {
        if (this.employeesList != null) {
            for (Employees item : this.employeesList) {
                if (item.getID() == employees.getID()) {
                    throw new IllegalArgumentException("O código do funcionário deve ser único");
                }
            }
        }
    this.employeesList.add(employees);
    }

    public List<Employees> getEmployeesList() {
        return this.employeesList;
    }

    public String getNameByID(int employeesID) {
        for (Employees item : this.employeesList) {
            if (item.getID() == employeesID) {
                return item.getName();
            }
        }
        throw new IllegalArgumentException("O funcionário informado não existe");
    }

    public double getDependentsLengthByID(int employeesID) {
        for (Employees item : this.employeesList) {
            if (item.getID() == employeesID) {
                return item.getDependentsLength();
            }
        }
        throw new IllegalArgumentException("O funcionário informado não existe");
    }


    public double getWageByID(int employeesID) {
        for (Employees item : this.employeesList) {
            if (item.getID() == employeesID) {
                return item.getWage();
            }
        }
        throw new IllegalArgumentException("O funcionário informado não existe");
    }

    public double getBonusByID(int employeesID) {
        for (Employees item : this.employeesList) {
            if (item.getID() == employeesID) {
                return item.getBonus();
            }
        }
        throw new IllegalArgumentException("O funcionário informado não existe");
    }

    public void removeEmployerByID(int employeesID) {
        if (!this.employeesList.removeIf(item -> item.getID() == employeesID)) {
            throw new IllegalArgumentException("O funcionário informado não existe");
        }
    }

    public void editEmployerWageByID(int employeesID, double newWage) {
        boolean have = false;
        for (Employees item : this.employeesList) {
            if (item.getID() == employeesID) {
                item.setWage(newWage);
                have = true;
            }
        }
        if (!have) {
            throw new IllegalArgumentException("O funcionário informado não existe");
        }
    }

    public void editDependentsByID(int employeesID, Dependents[] dependents) {
        boolean have = false;
        for (Employees item : this.employeesList) {
            if (item.getID() == employeesID) {
                item.setDependents(dependents);
                have = true;
            }
        }
        if (!have) {
            throw new IllegalArgumentException("O funcionário informado não existe");
        }
    }

}
