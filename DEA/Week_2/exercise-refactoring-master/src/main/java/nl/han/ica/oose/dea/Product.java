package nl.han.ica.oose.dea;

import nl.han.ica.oose.dea.colors.Color;
import nl.han.ica.oose.dea.sizes.Size;

public class Product {
    private String code;
    private Color color;
    private Size size;
    private double price;
    private String currency;

    public Product(String code, Color color, Size size, double price, String currency) {
        this.code = code;
        this.color = color;
        this.size = size;
        this.price = price;
        this.currency = currency;
    }

    public String getCode() {
        return code;
    }

    public String getColor() {
        return color.getColorAsString();
    }

    public String getSize() {
        return size.getSizeAsString();
    }

  /*  public String getSizeAsString() {
        switch (this.getSize()) {
            case 1:
                return "XS";
            case 2:
                return "S";
            case 3:
                return "M";
            case 4:
                return "L";
            case 5:
                return "XL";
            case 6:
                return "XXL";
            default:
                return "Invalid Size";
        }
    }*/


    public double getPrice() {
        return price;
    }

    public String getCurrency() {
        return currency;
    }
}
