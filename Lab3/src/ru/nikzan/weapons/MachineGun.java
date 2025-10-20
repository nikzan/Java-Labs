package ru.nikzan.weapons;

public class MachineGun extends Gun {
    private final int rateOfFire;

    public MachineGun() {
        super(30);
        this.rateOfFire = 30;
    }

    public MachineGun(int maxAmmo) {
        super(maxAmmo);
        this.rateOfFire = maxAmmo / 2;
    }

    public MachineGun(int maxAmmo, int rateOfFire) {
        super(maxAmmo);
        if (rateOfFire <= 0) {
            throw new IllegalArgumentException("Скорострельность должна быть положительным числом");
        }
        this.rateOfFire = rateOfFire;
    }

    @Override
    public void shoot() {
        for (int i = 0; i < rateOfFire; i++) {
            super.shoot();
        }
    }

    public void shootForSeconds(int seconds) {
        int totalShots = seconds * rateOfFire;
        for (int i = 0; i < totalShots; i++) {
            super.shoot();
        }
    }

    public int getRateOfFire() {
        return rateOfFire;
    }

    @Override
    public String toString() {
        return "Автомат (" + getCurrentAmmo() + "/" + getMaxAmmo() + " патронов, скорострельность: " + rateOfFire + " выстр/сек)";
    }
}
