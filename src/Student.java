import java.util.Objects;

public class Student
{
    int numarMatricol;
    String prenume;
    String nume;
    String formatieDeStudiu;

    public Student(int numarMatricol,String prenume,String nume,String  formatieDeStudiu)
    {
        this.numarMatricol=numarMatricol;
        this.prenume=prenume;
         this.nume=nume;
        this.formatieDeStudiu=formatieDeStudiu;

    }

    public Student(String linieDinFisier){
        String[] bucati=linieDinFisier.split(",");
        this.numarMatricol=Integer.parseInt(bucati[0].trim());
        this.nume=bucati[1].trim();
        this.prenume=bucati[2].trim();
        this.formatieDeStudiu=bucati[3].trim();
    }

    public String getNume() {
        return nume;
    }

    public String getFormatieDeStudiu() {
        return formatieDeStudiu;
    }

    @Override
  public String toString()
    {
        return "Student{" +
               "numarMatricol=" + numarMatricol +
               ", prenume='" + prenume + '\'' +
                ", nume='" + nume + '\'' +
               ", formatieDeStudiu=" + formatieDeStudiu +
               '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Student student = (Student) o;
        return Objects.equals(numarMatricol,student.numarMatricol)&&
                Objects.equals(nume, student.nume) &&
                Objects.equals(prenume, student.prenume) &&
                Objects.equals(formatieDeStudiu, student.formatieDeStudiu);
    }

    @Override
    public int hashCode() {
        return Objects.hash(numarMatricol,nume, prenume,  formatieDeStudiu);
    }

}
