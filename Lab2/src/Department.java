// FIXME: отсутствует лицензия (п. 3.1) и глобальные отступы должны быть 2 пробела вместо 4 (п. 4.2)
// FIXTO:
/*
 * Copyright (c) 2026 Nikita Zanadvornykh
 * 
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 * 
 * The above copyright notice and this permission notice shall be included in all
 * copies or substantial portions of the Software.
 * 
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 * SOFTWARE.
 */

import java.util.ArrayList;
import java.util.List;

// FIXME: отсутствует обязательный Javadoc публичного класса (п. 7.3)
//public class Department {
//    private String name;
//    private Employee boss;
//    private List<Employee> employees;
//
//    // FIXME: отсутствует Javadoc конструктора (п. 7.3)
//    public Department(String name) {
// FIXTO:
/**
 * Класс, представляющий отдел компании.
 */
public class Department {
  private String name;
  private Employee boss;
  private List<Employee> employees;

  /**
   * Создает новый пустой отдел.
   *
   * @param name название отдела
   */
  public Department(String name) {
    this.name = name;
    this.employees = new ArrayList<>();
  }

  public void setBoss(Employee boss) {
    this.boss = boss;
  }

  // FIXME: отсутствует Javadoc метода со сложной логикой (п. 7.3)
//    public void addEmployee(Employee employee) {
  // FIXTO:
  /**
   * Добавляет сотрудника в отдел, предотвращая появление дубликатов.
   *
   * @param employee добавляемый сотрудник
   */
  public void addEmployee(Employee employee) {
    if (!employees.contains(employee)) {
      employees.add(employee);
    }
  }

  // FIXME: метод возвращает копию списка (защитное копирование), это неочевидное поведение, требующее Javadoc (п. 7.3)
//    public List<Employee> getEmployees() {
//        return new ArrayList<>(employees);
//    }
  // FIXTO:
  /**
   * Возвращает копию списка сотрудников отдела.
   *
   * @return список сотрудников
   */
  public List<Employee> getEmployees() {
    return new ArrayList<>(employees);
  }

  public String getName() {
    return name;
  }

  public Employee getBoss() {
    return boss;
  }

  // FIXME: нет @Override (п. 6.1)
//    public String toString() {
//        return name;
//    }
  // FIXTO:
  @Override
  public String toString() {
    return name;
  }
}