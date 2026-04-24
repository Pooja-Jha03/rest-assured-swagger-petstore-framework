package api.utilities;

import org.testng.annotations.DataProvider;   // ✅ import this

public class DataProviders {

    @DataProvider(name = "allData")   // ✅ correct annotation
    public Object[][] getAllData() throws Exception {

        String path = System.getProperty("user.dir") + "/testData/Userdata.xlsx";
        String sheetName = "Sheet1";

        int rowCount = XlUtility.getRowCount(path, sheetName);
        int colCount = XlUtility.getCellCount(path, sheetName, 1);

        Object data[][] = new Object[rowCount][colCount];

        for (int i = 1; i <= rowCount; i++) {   // skip header
            for (int j = 0; j < colCount; j++) {
                data[i - 1][j] = XlUtility.getCellData(path, sheetName, i, j);
            }
        }

        return data;
    }

    @DataProvider(name = "usernames")
    public static Object[][] usernames() throws Exception {

        String path = System.getProperty("user.dir") + "/testData/Userdata.xlsx";
        String sheetName = "Sheet1";

        int rowCount = XlUtility.getRowCount(path, sheetName);

        Object data[][] = new Object[rowCount][1];

        for (int i = 1; i <= rowCount; i++) {
            data[i - 1][0] = XlUtility.getCellData(path, sheetName, i, 1).trim()    ;
        }

        return data;

    }
}