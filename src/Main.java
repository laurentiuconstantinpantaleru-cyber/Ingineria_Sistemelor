import java.util.List;
import java.util.ArrayList;
void main() {

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
}
