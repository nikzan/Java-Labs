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

package ru.nikzan.people;

// FIXME: отсутствует обязательный Javadoc публичного класса (п. 7.3)
//public class Name {
// FIXTO:
/**
 * Класс, инкапсулирующий полное имя человека и гарантирующий его валидность.
 */
public class Name {
  private final String lastName;
  private final String firstName;
  private final String patronymic;

  // FIXME: отсутствует Javadoc конструктора со сложной логикой валидации (п. 7.3), 
  // неверный перенос логических операторов && (п. 4.5.1) - они должны быть на новой строке
//    public Name(String firstName, String patronymic, String lastName) {
//        if ((firstName == null || firstName.isEmpty()) && 
//            (patronymic == null || patronymic.isEmpty()) && 
//            (lastName == null || lastName.isEmpty())) {
//            throw new IllegalArgumentException("Хотя бы одно из полей имени должно быть заполнено");
//        }
//        ...
  // FIXTO:
  /**
   * Конструктор полного имени (с отчеством).
   *
   * @param firstName имя
   * @param patronymic отчество
   * @param lastName фамилия
   * @throws IllegalArgumentException если все переданные параметры null или пусты
   */
  public Name(String firstName, String patronymic, String lastName) {
    if ((firstName == null || firstName.isEmpty())
        && (patronymic == null || patronymic.isEmpty())
        && (lastName == null || lastName.isEmpty())) {
      throw new IllegalArgumentException("Хотя бы одно из полей имени должно быть заполнено");
    }
    
    this.firstName = firstName;
    this.patronymic = patronymic;
    this.lastName = lastName;
  }

  /**
   * Создает имя без отчества.
   *
   * @param firstName имя
   * @param lastName фамилия
   */
  public Name(String firstName, String lastName) {
    this(firstName, null, lastName);
  }

  /**
   * Создает имя без отчества и фамилии.
   *
   * @param firstName имя
   */
  public Name(String firstName) {
    this(firstName, null, null);
  }

  @Override
  public String toString() {
    StringBuilder result = new StringBuilder();
    if (firstName != null && !firstName.isEmpty()) {
      result.append(firstName);
    }
    if (patronymic != null && !patronymic.isEmpty()) {
      if (result.length() > 0) {
        result.append(" ");
      }
      result.append(patronymic);
    }
    if (lastName != null && !lastName.isEmpty()) {
      if (result.length() > 0) {
        result.append(" ");
      }
      result.append(lastName);
    }
    return result.toString();
  }

  public String getLastName() {
    return lastName;
  }

  public String getFirstName() {
    return firstName;
  }

  public String getPatronymic() {
    return patronymic;
  }
}