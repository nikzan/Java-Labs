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
//public class Gun {
//    private int bullets;
//
//    // FIXME: отсутствует Javadoc конструктора (п. 7.3)
//    public Gun(int bullets) {
// FIXTO:
/**
 * Описывает пистолет, способный стрелять ограниченное количество раз.
 */
public class Gun {
  private int bullets;

  /**
   * Создает пистолет с заданным количеством патронов.
   *
   * @param bullets количество патронов
   */
  public Gun(int bullets) {
    this.bullets = bullets;
  }

  // FIXME: отсутствует Javadoc (п. 7.3), дублирует логику основного конструктора — делегировать через this()
//    public Gun() {
//        this.bullets = 5;
//    }
  // FIXTO:
  /**
   * Создает пистолет со стандартным боезапасом в 5 патронов.
   */
  public Gun() {
    this(5);
  }

  // FIXME: отсутствует Javadoc метода (п. 7.3)
//    public void shoot() {
  // FIXTO:
  /**
   * Производит выстрел. Уменьшает боезапас, если пистолет заряжен.
   */
  public void shoot() {
    if (bullets > 0) {
      System.out.println("Бах!");
      bullets--;
    } else {
      System.out.println("Клац!");
    }
  }

  public int getBullets() {
    return bullets;
  }

  // FIXME: нет @Override (п. 6.1)
//    public String toString() {
//        return "Пистолет с " + bullets + " патронами";
//    }
  // FIXTO:
  @Override
  public String toString() {
    return "Пистолет с " + bullets + " патронами";
  }
}