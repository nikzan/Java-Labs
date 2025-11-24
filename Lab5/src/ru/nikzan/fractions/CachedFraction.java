package ru.nikzan.fractions;

public class CachedFraction implements FractionInterface {
    private final Fraction fraction;
    private Double cachedValue;

    public CachedFraction(Fraction fraction) {
        this.fraction = fraction;
    }

    @Override
    public double getDecimalValue() {
        if (cachedValue == null) {
            System.out.println(" Вычисление значения (не из кэша) ");
            cachedValue = fraction.getDecimalValue();
        } else {
            System.out.println(" Значение взято из кэша ");
        }
        return cachedValue;
    }

    @Override
    public void setNum(int num) {
        fraction.setNum(num);
        cachedValue = null; 
        System.out.println(" Кэш сброшен (изменен числитель) ");
    }

    @Override
    public void setDen(int den) {
        fraction.setDen(den);
        cachedValue = null; 
        System.out.println(" Кэш сброшен (изменен знаменатель) ");
    }

    @Override
    public String toString() {
        return fraction.toString();
    }
}
