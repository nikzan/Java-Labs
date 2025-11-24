package ru.nikzan.fractions;

import java.util.Objects;

public class Fraction implements FractionInterface {
    private int num;
    private int den;

    public Fraction(int num, int den) {
        if (den == 0) {
            throw new IllegalArgumentException("Знаменатель не может быть равен 0");
        }
        if (den < 0) {
            this.num = -num;
            this.den = -den;
        } else {
            this.num = num;
            this.den = den;
        }
    }

    @Override
    public double getDecimalValue() {
        return (double) num / den;
    }

    @Override
    public void setNum(int num) {
        this.num = num;
    }

    @Override
    public void setDen(int den) {
        if (den == 0) {
            throw new IllegalArgumentException("Знаменатель не может быть равен 0");
        }
        this.den = den;
    }

    @Override
    public String toString() {
        if (den < 0) {
            return (-num) + "/" + (-den);
        }
        return num + "/" + den;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Fraction fraction = (Fraction) o;
        int n1 = num, d1 = den;
        if (d1 < 0) { n1 = -n1; d1 = -d1; }
        int n2 = fraction.num, d2 = fraction.den;
        if (d2 < 0) { n2 = -n2; d2 = -d2; }
        return n1 == n2 && d1 == d2;
    }

    @Override
    public int hashCode() {
        int n = num, d = den;
        if (d < 0) { n = -n; d = -d; }
        return Objects.hash(n, d);
    }
}
