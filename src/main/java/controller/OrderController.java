package controller;

import domain.Order;
import domain.Product;
import service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/orders")
public class OrderController {
    @Autowired
    private OrderService orderService;

    @PostMapping
    public void createOrder(@RequestBody Order order) {
        orderService.createOrder(order);
    }

    @GetMapping("/{id}")
    public Order getOrder(@PathVariable Long id) {
        Optional<Order> order = orderService.findOrderById(id);
        return order.orElse(null);
    }

    @PostMapping("/{id}/addProduct")
    public void addProductToOrder(@PathVariable Long id, @RequestBody Product product) {
        orderService.addProductToOrder(id, product);
    }

    @PostMapping("/{id}/removeProduct")
    public void removeProductFromOrder(@PathVariable Long id, @RequestBody Product product) {
        orderService.removeProductFromOrder(id, product);
    }

    @PostMapping("/{id}/process")
    public void processOrder(@PathVariable Long id) {
        orderService.processOrder(id);
    }

    @PostMapping("/{id}/ship")
    public void shipOrder(@PathVariable Long id) {
        orderService.shipOrder(id);
    }

    @PostMapping("/{id}/deliver")
    public void deliverOrder(@PathVariable Long id) {
        orderService.deliverOrder(id);
    }

    @PostMapping("/{id}/complete")
    public void completeOrder(@PathVariable Long id) {
        orderService.completeOrder(id);
    }

    @PostMapping("/{id}/cancel")
    public void cancelOrder(@PathVariable Long id) {
        orderService.cancelOrder(id);
    }

    @PostMapping("/{id}/requestReturn")
    public void requestReturn(@PathVariable Long id) {
        orderService.requestReturn(id);
    }

    @PostMapping("/{id}/processReturn")
    public void processReturn(@PathVariable Long id) {
        orderService.processReturn(id);
    }

    @PostMapping("/{id}/refund")
    public void refundOrder(@PathVariable Long id) {
        orderService.refundOrder(id);
    }
}

