public class SensitiveDataTagging {
    
    public static <T extends DocumentFile> void encryptDocument(T document){
        if(document instanceof SensitiveData){
            System.out.println("Document encrypted successfully");
        }
        else{
            System.out.println("Document cannot be encrypted.");
        }
    }

    public static void main(String[] args) {
        DocumentFile documentFile1 = new NormalDocumentFile("Prime Numbers", "Prime numbers are those whose only factors are 1 and the number itself. 1 is neither prime nor composite.");
        DocumentFile documentFile2 = new SensitiveDocumentFile("Student data", "{Roll No.: STU123, Name: Ava, Age: 21}");

        encryptDocument(documentFile1);
        encryptDocument(documentFile2);
    }
}

interface SensitiveData{
}

abstract class DocumentFile{

    private String name;
    private String data;

    public DocumentFile(String name, String data) {
        this.name = name;
        this.data = data;
    }

    @Override
    public String toString() {
        return String.format("[Document name: %s, Data: %s]", name,data);
    }
}

class NormalDocumentFile extends DocumentFile{

    public NormalDocumentFile(String name, String data) {
        super(name, data);
    }
    
}


class SensitiveDocumentFile extends DocumentFile implements SensitiveData{

    public SensitiveDocumentFile(String name, String data) {
        super(name, data);
    }
    
}