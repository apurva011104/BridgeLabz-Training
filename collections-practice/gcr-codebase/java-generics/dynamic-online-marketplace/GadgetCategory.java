public class GadgetCategory extends Category {
    private static final String CATEGORY_NAME = "Gadget";

    public GadgetCategory(double maximumPrice, double minimumPrice) throws InvalidPriceRangeException {
        super( maximumPrice, minimumPrice);
    }

    @Override
    public String getCategoryName(){
        return CATEGORY_NAME;
    }
    
}
