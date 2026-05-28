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

package ru.nikzan.main;

import ru.nikzan.weapons.Weapon;
import ru.nikzan.weapons.UnmodifiableWeapon;

// FIXME: отсутствует обязательный Javadoc публичного класса (п. 7.3)
//public class Shooter {
// FIXTO:
/**
 * Класс, представляющий стрелка, который может владеть оружием и стрелять из него.
 */
public class Shooter {
  private String name;
  private Weapon weapon;

  /**
   * Создает безоружного стрелка.
   *
   * @param name имя стрелка
   */
  public Shooter(String name) {
    this.name = name;
    this.weapon = null;
  }

  /**
   * Создает стрелка, вооруженного конкретным оружием.
   *
   * @param name имя стрелка
   * @param weapon оружие
   */
  public Shooter(String name, Weapon weapon) {
    this.name = name;
    this.weapon = weapon;
  }

  /**
   * Стрелок производит выстрел из имеющегося оружия.
   * Выводит сообщение об ошибке, если оружия нет.
   */
  public void shoot() {
    if (weapon == null) {
      System.out.println(name + ": не могу участвовать в перестрелке");
    } else {
      System.out.print(name + ": ");
      weapon.shoot();
    }
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  // FIXME: Javadoc написан некорректно, отсутствуют теги @return (п. 7.1.3, 7.3)
//    /**
//     * Возвращает неизменяемую копию оружия.
//     * Защитное копирование - предотвращает модификацию внутреннего состояния.
//     */
//    public Weapon getWeapon() {
  // FIXTO:
  /**
   * Возвращает неизменяемую копию оружия.
   * Защитное копирование - предотвращает модификацию внутреннего состояния.
   *
   * @return неизменяемая обертка для оружия или null, если оружия нет
   */
  public Weapon getWeapon() {
    if (weapon == null) {
      return null;
    }
    return new UnmodifiableWeapon(weapon);
  }

  public void setWeapon(Weapon weapon) {
    this.weapon = weapon;
  }

  @Override
  public String toString() {
    if (weapon == null) {
      return "Стрелок " + name + " (без оружия)";
    }
    return "Стрелок " + name + " (оружие: " + weapon + ")";
  }
}