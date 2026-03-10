public class Student
{
    int numarMatricol;
    String prenume;
    String nume;
    int formatieDeStudiu;

    public Student(int numarMatricol,String prenume,String nume,int formatieDeStudiu)
    {
        this.numarMatricol=numarMatricol;
        this.prenume=prenume;
         this.nume=nume;
        this.formatieDeStudiu=formatieDeStudiu;

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
}
