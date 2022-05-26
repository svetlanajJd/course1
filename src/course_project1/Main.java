package course_project1;

import course_project1.Employee;

import java.util.Collections;

public class Main {


    public static void main(String[] args) {

        ContactBook contactBook = new ContactBook();
        contactBook.addContact("Ivanov", "Ivan", "Ivanovich", 2, 61_000.5f);
        contactBook.addContact("Petrov", "Petr", "Petrovich", 3, 55_500.6f);
        contactBook.addContact("Vasilev", "Vasiliy", "Vasilyevich", 1, 65_600.7f);
        contactBook.addContact("Fedorov", "Fedor", "Fedorovich", 4, 75_700.8f);
        contactBook.addContact("Ivanova", "Elizaveta", "Ivanovna", 5, 45_800.9f);
        contactBook.addContact("Petrova", "Olga", "Petrovna", 5, 85_900.1f);
        contactBook.addContact("Fedorova", "Nadegda", "Fedorovna", 1, 96_000.2f);
        contactBook.addContact("Sidorov", "Ivan", "Petrovich", 2, 66_100.3f);
        contactBook.addContact("Sidorova", "Irina", "Petrovna", 4, 76_200.4f);
        contactBook.addContact("Petrova", "Irina", "Petrovna", 3, 66_300.55f);
        contactBook.printAllContact();
        contactBook.Indicator();
        contactBook.printFullNameContact();
        contactBook.salaryIndex(8);
        contactBook.departmentMinSalary(5);
        contactBook.departmentMaxSalary(5);
        contactBook.departmentAverageSalary(5);
        contactBook.departmentSumSalary(5);
        contactBook.departmentSalaryIndex(5, 8);
        contactBook.printDepartmentContact(5);
        contactBook.compareMinSalary(45_801.1f);
        contactBook.compareMaxSalary(95_999.9f);
    }

    public static class ContactBook {

        private final Employee[] contacts;
        private int size;

        private static float newSalary;
        private static int index;

        public static float getNewSalary() {
            return newSalary;
        }

        public ContactBook() {
            this.contacts = new Employee[10];
        }

        public void addContact(String name, String lastName, String middleName, int department, float salary) {
            if (size >= contacts.length) {
                System.out.println("Phone book is full. Adding a new contact is restricted.");
            }
            Employee newContact = new Employee(lastName, name, middleName, department, salary);
            contacts[size++] = newContact;
        }

        public void printAllContact() {
            for (int i = 0; i < size; i++) {
                Employee contact = contacts[i];
                System.out.println(contact.getCounter() + ": " + contact.getLastName() + " " + contact.getName() + " " + contact.getMiddleName() + " отдел:" + contact.getDepartment() + " зарплата:" + contact.getSalary() + " рублей");
            }
        }

        public void printFullNameContact() {
            for (int i = 0; i < size; i++) {
                Employee contact = contacts[i];
                System.out.println(contact.getLastName() + " " + contact.getName() + " " + contact.getMiddleName());

            }
        }


        public void salaryIndex(int index) {
            for (int i = 0; i < size; i++) {
                Employee contact = contacts[i];
                newSalary = contacts[i].getSalary() + ((contacts[i].getSalary() / 100) * index);
            }
        }


        public void departmentMinSalary(int department) {
            String minSalaryName = null;
            float minSalary = contacts[size - 1].getSalary();
            for (int i = 0; i < size; i++)
                if (contacts[i].getSalary() < minSalary && department == contacts[i].getDepartment()) {
                    minSalary = contacts[i].getSalary();
                    minSalaryName = "минимальная зарплата по отделу-" + contacts[i].getDepartment() + " у сотрудника: " + contacts[i].getLastName() + " " + contacts[i].getName() + " " + contacts[i].getMiddleName() + " " + minSalary + " рублей";
                }
            System.out.println(minSalaryName);
        }


        public void departmentMaxSalary(int department) {
            String maxSalaryName = null;
            float maxSalary = contacts[0].getSalary();
            for (int i = 0; i < size; i++)
                if (contacts[i].getSalary() > maxSalary && department == contacts[i].getDepartment()) {
                    maxSalary = contacts[i].getSalary();
                    maxSalaryName = "максимальная зарплата по отделу-" + contacts[i].getDepartment() + " у сотрудника: " + contacts[i].getLastName() + " " + contacts[i].getName() + " " + contacts[i].getMiddleName() + " " + maxSalary + " рублей";
                }
            System.out.println(maxSalaryName);
        }


        public void departmentSumSalary(int department) {
            String sumSalaryName = null;
            float sumSalary = 0;
            for (int i = 0; i < size; i++)
                if (department == contacts[i].getDepartment()) {
                    sumSalary = sumSalary + contacts[i].getSalary();
                    sumSalaryName = "сумма затрат на зарплату по отделу-" + contacts[i].getDepartment() + " " + sumSalary + " рублей";
                }
            System.out.println(sumSalaryName);
        }


        public void departmentAverageSalary(int department) {
            String averageSalaryName = null;
            float averageSalary = 0;
            float sumSalary = 0;
            int id = 0;
            for (int i = 0; i < size; i++)
                if (department == contacts[i].getDepartment()) {
                    id++;

                    sumSalary = sumSalary + contacts[i].getSalary();
                    averageSalary = sumSalary / id;
                    averageSalaryName = "средняя зарплата по отделу-" + contacts[i].getDepartment() + " " + averageSalary + " рублей";
                }
            System.out.println(averageSalaryName);
        }


        public void departmentSalaryIndex(int department, int index) {
            String newSalaryDepartmentName = null;
            for (int i = 0; i < size; i++)
                if (department == contacts[i].getDepartment()) {
                    newSalary = contacts[i].getSalary() + ((contacts[i].getSalary() / 100) * index);
                }
        }

        public void printDepartmentContact(int department) {
            for (int i = 0; i < size; i++)
                if (department == contacts[i].getDepartment()) {
                    Employee contact = contacts[i];
                    System.out.println(contact.getLastName() + " " + contacts[i].getName() + " " + contact.getMiddleName() + " зарплата:" + contact.getSalary() + " рублей");
                }
        }

        public void compareMinSalary(float number) {
            for (int i = 0; i < size; i++)
                if (contacts[i].getSalary() < number) {
                    System.out.println("минимальная зарплата-данные:   " + contacts[i].getCounter() + ": " + contacts[i].getLastName() + " " + contacts[i].getName() + " " + contacts[i].getMiddleName() + " отдел:" + contacts[i].getDepartment() + " зарплата:" + contacts[i].getSalary() + " рублей");
                }
        }

        public void compareMaxSalary(float number) {
            for (int i = 0; i < size; i++)
                if (contacts[i].getSalary() > number) {
                    System.out.println("максимальная зарплата-данные:   " + contacts[i].getCounter() + ": " + contacts[i].getLastName() + " " + contacts[i].getName() + " " + contacts[i].getMiddleName() + " отдел:" + contacts[i].getDepartment() + " зарплата:" + contacts[i].getSalary() + " рублей");
                }
        }


        public void Indicator() {
            float sum = 0;
            float maxSalary = contacts[0].getSalary();
            float minSalary = contacts[0].getSalary();
            String maxSalaryName = null;
            String minSalaryName = null;
            for (int i = 0; i < size; i++) {
                sum = sum + contacts[i].getSalary();
                if (contacts[i].getSalary() > maxSalary) {
                    maxSalary = contacts[i].getSalary();
                    maxSalaryName = contacts[i].getLastName() + " " + contacts[i].getName() + " " + contacts[i].getMiddleName();
                }
            }
            for (int j = 0; j < size; j++) {
                if (contacts[j].getSalary() <= minSalary) {
                    minSalary = contacts[j].getSalary();
                    minSalaryName = contacts[j].getLastName() + " " + contacts[j].getName() + " " + contacts[j].getMiddleName();
                }
            }
            System.out.println("Сумма затрат на зарплаты в месяц: " + sum);
            System.out.println("Максимальная заработная плата: " + maxSalary + " рублей. Сотрудник: " + maxSalaryName);
            System.out.println("Минимальная заработная плата: " + minSalary + " рублей. Сотрудник: " + minSalaryName);
            System.out.println("Средняя зарплата в месяц: " + sum / size);
        }
    }
}