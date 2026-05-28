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

package ru.nikzan.weapons;

// FIXME: отсутствует обязательный Javadoc публичного класса (п. 7.3)
//public class MachineGun extends Gun {
// FIXTO:
/**
 * Автомат, способный вести огонь очередями в зависимости от скорострельности.
 */
public class MachineGun extends Gun {
  private final int rateOfFire;

  /**
   * Создает автомат со стандартной вместимостью (30) и скорострельностью (30).
   */
  public MachineGun() {
    super(30);
    this.rateOfFire = 30;
  }

  /**
   * Создает автомат с указанной максимальной вместимостью и половинной скорострельностью.
   *
   * @param maxAmmo максимальная вместимость
   */
  public MachineGun(int maxAmmo) {
    super(maxAmmo);
    this.rateOfFire = maxAmmo / 2;
  }

  /**
   * Создает автомат с указанными характеристиками.
   *
   * @param maxAmmo максимальная вместимость патронов
   * @param rateOfFire скорострельность (выстрелов в секунду)
   * @throws IllegalArgumentException если скорострельность <= 0
   */
  public MachineGun(int maxAmmo, int rateOfFire) {
    super(maxAmmo);
    if (rateOfFire <= 0) {
      throw new IllegalArgumentException(
          "Скорострельность должна быть положительным числом");
    }
    this.rateOfFire = rateOfFire;
  }

  @Override
  public void shoot() {
    for (int i = 0; i < rateOfFire; i++) {
      super.shoot();
    }
  }

  /**
   * Стреляет из автомата непрерывно в течение указанного времени.
   *
   * @param seconds количество секунд ведения огня
   */
  public void shootForSeconds(int seconds) {
    int totalShots = seconds * rateOfFire;
    for (int i = 0; i < totalShots; i++) {
      super.shoot();
    }
  }

  public int getRateOfFire() {
    return rateOfFire;
  }

  // FIXME: строка превышает 100 символов (п. 4.4), оператор конкатенации переносится неправильно (п. 4.5.1)
//    @Override
//    public String toString() {
//        return "Автомат (" + getCurrentAmmo() + "/" + getMaxAmmo() + " патронов, скорострельность: " + rateOfFire + " выстр/сек)";
//    }
  // FIXTO:
  @Override
  public String toString() {
    return "Автомат (" + getCurrentAmmo() + "/" + getMaxAmmo()
        + " патронов, скорострельность: " + rateOfFire + " выстр/сек)";
  }
}