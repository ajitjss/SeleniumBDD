package stepDef;

import java.io.IOException;
import java.util.Map;

public class ExcelReaderTest2 {
    public static void main(String[] args) throws IOException {
        ExcelReader ex = new ExcelReader("C:\\Users\\ajit\\Desktop\\Dholu\\userData.xls", 0);
        Map<String, Map<String, String>> excelData =ex.getExcelAsMap();
        System.out.println("Excel Data for 2nd row and column- AccountNo : "+excelData.get("2").get("AccountNo"));
        System.out.println("excelData as Map: "+excelData);
    }
}
