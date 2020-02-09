package nl.han.ica.oose.dea;

import java.util.ArrayList;
import java.util.List;

public class Orders {
    private List<Order> orders = new ArrayList<>();

    public void AddOrder(Order order) {
        orders.add(order);
    }

    public int getOrdersCount() {
        return orders.size();
    }

    public Order getOrder(int i) {
        return orders.get(i);
    }
}
