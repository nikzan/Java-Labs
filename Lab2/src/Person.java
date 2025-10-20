public class Person {
    private String name;
    private int height;

    public Person(String name, int height) {
        this.name = name;
        if (height < 100 || height > 250) {
            throw new IllegalArgumentException("Рост должен быть от 100 до 250 см");
        }
        this.height = height;
    }

    @Override
    public String toString() {
        return name + ", рост: " + height;
    }

    public String getName() {
        return name;
    }

    public int getHeight() {
        return height;
    }
}
