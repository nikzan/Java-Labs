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
//public class Gun extends Weapon {
// FIXTO:
/**
 * Класс, представляющий пистолет с ограниченной вместимостью обоймы.
 */
public class Gun extends Weapon {
  private final int maxBullets;

  /**
   * Создает пистолет с указанной максимальной вместимостью патронов.
   *
   * @param maxBullets максимальное количество патронов
   * @throws IllegalArgumentException если количество патронов отрицательное
   */
  public Gun(int maxBullets) {
    super(0);
    if (maxBullets < 0) {
      throw new IllegalArgumentException(
          "Максимальное количество патронов не может быть отрицательным");
    }
    this.maxBullets = maxBullets;
  }

  /**
   * Создает пистолет со стандартной вместимостью в 5 патронов.
   */
  public Gun() {
    this(5);
  }

  @Override
  public void shoot() {
    if (ammo > 0) {
      System.out.println("Бах!");
      ammo--;
    } else {
      System.out.println("Клац!");
    }
  }

  /**
   * Заряжает пистолет указанным количеством патронов.
   *
   * @param ammoToLoad количество добавляемых патронов
   * @return количество патронов, которые не влезли в обойму
   * @throws IllegalArgumentException если заряжаемое количество отрицательное
   */
  public int reload(int ammoToLoad) {
    if (ammoToLoad < 0) {
      throw new IllegalArgumentException(
          "Нельзя зарядить отрицательное количество патронов");
    }
    
    int totalAmmo = ammo + ammoToLoad;
    
    if (totalAmmo > maxBullets) {
      ammo = maxBullets;
      return totalAmmo - maxBullets;
    } else {
      ammo = totalAmmo;
      return 0;
    }
  }

  /**
   * Полностью разряжает пистолет.
   *
   * @return количество извлеченных патронов
   */
  public int unload() {
    int unloadedAmmo = ammo;
    ammo = 0;
    return unloadedAmmo;
  }

  public int getCurrentAmmo() {
    return ammo;
  }

  public int getMaxAmmo() {
    return maxBullets;
  }

  public boolean isLoaded() {
    return ammo > 0;
  }

  @Override
  public String toString() {
    return "Пистолет (" + ammo + "/" + maxBullets + " патронов)";
  }
}