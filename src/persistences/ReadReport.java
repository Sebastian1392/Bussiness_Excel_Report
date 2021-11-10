package persistences;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Iterator;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;


public class ReadReport {

    public static final String DATA_FILES_PATH = "src/data/Informe_Puerto_Carreño.xlsx";
    public static final String GENERAL_REPORT_PATH = "src/data/Reporte_General.xlsx";
    public static final String CAMPUS_DATA = "Datos Sede";

    public int getNumberSheets(){
        int numberPages = 0;
        try {
            FileInputStream fileInputStream = new FileInputStream(DATA_FILES_PATH);
            XSSFWorkbook excelBook = new XSSFWorkbook(fileInputStream);
            numberPages = excelBook.getNumberOfSheets();
            excelBook.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return numberPages;
    }

    public void readExcelFile(int page){
        try {
            FileInputStream fileInputStream = new FileInputStream(DATA_FILES_PATH);
            XSSFWorkbook excelBook = new XSSFWorkbook(fileInputStream);
            for (int i = 0; i < excelBook.getNumberOfSheets(); i++) {
                System.out.println(excelBook.getSheetName(i));
                switch (excelBook.getSheetName(i)) {
                    case CAMPUS_DATA:
                        
                        break;
                
                    default:
                        break;
                }
                XSSFSheet sheet = excelBook.getSheetAt(0);
                Iterator<Row> rows = sheet.iterator();
                Iterator<Cell> cells;
                Row row;
                Cell cell;
                while(rows.hasNext()){
                    row = rows.next();
                cells = row.cellIterator();
                while(cells.hasNext()){
                    cell = cells.next();
                    if(!cell.getStringCellValue().isEmpty()){
                        System.out.println(cell.getStringCellValue());
                    }
                }
            }
        }
        excelBook.close();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
