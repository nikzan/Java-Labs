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
//public class Name {
//    private String lastName;
//    private String firstName;
//    private String patronymic;
//
//    // FIXME: отсутствует Javadoc конструктора (п. 7.3)
//    public Name(String lastName, String firstName, String patronymic) {
// FIXTO:
/**
 * Класс, инкапсулирующий полное имя (ФИО) в строгом порядке параметров.
 */
public class Name {
  private String lastName;
  private String firstName;
  private String patronymic;

  /**
   * Конструктор полного имени.
   *
   * @param lastName фамилия
   * @param firstName имя
   * @param patronymic отчество
   */
  public Name(String lastName, String firstName, String patronymic) {
    this.lastName = lastName;
    this.firstName = firstName;
    this.patronymic = patronymic;
  }

  // FIXME: нет @Override (п. 6.1), лишние пустые строки внутри метода
//    public String toString() {
//        StringBuilder result = new StringBuilder();
//        
//        if (lastName != null && !lastName.isEmpty()) {
//            result.append(lastName);
//        }
//        
//        if (firstName != null && !firstName.isEmpty()) {
//            if (result.length() > 0) {
//                result.append(" ");
//            }
//            result.append(firstName);
//        }
//        
//        if (patronymic != null && !patronymic.isEmpty()) {
//            if (result.length() > 0) {
//                result.append(" ");
//            }
//            result.append(patronymic);
//        }
//        
//        return result.toString();
//    }
  // FIXTO:
  @Override
  public String toString() {
    StringBuilder result = new StringBuilder();
    if (lastName != null && !lastName.isEmpty()) {
      result.append(lastName);
    }
    if (firstName != null && !firstName.isEmpty()) {
      if (result.length() > 0) {
        result.append(" ");
      }
      result.append(firstName);
    }
    if (patronymic != null && !patronymic.isEmpty()) {
      if (result.length() > 0) {
        result.append(" ");
      }
      result.append(patronymic);
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