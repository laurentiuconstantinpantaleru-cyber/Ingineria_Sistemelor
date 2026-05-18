import java.util.Arrays;
import java.util.List;

public class AplicatieCuStrategy {
    public static void main(String[] args) {

        List<Student> studenti = Arrays.asList(
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

        ManagerStudenti manager = new ManagerStudenti();


        System.out.println("--- Executare Strategie: Consolă ---");
        manager.setStrategie(new StudentiInConsola());
        manager.salveaza(studenti, null);


        System.out.println("\n--- Executare Strategie: Export TXT ---");
        manager.setStrategie(new StudentiInFisierText());
        manager.salveaza(studenti, "studenti_export.txt");


        System.out.println("\n--- Executare Strategie: Export Excel ---");
        manager.setStrategie(new StudentiInFisierExcel());
        manager.salveaza(studenti, "studenti_export.xls");


        System.out.println("\n--- Executare Strategie: Import TXT ---");
        manager.setStrategie(new StudentiInFisierText());
        List<Student> listaTxt = manager.incarca("studenti_export.txt");
        listaTxt.forEach(System.out::println);


        System.out.println("\n--- Executare Strategie: Import Excel ---");
        manager.setStrategie(new StudentiInFisierExcel());
        List<Student> listaExcel = manager.incarca("studenti_export.xls");
        listaExcel.forEach(System.out::println);
    }
}