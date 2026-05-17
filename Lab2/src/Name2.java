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
//public class Name2 {
//    private String lastName;
//    private String firstName;
//    private String patronymic;
//
//    // FIXME: отсутствует Javadoc конструктора (п. 7.3)
//    public Name2(String firstName, String patronymic, String lastName) {
// FIXTO:
/**
 * Альтернативная реализация класса Name с перегрузкой конструкторов.
 */
public class Name2 {
  private String lastName;
  private String firstName;
  private String patronymic;

  /**
   * Создает полное имя (с отчеством).
   *
   * @param firstName имя
   * @param patronymic отчество
   * @param lastName фамилия
   */
  public Name2(String firstName, String patronymic, String lastName) {
    this.firstName = firstName;
    this.patronymic = patronymic;
    this.lastName = lastName;
  }

  // FIXME: отсутствует Javadoc конструктора (п. 7.3)
//    public Name2(String firstName, String lastName) {
  // FIXTO:
  /**
   * Создает имя и фамилию (без отчества).
   *
   * @param firstName имя
   * @param lastName фамилия
   */
  public Name2(String firstName, String lastName) {
    this.firstName = firstName;
    this.lastName = lastName;
  }

  // FIXME: отсутствует Javadoc (п. 7.3), явное присвоение null избыточно
//    public Name2(String firstName) {
//        this.firstName = firstName;
//        this.lastName = null;
//        this.patronymic = null;
//    }
  // FIXTO:
  /**
   * Создает имя (без фамилии и отчества).
   *
   * @param firstName имя
   */
  public Name2(String firstName) {
    this.firstName = firstName;
  }

  // FIXME: нет @Override (п. 6.1), лишние пустые строки внутри метода
//    public String toString() {
//        StringBuilder result = new StringBuilder();
//        
//        if (firstName != null && !firstName.isEmpty()) {
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
//        if (lastName != null && !lastName.isEmpty()) {
//            if (result.length() > 0) {
//                result.append(" ");
//            }
//            result.append(lastName);
//        }
//        
//        return result.toString();
//    }
  // FIXTO:
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