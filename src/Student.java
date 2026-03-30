import java.util.Map;
import java.util.Objects;
import java.util.HashMap;

public class Student
{
    int numarMatricol;
    String prenume;
    String nume;
    String formatieDeStudiu;
    int nota;

    public Student(int numarMatricol,String prenume,String nume,String  formatieDeStudiu,int nota)
    {
        this.numarMatricol=numarMatricol;
        this.prenume=prenume;
         this.nume=nume;
        this.formatieDeStudiu=formatieDeStudiu;
        this.nota=nota;

    }

    public static float gasesteNota(String prenume, String nume, Map<?, ?> tineri) {
        Map<String, Float> indexRapid = new HashMap<>();

        for (Object valoare : tineri.values()) {
            if (valoare instanceof Student s) {
                String cheie = s.prenume + "-" + s.nume;
                indexRapid.put(cheie, (float) s.nota);
            }
        }

        String cheieCautata = prenume + "-" + nume;


        return indexRapid.getOrDefault(cheieCautata, 0.0f);
    }

    public Student(String linieDinFisier){
        String[] bucati=linieDinFisier.split(",");
        this.numarMatricol=Integer.parseInt(bucati[0].trim());
        this.nume=bucati[1].trim();
        this.prenume=bucati[2].trim();
        this.formatieDeStudiu=bucati[3].trim();
    }

public int getNota(){
        return this.nota;
}
    public String getNume() {
        return this.nume;
    }

    public String getFormatieDeStudiu() {
        return this.formatieDeStudiu;
    }

    public String getPrenume() {
        return this.prenume;
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
