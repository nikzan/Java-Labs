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

// FIXME: отсутствует обязательный Javadoc публичного класса (п. 7.3)
//public class Employee {
//    private String name;
//    private Department department;
//
//    // FIXME: отсутствует Javadoc конструктора (п. 7.3)
//    public Employee(String name, Department department) {
// FIXTO:
/**
 * Класс, представляющий сотрудника.
 */
public class Employee {
  private String name;
  private Department department;

  /**
   * Создает сотрудника и автоматически добавляет его в указанный отдел.
   *
   * @param name имя сотрудника
   * @param department отдел, в котором будет числиться сотрудник
   */
  public Employee(String name, Department department) {
    this.name = name;
    this.department = department;
    if (department != null) {
      department.addEmployee(this);
    }
  }

  // FIXME: нет @Override (п. 6.1), лишняя пустая строка внутри метода, 
  // строка с конкатенацией слишком длинная — нужно перенести (п. 4.4)
//    public String toString() {
//        if (department == null) {
//            return name;
//        }
//        
//        if (department.getBoss() == this) {
//            return name + " начальник отдела " + department.getName();
//        } else {
//            String bossName = department.getBoss() != null ? department.getBoss().getName() : "неизвестен";
//            return name + " работает в отделе " + department.getName() + ", начальник которого " + bossName;
//        }
//    }
  // FIXTO:
  @Override
  public String toString() {
    if (department == null) {
      return name;
    }
    if (department.getBoss() == this) {
      return name + " начальник отдела " + department.getName();
    } else {
      String bossName =
          department.getBoss() != null ? department.getBoss().getName() : "неизвестен";
      return name + " работает в отделе " + department.getName()
          + ", начальник которого " + bossName;
    }
  }

  public String getName() {
    return name;
  }

  public Department getDepartment() {
    return department;
  }
}