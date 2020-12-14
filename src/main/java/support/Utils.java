package support;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.*;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class Utils {

    XSSFWorkbook workbook = new XSSFWorkbook();
    XSSFSheet sheet = workbook.createSheet("Stock Data");

    public void writeDataToExcel(Map<String, Object[]> getDataMap) {
        int rowNum = 0;
        for (String key : getDataMap.keySet()) {
            Row row = sheet.createRow(rowNum++);
            Object[] objArray = getDataMap.get(key);
            int cellNum = 0;
            for (Object obj : objArray) {
                Cell cell = row.createCell(cellNum++);
                if (obj instanceof String) {
                    cell.setCellValue((String) obj);
                } else if (obj instanceof Integer) {
                    cell.setCellValue((Integer) obj);
                }
            }
        }
        try {
            // this Writes the workbook gfgcontribute
            FileOutputStream out = new FileOutputStream(new File("NewFile.xlsx"));
            workbook.write(out);
            out.close();
            System.out.println("NewFile.xlsx written successfully on disk.");
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public Map<Integer, String[]> readDataFromCsv() {
        String line = "";
        Map<Integer, String[]> csvMap = new TreeMap<>();
        try {
            BufferedReader br = new BufferedReader(new FileReader
                    ("file.csv"));
            int i = 0;
            while (null != (line = br.readLine()))  {
                i++;
                String[] stockHoldings = line.split(",");
                csvMap.put(i, stockHoldings);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return csvMap;
    }

}
