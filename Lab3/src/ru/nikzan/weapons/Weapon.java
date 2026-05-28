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
//public abstract class Weapon {
// FIXTO:
/**
 * Абстрактный базовый класс для всех видов оружия.
 */
public abstract class Weapon {
  protected int ammo;

  /**
   * Инициализирует оружие стартовым количеством патронов.
   *
   * @param ammo начальное количество патронов
   * @throws RuntimeException если переданное количество отрицательное
   */
  public Weapon(int ammo) {
    if (ammo < 0) {
      throw new RuntimeException("Количество патронов не может быть отрицательным");
    }
    this.ammo = ammo;
  }

  /**
   * Производит выстрел. Реализуется в классах-наследниках.
   */
  public abstract void shoot();

  public int ammo() {
    return ammo;
  }

  /**
   * Пытается извлечь (потратить) один патрон из оружия.
   *
   * @return true, если патрон был успешно потрачен, иначе false
   */
  public boolean getAmmo() {
    if (ammo == 0) {
      return false;
    }
    ammo--;
    return true;
  }

  /**
   * Принудительно устанавливает новое количество патронов.
   *
   * @param ammo новое количество патронов
   * @return старое (извлеченное) количество патронов
   * @throws RuntimeException если переданное количество отрицательное
   */
  public int load(int ammo) {
    if (ammo < 0) {
      throw new RuntimeException("Нельзя зарядить отрицательное количество патронов");
    }
    int tmp = this.ammo;
    this.ammo = ammo;
    return tmp;
  }
}