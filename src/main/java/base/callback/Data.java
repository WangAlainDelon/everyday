package base.callback;

public class Data {
    private int n;
    private int m;

    public int getN() {
        return n;
    }

    public void setN(int n) {
        this.n = n;
    }

    public int getM() {
        return m;
    }

    public void setM(int m) {
        this.m = m;
    }

    @Override
    public String toString() {
        return "Data{" +
                "n=" + n +
                ", m=" + m +
                '}';
    }
}
