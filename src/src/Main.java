import javax.swing.*;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Company company = new Company();
        for (; ; ) {
            startDialog(company);
        }
    }

    public static void startDialog(Company company) {
        String[] options = new String[]{"Cadastrar funcionário", "Excluir funcionário", "Editar Salário", "Imprimir Salário"};
        int response = JOptionPane.showOptionDialog(null, "Escolha a função que deseja fazer", "Interface da compania",
                JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE,
                null, options, options[0]);


        if (response == 0) {
            String dialogResponse = JOptionPane.showInputDialog(null, "Insira o código, o nome, o salário, a quantidade de dependentes e o cargo separados por vírgula");
            String[] fields = dialogResponse.split(", ");
            if (fields.length != 5) {
                JOptionPane.showMessageDialog(null, "Campos enviados de forma incorreta");
                return;
            }
            try {
                int id = Integer.parseInt(fields[0]);
                String name = fields[1];
                double wage = Double.parseDouble(fields[2]);
                int dependents = Integer.parseInt(fields[3]);
                String cargo = fields[4];

                Dependents dependents1 = new Dependents();

                Dependents[] dependentsArray = new Dependents[0];
                Employees employees = new Employees(id, name, cargo, wage, dependentsArray);
                company.register(employees);

                List<Dependents> dependentsList = new ArrayList<>();

                for (var i = 0; i < dependents; i++) {
                    int index = i + 1;
                    String dialogResponseDependent = JOptionPane.showInputDialog("Insira o nome do seu " + index + " dependente");
                    dependents1.setEmployerID(employees);
                    dependents1.setName(dialogResponseDependent);
                    dependentsList.add(dependents1);
                }

                Dependents[] arr = new Dependents[dependentsList.size()];
                dependentsList.toArray(arr);
                company.editDependentsByID(id, arr);

                JOptionPane.showMessageDialog(null, "Funcionário criado!");

            } catch (Exception err) {
                JOptionPane.showMessageDialog(null, err.getMessage());
                return;
            }
        }

        if (response == 1) {
            String dialogResponse = JOptionPane.showInputDialog(null, "Insira do Id do funcioanrio que deseja excluir");
            try {
                int id = Integer.parseInt(dialogResponse);
                company.removeEmployerByID(id);
                JOptionPane.showMessageDialog(null, "Funcionário excluido!");
            } catch (Exception err) {
                JOptionPane.showMessageDialog(null, err.getMessage());
                return;
            }
        }

        if (response == 2) {
            String dialogResponse = JOptionPane.showInputDialog(null, "Insira do Id do funcioanrio que deseja editar o salário");
            String dialogResponse2 = JOptionPane.showInputDialog(null, "Insira o novo salário");
            try {
                int id = Integer.parseInt(dialogResponse);
                double newWage = Double.parseDouble(dialogResponse2);
                company.editEmployerWageByID(id, newWage);
                JOptionPane.showMessageDialog(null, "Salário do funcionário editado!");
            } catch (Exception err) {
                JOptionPane.showMessageDialog(null, err.getMessage());
                return;
            }
        }
        if (response == 3) {
            String dialogResponse = JOptionPane.showInputDialog(null, "Insira do Id do funcioanrio que deseja editar o salário");
            if (Integer.parseInt(dialogResponse) == 0) {
                for (var i = 0; i < company.getEmployeesList().size(); i++) {
                    var item = company.getEmployeesList().get(i);
                    appendStrToFile("arquivo.txt", "Nome do funcionario: " + item.getName() + ", Quantidade de dependentes: " + item.getDependentsLength() + ", Bonus que tem direito: " + item.getBonus() + ", Salário base: " + item.getWage() + "\n");
                }
            } else {
                try {
                    int id = Integer.parseInt(dialogResponse);
                    appendStrToFile("arquivo.txt", "Nome do funcionario: " + company.getNameByID(id) + ", Quantidade de dependentes: " + company.getDependentsLengthByID(id) + ", Bonus que tem direito: " + company.getBonusByID(id) + ", Salário base: " + company.getWageByID(id) + "\n");
                } catch (Exception err) {
                    JOptionPane.showMessageDialog(null ,err.getMessage());
                }
            }
        }
    }

    public static void appendStrToFile(String fileName, String str) {
        try {
            BufferedWriter out = new BufferedWriter(
                    new FileWriter(fileName, true));

            out.write(str);
            out.close();
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "Erro ao criar o arquivo");
        }
    }
}