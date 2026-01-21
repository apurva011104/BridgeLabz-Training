public class BookCategory extends Category {
    
    private static final String CATEGORY_NAME = "Book";

    public BookCategory(double maximumPrice, double minimumPrice) throws InvalidPriceRangeException{
        super(maximumPrice, minimumPrice);
    }

    @Override
    public String getCategoryName(){
        return CATEGORY_NAME;
    }
}
