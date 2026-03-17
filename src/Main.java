import java.util.List;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

void main() {
   try
   {
List<String> Lista=Files.readAllLines(Paths.get("studenti_in.txt"));
List<Student> studenti= new ArrayList<>();
List<String> liniiSortate = new ArrayList<>();
List<String> liniiSortate1 = new ArrayList<>();
for(String s : Lista)
{
   studenti.add(new Student(s));
}
      studenti.sort(Comparator.comparing((Student s) -> s.nume));

        for (Student s : studenti) liniiSortate.add(s.toString());
      Files.write(Paths.get("studenti_out.txt"), liniiSortate);

      studenti.sort(Comparator.comparing((Student s) -> s.formatieDeStudiu).thenComparing(s -> s.nume));

      for (Student s : studenti) liniiSortate1.add(s.toString());
      Files.write(Paths.get("studenti_out_sorted.txt"), liniiSortate1);
   }

   catch (IOException e) {
      System.out.println("Eroare: Nu am putut citi fisierul! " );
   }
   /*Student s1 = new Student(589, "laur", "pantaleru", "ISM21/2");
   Student s2 = new Student(120, "Alis", "Popa", "TI21/2");
   Student s3 = new Student(112, "Maria", "Popa", "TI21/1");
   System.out.println(s1);
   List<Student> listaStudenti = new ArrayList<>();
   listaStudenti.add(s1);
   listaStudenti.add(s2);
   listaStudenti.add(s3);
   System.out.println("Lista de studenți:");
   for (Student s : listaStudenti) {
      System.out.println(s);
   }
   Student cautat1 = new Student(10, "Alis", "Popa", "TI21/2");
   System.out.println("\nEste prezent Alis Popa? " + listaStudenti.contains(cautat1));
   Student cautat2  = new Student(112, "Maria", "Popa", "TI21/1");
   System.out.println("Este prezent Maria Popa? " + listaStudenti.contains( cautat2));

   System.out.println(cautat1.hashCode());
   Set<Student> setStudenti = new HashSet<>(listaStudenti);
*/

}

