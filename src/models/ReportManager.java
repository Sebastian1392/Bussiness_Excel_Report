package models;

import persistences.ReadReport;

public class ReportManager {
    
    private ReadReport reader;
    
    public ReportManager(){
        reader = new ReadReport();
    }

    public void getData(){
        int numberSheets = reader.getNumberSheets();
    }

}
