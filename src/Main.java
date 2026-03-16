import java.util.List;

void main() {

   Student s1 = new Student(589, "laur", "pantaleru", "ISM21/2");
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
   Student cautat1 = new Student(120, "Alis", "Popa", "TI21/2");
   System.out.println("\nEste prezent Alis Popa? " + estePrezent(listaStudenti, cautat1));
   Set<Student> setStudenti = new HashSet<>(listaStudenti);
}
public static boolean estePrezent(List<Student> listaStudenti, Student s) {
   // Metoda contains folosește intern metoda equals() definită în clasa Student
   return listaStudenti.contains(s);
}
