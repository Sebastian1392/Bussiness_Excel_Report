package persistences;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ReadReport {

	public static ArrayList<ArrayList<String>> readfiles(String pathFile, int indexSheet) {
		File file = new File(pathFile);
        if(indexSheet != 0){
            return readExcelProducts(file,indexSheet);
        }else{
            return readPrincipalSheet(file);
        }
	}

	public static ArrayList<ArrayList<String>> readExcelProducts(File file,int indexSheet) {
		ArrayList<ArrayList<String>> rowsStr = new ArrayList<ArrayList<String>>();
		try {
			FileInputStream stre = new FileInputStream(file);
			XSSFWorkbook book = new XSSFWorkbook(stre);
			XSSFSheet sheet = book.getSheetAt(indexSheet);
			Iterator<Row> rows=sheet.rowIterator();
			boolean first = true;
			while(rows.hasNext()) {
				if(!first){
					ArrayList<String> rowString = new ArrayList<String>();
                    rowString.add(book.getSheetName(indexSheet));
					XSSFRow row = (XSSFRow)rows.next();
					Iterator<Cell> cells = row.cellIterator();
                    boolean firstCell = true;
					while(cells.hasNext()) {
                        XSSFCell cell = (XSSFCell)cells.next();
                        if(firstCell){
                            firstCell = false;
                            if(cell.getStringCellValue().isEmpty()){
                                book.close();
                                return rowsStr;
                            }
                        }
                        rowString.add(cell.toString());
                    }
				    rowsStr.add(rowString);
				}else{
                    rows.next();
                    first = false;
                }
			}
            book.close();
		} catch (IOException e){
			e.printStackTrace();
		}
		return rowsStr; 
	}

	public static ArrayList<ArrayList<String>> readPrincipalSheet(File file){
		ArrayList<String> datasResume = new ArrayList<String>();
        ArrayList<ArrayList<String>> content = new ArrayList<ArrayList<String>>();
		try {
			FileInputStream stre = new FileInputStream(file);
			XSSFWorkbook book = new XSSFWorkbook(stre);
			XSSFSheet sheet = book.getSheetAt(0);
			Iterator<Row> rows = sheet.rowIterator();
			while(rows.hasNext()) {
                XSSFRow row = (XSSFRow)rows.next();
                Iterator<Cell> cells = row.cellIterator();
                while(cells.hasNext()){
                    cells.next();
                    XSSFCell cell = (XSSFCell)cells.next();
                    String value = cell.getStringCellValue();
                    if(!value.isEmpty()){
                        datasResume.add(value);
                    }
				}
			}
            content.add(datasResume);
            book.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return content;
	}

    public static void main(String[] args) {
        ArrayList<ArrayList<String>> list = readfiles("src/data/Vichada/Informe_Puerto_Carreño.xlsx",0);
        for (ArrayList<String> arrayList : list) {
            for (String string : arrayList) {
                System.out.println(string);
            }
        }
    }
}