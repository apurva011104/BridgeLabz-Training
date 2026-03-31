//Hierarchial inheritance is demonstrated
//Super class
public class Animal {
    
    String name;
    int age;

    public Animal(String name, int age) {
        this.name = name;
        this.age = age;
    }


    public void makeSound(){
        System.out.println("Animal makes sound.");
    }

    public void displayDetails(){
        System.out.println("Animal's name: "+name);
        System.out.println("Animal's age: "+age+" years");
    }

}

//Sub class
class Dog extends Animal{

    //Explicity calling the super class constructor is important as super class contains a parameterized constructor
    public Dog(String name, int age){
        super(name, age);
    }

    //Overriding method of superclass "Animal"
    @Override
    public void makeSound(){
        System.out.println("Dog barks.");
    }

    @Override
    public void displayDetails(){
        System.out.println("Dog's name: "+name);
        System.out.println("Dog's age: "+age+" years");
    }

}

//Sub class
class Cat extends Animal{

    public Cat(String name, int age){
        super(name, age);
    }

    //Overriding method of superclass "Animal"
    @Override
    public void makeSound(){
        System.out.println("Cat meows.");
    }

    @Override
    public void displayDetails(){
        System.out.println("Cat's name: "+name);
        System.out.println("Cat's age: "+age+" years");
    }


}

//Sub class
class Bird extends Animal{

    public Bird(String name, int age){
        super(name, age);
    }

    //Overriding method of superclass "Animal"
    @Override
    public void makeSound(){
        System.out.println("Bird chirps.");
    }

    @Override
    public void displayDetails(){
        System.out.println("Bird's name: "+name);
        System.out.println("Bird's age: "+age+" years");
    }


}

//Main class for testing
class Main{

    public static void main(String[] args) {
        Animal animal1 = new Animal("Rihno",23);
        Dog dog1 = new Dog("Snoopy",12);
        Cat cat1 = new Cat("Lilly",7);
        Bird bird1 = new Bird("Kiwi",2);

        animal1.makeSound();
        dog1.makeSound();
        cat1.makeSound();
        bird1.makeSound();
        animal1.displayDetails();
        dog1.displayDetails();
        cat1.displayDetails();
        bird1.displayDetails();
    }

}