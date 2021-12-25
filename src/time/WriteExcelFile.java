package time;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.BorderStyle;
import org.apache.poi.ss.usermodel.BuiltinFormats;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.DataFormat;
import org.apache.poi.ss.usermodel.FillPatternType;
import org.apache.poi.ss.usermodel.Font;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.util.CellReference;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class WriteExcelFile {
    public static final int BINARY_TREE_GEN         = 0;
    public static final int DFS_GEN                 = 1;
    public static final int ELLERS_GEN              = 2;
    public static final int HUNT_AND_KILL_GEN       = 3;
    public static final int KRUSKALS_GEN            = 4;
    public static final int PRIM_GEN                = 5;
    public static final int SIDE_WINDER_GEN         = 6;
    public static final int SPIRAL_BACKTRACKER_GEN  = 7;
    public static final int WILSONS_GEN             = 8;
    public static final int ZIGZAG_GEN              = 9;
    private static CellStyle cellStyleFormatNumber = null;


    public void writeHeader(Sheet sheet, int rowIndex){
        // create CellStyle
        CellStyle cellStyle = createStyleForHeader(sheet);

        // Create row
        Row row = sheet.createRow(rowIndex);

        // Create cells
        Cell cell = row.createCell(BINARY_TREE_GEN);
        cell.setCellStyle(cellStyle);
        cell.setCellValue("Binary tree");

        cell = row.createCell(DFS_GEN);
        cell.setCellStyle(cellStyle);
        cell.setCellValue("DFS");

        cell = row.createCell(ELLERS_GEN);
        cell.setCellStyle(cellStyle);
        cell.setCellValue("Ellers");

        cell = row.createCell(HUNT_AND_KILL_GEN);
        cell.setCellStyle(cellStyle);
        cell.setCellValue("Hunt and kill");

        cell = row.createCell(PRIM_GEN);
        cell.setCellStyle(cellStyle);
        cell.setCellValue("Prim");

        cell = row.createCell(SIDE_WINDER_GEN);
        cell.setCellStyle(cellStyle);
        cell.setCellValue("Side winder");

        cell = row.createCell(SPIRAL_BACKTRACKER_GEN);
        cell.setCellStyle(cellStyle);
        cell.setCellValue("Spiral backtracker");

        cell = row.createCell(WILSONS_GEN);
        cell.setCellStyle(cellStyle);
        cell.setCellValue("Winsons");

        cell = row.createCell(KRUSKALS_GEN);
        cell.setCellStyle(cellStyle);
        cell.setCellValue("Kruskals");

        cell = row.createCell(ZIGZAG_GEN);
        cell.setCellStyle(cellStyle);
        cell.setCellValue("Zigzag");
    }

    // Write footer
    private static void writeFooter(Sheet sheet, int rowIndex) {
        // Create row
        Row row = sheet.createRow(rowIndex);
        Cell cell = row.createCell(BINARY_TREE_GEN, CellType.FORMULA);
        cell.setCellFormula("AV(A2:E6)");
    }

    private static CellStyle createStyleForHeader(Sheet sheet) {
        // Create font
        Font font = sheet.getWorkbook().createFont();
        font.setFontName("Times New Roman");
        font.setBold(true);
        font.setFontHeightInPoints((short) 14); // font size
        font.setColor(IndexedColors.WHITE.getIndex()); // text color

        // Create CellStyle
        CellStyle cellStyle = sheet.getWorkbook().createCellStyle();
        cellStyle.setFont(font);
        cellStyle.setFillForegroundColor(IndexedColors.BLUE.getIndex());
        cellStyle.setFillPattern(FillPatternType.SOLID_FOREGROUND);
        cellStyle.setBorderBottom(BorderStyle.THIN);
        return cellStyle;
    }


}
