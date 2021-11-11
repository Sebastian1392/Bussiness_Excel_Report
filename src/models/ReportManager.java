package models;

import java.io.File;
import java.util.ArrayList;

import persistences.ReadReport;

public class ReportManager {

    public static final String REGULAR_EXPRESION_EXTENTION = "^.*\\.(.*)$";
    public static final String PATH_DATA = "src/data/";
    public static final String EXCEL_EXTENTION = "xlsx";
    
    public ReportManager(){
        readFile();
    }

    public void getData(String pathFile){
        int numberSheets = 5;
        ArrayList<ArrayList<String>> regionData = new ArrayList<>();
        ArrayList<ArrayList<String>> productsData = new ArrayList<>();
        for (int i = 0; i < numberSheets; i++) {
            if(i != 0){
                productsData = addToProductList(productsData, ReadReport.readfiles(pathFile, i));
            }else{
                regionData = ReadReport.readfiles(pathFile, i);
            }
        }
        mixData(productsData,regionData);
    }

    public ArrayList<ArrayList<String>> addToProductList(ArrayList<ArrayList<String>> generalProducts, 
            ArrayList<ArrayList<String>> productsData){
        for (ArrayList<String> product : productsData) {
            generalProducts.add(product);
        }
        return generalProducts;
    }

    public void mixData(ArrayList<ArrayList<String>> generalProducts, 
            ArrayList<ArrayList<String>> regionData){
        String[] regions = new String[]{regionData.get(0).get(0),regionData.get(0).get(1)};
        for (ArrayList<String> products : generalProducts) {
            products.add(0, regions[0]);
            products.add(1, regions[1]);
        }
        prueba(generalProducts);
    }

    private void prueba(ArrayList<ArrayList<String>> generalProducts) {
        for (ArrayList<String> arrayList : generalProducts) {
            for (String string : arrayList) {
                System.out.print(string + "; ");
            }
            System.out.println();
        }
    }

    public void readFile(){
        readReports(new File(PATH_DATA));
    }

    public void readReports(File file){
        File[] listFiles = file.listFiles();
        for (int i = 0; i < listFiles.length; i++) {
            File fileOfList = listFiles[i];
            if(fileOfList.isDirectory()){
                readReports(listFiles[i]);
            }else{
                if(simpleTesting(fileOfList.getName())){
                    getData(fileOfList.getPath());
                }
            }
        }
    }

    public boolean simpleTesting(String fileName) {
        String extention = fileName.replaceAll(REGULAR_EXPRESION_EXTENTION, "$1");;
        return EXCEL_EXTENTION.equals(extention);
    }

    public static void main(String[] args) {
        new ReportManager();
    }
}
