package ru.nikzan.weapons;

/**
 * Неизменяемая обёртка для Weapon.
 * Защищает от модификации оружия извне.
 */
public class UnmodifiableWeapon extends Weapon {
    private final Weapon delegate;

    public UnmodifiableWeapon(Weapon weapon) {
        super(weapon.ammo());
        this.delegate = weapon;
    }

    @Override
    public void shoot() {
        throw new UnsupportedOperationException("Нельзя стрелять из неизменяемой обёртки");
    }

    @Override
    public int load(int ammo) {
        throw new UnsupportedOperationException("Нельзя перезаряжать неизменяемую обёртку");
    }

    @Override
    public boolean getAmmo() {
        throw new UnsupportedOperationException("Нельзя расходовать патроны из неизменяемой обёртки");
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
