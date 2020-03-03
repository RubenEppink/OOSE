package nl.han.ica.oose.ooad;

public class Register {
   private Sale currentSale;
   private ProductCatalog productCatalog;

    public Register(Sale currentSale, ProductCatalog productCatalog) {
        this.currentSale = currentSale;
        this.productCatalog = productCatalog;
    }

    public void enterItem(String itemID, int qty) {


    }
}
