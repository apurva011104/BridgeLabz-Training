public abstract class Category {
    private double maximumPrice;
    private double minimumPrice;

    public Category(double maximumPrice, double minimumPrice) throws InvalidPriceRangeException{
        if(minimumPrice<0 || maximumPrice<0 || maximumPrice<minimumPrice){
            throw new InvalidPriceRangeException("Invalid Price Range");
        }
        this.maximumPrice = maximumPrice;
        this.minimumPrice = minimumPrice;
    }

    public abstract String getCategoryName();

    public double getMaximumPrice() {
        return maximumPrice;
    }

    public double getMinimumPrice() {
        return minimumPrice;
    }

    public void setMaximumPrice(double maximumPrice) throws InvalidPriceRangeException{
        if(maximumPrice<0 || maximumPrice<this.minimumPrice){
            throw new InvalidPriceRangeException("Invalid Price Range");
        }
        this.maximumPrice = maximumPrice;
    }

    public void setMinimumPrice(double minimumPrice) throws InvalidPriceRangeException{
        if(minimumPrice<0 || this.maximumPrice<minimumPrice){
            throw new InvalidPriceRangeException("Invalid Price Range");
        }
        this.minimumPrice = minimumPrice;
    }

}
