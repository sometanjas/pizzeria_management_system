package src.storage.order;

import java.util.List;

public interface OrderDao {
    List<OrderRecord> getAllOrders();

    void addOrder(OrderRecord orderRecord);
}
