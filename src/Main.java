import java.util.List;
import java.util.ArrayList;
void main() {

    List<Student> studentiCuNote = Arrays.asList(
            new Student(1025, "Andrei", "Popa", "ISM141/2", 8.70),
            new Student(1024, "Ioan", "Mihalcea", "ISM141/1", 10.0),
            new Student(1026, "Anamaria", "Prodan", "TI131/1", 8.90),
            new Student(1029, "Bianca", "Popescu", "TI131/1", 10.0),
            new Student(1029, "Maria", "Pana", "TI131/2", 4.10),
            new Student(1029, "Gabriela", "Mohanu", "TI131/2", 7.33),
            new Student(1029, "Marius", "Nasta", "TI131/2", 3.20),
            new Student(1029, "Marius", "Nasta", "TI131/1", 5.12),
            new Student(1029, "Andrei", "Dobrescu", "TI131/2", 2.22)
    );

    System.out.println("=== a) Studenții cu nota 10 ===");
    studentiCuNote.stream()
            .filter(s -> s.nota == 10.0)
            .forEach(System.out::println);

    System.out.println("\n=== b) Studenții cu nota sub 5 ===");
    studentiCuNote.stream()
            .filter(s -> s.nota < 5.0)
            .forEach(System.out::println);

    System.out.println("\n=== c) Studenții cu nota < 4 devin studenți cu nota 4 ===");
    List<Student> studentiModificati = studentiCuNote.stream()
            .map(s -> {
                if (s.nota < 4.0) {
                    // Returnăm o nouă instanță pentru a nu modifica obiectul original din prima listă
                    return new Student(s.numarMatricol, s.prenume, s.nume, s.formatieDeStudiu, 4.0);
                }
                return s;
            })
            .collect(Collectors.toList());
    studentiModificati.forEach(System.out::println);

    System.out.println("\n=== d) Suma notelor (reduce) ===");
    // Extragem notele (map) și le adunăm (reduce)
    double sumaNotelor = studentiCuNote.stream()
            .map(s -> s.nota)
            .reduce(0.0, (a, b) -> a + b); // Echivalent cu: Double::sum

    System.out.println("Suma totală a notelor: " + sumaNotelor);

    System.out.println("\n=== e) Media notelor ===");
    // Media = suma totală împărțită la numărul de elemente
    if (!studentiCuNote.isEmpty()) {
        double media = sumaNotelor / studentiCuNote.size();
        System.out.printf("Media generală este: %.2f\n", media);
    } else {
        System.out.println("Lista este goală, nu se poate calcula media.");
    }

    List<Student> listaInitiala = new ArrayList<>();
    listaInitiala.add(new Student(1, "Bianca", "Popescu", "Initiala", 9));
    listaInitiala.add(new Student(2, "Ioan", "Popa", "Initiala", 8));
    listaInitiala.add(new Student(3, "Andrei", "Muresan", "Initiala", 10));
    listaInitiala.add(new Student(4, "Elena", "Dinu", "Initiala", 7));
    listaInitiala.add(new Student(5, "Matei", "Radu", "Initiala", 9));
    int mijloc = (listaInitiala.size() + 1) / 2;
    List<Student> listaNoua = new ArrayList<>();

    for (int i = 0; i < listaInitiala.size(); i++) {
        Student s = listaInitiala.get(i);
        if (i < mijloc) {
            // Primii studenti merg in Grupa 1
            listaNoua.add(s.mutaInFormatie("Grupa_1"));
        } else {
            // Restul merg in Grupa 2
            listaNoua.add(s.mutaInFormatie("Grupa_2"));
        }
    }
    System.out.println("--- Noua lista de studenti (Imutabili) ---");
    listaNoua.forEach(System.out::println);

    //  Creare lista de studenti
    List<Student> studenti = new ArrayList<>();
    studenti.add(new Student(101, "Ion", "Popescu", "311AC", 9));
    studenti.add(new Student(102, "Maria", "Ionescu", "311AC", 10));

    // EXPORT
    Student.exportToExcel(studenti, "laborator8_students.xls");

  // IMPORT
    List<Student> listaCitita = Student.importFromExcel("laborator8_students.xls");

    System.out.println("Studenti cititi din fisier:");
    listaCitita.forEach(System.out::println);
}
