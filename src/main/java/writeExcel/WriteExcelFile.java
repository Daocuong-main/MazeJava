package writeExcel;


import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class WriteExcelFile {

    public static void writeExcelGen(int size, int col, long timeElapsed) throws IOException {
        String excelFilePath = "src/main/java/writeExcel/Time.xlsx";
        FileInputStream fileInputStream = new FileInputStream(new File(excelFilePath));
        XSSFWorkbook xssfWorkbook = new XSSFWorkbook(fileInputStream);
        XSSFSheet sheet = xssfWorkbook.getSheetAt(0);
        if (size == 16) {
            for (int i = 2; i < 2 + 10; i++) {
                Cell cell = null;
                cell = sheet.getRow(i).getCell(col);
                if (cell.getNumericCellValue() == 0) {
                    cell.setCellValue(timeElapsed);
                    break;
                }
            }
        } else if (size == 32) {
            for (int i = 14; i < 14 + 10; i++) {
                Cell cell = null;
                cell = sheet.getRow(i).getCell(col);
                if (cell.getNumericCellValue() == 0) {
                    cell.setCellValue(timeElapsed);
                    break;
                }
            }
        } else if (size == 64) {
            for (int i = 26; i < 26 + 10; i++) {
                Cell cell = null;
                cell = sheet.getRow(i).getCell(col);
                if (cell.getNumericCellValue() == 0) {
                    cell.setCellValue(timeElapsed);
                    break;
                }
            }
        } else if (size == 128) {
            for (int i = 38; i < 38 + 10; i++) {
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

    public static void writeExcelSol(int size, int col, int index, long timeElapsed) throws IOException {
        String excelFilePath = "src/main/java/writeExcel/Time.xlsx";
        FileInputStream fileInputStream = new FileInputStream(new File(excelFilePath));
        XSSFWorkbook xssfWorkbook = new XSSFWorkbook(fileInputStream);
        XSSFSheet sheet = xssfWorkbook.getSheetAt(0);
        if (size == 16) {
            if (index == 0) {
                for (int i = 3; i < 3 + 10; i++) {
                    Cell cell = null;
                    cell = sheet.getRow(i).getCell(8 + col);
                    if (cell.getNumericCellValue() == 0) {
                        cell.setCellValue(timeElapsed);
                        break;
                    }
                }
            } else if (index == 1) {
                for (int i = 3; i < 3 + 10; i++) {
                    Cell cell = null;
                    cell = sheet.getRow(i).getCell(11 + col);
                    if (cell.getNumericCellValue() == 0) {
                        cell.setCellValue(timeElapsed);
                        break;
                    }
                }
            } else if (index == 2) {
                for (int i = 3; i < 3 + 10; i++) {
                    Cell cell = null;
                    cell = sheet.getRow(i).getCell(14 + col);
                    if (cell.getNumericCellValue() == 0) {
                        cell.setCellValue(timeElapsed);
                        break;
                    }
                }
            } else if (index == 3) {
                for (int i = 3; i < 3 + 10; i++) {
                    Cell cell = null;
                    cell = sheet.getRow(i).getCell(17 + col);
                    if (cell.getNumericCellValue() == 0) {
                        cell.setCellValue(timeElapsed);
                        break;
                    }
                }
            } else if (index == 4) {
                for (int i = 3; i < 3 + 10; i++) {
                    Cell cell = null;
                    cell = sheet.getRow(i).getCell(20 + col);
                    if (cell.getNumericCellValue() == 0) {
                        cell.setCellValue(timeElapsed);
                        break;
                    }
                }
            } else {
                for (int i = 3; i < 3 + 10; i++) {
                    Cell cell = null;
                    cell = sheet.getRow(i).getCell(23 + col);
                    if (cell.getNumericCellValue() == 0) {
                        cell.setCellValue(timeElapsed);
                        break;
                    }
                }
            }
        } else if (size == 32) {
            if (index == 0) {
                for (int i = 16; i < 16 + 10; i++) {
                    Cell cell = null;
                    cell = sheet.getRow(i).getCell(8 + col);
                    if (cell.getNumericCellValue() == 0) {
                        cell.setCellValue(timeElapsed);
                        break;
                    }
                }
            } else if (index == 1) {
                for (int i = 16; i < 16 + 10; i++) {
                    Cell cell = null;
                    cell = sheet.getRow(i).getCell(11 + col);
                    if (cell.getNumericCellValue() == 0) {
                        cell.setCellValue(timeElapsed);
                        break;
                    }
                }
            } else if (index == 2) {
                for (int i = 16; i < 16 + 10; i++) {
                    Cell cell = null;
                    cell = sheet.getRow(i).getCell(14 + col);
                    if (cell.getNumericCellValue() == 0) {
                        cell.setCellValue(timeElapsed);
                        break;
                    }
                }
            } else if (index == 3) {
                for (int i = 16; i < 16 + 10; i++) {
                    Cell cell = null;
                    cell = sheet.getRow(i).getCell(17 + col);
                    if (cell.getNumericCellValue() == 0) {
                        cell.setCellValue(timeElapsed);
                        break;
                    }
                }
            } else if (index == 4) {
                for (int i = 16; i < 16 + 10; i++) {
                    Cell cell = null;
                    cell = sheet.getRow(i).getCell(20 + col);
                    if (cell.getNumericCellValue() == 0) {
                        cell.setCellValue(timeElapsed);
                        break;
                    }
                }
            } else {
                for (int i = 16; i < 16 + 10; i++) {
                    Cell cell = null;
                    cell = sheet.getRow(i).getCell(23 + col);
                    if (cell.getNumericCellValue() == 0) {
                        cell.setCellValue(timeElapsed);
                        break;
                    }
                }
            }
        } else if (size == 64) {
            if (index == 0) {
                for (int i = 29; i < 29 + 10; i++) {
                    Cell cell = null;
                    cell = sheet.getRow(i).getCell(8 + col);
                    if (cell.getNumericCellValue() == 0) {
                        cell.setCellValue(timeElapsed);
                        break;
                    }
                }
            } else if (index == 1) {
                for (int i = 29; i < 29 + 10; i++) {
                    Cell cell = null;
                    cell = sheet.getRow(i).getCell(11 + col);
                    if (cell.getNumericCellValue() == 0) {
                        cell.setCellValue(timeElapsed);
                        break;
                    }
                }
            } else if (index == 2) {
                for (int i = 29; i < 29 + 10; i++) {
                    Cell cell = null;
                    cell = sheet.getRow(i).getCell(14 + col);
                    if (cell.getNumericCellValue() == 0) {
                        cell.setCellValue(timeElapsed);
                        break;
                    }
                }
            } else if (index == 3) {
                for (int i = 29; i < 29 + 10; i++) {
                    Cell cell = null;
                    cell = sheet.getRow(i).getCell(17 + col);
                    if (cell.getNumericCellValue() == 0) {
                        cell.setCellValue(timeElapsed);
                        break;
                    }
                }
            } else if (index == 4) {
                for (int i = 29; i < 29 + 10; i++) {
                    Cell cell = null;
                    cell = sheet.getRow(i).getCell(20 + col);
                    if (cell.getNumericCellValue() == 0) {
                        cell.setCellValue(timeElapsed);
                        break;
                    }
                }
            } else {
                for (int i = 29; i < 29 + 10; i++) {
                    Cell cell = null;
                    cell = sheet.getRow(i).getCell(23 + col);
                    if (cell.getNumericCellValue() == 0) {
                        cell.setCellValue(timeElapsed);
                        break;
                    }
                }
            }
        } else if (size == 128) {
            if (index == 0) {
                for (int i = 42; i < 42 + 10; i++) {
                    Cell cell = null;
                    cell = sheet.getRow(i).getCell(8 + col);
                    if (cell.getNumericCellValue() == 0) {
                        cell.setCellValue(timeElapsed);
                        break;
                    }
                }
            } else if (index == 1) {
                for (int i = 42; i < 42 + 10; i++) {
                    Cell cell = null;
                    cell = sheet.getRow(i).getCell(11 + col);
                    if (cell.getNumericCellValue() == 0) {
                        cell.setCellValue(timeElapsed);
                        break;
                    }
                }
            } else if (index == 2) {
                for (int i = 42; i < 42 + 10; i++) {
                    Cell cell = null;
                    cell = sheet.getRow(i).getCell(14 + col);
                    if (cell.getNumericCellValue() == 0) {
                        cell.setCellValue(timeElapsed);
                        break;
                    }
                }
            } else if (index == 3) {
                for (int i = 42; i < 42 + 10; i++) {
                    Cell cell = null;
                    cell = sheet.getRow(i).getCell(17 + col);
                    if (cell.getNumericCellValue() == 0) {
                        cell.setCellValue(timeElapsed);
                        break;
                    }
                }
            } else if (index == 4) {
                for (int i = 42; i < 42 + 10; i++) {
                    Cell cell = null;
                    cell = sheet.getRow(i).getCell(20 + col);
                    if (cell.getNumericCellValue() == 0) {
                        cell.setCellValue(timeElapsed);
                        break;
                    }
                }
            } else {
                for (int i = 42; i < 42 + 10; i++) {
                    Cell cell = null;
                    cell = sheet.getRow(i).getCell(23 + col);
                    if (cell.getNumericCellValue() == 0) {
                        cell.setCellValue(timeElapsed);
                        break;
                    }
                }
            }
        }
        fileInputStream.close();
        FileOutputStream fileOutputStream = new FileOutputStream(new File(excelFilePath));
        xssfWorkbook.write(fileOutputStream);
        fileOutputStream.close();
    }

    public static void writeExcelNumberOfCellPath(int size, int index, int numberOfCell) throws IOException {
        String excelFilePath = "src/main/java/writeExcel/NumberOfCellPath.xlsx";
        FileInputStream fileInputStream = new FileInputStream(new File(excelFilePath));
        XSSFWorkbook xssfWorkbook = new XSSFWorkbook(fileInputStream);
        XSSFSheet sheet = xssfWorkbook.getSheetAt(0);
        if (size == 16) {
            if (index == 0) {
                for (int i = 2; i < 2 + 10; i++) {
                    Cell cell = null;
                    cell = sheet.getRow(i).getCell(1);
                    if (cell.getNumericCellValue() == 0) {
                        cell.setCellValue(numberOfCell);
                        break;
                    }
                }
            } else if (index == 1) {
                for (int i = 2; i < 2 + 10; i++) {
                    Cell cell = null;
                    cell = sheet.getRow(i).getCell(2);
                    if (cell.getNumericCellValue() == 0) {
                        cell.setCellValue(numberOfCell);
                        break;
                    }
                }
            } else if (index == 3) {
                for (int i = 2; i < 2 + 10; i++) {
                    Cell cell = null;
                    cell = sheet.getRow(i).getCell(3);
                    if (cell.getNumericCellValue() == 0) {
                        cell.setCellValue(numberOfCell);
                        break;
                    }
                }
            } else if (index == 4) {
                for (int i = 2; i < 2 + 10; i++) {
                    Cell cell = null;
                    cell = sheet.getRow(i).getCell(4);
                    if (cell.getNumericCellValue() == 0) {
                        cell.setCellValue(numberOfCell);
                        break;
                    }
                }
            } else {
                for (int i = 2; i < 2 + 10; i++) {
                    Cell cell = null;
                    cell = sheet.getRow(i).getCell(5);
                    if (cell.getNumericCellValue() == 0) {
                        cell.setCellValue(numberOfCell);
                        break;
                    }
                }
            }
        } else if (size == 32) {
            if (index == 0) {
                for (int i = 14; i < 14 + 10; i++) {
                    Cell cell = null;
                    cell = sheet.getRow(i).getCell(1);
                    if (cell.getNumericCellValue() == 0) {
                        cell.setCellValue(numberOfCell);
                        break;
                    }
                }
            } else if (index == 1) {
                for (int i = 14; i < 14 + 10; i++) {
                    Cell cell = null;
                    cell = sheet.getRow(i).getCell(2);
                    if (cell.getNumericCellValue() == 0) {
                        cell.setCellValue(numberOfCell);
                        break;
                    }
                }
            } else if (index == 3) {
                for (int i = 14; i < 14 + 10; i++) {
                    Cell cell = null;
                    cell = sheet.getRow(i).getCell(3);
                    if (cell.getNumericCellValue() == 0) {
                        cell.setCellValue(numberOfCell);
                        break;
                    }
                }
            } else if (index == 4) {
                for (int i = 14; i < 14 + 10; i++) {
                    Cell cell = null;
                    cell = sheet.getRow(i).getCell(4);
                    if (cell.getNumericCellValue() == 0) {
                        cell.setCellValue(numberOfCell);
                        break;
                    }
                }
            } else {
                for (int i = 14; i < 14 + 10; i++) {
                    Cell cell = null;
                    cell = sheet.getRow(i).getCell(5);
                    if (cell.getNumericCellValue() == 0) {
                        cell.setCellValue(numberOfCell);
                        break;
                    }
                }
            }
        } else if (size == 64) {
            if (index == 0) {
                for (int i = 26; i < 26 + 10; i++) {
                    Cell cell = null;
                    cell = sheet.getRow(i).getCell(1);
                    if (cell.getNumericCellValue() == 0) {
                        cell.setCellValue(numberOfCell);
                        break;
                    }
                }
            } else if (index == 1) {
                for (int i = 26; i < 26 + 10; i++) {
                    Cell cell = null;
                    cell = sheet.getRow(i).getCell(2);
                    if (cell.getNumericCellValue() == 0) {
                        cell.setCellValue(numberOfCell);
                        break;
                    }
                }
            } else if (index == 3) {
                for (int i = 26; i < 26 + 10; i++) {
                    Cell cell = null;
                    cell = sheet.getRow(i).getCell(3);
                    if (cell.getNumericCellValue() == 0) {
                        cell.setCellValue(numberOfCell);
                        break;
                    }
                }
            } else if (index == 4) {
                for (int i = 26; i < 26 + 10; i++) {
                    Cell cell = null;
                    cell = sheet.getRow(i).getCell(4);
                    if (cell.getNumericCellValue() == 0) {
                        cell.setCellValue(numberOfCell);
                        break;
                    }
                }
            } else {
                for (int i = 26; i < 26 + 10; i++) {
                    Cell cell = null;
                    cell = sheet.getRow(i).getCell(5);
                    if (cell.getNumericCellValue() == 0) {
                        cell.setCellValue(numberOfCell);
                        break;
                    }
                }
            }
        } else if (size == 128) {
            if (index == 0) {
                for (int i = 38; i < 38 + 10; i++) {
                    Cell cell = null;
                    cell = sheet.getRow(i).getCell(1);
                    if (cell.getNumericCellValue() == 0) {
                        cell.setCellValue(numberOfCell);
                        break;
                    }
                }
            } else if (index == 1) {
                for (int i = 38; i < 38 + 10; i++) {
                    Cell cell = null;
                    cell = sheet.getRow(i).getCell(2);
                    if (cell.getNumericCellValue() == 0) {
                        cell.setCellValue(numberOfCell);
                        break;
                    }
                }
            } else if (index == 3) {
                for (int i = 38; i < 38 + 10; i++) {
                    Cell cell = null;
                    cell = sheet.getRow(i).getCell(3);
                    if (cell.getNumericCellValue() == 0) {
                        cell.setCellValue(numberOfCell);
                        break;
                    }
                }
            } else if (index == 4) {
                for (int i = 38; i < 38 + 10; i++) {
                    Cell cell = null;
                    cell = sheet.getRow(i).getCell(4);
                    if (cell.getNumericCellValue() == 0) {
                        cell.setCellValue(numberOfCell);
                        break;
                    }
                }
            } else {
                for (int i = 38; i < 38 + 10; i++) {
                    Cell cell = null;
                    cell = sheet.getRow(i).getCell(5);
                    if (cell.getNumericCellValue() == 0) {
                        cell.setCellValue(numberOfCell);
                        break;
                    }
                }
            }
        }
        fileInputStream.close();
        FileOutputStream fileOutputStream = new FileOutputStream(new File(excelFilePath));
        xssfWorkbook.write(fileOutputStream);
        fileOutputStream.close();
    }

    public static void writeExcelNumberOfCellVisited(int size, int index, int numberOfCell) throws IOException {
        String excelFilePath = "src/main/java/writeExcel/NumberOfCellVisited.xlsx";
        FileInputStream fileInputStream = new FileInputStream(new File(excelFilePath));
        XSSFWorkbook xssfWorkbook = new XSSFWorkbook(fileInputStream);
        XSSFSheet sheet = xssfWorkbook.getSheetAt(0);
        if (size == 16) {
            if (index == 0) {
                for (int i = 2; i < 2 + 10; i++) {
                    Cell cell = null;
                    cell = sheet.getRow(i).getCell(1);
                    if (cell.getNumericCellValue() == 0) {
                        cell.setCellValue(numberOfCell);
                        break;
                    }
                }
            } else if (index == 1) {
                for (int i = 2; i < 2 + 10; i++) {
                    Cell cell = null;
                    cell = sheet.getRow(i).getCell(2);
                    if (cell.getNumericCellValue() == 0) {
                        cell.setCellValue(numberOfCell);
                        break;
                    }
                }
            } else if (index == 3) {
                for (int i = 2; i < 2 + 10; i++) {
                    Cell cell = null;
                    cell = sheet.getRow(i).getCell(3);
                    if (cell.getNumericCellValue() == 0) {
                        cell.setCellValue(numberOfCell);
                        break;
                    }
                }
            } else if (index == 4) {
                for (int i = 2; i < 2 + 10; i++) {
                    Cell cell = null;
                    cell = sheet.getRow(i).getCell(4);
                    if (cell.getNumericCellValue() == 0) {
                        cell.setCellValue(numberOfCell);
                        break;
                    }
                }
            } else {
                for (int i = 2; i < 2 + 10; i++) {
                    Cell cell = null;
                    cell = sheet.getRow(i).getCell(5);
                    if (cell.getNumericCellValue() == 0) {
                        cell.setCellValue(numberOfCell);
                        break;
                    }
                }
            }
        } else if (size == 32) {
            if (index == 0) {
                for (int i = 14; i < 14 + 10; i++) {
                    Cell cell = null;
                    cell = sheet.getRow(i).getCell(1);
                    if (cell.getNumericCellValue() == 0) {
                        cell.setCellValue(numberOfCell);
                        break;
                    }
                }
            } else if (index == 1) {
                for (int i = 14; i < 14 + 10; i++) {
                    Cell cell = null;
                    cell = sheet.getRow(i).getCell(2);
                    if (cell.getNumericCellValue() == 0) {
                        cell.setCellValue(numberOfCell);
                        break;
                    }
                }
            } else if (index == 3) {
                for (int i = 14; i < 14 + 10; i++) {
                    Cell cell = null;
                    cell = sheet.getRow(i).getCell(3);
                    if (cell.getNumericCellValue() == 0) {
                        cell.setCellValue(numberOfCell);
                        break;
                    }
                }
            } else if (index == 4) {
                for (int i = 14; i < 14 + 10; i++) {
                    Cell cell = null;
                    cell = sheet.getRow(i).getCell(4);
                    if (cell.getNumericCellValue() == 0) {
                        cell.setCellValue(numberOfCell);
                        break;
                    }
                }
            } else {
                for (int i = 14; i < 14 + 10; i++) {
                    Cell cell = null;
                    cell = sheet.getRow(i).getCell(5);
                    if (cell.getNumericCellValue() == 0) {
                        cell.setCellValue(numberOfCell);
                        break;
                    }
                }
            }
        } else if (size == 64) {
            if (index == 0) {
                for (int i = 26; i < 26 + 10; i++) {
                    Cell cell = null;
                    cell = sheet.getRow(i).getCell(1);
                    if (cell.getNumericCellValue() == 0) {
                        cell.setCellValue(numberOfCell);
                        break;
                    }
                }
            } else if (index == 1) {
                for (int i = 26; i < 26 + 10; i++) {
                    Cell cell = null;
                    cell = sheet.getRow(i).getCell(2);
                    if (cell.getNumericCellValue() == 0) {
                        cell.setCellValue(numberOfCell);
                        break;
                    }
                }
            } else if (index == 3) {
                for (int i = 26; i < 26 + 10; i++) {
                    Cell cell = null;
                    cell = sheet.getRow(i).getCell(3);
                    if (cell.getNumericCellValue() == 0) {
                        cell.setCellValue(numberOfCell);
                        break;
                    }
                }
            } else if (index == 4) {
                for (int i = 26; i < 26 + 10; i++) {
                    Cell cell = null;
                    cell = sheet.getRow(i).getCell(4);
                    if (cell.getNumericCellValue() == 0) {
                        cell.setCellValue(numberOfCell);
                        break;
                    }
                }
            } else {
                for (int i = 26; i < 26 + 10; i++) {
                    Cell cell = null;
                    cell = sheet.getRow(i).getCell(5);
                    if (cell.getNumericCellValue() == 0) {
                        cell.setCellValue(numberOfCell);
                        break;
                    }
                }
            }
        } else if (size == 128) {
            if (index == 0) {
                for (int i = 38; i < 38 + 10; i++) {
                    Cell cell = null;
                    cell = sheet.getRow(i).getCell(1);
                    if (cell.getNumericCellValue() == 0) {
                        cell.setCellValue(numberOfCell);
                        break;
                    }
                }
            } else if (index == 1) {
                for (int i = 38; i < 38 + 10; i++) {
                    Cell cell = null;
                    cell = sheet.getRow(i).getCell(2);
                    if (cell.getNumericCellValue() == 0) {
                        cell.setCellValue(numberOfCell);
                        break;
                    }
                }
            } else if (index == 3) {
                for (int i = 38; i < 38 + 10; i++) {
                    Cell cell = null;
                    cell = sheet.getRow(i).getCell(3);
                    if (cell.getNumericCellValue() == 0) {
                        cell.setCellValue(numberOfCell);
                        break;
                    }
                }
            } else if (index == 4) {
                for (int i = 38; i < 38 + 10; i++) {
                    Cell cell = null;
                    cell = sheet.getRow(i).getCell(4);
                    if (cell.getNumericCellValue() == 0) {
                        cell.setCellValue(numberOfCell);
                        break;
                    }
                }
            } else {
                for (int i = 38; i < 38 + 10; i++) {
                    Cell cell = null;
                    cell = sheet.getRow(i).getCell(5);
                    if (cell.getNumericCellValue() == 0) {
                        cell.setCellValue(numberOfCell);
                        break;
                    }
                }
            }
        }
        fileInputStream.close();
        FileOutputStream fileOutputStream = new FileOutputStream(new File(excelFilePath));
        xssfWorkbook.write(fileOutputStream);
        fileOutputStream.close();
    }
}
