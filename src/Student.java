import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.*;
import java.io.*;
import java.util.*;

public final class Student {
    private final int numarMatricol;
    private final String prenume;
    private final String nume;
    private final String formatieDeStudiu;
    private final int nota;

    public Student(int numarMatricol, String prenume, String nume, String formatieDeStudiu, int nota) {
        this.numarMatricol = numarMatricol;
        this.prenume = prenume;
        this.nume = nume;
        this.formatieDeStudiu = formatieDeStudiu;
        this.nota = nota;
    }

    public Student(String linieDinFisier) {
        String[] bucati = linieDinFisier.split(",");
        this.numarMatricol = Integer.parseInt(bucati[0].trim());
        this.nume = bucati[1].trim();
        this.prenume = bucati[2].trim();
        this.formatieDeStudiu = bucati[3].trim();
        this.nota = 0;
    }

    // 8.5.4 a) Metoda pentru EXPORT (scrie lista in .xls)
    public static void exportToExcel(List<Student> studenti, String fileName) {
        try (Workbook workbook = new HSSFWorkbook()) { // HSSFWorkbook pentru format .xls
            Sheet sheet = workbook.createSheet("Studenti");

            // Header rând
            Row headerRow = sheet.createRow(0);
            String[] coloane = {"Nr Matricol", "Nume", "Prenume", "Formatie", "Nota"};
            for (int i = 0; i < coloane.length; i++) {
                headerRow.createCell(i).setCellValue(coloane[i]);
            }

            // Adaugare date studenti
            int rowIdx = 1;
            for (Student s : studenti) {
                Row row = sheet.createRow(rowIdx++);
                row.createCell(0).setCellValue(s.numarMatricol);
                row.createCell(1).setCellValue(s.nume);
                row.createCell(2).setCellValue(s.prenume);
                row.createCell(3).setCellValue(s.formatieDeStudiu);
                row.createCell(4).setCellValue(s.nota);
            }

            try (FileOutputStream fileOut = new FileOutputStream(fileName)) {
                workbook.write(fileOut);
                System.out.println("Fisierul " + fileName + " a fost exportat cu succes.");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // 8.5.4 b) Metoda pentru IMPORT (citeste din .xls si returneaza o lista)
    public static List<Student> importFromExcel(String fileName) {
        List<Student> listaImportata = new ArrayList<>();
        try (FileInputStream fis = new FileInputStream(new File(fileName));
             Workbook workbook = new HSSFWorkbook(fis)) {

            Sheet sheet = workbook.getSheetAt(0);
            Iterator<Row> rowIterator = sheet.iterator();

            // Sarim peste header
            if (rowIterator.hasNext()) rowIterator.next();

            while (rowIterator.hasNext()) {
                Row row = rowIterator.next();

                // Excel stocheaza numerele ca double, facem cast la int
                int matricol = (int) row.getCell(0).getNumericCellValue();
                String numeStr = row.getCell(1).getStringCellValue();
                String prenumeStr = row.getCell(2).getStringCellValue();
                String formatieStr = row.getCell(3).getStringCellValue();
                int notaVal = (int) row.getCell(4).getNumericCellValue();

                listaImportata.add(new Student(matricol, prenumeStr, numeStr, formatieStr, notaVal));
            }
        } catch (IOException e) {
            System.err.println("Eroare la import: " + e.getMessage());
        }
        return listaImportata;
    }

    // Metodele existente ...
    public Student mutaInFormatie(String nouaFormatie) {
        return new Student(this.numarMatricol, this.prenume, this.nume, nouaFormatie, this.nota);
    }

    public int getNota() { return this.nota; }
    public String getNume() { return this.nume; }
    public String getFormatieDeStudiu() { return this.formatieDeStudiu; }
    public String getPrenume() { return this.prenume; }
    public int getNumarMatricol() { return this.numarMatricol; }

    @Override
    public String toString() {
        return "Student{" + "matr=" + numarMatricol + ", nume='" + nume + '\'' + ", prenume='" + prenume + '\'' + ", grupa='" + formatieDeStudiu + '\'' + ", nota=" + nota + '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Student student = (Student) o;
        return numarMatricol == student.numarMatricol && Objects.equals(nume, student.nume) && Objects.equals(prenume, student.prenume) && Objects.equals(formatieDeStudiu, student.formatieDeStudiu);
    }

    @Override
    public int hashCode() {
        return Objects.hash(numarMatricol, nume, prenume, formatieDeStudiu);
    }
}