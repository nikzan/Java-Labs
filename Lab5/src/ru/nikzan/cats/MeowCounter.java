package ru.nikzan.cats;

public class MeowCounter implements Meowable {
    private final Meowable meowable;
    private int count;

    public MeowCounter(Meowable meowable) {
        this.meowable = meowable;
        this.count = 0;
    }

    @Override
    public void meow() {
        count++;
        meowable.meow();
    }

    public int getCount() {
        return count;
    }

    @Override
    public String toString() {
        return meowable.toString();
    }
}
