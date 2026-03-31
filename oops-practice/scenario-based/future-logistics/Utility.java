
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

public class Utility {
    
    public GoodsTransport parseDetails(String input){
        if(input==null){
            throw new IllegalArgumentException("Please provide valid input");
        }
        input = input.replaceAll("\\s+", "");
        String[] attributes = input.split(":");
        if(!validateAttributes(attributes)){
            return null;
        }
        String transportId = attributes[0];
        String transportDate = attributes[1];
        int rating = Integer.parseInt(attributes[2]);

        String transportType = attributes[3];

        if(transportType.equalsIgnoreCase("BrickTransport")){

            float brickSize = Float.parseFloat(attributes[4]);
            int brickQuantity = Integer.parseInt(attributes[5]);
            float brickPrice = Float.parseFloat(attributes[6]);

            BrickTransport brickTransport = new BrickTransport(transportId, transportDate, rating, brickSize, brickQuantity, brickPrice);
            return brickTransport;
        }
        else{
            float timberLength = Float.parseFloat(attributes[4]);
            float timberRadius = Float.parseFloat(attributes[5]);
            String timberType = attributes[6];
            float timberPrice = Float.parseFloat(attributes[7]);

            TimberTransport timberTransport = new TimberTransport(transportId, transportDate, rating, timberLength, timberRadius, timberType, timberPrice);
            return timberTransport;

        }
    }

    public String findObjectType(GoodsTransport goodsTransport){
        if(goodsTransport instanceof BrickTransport){
            return "BrickTransport";
        }
        else if(goodsTransport instanceof TimberTransport){
            return "TimberTransport";
        }
        else{
            return null;
        }
    }

    public boolean validateTransportId(String transportId){
        boolean flag;
        if(transportId.length()!=7){
            flag = false;
        }
        else if(!transportId.startsWith("RTS")){
           flag = false;
        }
        else if(!transportId.substring(3,6).matches("[0-9]{3}")){
            flag = false;
        }
        else if(transportId.charAt(transportId.length()-1)<'A' || transportId.charAt(transportId.length()-1)>'Z'){
            flag = false;
        }
        else{
            flag = true;
        }
        if(!flag){
            System.out.println("Transport id "+transportId+" is invalid");
            System.out.println("Please provide a valid record");
        }
        return flag;
    }

    public void displayTransportDetails(GoodsTransport transport){
        if(transport == null){
            return;
        }
        String objectType= findObjectType(transport);
        if(objectType.equalsIgnoreCase("BrickTransport")){
            displayBrickTransportDetails((BrickTransport)transport);
        }
        else if(objectType.equalsIgnoreCase("TimberTransport")){
            displayTimberTransportDetails((TimberTransport)transport);
        }

    }

    /*-----------------------------PRIVATE VALIDATOR METHODS--------------------------------*/
    private boolean validateAttributes(String[] attributes){

        if(attributes.length != 7 && attributes.length != 8){
            return false;
        }
        if(!validateTransportId(attributes[0])){
            return false;
        }
        if(!validateDate(attributes[1])){
            System.out.println("Date "+ attributes[1]+" is invalid.\nPlease provide a valid record");
            return false;
        }
        if(!validateRating(attributes[2])){
            System.out.println("Rating "+ attributes[2]+" is invalid.\nPlease provide a valid record");
            return false;
        }

        String transportType = attributes[3];

        if(!transportType.equalsIgnoreCase("BrickTransport") && !transportType.equalsIgnoreCase("TimberTransport")){
            System.out.println("Transport type is invalid.\nPlease provide a valid record");
            return false;
        }

        if(transportType.equalsIgnoreCase("BrickTransport")){
            if(attributes.length != 7){
                System.out.println("Number of attributes for BrickTransport is invalid.\nPlease provide a valid record");
                return false;
            }
            if(!validateShapeParameters(attributes[4])){
                System.out.println("Brick size is invalid.\nPlease provide a valid record");
                return false;
            }
            if(!validateBrickQuantity(attributes[5])){
                System.out.println("Brick quantity is invalid.\nPlease provide a valid record");
                return false;
            }
            if(!validatePrice(attributes[6])){
                System.out.println("Brick price is invalid.\nPlease provide a valid record");
                return false;
            }
        }
        else{
            if(attributes.length != 8){
                System.out.println("Number of attributes for TimberTransport is invalid.\nPlease provide a valid record");
                return false;
            }
            if(!validateShapeParameters(attributes[4])){
                System.out.println("Timber length is invalid.\nPlease provide a valid record");
                return false;
            }
            if(!validateShapeParameters(attributes[5])){
                System.out.println("Timber radius is invalid.\nPlease provide a valid record");
                return false;
            }
            String timberType = attributes[6];
            if(!timberType.equalsIgnoreCase("Premium") && !timberType.equalsIgnoreCase("NonPremium")){
                System.out.println("Timber type is invalid.\nPlease provide a valid record");
                return false;
            }
            if(!validatePrice(attributes[7])){
                System.out.println("Timber price is invalid.\nPlease provide a valid record");
                return false;
            }
        }
        return true;
    }


    private boolean validateDate(String date){
        final DateTimeFormatter FORMATTER = DateTimeFormatter.ofPattern("dd/M/yy");
        try {
            LocalDate.parse(date,FORMATTER);
            return true;
        } catch (DateTimeParseException e) {
            return false;
        }
    }

    private boolean validateRating(String rating){
        try {
            int r = Integer.parseInt(rating);
            if(r<1 || r>5){
                return false;
            }
            return true;
        } 
        catch (NumberFormatException e) {
            return false;
        }
    }

    private boolean validateShapeParameters(String parameter){
        try {
            float p = Float.parseFloat(parameter);
            if(p<=0){
                return false;
            }
            return true;
        } 
        catch (NumberFormatException e) {
            return false;
        }
    }

    private boolean validateBrickQuantity(String brickQuantity){
        try {
            int bs = Integer.parseInt(brickQuantity);
            if(bs<1){
                return false;
            }
            return true;
        } 
        catch (NumberFormatException e) {
            return false;
        }
    }

    private boolean validatePrice(String price){
        try {
            float p = Float.parseFloat(price);
            if(p<=0){
                return false;
            }
            return true;
        } 
        catch (NumberFormatException e) {
            return false;
        }
    }

    /*-----------------------PRIVATE DISPLAY METHODS---------------------------*/
    private void displayBrickTransportDetails(BrickTransport transport){
        System.out.println("Transporter id : "+transport.getTransportID());
        System.out.println("Date of transport : "+transport.getTransportDate());
        System.out.println("Rating of the transport : "+transport.getTransportRating());
        System.out.println("Quantity of bricks : "+transport.getBrickQuantity());
        System.out.println("Brick price : "+transport.getBrickPrice());
        System.out.println("Vehicle for transport : "+transport.vehicleSelection());
        System.out.println("Total charge : "+transport.calculateTotalCharge());
    }

    private void displayTimberTransportDetails(TimberTransport timberTransport){
        System.out.println("Transporter id : "+timberTransport.getTransportID());
        System.out.println("Date of transport : "+timberTransport.getTransportDate());
        System.out.println("Rating of the transport : "+timberTransport.getTransportRating());
        System.out.println("Type of the timber : "+timberTransport.getTimberType());
        System.out.println("Timber price per kilo : "+timberTransport.getTimberPrice());
        System.out.println("Vehicle for transport : "+timberTransport.vehicleSelection());
        System.out.println("Total charge : "+timberTransport.calculateTotalCharge());
    }

}
