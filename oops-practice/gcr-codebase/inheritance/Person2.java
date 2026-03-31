public class Person2 {

    private final String id;
    String name;
    int age;

    public Person2(String id, String name, int age) {
        this.id = id;
        this.name = name;
        this.age = age;
    }

    //Getter for id
    public String getId(){
        return id;
    }

    //Method to display information
    public void displayInfo(){
        System.out.println("ID: "+id);
        System.out.println("Name: "+name);
        System.out.println("Age: "+age);
    }
    
}

interface Worker{
    public void performDuties();
}

class Chef extends Person2 implements Worker{

    public Chef(String id, String name, int age){
        super(id, name, age);
    }

    @Override
    public void performDuties(){
        System.out.println("Chef cooks");
    }

    @Override
    public void displayInfo(){
        System.out.println("Role: Chef");
        super.displayInfo();
    }
}

class Waiter extends Person2 implements Worker{

    public Waiter(String id, String name, int age){
        super(id, name, age);
    }

    @Override
    public void performDuties(){
        System.out.println("Waiter serves");
    }

    @Override
    public void displayInfo(){
        System.out.println("Role: Waiter");
        super.displayInfo();
    }
}

//Main class for testing
class Main{
    public static void main(String[] args) {
        Person2 person1 = new Person2("P0101", "Valerie", 26);
        Chef chef1 = new Chef("C101", "Candice", 34);
        Waiter waiter1 = new Waiter("W101","Amelia", 23);

        person1.displayInfo();

        System.out.println();

        chef1.displayInfo();
        chef1.performDuties();

        System.out.println();

        waiter1.displayInfo();
        waiter1.performDuties();

    }
}