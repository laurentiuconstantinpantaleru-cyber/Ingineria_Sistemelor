import java.io.*;
import java.util.*;

public class StudentiInFisierText implements StudentStorageStrategy {
    @Override
    public void exportStudents(List<Student> studenti, String sursa) {
        try (PrintWriter writer = new PrintWriter(new FileWriter(sursa))) {
            for (Student s : studenti) {
                // Format: matricol,nume,prenume,formatie,nota
                writer.println(s.numarMatricol + "," + s.nume + "," + s.prenume + "," + s.formatieDeStudiu + "," + s.nota);
            }
            System.out.println("Export text finalizat în: " + sursa);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<Student> importStudents(String sursa) {
        List<Student> lista = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(sursa))) {
            String linie;
            while ((linie = reader.readLine()) != null) {
                String[] b = linie.split(",");
                lista.add(new Student(Integer.parseInt(b[0]), b[2], b[1], b[3], Double.parseDouble(b[4])));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return lista;
    }
}