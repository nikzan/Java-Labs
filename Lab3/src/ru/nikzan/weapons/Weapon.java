package ru.nikzan.weapons;

public abstract class Weapon {
    protected int ammo;

    public Weapon(int ammo) {
        if (ammo < 0) {
            throw new RuntimeException("Количество патронов не может быть отрицательным");
        }
        this.ammo = ammo;
    }

    public abstract void shoot();

    public int ammo() {
        return ammo;
    }

    public boolean getAmmo() {
        if (ammo == 0) {
            return false;
        }
        ammo--;
        return true;
    }

    public int load(int ammo) {
        if (ammo < 0) {
            throw new RuntimeException("Нельзя зарядить отрицательное количество патронов");
        }
        int tmp = this.ammo;
        this.ammo = ammo;
        return tmp;
    }
}
