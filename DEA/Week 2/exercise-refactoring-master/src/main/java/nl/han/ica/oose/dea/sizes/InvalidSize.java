package nl.han.ica.oose.dea.sizes;

public class InvalidSize extends Size {
    private String size = "Invalid Size";

    @Override
    public String getSizeAsString() {
        return size;
    }
}
