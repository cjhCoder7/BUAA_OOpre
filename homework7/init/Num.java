public class Num implements Factor {
    public final int value;

    public Num(int value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return String.valueOf(value);
    }

    public void print() {
        System.out.println("Num " + this);
    }
}
