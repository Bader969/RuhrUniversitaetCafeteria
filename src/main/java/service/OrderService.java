package service;

import domain.Order;
import domain.OrderObserver;
import domain.Product;
import repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Optional;

@Service
public class OrderService implements OrderObserver {
    @Autowired
    private OrderRepository orderRepository;

    public void createOrder(Order order) {
        order.setOrderDate(LocalDateTime.now());
        order.setStatus("Neu");
        orderRepository.save(order);
    }

    public Optional<Order> findOrderById(Long id) {
        return orderRepository.findById(id);
    }

    public void addProductToOrder(Long orderId, Product product) {
        Order order = findOrderById(orderId).orElseThrow(() -> new RuntimeException("Order not found"));
        order.addProduct(product);
        orderRepository.save(order);
    }

    public void removeProductFromOrder(Long orderId, Product product) {
        Order order = findOrderById(orderId).orElseThrow(() -> new RuntimeException("Order not found"));
        order.removeProduct(product);
        orderRepository.save(order);
    }

    public void processOrder(Long orderId) {
        Order order = findOrderById(orderId).orElseThrow(() -> new RuntimeException("Order not found"));
        order.processOrder();
        orderRepository.save(order);
    }

    public void shipOrder(Long orderId) {
        Order order = findOrderById(orderId).orElseThrow(() -> new RuntimeException("Order not found"));
        order.shipOrder();
        orderRepository.save(order);
    }

    public void deliverOrder(Long orderId) {
        Order order = findOrderById(orderId).orElseThrow(() -> new RuntimeException("Order not found"));
        order.deliverOrder();
        orderRepository.save(order);
    }

    public void completeOrder(Long orderId) {
        Order order = findOrderById(orderId).orElseThrow(() -> new RuntimeException("Order not found"));
        order.completeOrder();
        orderRepository.save(order);
    }

    public void cancelOrder(Long orderId) {
        Order order = findOrderById(orderId).orElseThrow(() -> new RuntimeException("Order not found"));
        order.cancelOrder();
        orderRepository.save(order);
    }

    public void requestReturn(Long orderId) {
        Order order = findOrderById(orderId).orElseThrow(() -> new RuntimeException("Order not found"));
        order.requestReturn();
        orderRepository.save(order);
    }

    public void processReturn(Long orderId) {
        Order order = findOrderById(orderId).orElseThrow(() -> new RuntimeException("Order not found"));
        order.processReturn();
        orderRepository.save(order);
    }

    public void refundOrder(Long orderId) {
        Order order = findOrderById(orderId).orElseThrow(() -> new RuntimeException("Order not found"));
        order.refundOrder();
        orderRepository.save(order);
    }

    @Override
    public void update(Order order) {
        // Implement logic for updating order status or notifying user
    }
}
