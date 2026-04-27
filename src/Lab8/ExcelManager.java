package Lab8;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class ExcelManager {

    public static void main(String[] args) {
        String inputFileName = "laborator8_input.xlsx";

        // Ex 8.5.2
        genereazaMediaValoare(inputFileName, "laborator8_output2.xlsx");

        // Ex 8.5.3
        genereazaMediaFormula(inputFileName, "laborator8_output3.xlsx");
    }

    // Metoda 8.5.3: Generare cu FORMULA Excel
    public static void genereazaMediaFormula(String inputPath, String outputPath) {
        try (FileInputStream fis = new FileInputStream(new File(inputPath));
             Workbook workbookIn = new XSSFWorkbook(fis);
             Workbook workbookOut = new XSSFWorkbook()) {

            Sheet sheetIn = workbookIn.getSheetAt(0);
            Sheet sheetOut = workbookOut.createSheet("Media cu Formula");

            int rowIdx = 0;
            for (Row rowIn : sheetIn) {
                Row rowOut = sheetOut.createRow(rowIdx++);
                int lastCol = rowIn.getLastCellNum();

                // Copiem datele existente
                for (int i = 0; i < lastCol; i++) {
                    Cell cellIn = rowIn.getCell(i);
                    Cell cellOut = rowOut.createCell(i);
                    if (cellIn != null) {
                        copyCellValue(cellIn, cellOut);
                    }
                }

                // Adaugam coloana cu formula
                if (rowIn.getRowNum() == 0) {
                    rowOut.createCell(lastCol).setCellValue("Media (Formula)");
                } else {
                    // Excel incepe numaratoarea randurilor de la 1 in formule (Row 0 in Java este 1 in Excel)
                    int excelRowNum = rowIn.getRowNum() + 1;

                    // Construim formula: AVERAGE(D<row>:F<row>)
                    // Presupunem ca D, E, F sunt coloanele 3, 4, 5 (index 0)
                    String formula = String.format("AVERAGE(D%d:F%d)", excelRowNum, excelRowNum);

                    Cell formulaCell = rowOut.createCell(lastCol);
                    formulaCell.setCellFormula(formula);
                }
            }

            try (FileOutputStream fos = new FileOutputStream(outputPath)) {
                workbookOut.write(fos);
                System.out.println("Succes! Fisierul cu FORMULE a fost generat: " + outputPath);
            }

        } catch (IOException e) {
            System.err.println("Eroare la generare output3: " + e.getMessage());
        }
    }

    // Metoda 8.5.2 (Versiunea scurta pentru referinta)
    public static void genereazaMediaValoare(String inputPath, String outputPath) {
        try (FileInputStream fis = new FileInputStream(new File(inputPath));
             Workbook workbookIn = new XSSFWorkbook(fis);
             Workbook workbookOut = new XSSFWorkbook()) {

            Sheet sheetIn = workbookIn.getSheetAt(0);
            Sheet sheetOut = workbookOut.createSheet("Media Calculata");

            for (int i = 0; i <= sheetIn.getLastRowNum(); i++) {
                Row rowIn = sheetIn.getRow(i);
                Row rowOut = sheetOut.createRow(i);
                if (rowIn == null) continue;

                int lastCol = rowIn.getLastCellNum();
                for (int j = 0; j < lastCol; j++) {
                    Cell cIn = rowIn.getCell(j);
                    if (cIn != null) copyCellValue(cIn, rowOut.createCell(j));
                }

                if (i == 0) rowOut.createCell(lastCol).setCellValue("Media (Valoare)");
                else {
                    double s = 0;
                    for (int k = lastCol - 3; k < lastCol; k++) s += rowIn.getCell(k).getNumericCellValue();
                    rowOut.createCell(lastCol).setCellValue(s / 3);
                }
            }
            try (FileOutputStream fos = new FileOutputStream(outputPath)) { workbookOut.write(fos); }
        } catch (Exception e) { e.printStackTrace(); }
    }

    private static void copyCellValue(Cell source, Cell target) {
        switch (source.getCellType()) {
            case STRING: target.setCellValue(source.getStringCellValue()); break;
            case NUMERIC: target.setCellValue(source.getNumericCellValue()); break;
            case BOOLEAN: target.setCellValue(source.getBooleanCellValue()); break;
            default: break;
        }
    }
}