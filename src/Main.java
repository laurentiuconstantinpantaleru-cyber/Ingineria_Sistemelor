import java.util.List;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashMap;

void main() {

   try
   {
       List<StudentBursier> bursieri = new ArrayList<>();

       bursieri.add(new StudentBursier(1025, "Andrei", "Popa", "ISM141/2", 8.70, 725.50));
       bursieri.add(new StudentBursier(1024, "Ioan", "Mihalcea", "ISM141/1", 9.80, 801.10));
       bursieri.add(new StudentBursier(1026, "Anamaria", "Prodan", "TI131/1", 8.90, 745.50));
       bursieri.add(new StudentBursier(1029, "Bianca", "Popescu", "TI131/1", 9.10, 780.80));

       // Salvare în fișier folosind metoda definită
       salveazaInFisier("bursieri_out.txt", bursieri);
       Map<Integer, Student> tineri = new HashMap<>();
       tineri.put(1, new Student(589, "Bianca", "Popescu", "ISM21/2", 9));
       tineri.put(2, new Student(120, "Ioan", "Popa", "TI21/2", 8));

       float nota1 = Student.gasesteNota("Bianca", "Popescu", tineri);
       float nota2 = Student.gasesteNota("Ioan", "Popa", tineri);

       System.out.println("Nota Bianca Popescu: " + nota1);
       System.out.println("Nota Ioan Popa: " + nota2);

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
      System.out.println("Eroare" );
   }


}
public static void salveazaInFisier(String numeFisier, List<? extends Student> lista) {
    List<String> linii = new ArrayList<>();
    for (Student s : lista) {
        linii.add(s.toString());
    }
    try {
        Files.write(Paths.get(numeFisier), linii);
        System.out.println("Fișierul " + numeFisier + " a fost salvat cu succes.");
    } catch (IOException e) {
        System.err.println("Eroare la scrierea în fișier: " + e.getMessage());
    }
}
