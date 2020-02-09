package nl.han.ica.oose.dea;

public class OrdersWriter {
    private Orders orders;
    private StringBuffer sb = new StringBuffer("{\"orders\": [");

    public OrdersWriter(Orders orders) {
        this.orders = orders;
    }

    public String getContents() {

        for (int i = 0; i < orders.getOrdersCount(); i++) {
            Order order = orders.getOrder(i);
            appendId(order);

            for (int j = 0; j < order.getProductsCount(); j++) {
                Product product = order.getProduct(j);

                appendCode(product);
                appendColor(product);

                if (!product.getSize().equals(" ")) {
                    appendSize(product);
                }

                appendPrice(product);
                appendCurrency(product);
            }

            if (order.getProductsCount() > 0) {
                sb.delete(sb.length() - 2, sb.length());
            }

            sb.append("]");
            sb.append("}, ");
        }

        if (orders.getOrdersCount() > 0) {
            sb.delete(sb.length() - 2, sb.length());
        }

        return sb.append("]}").toString();
    }

    private void appendCurrency(Product product) {
        sb.append("\"currency\": \"");
        sb.append(product.getCurrency());
        sb.append("\"}, ");
    }

    private void appendPrice(Product product) {
        sb.append("\"price\": ");
        sb.append(product.getPrice());
        sb.append(", ");

    }

    private void appendSize(Product product) {
        sb.append("\"size\": \"");
        sb.append(product.getSize());
        sb.append("\", ");
    }

    private void appendColor(Product product) {
        sb.append("\", ");
        sb.append("\"color\": \"");
        sb.append(product.getColor());
        sb.append("\", ");
    }

    private void appendCode(Product product) {
        sb.append("{");
        sb.append("\"code\": \"");
        sb.append(product.getCode());
    }

    private void appendId(Order order) {
        sb.append("{");
        sb.append("\"id\": ");
        sb.append(order.getOrderId());
        sb.append(", ");
        sb.append("\"products\": [");
    }
}
