import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.*;
import java.io.*;
import java.util.*;

public class StudentiInFisierExcel implements StudentStorageStrategy {
    @Override
    public void exportStudents(List<Student> studenti, String sursa) {
        try (Workbook workbook = new HSSFWorkbook()) {
            Sheet sheet = workbook.createSheet("Studenti");
            int rowIdx = 0;
            for (Student s : studenti) {
                Row row = sheet.createRow(rowIdx++);
                row.createCell(0).setCellValue(s.numarMatricol);
                row.createCell(1).setCellValue(s.nume);
                row.createCell(2).setCellValue(s.prenume);
                row.createCell(3).setCellValue(s.formatieDeStudiu);
                row.createCell(4).setCellValue(s.nota);
            }
            try (FileOutputStream fos = new FileOutputStream(sursa)) {
                workbook.write(fos);
            }
            System.out.println("Export Excel finalizat în: " + sursa);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<Student> importStudents(String sursa) {
        return Student.importFromExcel(sursa); // Apelăm metoda existentă în clasa Student
    }
}
