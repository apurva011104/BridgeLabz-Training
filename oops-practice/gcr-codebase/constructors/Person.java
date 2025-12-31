public class Person {

    String name;
    int age;
    String gender;
    double height;
    double weight;

    //Parameterized constructor to create new person
    Person(String name, int age, String gender, double height, double weight) {
        this.name = name;
        this.age = age;
        this.gender = gender;
        this.height = height;
        this.weight = weight;
    }

    //Copy constructor to create copy of person
    Person(Person person){
        this.name = person.name;
        this.age = person.age;
        this.gender = person.gender;
        this.height = person.height;
        this.weight = person.weight;
    }

    public void displayAttributes(){
        System.out.println("Person's name: "+name);
        System.out.println("Person's age: "+age);
        System.out.println("Person's gender: "+gender);
        System.out.println("Person's height: "+height);
        System.out.println("Person's weight: "+weight);
        System.out.println("----------------------------------------------");
    }

    public static void main(String[] args) {
        
        Person person = new Person("Ava",21,"Female",163.25,51.5);
        Person copyOfPerson = new Person(person);

        System.out.println("Original person's attributes: ");
        person.displayAttributes();
        System.out.println("Copy of person's attributes: ");
        copyOfPerson.displayAttributes();
    }
    
}
