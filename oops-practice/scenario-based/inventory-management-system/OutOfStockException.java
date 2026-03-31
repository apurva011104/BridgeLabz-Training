public class OutOfStockException extends Exception {

    @Override
    public String getMessage() {
        return "Product is out of stock!";
    }
}
