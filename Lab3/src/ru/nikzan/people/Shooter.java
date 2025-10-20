package ru.nikzan.people;

import ru.nikzan.weapons.Weapon;
import ru.nikzan.weapons.UnmodifiableWeapon;

public class Shooter {
    private String name;
    private Weapon weapon;

    public Shooter(String name) {
        this.name = name;
        this.weapon = null;
    }

    public Shooter(String name, Weapon weapon) {
        this.name = name;
        this.weapon = weapon;
    }

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

    /**
     * Возвращает неизменяемую копию оружия.
     * Защитное копирование - предотвращает модификацию внутреннего состояния.
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
