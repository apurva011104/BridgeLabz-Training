 abstract class Patient extends Person implements IPayable{
    
    private int age;
    private String ailment;

    public Patient( String ID, String name, int age, String ailment) {
        super(ID, name);
        this.age = age;
        this.ailment = ailment;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getAilment() {
        return ailment;
    }

    public void setAilment(String ailment) {
        this.ailment = ailment;
    }

}
