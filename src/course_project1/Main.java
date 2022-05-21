package course_project1;

import course_project1.Employee;

public class Main {


    public static void main(String[] args) {

        ContactBook contactBook = new ContactBook();
        contactBook.addContact("Ivanov", "Ivan", "Ivanovich", 2, 65_000.5f);
        contactBook.addContact("Petrov", "Petr", "Petrovich", 3, 65_500.6f);
        contactBook.addContact("Vasilev", "Vasiliy", "Vasilyevich", 1, 65_600.7f);
        contactBook.addContact("Fedorov", "Fedor", "Fedorovich", 4, 65_700.8f);
        contactBook.addContact("Ivanova", "Elizaveta", "Ivanovna", 5, 65_800.9f);
        contactBook.addContact("Petrova", "Olga", "Petrovna", 5, 65_900.1f);
        contactBook.addContact("Fedorova", "Nadegda", "Fedorovna", 1, 66_000.2f);
        contactBook.addContact("Sidorov", "Ivan", "Petrovich", 2, 66_100.3f);
        contactBook.addContact("Sidorova", "Irina", "Petrovna", 4, 66_200.4f);
        contactBook.addContact("Petrova", "Irina", "Petrovna", 2, 66_300.55f);
        contactBook.printAllContact();
        contactBook.Indicator();
        contactBook.printFullNameContact();
    }

    public static class ContactBook {
        private final Employee[] contacts;
        private int size;

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
                System.out.println(contact.getCounter() + ": " + contact.getName() + " " + contact.getLastName() + " " + contact.getMiddleName() + " отдел:" + contact.getDepartment() + " зарплата:" + contact.getSalary() + " рублей");
            }
        }

        public void printFullNameContact() {
            for (int i = 0; i < size; i++) {
                Employee contact = contacts[i];
                System.out.println(contact.getLastName() + " " + contact.getName() + " " + contact.getMiddleName());
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
                Employee contact = contacts[i];
                if (contacts[i].getSalary() > maxSalary) {
                    maxSalary = contacts[i].getSalary();
                    maxSalaryName = contacts[i].getLastName() + " " + contacts[i].getName() + " " + contacts[i].getMiddleName();
                }
            }
            for (int j = 0; j < size; j++) {
                Employee contact = contacts[j];
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