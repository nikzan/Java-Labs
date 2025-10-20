package ru.nikzan.weapons;

public class Gun extends Weapon {
    private final int maxBullets;

    public Gun(int maxBullets) {
        super(0);
        if (maxBullets < 0) {
            throw new IllegalArgumentException("Максимальное количество патронов не может быть отрицательным");
        }
        this.maxBullets = maxBullets;
    }

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

    public int reload(int ammoToLoad) {
        if (ammoToLoad < 0) {
            throw new IllegalArgumentException("Нельзя зарядить отрицательное количество патронов");
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
