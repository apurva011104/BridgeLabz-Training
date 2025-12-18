public class profitOrLoss {
    public static void main(String[] args) {
        double costPrice=129;
        double sellingPrice=191;
        double profitOrLoss = sellingPrice - costPrice;
        System.out.println("The cost price is INR " + costPrice + ", and the selling price is INR " + sellingPrice);
        if(profitOrLoss > 0){
            double profitPercentage = (profitOrLoss * 100.0) / costPrice;
            System.out.println("The profit is INR " + profitOrLoss+" and the profit percentage is INR " + profitPercentage + "%");
        }
        else if(profitOrLoss < 0){
            double lossPercentage = (Math.abs(profitOrLoss) * 100.0) / costPrice;
            System.out.println("The loss is INR " + Math.abs(profitOrLoss)+" and the loss percentage is INR " + lossPercentage + "%");
        }
        else{
            System.out.println("Neither profit nor loss.");
        }
    }
}
