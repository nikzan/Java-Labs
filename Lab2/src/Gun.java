public class Gun {
    private int bullets;

    public Gun(int bullets) {
        this.bullets = bullets;
    }

    public Gun() {
        this.bullets = 5;
    }

    public void shoot() {
        if (bullets > 0) {
            System.out.println("Бах!");
            bullets--;
        } else {
            System.out.println("Клац!");
        }
    }

    public int getBullets() {
        return bullets;
    }

    @Override
    public String toString() {
        return "Пистолет с " + bullets + " патронами";
    }
}
