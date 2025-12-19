public class volumeOfEarth {
    public static void main(String[] args) {
        double radius=6378.0; // Radius of the Earth in kilometers
        double volume= (4.0/3.0) * Math.PI * Math.pow(radius, 3);
        System.out.println("The volume of the Earth is: " + volume + " cubic kilometers.");
    }
}
