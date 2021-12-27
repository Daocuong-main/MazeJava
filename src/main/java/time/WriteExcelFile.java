package time;


import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class WriteExcelFile {

    private static final String excelFilePath = "F:\\JavaProject\\MazeJava\\src\\main\\java\\time\\Time.xlsx";

    public static void writeExcel(int size, int col, long timeElapsed) throws IOException {
        FileInputStream fileInputStream = new FileInputStream(new File(excelFilePath));
        XSSFWorkbook xssfWorkbook = new XSSFWorkbook(fileInputStream);
        XSSFSheet sheet = xssfWorkbook.getSheetAt(0);
        if (size == 16) {
            for (int i = 2; i < 2+10; i++) {
                Cell cell = null;
                cell = sheet.getRow(i).getCell(col);
                if (cell.getNumericCellValue() == 0) {
                    cell.setCellValue(timeElapsed);
                    break;
                }
            }
        }
        else if (size == 32) {
            for (int i = 14; i < 14+10; i++) {
                Cell cell = null;
                cell = sheet.getRow(i).getCell(col);
                if (cell.getNumericCellValue() == 0) {
                    cell.setCellValue(timeElapsed);
                    break;
                }
            }
        }
        else if (size == 64) {
            for (int i = 26; i < 26+10; i++) {
                Cell cell = null;
                cell = sheet.getRow(i).getCell(col);
                if (cell.getNumericCellValue() == 0) {
                    cell.setCellValue(timeElapsed);
                    break;
                }
            }
        }
        else if (size == 128) {
            for (int i = 38; i < 38+10; i++) {
                Cell cell = null;
                cell = sheet.getRow(i).getCell(col);
                if (cell.getNumericCellValue() == 0) {
                    cell.setCellValue(timeElapsed);
                    break;
                }
            }
        }
        fileInputStream.close();
        FileOutputStream fileOutputStream = new FileOutputStream(new File(excelFilePath));
        xssfWorkbook.write(fileOutputStream);
        fileOutputStream.close();
    }


}
