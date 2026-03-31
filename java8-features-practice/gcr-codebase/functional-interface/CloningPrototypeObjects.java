public class CloningPrototypeObjects {
    public static void main(String[] args) {

        Document document = new Document("DOC123", "UserData.json", "{UserId: UID123, Name: Ava, Age: 21}");
        Document clonedDocument = document.clone();

        System.out.println("Original Document:\n"+document);
        System.out.println("Cloned Document:\n"+clonedDocument);
        
    }
}


class Document implements Cloneable{

    private final String id;
    private String name;
    private String data;

    public Document(String id, String name, String data) {
        this.id = id;
        this.name = name;
        this.data = data;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public String getId() {
        return id;
    }

    @Override
    public Document clone() {
        try {
            return (Document)super.clone();
        } 
        catch (CloneNotSupportedException e) {
            throw new AssertionError();
        }
    }

    @Override
    public String toString() {
        return String.format("[\n\tDocument ID: %s,\n\tName: %s,\n\tData: %s\n]", id,  name, data);
    }
}