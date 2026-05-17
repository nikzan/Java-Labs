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
//public class Person {
//    private String name;
//    private int height;
//
//    // FIXME: отсутствует Javadoc, присвоение this.name происходит до валидации (если исключение - частично инициализирован)
//    public Person(String name, int height) {
//        this.name = name;
//        if (height < 100 || height > 250) {
//            throw new IllegalArgumentException("Рост должен быть от 100 до 250 см");
//        }
//        this.height = height;
//    }
// FIXTO:
/**
 * Класс, описывающий человека.
 */
public class Person {
  private String name;
  private int height;

  /**
   * Создает человека с валидацией его параметров.
   *
   * @param name имя человека
   * @param height рост человека (допустимо от 100 до 250 см)
   * @throws IllegalArgumentException если рост выходит за допустимые границы
   */
  public Person(String name, int height) {
    if (height < 100 || height > 250) {
      throw new IllegalArgumentException("Рост должен быть от 100 до 250 см");
    }
    this.name = name;
    this.height = height;
  }

  // FIXME: нет @Override (п. 6.1)
//    public String toString() {
//        return name + ", рост: " + height;
//    }
  // FIXTO:
  @Override
  public String toString() {
    return name + ", рост: " + height;
  }

  public String getName() {
    return name;
  }

  public int getHeight() {
    return height;
  }
}