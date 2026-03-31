public class DataExportFeature implements DataExporter{

    @Override
    public void exportToCSV(){
        System.out.println("Data exported to CSV successfully");
    }

    @Override
    public void exportToPDF(){
        System.out.println("Data exported to PDF successfully");
    }


    public static void main(String[] args) {
        DataExportFeature dataExporter = new DataExportFeature();

        dataExporter.exportToCSV();
        dataExporter.exportToPDF();
        dataExporter.exportToJSON();
    }
}


interface DataExporter{

    public void exportToCSV();
    public void exportToPDF();

    default void exportToJSON(){
        System.out.println("Data exported to JSON successfully");
    }
}
