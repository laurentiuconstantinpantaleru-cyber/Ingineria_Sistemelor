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
   Student cautat1 = new Student(10_, "Alis", "Popa", "TI21/2");
   System.out.println("\nEste prezent Alis Popa? " + listaStudenti.contains(cautat1));
   Student cautat2  = new Student(112, "Maria", "Popa", "TI21/1");
   System.out.println("Este prezent Maria Popa? " + listaStudenti.contains( cautat2));

   System.out.println(cautat1.hashCode());
   Set<Student> setStudenti = new HashSet<>(listaStudenti);
}

