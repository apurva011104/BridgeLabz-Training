abstract class Person {
    
    private final String ID;
    private String name;
    private int age;
    private String gender;

    public Person(String ID, String name, int age, String gender) {
        this.ID = ID;
        this.name = name;
        this.age = age;
        this.gender = gender;
    }

    public String getID() {
        return ID;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public String getGender() {
        return gender;
    }

    abstract void displayInformation();

}
