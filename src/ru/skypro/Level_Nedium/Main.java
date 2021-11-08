package ru.skypro.Level_Nedium;
/**
 * Класс приложения по задаче Employee.
 */
public class Main {
    // Массив, выполняющий роль хранилища для записей о сотрудниках.
    private static final Employee[] employee = new Employee[10];

    /**
     * Точка входа в приложение. public static void main
     */
    public static void main(String[] args) {
        System.out.println("Задача о сотрудниках");
        System.out.println("Повышенная сложность ");
        System.out.print("\n");
        initializationEmployeesData();
        /**
         * 1. Проиндексировать зарплату (вызвать изменение зарплат у всех сотрудников на величину аргумента в %).
         */
        indexEmployeeSalaries(15f);
        /**
         * 2.e Проиндексировать зарплату (вызвать изменение зарплат у всех сотрудников ОТДЕЛА на величину аргумента в %).
         */
        indexEmployeeSalaries(5f, Department.FIRST);
        /**
         * 2.f Напечатать всех сотрудников отдела (все данные, кроме отдела)
         */
        printEmployeesInformationList(Department.FIRST);
        printSeparator();
        printEmployeesInformationList(Department.SECOND);
        printSeparator();
        printEmployeesInformationList(Department.THIRD);
        printSeparator();

        Employee employee;
        final float amount = 40000f;
        System.out.format("Сотрудник с минимальной зарплатой %s отдела:\n", Department.FIRST);
        employee = findEmployeeWithMinSalary(Department.FIRST);
        System.out.println((employee != null) ? employee.toString() : "отсутствует");
        System.out.println();

        System.out.format("Сотрудник с максимальной зарплатой %s отдела:\n", Department.FIRST);
        employee = findEmployeeWithMaxSalary(Department.FIRST);
        System.out.println((employee != null) ? employee.toString() : "отсутствует");
        System.out.println();

        System.out.format("Сумма затрат на зарплаты в месяц по отделу %s:\n", Department.FIRST);
        System.out.format("%.2f\n", calculateSalaryCosts(Department.FIRST));
        printSeparator();

        System.out.format("Среднее значение зарплат %s отдела:\n", Department.FIRST);
        System.out.format("%.2f\n", calculatingTheAverageSalary(Department.FIRST));
        printSeparator();

        System.out.format("Сотрудники с зарплатой меньше %.2f\n", amount);
        findEmployeesWithSalaryLessSpecified(amount);
        System.out.println();
        printSeparator();

        System.out.format("Сотрудники с зарплатой больше %.2f\n", amount);
        findEmployeesWithSalaryGreaterSpecified(amount);
        System.out.println();
        printSeparator();

    }

    public static void printSeparator() {
        System.out.println("====================================================");
    }

    /**
     * Заполнение начальных данных о сотрудниках.
     */
    private static void initializationEmployeesData() {
        employee[0] = new Employee(new FullName("Александр", "Сергеевич", "Пушкин"), Department.FIRST, new java.util.Random().nextInt(100_000));
        employee[1] = new Employee(new FullName("Михаил", "Юрьевич", "Лермонтов"), Department.FIRST, new java.util.Random().nextInt(100_000));
        employee[2] = new Employee(new FullName("Александр", "Александрович", "Блок"), Department.FIRST, new java.util.Random().nextInt(100_000));
        employee[3] = new Employee(new FullName("Владимир", "Владимирович", "Маяковский"), Department.SECOND, new java.util.Random().nextInt(100_000));
        employee[4] = new Employee(new FullName("Сергей", "Александрович", "Есенин"), Department.SECOND, new java.util.Random().nextInt(100_000));
        employee[5] = new Employee(new FullName("Борис", "Акунин"), Department.THIRD, new java.util.Random().nextInt(100_000));
        employee[6] = new Employee(new FullName("Анна", "Борисова"), Department.THIRD, new java.util.Random().nextInt(100_000));
    }

    /**
     * Проиндексировать зарплату всех сотрудников на величину в процентах.
     * @param percent Процент индексации.
     */
    public static void indexEmployeeSalaries(float percent) {
        float wagesAmount, indexationAmount;

        for (Employee item : employee) {
            if (item != null) {
                wagesAmount = item.getSalary();
                indexationAmount = wagesAmount * percent / 100.0f;
                item.setSalary(wagesAmount + indexationAmount);
            }
        }
    }
    /**
     * Проиндексировать зарплату сотрудников заданного отдела на величину в процентах.
     * @param percent Процент индексации.
     * @param department Код отдела.
     */
    public static void indexEmployeeSalaries(float percent, Department department) {
        float wagesAmount, indexationAmount;

        for (Employee item : employee) {
            if (item != null && department == item.getDepartment()) {
                wagesAmount = item.getSalary();
                indexationAmount = wagesAmount * percent / 100.0f;
                item.setSalary(wagesAmount + indexationAmount);
            }
        }
    }
    /**
     * Получить список и вывести в консоль
     * всех сотрудников отдела со всеми имеющимися
     * по ним данными (кроме отдела).
     *
     * @param department Код отдела.
     */
    public static void printEmployeesInformationList(Department department) {
        System.out.format("%5s %-15s %-15s %-15s %s", "ИД", "ИМЯ", "ОТЧЕСТВО", "ФАМИЛИЯ", "ЗАРПЛАТА");
        System.out.println();
        for (Employee item : employee) {
            if (item != null && department == item.getDepartment()) {
                System.out.format("%5d %s %.2f\n", item.getId(), item.getPerson(), item.getSalary());
            }
        }
    }

    /**
     * Посчитать сумму затрат на зарплаты по отделу в месяц.
     * @param department Код отдела.
     * @return Сумма затрат.
     */
    public static float calculateSalaryCosts(Department department) {
        float sumOfAllSalaries = 0;

        for (Employee item : employee) {
            if (item != null && department == item.getDepartment()) {
                sumOfAllSalaries += item.getSalary();
            }
        }

        return sumOfAllSalaries;
    }

    /**
     * Расчет средней зарплаты по отделу.
     * @param department Код отдела.
     * @return Величина зарплаты.
     */
    public static float calculatingTheAverageSalary(Department department) {
        float sumOfAllSalaries = 0;
        int numberOfRegisteredEmployees = 0;

        for (Employee item : employee) {
            if (item != null && department == item.getDepartment()) {
                numberOfRegisteredEmployees++;
                sumOfAllSalaries += item.getSalary();
            }
        }
        return (numberOfRegisteredEmployees > 0) ? sumOfAllSalaries / numberOfRegisteredEmployees : 0.0f;
    }
    /**
     * Поиск сотрудника с минимальной зарплатой в отделе.
     * @param department Код отдела.
     * @return Объект найденного сотрудника.
     */
    public static Employee findEmployeeWithMinSalary(Department department) {
        float minimumWage = Float.MAX_VALUE;
        Employee employeeWithMinimumWage = null;

        for (Employee item : employee){
            if (item != null && department == item.getDepartment()) {
                float wage = item.getSalary();
                if (wage < minimumWage) {
                    minimumWage = wage;
                    employeeWithMinimumWage = item;
                }
            }
        }
        return employeeWithMinimumWage;
    }
    /**
     * Поиск сотрудника с максимальной зарплатой в отделе.
     * @param department Код отдела.
     * @return Объект найденного сотрудника.
     */
    public static Employee findEmployeeWithMaxSalary(Department department) {
        float maximumWage = Float.MIN_VALUE;
        Employee employeeWithMaximumWage = null;

        for (Employee item : employee){
            if (item != null && department == item.getDepartment()) {
                float wage = item.getSalary();
                if (wage > maximumWage) {
                    maximumWage = wage;
                    employeeWithMaximumWage = item;
                }
            }
        }
        return employeeWithMaximumWage;
    }
    /**
     * Получить список и вывести в консоль (id, Ф. И. О. и зарплату)
     * всех сотрудников с зарплатой меньше заданного зачения.
     *
     * @param amount Зачение для сравнения.
     */
    public static void findEmployeesWithSalaryLessSpecified(float amount) {
        for (Employee item : employee){
            if (item != null && item.getSalary() < amount) {
                System.out.println(item);
            }
        }
    }

    /**
     * Получить список и вывести в консоль (id, Ф.И. О. и зарплату)
     * всех сотрудников с зарплатой больше или равно заданного зачения.
     *
     * @param amount Зачение для сравнения.
     */
    public static void findEmployeesWithSalaryGreaterSpecified(float amount) {
        for (Employee item : employee){
            if (item != null && item.getSalary() >= amount) {
                System.out.println(item);
            }
        }
    }

}

