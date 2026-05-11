import java.util.*;
public class ManagerStudenti {
    private StudentStorageStrategy strategie;

    public void setStrategie(StudentStorageStrategy strategie) {
        this.strategie = strategie;
    }

    public void salveaza(List<Student> lista, String sursa) {
        strategie.exportStudents(lista, sursa);
    }

    public List<Student> incarca(String sursa) {
        return strategie.importStudents(sursa);
    }
}
