import java.io.*;
import java.util.*;

public class StudentiInConsola implements StudentStorageStrategy {
    @Override
    public void exportStudents(List<Student> studenti, String sursa) {
        System.out.println("--- Lista Studenți (Consolă) ---");
        studenti.forEach(System.out::println);
    }

    @Override
    public List<Student> importStudents(String sursa) {
        System.out.println("Importul din consolă nu este implementat.");
        return new ArrayList<>();
    }
}
