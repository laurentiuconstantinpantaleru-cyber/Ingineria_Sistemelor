import java.util.Objects;

// a)
public final class Student {
    private final int numarMatricol;
    private final String prenume;
    private final String nume;
    private final String formatieDeStudiu;
    private final int nota;

    public Student(int numarMatricol, String prenume, String nume, String formatieDeStudiu, int nota) {
        this.numarMatricol = numarMatricol;
        this.prenume = prenume;
        this.nume = nume;
        this.formatieDeStudiu = formatieDeStudiu;
        this.nota = nota;
    }


    public Student(String linieDinFisier) {
        String[] bucati = linieDinFisier.split(",");
        this.numarMatricol = Integer.parseInt(bucati[0].trim());
        this.nume = bucati[1].trim();
        this.prenume = bucati[2].trim();
        this.formatieDeStudiu = bucati[3].trim();
        this.nota = 0;
    }


    public Student mutaInFormatie(String nouaFormatie) {
        return new Student(this.numarMatricol, this.prenume, this.nume, nouaFormatie, this.nota);
    }


    public int getNota() { return this.nota; }
    public String getNume() { return this.nume; }
    public String getFormatieDeStudiu() { return this.formatieDeStudiu; }
    public String getPrenume() { return this.prenume; }
    public int getNumarMatricol() { return this.numarMatricol; }

    @Override
    public String toString() {
        return "Student{" +
                "matr=" + numarMatricol +
                ", nume='" + nume + '\'' +
                ", grupa='" + formatieDeStudiu + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Student student = (Student) o;
        return numarMatricol == student.numarMatricol &&
                Objects.equals(nume, student.nume) &&
                Objects.equals(prenume, student.prenume) &&
                Objects.equals(formatieDeStudiu, student.formatieDeStudiu);
    }

    @Override
    public int hashCode() {
        return Objects.hash(numarMatricol, nume, prenume, formatieDeStudiu);
    }
}