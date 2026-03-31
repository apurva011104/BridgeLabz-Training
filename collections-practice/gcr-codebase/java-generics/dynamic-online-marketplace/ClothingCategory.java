public class ClothingCategory extends Category {
    private static final String CATEGORY_NAME = "Clothing";

    public ClothingCategory(double maximumPrice, double minimumPrice)throws InvalidPriceRangeException {
        super(maximumPrice, minimumPrice);
    }
    
    @Override
    public String getCategoryName(){
        return CATEGORY_NAME;
    }
}
