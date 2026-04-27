import java.util.Objects;

public class StudentBursier extends Student {
    private double cuantumBursa;

    public StudentBursier(int numarMatricol, String prenume, String nume, String formatieDeStudiu, double nota, double cuantumBursa) {
        super(numarMatricol, prenume, nume, formatieDeStudiu, (int) nota);
        this.cuantumBursa = cuantumBursa;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof StudentBursier that)) return false;
        if (!super.equals(o)) return false;
        return Double.compare(that.cuantumBursa, cuantumBursa) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), cuantumBursa);
    }

    @Override
    public String toString() {
        return super.toString().replace("}", ", cuantumBursa=" + cuantumBursa + "}");
    }
}