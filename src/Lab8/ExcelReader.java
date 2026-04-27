package Lab8;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Iterator;

public class ExcelReader {

    public static void main(String[] args) {
        // Numele fisierului - asigura-te ca e in radacina proiectului
        String fileName = "laborator8_input.xlsx";

        try (FileInputStream fis = new FileInputStream(new File(fileName))) {

            // Initializam workbook-ul pentru formatul .xlsx
            Workbook workbook = new XSSFWorkbook(fis);
            Sheet sheet = workbook.getSheetAt(0);

            System.out.println("--- Date extrase din Excel ---\n");

            // Iteram prin randuri
            for (Row row : sheet) {
                // Iteram prin celulele fiecarui rand
                Iterator<Cell> cellIterator = row.cellIterator();

                while (cellIterator.hasNext()) {
                    Cell cell = cellIterator.next();

                    // Folosim printf pentru aliniere la coloane de 15 caractere
                    switch (cell.getCellType()) {
                        case STRING:
                            System.out.printf("%-15s", cell.getStringCellValue());
                            break;
                        case NUMERIC:
                            if (DateUtil.isCellDateFormatted(cell)) {
                                System.out.printf("%-15s", cell.getDateCellValue().toString());
                            } else {
                                // Scoatem zecimala .0 daca numarul este intreg (ex: 7.0 devine 7)
                                double numericValue = cell.getNumericCellValue();
                                if (numericValue == (long) numericValue) {
                                    System.out.printf("%-15d", (long) numericValue);
                                } else {
                                    System.out.printf("%-15.1f", numericValue);
                                }
                            }
                            break;
                        case BOOLEAN:
                            System.out.printf("%-15b", cell.getBooleanCellValue());
                            break;
                        default:
                            System.out.printf("%-15s", "");
                    }
                }
                // Trecem la randul urmator dupa ce am terminat celulele dintr-un rand
                System.out.println();
            }

            workbook.close();

        } catch (IOException e) {
            System.err.println("Eroare: Nu s-a putut gasi sau citi fisierul " + fileName);
            System.err.println("Verifica daca fisierul este in radacina proiectului, nu in src!");
        }
    }
}