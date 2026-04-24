package api.utilities;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.ss.usermodel.DataFormatter;
import java.io.FileInputStream;

public class XlUtility {

        // 🔹 Get Row Count
        public static int getRowCount(String filePath, String sheetName) {

            int rows = 0;

            try {
                FileInputStream file = new FileInputStream(filePath);
                XSSFWorkbook workbook = new XSSFWorkbook(file);
                XSSFSheet sheet = workbook.getSheet(sheetName);

                rows = sheet.getLastRowNum();

                workbook.close();
                file.close();

            } catch (Exception e) {
                e.printStackTrace();
            }

            return rows;
        }

        // 🔹 Get Cell Count
        public static int getCellCount(String filePath, String sheetName, int rowNum) {

            int cells = 0;

            try {
                FileInputStream file = new FileInputStream(filePath);
                XSSFWorkbook workbook = new XSSFWorkbook(file);
                XSSFSheet sheet = workbook.getSheet(sheetName);

                cells = sheet.getRow(rowNum).getLastCellNum();

                workbook.close();
                file.close();

            } catch (Exception e) {
                e.printStackTrace();
            }

            return cells;
        }

        // 🔹 Get Cell Data
        public static String getCellData(String filePath, String sheetName, int rowNum, int colNum) {

            String data = "";

            try {
                FileInputStream file = new FileInputStream(filePath);
                XSSFWorkbook workbook = new XSSFWorkbook(file);
                XSSFSheet sheet = workbook.getSheet(sheetName);

                XSSFRow row = sheet.getRow(rowNum);
                XSSFCell cell = row.getCell(colNum);

                DataFormatter formatter = new DataFormatter();
                data = formatter.formatCellValue(cell);

                workbook.close();
                file.close();

            } catch (Exception e) {
                e.printStackTrace();
            }

            return data;
        }
    }
