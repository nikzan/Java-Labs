package ru.nikzan.cats;

public class Funs {
    public static void meowsCare(Meowable m) {
        System.out.print("Вызываем мяуканье: ");
        m.meow();
        System.out.print("Вызываем мяуканье еще раз: ");
        m.meow();
        System.out.print("И еще раз: ");
        m.meow();
    }
}
