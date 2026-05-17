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
//public class TestRunner {
//    private int totalTests = 0;
//    private int passedTests = 0;
//    private int failedTests = 0;
//
//    // FIXME: отсутствует Javadoc метода (п. 7.3)
//    public void test(String testName, boolean condition) {
// FIXTO:
/**
 * Утилитарный класс для запуска автоматических тестов.
 */
public class TestRunner {
  private int totalTests = 0;
  private int passedTests = 0;
  private int failedTests = 0;

  /**
   * Проверяет истинность переданного условия.
   *
   * @param testName название теста
   * @param condition ожидаемое логическое значение
   */
  public void test(String testName, boolean condition) {
    totalTests++;
    if (condition) {
      passedTests++;
      System.out.println("+ " + testName);
    } else {
      failedTests++;
      System.out.println("- " + testName);
    }
  }

  // FIXME: отсутствует Javadoc (п. 7.3), неправильный перенос оператора || (п. 4.5.1), строка > 100 символов (п. 4.4)
//    public void testEquals(String testName, Object expected, Object actual) {
//        totalTests++;
//        boolean passed = (expected == null && actual == null) ||
//                        (expected != null && expected.equals(actual));
//        if (passed) {
//            passedTests++;
//            System.out.println("+ " + testName);
//        } else {
//            failedTests++;
//            System.out.println("- " + testName + " (ожидалось: " + expected + ", получено: " + actual + ")");
//        }
//    }
  // FIXTO:
  /**
   * Проверяет равенство ожидаемого и фактического результатов.
   *
   * @param testName название теста
   * @param expected ожидаемое значение
   * @param actual фактическое значение
   */
  public void testEquals(String testName, Object expected, Object actual) {
    totalTests++;
    boolean passed = (expected == null && actual == null)
        || (expected != null && expected.equals(actual));
    if (passed) {
      passedTests++;
      System.out.println("+ " + testName);
    } else {
      failedTests++;
      System.out.println("- " + testName + " (ожидалось: " + expected 
          + ", получено: " + actual + ")");
    }
  }

  // FIXME: отсутствует Javadoc метода (п. 7.3)
//    public void startSection(String sectionName) {
  // FIXTO:
  /**
   * Выводит заголовок новой секции тестирования.
   *
   * @param sectionName название секции
   */
  public void startSection(String sectionName) {
    System.out.println("\n=== " + sectionName + " ===");
  }

  // FIXME: отсутствует Javadoc метода (п. 7.3)
//    public void printSummary() {
  // FIXTO:
  /**
   * Выводит итоговую статистику по всем пройденным тестам.
   */
  public void printSummary() {
    System.out.println("\n" + "=".repeat(50));
    System.out.println("Результаты тестирования:");
    System.out.println("Всего тестов: " + totalTests);
    System.out.println("Пройдено: " + passedTests);
    System.out.println("Провалено: " + failedTests);
    System.out.println("=".repeat(50));
  }

  // FIXME: отсутствует Javadoc метода (п. 7.3)
//    public static void main(String[] args) {
  // FIXTO:
  /**
   * Точка входа для запуска автоматических проверок (тестов).
   *
   * @param args аргументы командной строки
   */
  public static void main(String[] args) {
    TestRunner tr = new TestRunner();

    tr.startSection("Задача 1A - Класс Name");
    Name name1 = new Name(null, "Клеопатра", null);
    tr.testEquals("Клеопатра", "Клеопатра", name1.toString());

    Name name2 = new Name("Пушкин", "Александр", "Сергеевич");
    tr.testEquals("Пушкин Александр Сергеевич", "Пушкин Александр Сергеевич", name2.toString());

    Name name3 = new Name("Маяковский", "Владимир", null);
    tr.testEquals("Маяковский Владимир", "Маяковский Владимир", name3.toString());

    Name name4 = new Name("", "", "");
    tr.testEquals("Пустое имя", "", name4.toString());

    Name name5 = new Name(null, null, null);
    tr.testEquals("Все null", "", name5.toString());

    // FIXME: тест проходит, но результат будет строкой из пробелов — Name не делает trim()
//        Name name6 = new Name("  ", "  ", "  ");
//        tr.test("Имя с пробелами не должно быть пустым", name6.toString().length() > 0);
    // FIXTO: добавлен комментарий, поясняющий поведение
    Name name6 = new Name("  ", "  ", "  ");
    // Name не обрезает пробелы — toString() вернёт непустую строку, это ожидаемо
    tr.test("Имя с пробелами не должно быть пустым", name6.toString().length() > 0);

    tr.startSection("Задача 1B - Класс Person");
    Person person1 = new Person("Клеопатра", 152);
    tr.testEquals("Клеопатра с ростом 152", "Клеопатра, рост: 152", person1.toString());

    Person person2 = new Person("Пушкин", 167);
    tr.testEquals("Пушкин с ростом 167", "Пушкин, рост: 167", person2.toString());

    Person person3 = new Person("Владимир", 189);
    tr.testEquals("Владимир с ростом 189", "Владимир, рост: 189", person3.toString());

    Person person4 = new Person("Минимум", 100);
    tr.testEquals("Минимальный рост", "Минимум, рост: 100", person4.toString());

    Person person5 = new Person("Максимум", 250);
    tr.testEquals("Максимальный рост", "Максимум, рост: 250", person5.toString());

    try {
      Person personInvalid1 = new Person("Ошибка", 99);
      tr.test("Рост 99 должен вызвать ошибку", false);
    } catch (IllegalArgumentException e) {
      tr.test("Рост 99 вызывает ошибку", true);
    }

    try {
      Person personInvalid2 = new Person("Ошибка", 251);
      tr.test("Рост 251 должен вызвать ошибку", false);
    } catch (IllegalArgumentException e) {
      tr.test("Рост 251 вызывает ошибку", true);
    }

    try {
      Person personInvalid3 = new Person("Ошибка", -10);
      tr.test("Отрицательный рост должен вызвать ошибку", false);
    } catch (IllegalArgumentException e) {
      tr.test("Отрицательный рост вызывает ошибку", true);
    }

    tr.startSection("Задача 2 - Employee и Department");
    Department it = new Department("IT");
    Employee petrov = new Employee("Петров", it);
    Employee kozlov = new Employee("Козлов", it);
    Employee sidorov = new Employee("Сидоров", it);
    it.setBoss(kozlov);

    tr.test("Петров работает в отделе IT", petrov.toString().contains("работает в отделе IT"));
    tr.test("Козлов начальник отдела IT", kozlov.toString().contains("начальник отдела IT"));
    tr.test("Сидоров работает в отделе IT", sidorov.toString().contains("работает в отделе IT"));
    tr.test("У Петрова начальник Козлов", petrov.toString().contains("Козлов"));

    Department hr = new Department("HR");
    Employee ivanov = new Employee("Иванов", hr);
    tr.test("Сотрудник без начальника", ivanov.toString().contains("неизвестен"));

    tr.startSection("Задача 3 - Список сотрудников отдела");
    tr.testEquals("В отделе IT 3 сотрудника", 3, it.getEmployees().size());
    tr.test("Петров в списке", it.getEmployees().contains(petrov));
    tr.test("Козлов в списке", it.getEmployees().contains(kozlov));
    tr.test("Сидоров в списке", it.getEmployees().contains(sidorov));

    Department empty = new Department("Empty");
    tr.testEquals("Пустой отдел", 0, empty.getEmployees().size());

    tr.startSection("Задача 4 - Перегрузка конструкторов Name2");
    Name2 n1 = new Name2("Клеопатра");
    tr.testEquals("Только имя", "Клеопатра", n1.toString());

    Name2 n2 = new Name2("Александр", "Пушкин");
    tr.testEquals("Имя и фамилия", "Александр Пушкин", n2.toString());

    Name2 n3 = new Name2("Владимир", "Маяковский");
    tr.testEquals("Владимир Маяковский", "Владимир Маяковский", n3.toString());

    Name2 n4 = new Name2("Христофор", "Бонифатьевич");
    tr.testEquals("Христофор Бонифатьевич", "Христофор Бонифатьевич", n4.toString());

    Name2 n5 = new Name2("");
    tr.testEquals("Пустая строка в конструкторе", "", n5.toString());

    Name2 n6 = new Name2("Александр", "Сергеевич", "Пушкин");
    tr.testEquals("Александр Сергеевич Пушкин", "Александр Сергеевич Пушкин", n6.toString());

    tr.startSection("Задача 5 - Gun");
    Gun gun1 = new Gun(3);
    gun1.shoot();
    tr.testEquals("После 1 выстрела осталось 2 патрона", 2, gun1.getBullets());
    gun1.shoot();
    gun1.shoot();
    tr.testEquals("После 3 выстрелов патронов нет", 0, gun1.getBullets());
    gun1.shoot();
    tr.testEquals("Выстрел из пустого пистолета не меняет патроны", 0, gun1.getBullets());

    Gun gun2 = new Gun();
    tr.testEquals("Пистолет по умолчанию имеет 5 патронов", 5, gun2.getBullets());

    Gun gun3 = new Gun(0);
    tr.testEquals("Пистолет с 0 патронов", 0, gun3.getBullets());

    // FIXME: Gun не валидирует отрицательные патроны — поведение не задокументировано
//        Gun gun4 = new Gun(-5);
//        tr.testEquals("Пистолет с отрицательным количеством патронов", -5, gun4.getBullets());
    // FIXTO: добавлен комментарий
    Gun gun4 = new Gun(-5);
    // Gun не валидирует количество патронов — при отрицательном значении shoot() выводит "Клац!"
    tr.testEquals("Пистолет с отрицательным количеством патронов", -5, gun4.getBullets());

    tr.printSummary();
  }
}