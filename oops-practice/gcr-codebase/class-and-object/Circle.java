public class Circle{
    double radius;
	
	//Circle constructor which creates a circle obj
	Circle(double radius){
		this.radius = radius;
	}
	
    //Method to calculate area
	private double area() {
		return Math.PI * radius * radius;
	}
	
    //Method to calculate circumference
	private double circumference() {
		return 2 * Math.PI * radius;
	}

    //Method to display area
    public void displayArea(){
        double area = area();
        System.out.printf("Area of the circle: %.4f sq. units%n",area);
    }

    //Method to display circumference
    public void displayCircumference(){
        double circumference = circumference();
        System.out.printf("Circumference of the circle: %.4f units%n",circumference);
    }
	
	public static void main(String []args) {
		Circle circle = new Circle(2.5);
        circle.displayArea();
        circle.displayCircumference();
	}
}