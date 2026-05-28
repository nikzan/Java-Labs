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

/**
 * Неизменяемая обёртка для Weapon.
 * Защищает от модификации оружия извне.
 */
public class UnmodifiableWeapon extends Weapon {
  private final Weapon delegate;

  /**
   * Создает неизменяемую обертку вокруг существующего оружия.
   *
   * @param weapon исходное оружие
   */
  public UnmodifiableWeapon(Weapon weapon) {
    super(weapon.ammo());
    this.delegate = weapon;
  }

  @Override
  public void shoot() {
    throw new UnsupportedOperationException(
        "Нельзя стрелять из неизменяемой обёртки");
  }

  @Override
  public int load(int ammo) {
    throw new UnsupportedOperationException(
        "Нельзя перезаряжать неизменяемую обёртку");
  }

  @Override
  public boolean getAmmo() {
    throw new UnsupportedOperationException(
        "Нельзя расходовать патроны из неизменяемой обёртки");
  }

  @Override
  public int ammo() {
    return delegate.ammo();
  }

  @Override
  public String toString() {
    return delegate.toString();
  }
}