public class Main {


    public static void main(String[] args) {

        ContactBook contactBook = new ContactBook();
        contactBook.addContact("Ivanov", "Ivan", "Ivanovich", 2, 65_000);
        contactBook.addContact("Petrov", "Petr", "Petrovich", 3, 65_500);
        contactBook.addContact("Vasilev", "Vasiliy", "Vasilyevich", 1, 65_600);
        contactBook.addContact("Fedorov", "Fedor", "Fedorovich", 4, 65_700);
        contactBook.addContact("Ivanova", "Elizaveta", "Ivanovna", 5, 65_800);
        contactBook.addContact("Petrova", "Olga", "Petrovna", 5, 65_900);
        contactBook.addContact("Fedorova", "Nadegda", "Fedorovna", 1, 66_000);
        contactBook.addContact("Sidorov", "Ivan", "Petrovich", 2, 66_100);
        contactBook.addContact("Sidorova", "Irina", "Petrovna", 4, 66_200);
        contactBook.addContact("Petrova", "Irina", "Petrovna", 2, 66_300);
        contactBook.printAllContacts();
        contactBook.Indicator();


    }

    public static class ContactBook {
        private final Employee[] contacts;
        private static int size;

        public ContactBook() {
            this.contacts = new Employee[10];
        }

        public void addContact(String name, String lastName, String middleName, int department, float salary) {
            if (size >= contacts.length) {
                System.out.println("Phone book is full. Adding a new contact is restricted.");
            }
            Employee newContact = new Employee(name, lastName, middleName, department, salary);
            contacts[size++] = newContact;
        }

        public void printAllContacts() {
            for (int i = 0; i < size; i++) {
                Employee contact = contacts[i];
                System.out.println(contact.getCounter() + ": " + contact.getName() + " " + contact.getLastName() + " " + contact.getMiddleName() + " отдел:" + contact.getDepartment() + " зарплата:" + contact.getSalary() + " рублей");
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
                    maxSalaryName = contacts[i].getName();

                }}
                for (int j = 0; j < size; j++) {
                    Employee contact = contacts[j];
                if (contacts[j].getSalary() < minSalary) {
                    minSalary = contacts[j].getSalary();
                    minSalaryName = contacts[j].getName();
                }
            }
            System.out.println("Сумма затрат на зарплаты в месяц: " + sum);
            System.out.println("Максимальная заработная плата: " + maxSalary+" рублей. Сотрудник: " + maxSalaryName);
            System.out.println("Минимальная заработная плата: " + minSalary+" рублей. Сотрудник: " + minSalaryName);
        }
    }

}