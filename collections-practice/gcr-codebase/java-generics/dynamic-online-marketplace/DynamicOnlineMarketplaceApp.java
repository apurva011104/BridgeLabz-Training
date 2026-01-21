public class DynamicOnlineMarketplaceApp {
    public static void main(String[] args) {
       

        try {

            Category category1 = new BookCategory(1000,50);
            BookCategory bookCategory = new BookCategory(1500, 100);
            ClothingCategory clothingCategory = new ClothingCategory(2000,100);
            GadgetCategory gadgetCategory = new GadgetCategory(55000,200);

            ProductCatalog productCatalog = new ProductCatalog();

            Product<BookCategory> product1 = new Product<>("P1452","Alice in Wonderland",749.99,bookCategory);
            Product<Category> product2 = new Product<>("P7542","Insect",499.99,category1);
            Product<ClothingCategory> product3 = new Product<>("P8523","Y2K Top",729.99, clothingCategory);
            Product<GadgetCategory> product4 = new Product<>("P5534","AC reote controller",999.99,gadgetCategory);
            Product<ClothingCategory> product5 = new Product<>("P7553","Y2K Skirt",549.99, clothingCategory);

            productCatalog.addNewProduct(product1);
            productCatalog.addNewProduct(product2);
            productCatalog.addNewProduct(product3);
            productCatalog.addNewProduct(product4);
            productCatalog.addNewProduct(product5);

            productCatalog.displayCatalog();

            productCatalog.applyDiscount(product3, 10);

            productCatalog.removeProduct(product5);

            productCatalog.displayCatalog();
            
        }
        catch (InvalidPriceRangeException | PriceNotInRangeException e) {
            System.out.println(e);
        }
    }
}
