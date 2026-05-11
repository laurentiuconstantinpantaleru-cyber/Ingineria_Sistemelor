import java.util.List;

public interface StudentStorageStrategy {
    void exportStudents(List<Student> studenti, String sursa);
    List<Student> importStudents(String sursa);
}