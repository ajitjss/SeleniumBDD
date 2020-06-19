package stepDef;

import org.apache.commons.io.FileUtils;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import java.io.*;
import java.util.*;

public class ExcelWriter {
    private String filePath;
    private Workbook wb;
    private Sheet sheet;
      public ExcelWriter(String filePath) throws IOException {
        this.filePath=filePath;
      File  file = new File(filePath);
        if (file.createNewFile()){
            System.out.println("File is created!");
        }else{
            System.out.println("File already exists.");
        }
    }

    public Sheet getSheetInstance(){
            wb = new HSSFWorkbook();
            sheet = wb.createSheet();
            return sheet;
    }



    public void  commitData() throws IOException {
           try{
            FileOutputStream fos =new FileOutputStream(filePath);
            wb.write(fos);
            wb.close();
            fos.close();
            fos.flush();
               System.out.println("Data successfully Committed in sheet!");
        } catch(IOException e){
            e.printStackTrace();
        }
    }

    public  void writeToExcel(Map<String, List<String>> excelData) {
        Sheet sheet = getSheetInstance();
        Set<String> keys = excelData.keySet();
        Iterator itr = keys.iterator();
        int i = 0;
        while (itr.hasNext()) {
            String tempKey = (String) itr.next();
            List<String> temList = excelData.get(tempKey);
            Row row = sheet.createRow(i);
            int j = 0;
            Iterator<String> rowData = temList.iterator();
            while (rowData.hasNext()) {
                Cell cell = row.createCell(j);
                cell.setCellValue(rowData.next());
                j++;
            }
            i++;
        }
    }

    public  void writeToCell(Sheet sheet,  int rowNum, int columnNum, String textToWrite) throws IOException {
        sheet = wb.getSheetAt(0);
        Row row = sheet.createRow(rowNum);
        Cell cell = row.createCell(columnNum);
        cell.setCellValue(textToWrite);
         }

    public  void WriteData( Sheet sheet, int rowNum, List<String> data) throws FileNotFoundException {
        Row row = sheet.createRow(rowNum);
        Iterator itr = data.iterator();
        int i = 0;
        while (itr.hasNext()) {
            String tempData = itr.next().toString();
            Cell cell = row.createCell(i);
            cell.setCellValue(tempData);
            i++;
        }
          }
}
