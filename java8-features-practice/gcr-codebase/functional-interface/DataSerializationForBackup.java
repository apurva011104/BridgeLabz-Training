
import java.io.Serializable;

public class DataSerializationForBackup {
    public static void main(String[] args) {
        NormalData data = new NormalData("ND123", "This data is not important");
        DataToBackup dataToBackup = new DataToBackup("BD687", "This is an important data.");

        BackupStorage<DataToBackup> backupStorage = new BackupStorage<>();
        backupStorage.processBackup(dataToBackup);
    }
}

class Data{
    protected final String id;
    protected String description;

    public Data(String id, String description) {
        this.id = id;
        this.description = description;
    }

    @Override
    public String toString() {
        return String.format("[Data ID: %s, Description: %s]", id,description);
    }
    
}

class DataToBackup extends Data implements Serializable {

    public DataToBackup(String id, String description) {
        super(id, description);
    }
}

class NormalData extends Data{

    public NormalData(String id, String description) {
        super(id, description);
    }
    
}

class BackupStorage<T extends Data & Serializable>{

    public void processBackup(T obj){
        if(obj!=null){
            System.out.println("Backing up and storing data: "+obj);
        }
        else{
            throw new IllegalArgumentException("Cannot backup null data.");
        }
    }
}