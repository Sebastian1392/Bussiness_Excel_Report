package persistences;

import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.Font;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;

public class WriteReport {

    private XSSFWorkbook libro;

    public WriteReport(){
        libro = new XSSFWorkbook();
    }

    public void writeSheet(ArrayList<ArrayList<String>> data, ArrayList<String> header, String nombreHoja) {
        String hoja = nombreHoja;
        XSSFSheet hoja1 = libro.createSheet(hoja);

        for (int i = 0; i < header.size(); i++) {
            hoja1.setColumnWidth(i, 6000);
        }

        CellStyle style = libro.createCellStyle();
        Font font = libro.createFont();
        font.setBold(true);
        style.setFont(font);

        for(int i = 0; i <= data.size(); i++) {
            XSSFRow row = hoja1.createRow(i);//Crea la fila
            for(int j = 0; j < header.size(); j++) {
                if(i == 0) {
                    XSSFCell cell = row.createCell(j); //Se crean las celdas para cabecera
                    cell.setCellValue(header.get(j));
                    cell.setCellStyle(style);
                }else {
                    XSSFCell cell = row.createCell(j);
                    if(!isDigit(data.get(i-1).get(j))) {
                        cell.setCellValue(data.get(i-1).get(j));//Se añade el contenido
                    }else if (isDigit(data.get(i-1).get(j)) && !data.get(i-1).get(j).equals("")) {
                        cell.setCellValue(Double.parseDouble(data.get(i-1).get(j)));//Se añade el contenido
                    }
                }
            }
        }
    }

    public void createFile() {
        String nombreArchivo = "InformeGeneral.xlsx";

        try (OutputStream fileOut = new FileOutputStream(nombreArchivo)) {
            System.out.println("Se creo el excel");
            libro.write(fileOut);
        }catch (IOException e) {
            e.printStackTrace();
        }
    }

    private boolean isDigit(String str) {
        boolean isNumeric = true;
        for (int i = 0; i < str.length(); i++) {
            if (!Character.isDigit(str.charAt(i))) {
                isNumeric = false;
            }
        }
        return isNumeric;
    }
}
