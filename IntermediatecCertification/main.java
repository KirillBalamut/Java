
import java.io.*;
import java.util.*;

// Задание
// Реализуйте структуру телефонной книги с помощью HashMap.
// Программа также должна учитывать, что в во входной структуре будут повторяющиеся имена с разными телефонами, их необходимо считать, как одного человека с разными телефонами. Вывод должен быть отсортирован по убыванию числа телефонов.
//

class PhoneBook {
    public static void main(String[] args) {
        // Создание телефонной книги с помощью HashMap
        Map<String, List<String>> phoneBook = new HashMap<>();

        Scanner scanner = new Scanner(System.in);
        String command = "";

        while (!command.equals("exit")) {
            System.out.print("Введите команду: showHelp - выводит список команд с описанием их действий ");
            command = scanner.nextLine();

            switch (command) {
                case "addRecord" -> {
                    System.out.print("Введите имя: ");
                    String name = scanner.nextLine();
                    System.out.print("Введите номер телефона: ");
                    String phoneNumber = scanner.nextLine();
                    addRecord(phoneBook, name, phoneNumber);
                }
                case "printSortedContacts" -> printSortedContacts(phoneBook);
                case "changeContactName" -> {
                    System.out.print("Введите текущее имя контакта: ");
                    String oldName = scanner.nextLine();
                    System.out.print("Введите новое имя контакта: ");
                    String newName = scanner.nextLine();
                    changeContactName(phoneBook, oldName, newName);
                }
                case "editContactNumber" -> {
                    System.out.print("Введите имя контакта: ");
                    String contactName = scanner.nextLine();
                    System.out.print("Введите новый номер телефона: ");
                    String newNumber = scanner.nextLine();
                    editContactNumber(phoneBook, contactName, newNumber);
                }
                case "addContactNumber" -> {
                    System.out.print("Введите имя контакта: ");
                    String contactName = scanner.nextLine();
                    System.out.print("Введите новый номер телефона: ");
                    String newNumber = scanner.nextLine();
                    addContactNumber(phoneBook, contactName, newNumber);
                }
                case "savePhoneBookToFile" -> {
                    System.out.print("Введите имя файла: ");
                    String fileName = scanner.nextLine();
                    savePhoneBookToFile(phoneBook, fileName);
                }
                case "showHelp" -> showHelp();
            }
        }

        System.out.println("Программа завершена.");
    }

    public static void addRecord(Map<String, List<String>> phoneBook, String name, String phoneNumber) {
        // Проверка, существует ли уже запись с таким именем
        if (phoneBook.containsKey(name)) {
            // Если запись существует, добавляем телефонный номер к списку номеров
            List<String> phoneNumbers = phoneBook.get(name);
            phoneNumbers.add(phoneNumber);
        } else {
            // Если записи нет, создаем новую запись с одним телефонным номером
            List<String> phoneNumbers = new ArrayList<>();
            phoneNumbers.add(phoneNumber);
            phoneBook.put(name, phoneNumbers);
        }
    }

    public static void printSortedContacts(Map<String, List<String>> phoneBook) {
        // Создание отсортированного списка контактов
        List<Map.Entry<String, List<String>>> sortedContacts = new ArrayList<>(phoneBook.entrySet());
        sortedContacts.sort(new Comparator<Map.Entry<String, List<String>>>() {
            public int compare(Map.Entry<String, List<String>> entry1, Map.Entry<String, List<String>> entry2) {
                return entry2.getValue().size() - entry1.getValue().size();
            }
        });

        // Вывод отсортированного списка контактов
        System.out.println("Отсортированный список контактов:");
        for (Map.Entry<String, List<String>> entry : sortedContacts) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
        System.out.println();
    }

    public static void changeContactName(Map<String, List<String>> phoneBook, String oldName, String newName) {
        // Проверка, существует ли запись с oldName
        if (phoneBook.containsKey(oldName)) {
            // Получение списка номеров для oldName
            List<String> phoneNumbers = phoneBook.remove(oldName);
            // Добавление записи с newName и списком номеров
            phoneBook.put(newName, phoneNumbers);
            System.out.println("Имя контакта успешно изменено.");
        } else {
            System.out.println("Контакт с указанным именем не найден.");
        }
        System.out.println();
    }

    public static void editContactNumber(Map<String, List<String>> phoneBook, String contactName, String newNumber) {
        // Проверка, существует ли запись с contactName
        if (phoneBook.containsKey(contactName)) {
            // Получение списка номеров для contactName
            List<String> phoneNumbers = phoneBook.get(contactName);
            // Изменение первого номера в списке на newNumber
            phoneNumbers.set(0, newNumber);
            System.out.println("Номер контакта успешно отредактирован.");
        } else {
            System.out.println("Контакт с указанным именем не найден.");
        }
        System.out.println();
    }

    public static void addContactNumber(Map<String, List<String>> phoneBook, String contactName, String newNumber) {
        // Проверка, существует ли запись с contactName
        if (phoneBook.containsKey(contactName)) {
            // Получение списка номеров для contactName
            List<String> phoneNumbers = phoneBook.get(contactName);
            // Добавление нового номера в список
            phoneNumbers.add(newNumber);
            System.out.println("Номер успешно добавлен к контакту.");
        } else {
            System.out.println("Контакт с указанным именем не найден.");
        }
        System.out.println();
    }

    public static void savePhoneBookToFile(Map<String, List<String>> phoneBook, String fileName) {
        try (PrintWriter writer = new PrintWriter(new FileWriter(fileName))) {
            // Сохранение телефонной книги в файл
            for (Map.Entry<String, List<String>> entry : phoneBook.entrySet()) {
                writer.println(entry.getKey() + ": " + entry.getValue());
            }
            System.out.println("Телефонная книга успешно сохранена в файл " + fileName);
        } catch (IOException e) {
            System.out.println("Ошибка при сохранении телефонной книги в файл " + fileName);
        }
        System.out.println();
    }

    public static void showHelp() {
        System.out.println("Список команд:");
        System.out.println("addRecord: добавляет запись в телефонную книгу");
        System.out.println("printSortedContacts: выводит отсортированный список контактов");
        System.out.println("changeContactName: изменяет имя контакта");
        System.out.println("editContactNumber: редактирует номер контакта");
        System.out.println("addContactNumber: добавляет номер контакту");
        System.out.println("savePhoneBookToFile: сохраняет телефонную книгу в файл");
        System.out.println("showHelp: выводит список команд с описанием их действий");
        System.out.println("exit: завершает программу");
    }
}