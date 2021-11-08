package ru.skypro.Level_Nedium;
public class Employee {
private static int counter = 0;      // Добавить статическую переменную-счетчик

private final int id;                // Уникальный идентификационный номер сотрудника.
private final FullName person;       // ФИО сотрудника.
private Department  department;      // Отдел сотрудника.
private float salary;                // Текущая заработная плата сотрудника.

/**
 * Конструктор нового экземпляра класса {@code Employee},
 * заполняющий все реквизиты сотрудника, кроме идентификатора.
 * Уникальный идентификационный номер (@code id) заполняется
 * автоматически по глобальному счетчику (@code counter).
 *
 * @param department Отдел, где трудится сотрудник.
 * @param person    ФИО сотрудника.
 * @param salary Размер заработной платы сотрудника.
 */

public Employee(FullName person, Department department, float salary) {
        this.person     = person;
        this.department = department;
        this.salary     = salary;
        id = ++counter;
        }

        // 4. Добавить возможность получать значения полей из Employee (геттеры) для всех полей.
        /**
         * Получить полное имя (Ф.И.О.) сотрудника.
         * @return Значение Ф.И.О. сотрудника.
         */
        public FullName getPerson() {
                return person;
        }
        /**
         * Получить значение заработной платы сотрудника.
         * @return Зарплата сотрудника.
         */
        public float getSalary() {
                return salary;
        }
        /**
         * Получить отдел сотрудника.
         * @return Отдел сотрудника.
         */
        public Department getDepartment() {
                return department;
        }
        /**
         * Получить значение идентификационного номера сотрудника.
         * @return Идентификационный номер сотрудника.
         */
        public int getId() {
                return id;
        }
        //5. Добавить возможность устанавливать значения полей отдела и зарплаты (сеттеры).
        /**
         * Установить новое значение отдела сотрудника.
         * @param department Отдел сотрудника.
         */
        public void setDepartment(Department department) {
                this.department = department;
        }
        /**
         * Получить значение заработной платы сотрудника.
         * @return Зарплата сотрудника.
         */
        public void setSalary(float salary) {
                this.salary = salary;
        }

        @Override
        public String toString() {
                return String.format( "Таб.номер %d, Сотрудник %s, Отдел - %7s, З/П %10.2f руб. ",
                        id, person, department, salary);

        }
}
