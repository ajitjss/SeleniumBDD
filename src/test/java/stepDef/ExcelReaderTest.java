package stepDef;

import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Workbook;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Map;

public class ExcelReaderTest {

    public static void main(String[] args) throws IOException {
       ExcelReader ex = new ExcelReader("C:\\Users\\ajit\\Desktop\\Dholu\\userData.xls", 0);
        Map<String, Map<String, String>> excelData =ex.getExcelAsMap();
        System.out.println("get Total row count: "+ex.totalRowCount());
        System.out.println("Sheet Name: "+ex.getSheetName(1));
        System.out.println("Sheet Count: "+ex.getSheetCount());
        System.out.println("Total Column Count: "+ex.totolColumnCount());
          int rowNum = ex.totalRowCount();
        int columnCount = ex.totolColumnCount();
               for(int i=0; i<rowNum;i++){
            for(int j=0; j<columnCount;j++){
                System.out.println("Row "+i+ " Column "+j+" value: "+ex.getCellValue(i,j));
            }
        }

        System.out.println("Complete Sheet Data: "+ex.getExcelAsMap());
      //  Map<String, Map<String, String>> excelData =ex.getExcelAsMap();
      //  System.out.println( excelData.get("4").get("password"));
    }
    }
