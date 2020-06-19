package stepDef;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;

import java.io.*;
import java.util.*;

public class ExcelWriterTest {

    public static void main(String[] args) throws IOException {
        Map<String, List<String>> excelData = new TreeMap<String, List<String>>();
        List<String> user1 = new LinkedList<String>();
        user1.add("FirstName");
        user1.add("LastName");
        user1.add("Employer");
        excelData.put("user", user1);
        List<String> user2 = new LinkedList<String>();
        user2.add("Amit");
        user2.add("Yadav");
        user2.add("Ericsson");
        excelData.put("user2", user2);
        List<String> user3 = new LinkedList<String>();
        user3.add("Neerav");
        user3.add("Kumar");
        user3.add("Deloitte");
        excelData.put("user3", user3);
        System.out.println("User Data" + excelData);
        // Code to Write in Excel Sheet
        String filePath = "C:\\Users\\ajit\\Desktop\\Chinees\\excelData.xls";
        ExcelWriter ex = new ExcelWriter(filePath);
        ex.writeToExcel(excelData);
        ex.commitData();
        String filePath1 = "C:\\Users\\ajit\\Desktop\\Chinees\\excelData1.xls";
       ExcelWriter excel = new ExcelWriter(filePath1);
       Sheet sheet = excel.getSheetInstance();
      excel.writeToCell(sheet, 0, 0, "Row0Column0");
      excel.writeToCell(sheet, 1, 0, "Row1Column1");
      excel.writeToCell(sheet, 2, 0, "Row0Column2");
        excel.commitData();

        String filePath2 = "C:\\Users\\ajit\\Desktop\\Chinees\\excelData2.xls";
        ExcelWriter excelListExample = new ExcelWriter(filePath2);
        List<String> testData = new ArrayList<String>();
        testData.add("ThoughtCoders");
        testData.add("Smartech");
        List<String>  rw2 = new ArrayList<String>();
        rw2.add("Column0"); rw2.add("column1"); rw2.add("column2");  rw2.add("column3");
        Sheet sheet1 = excelListExample.getSheetInstance();
        excelListExample.WriteData( sheet1, 0, testData);
        excelListExample.WriteData( sheet1, 1, testData);
        excelListExample.WriteData(sheet1, 2, rw2);
        excelListExample.commitData();
    }
}
