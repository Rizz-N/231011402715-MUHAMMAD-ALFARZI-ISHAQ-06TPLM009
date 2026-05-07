package com.api.pos.service;

import com.api.pos.models.Order;
import com.api.pos.models.OrderItem;
import com.api.pos.models.Status;
import com.api.pos.repository.RepositoryOrder;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ServiceOrder {

    private final RepositoryOrder repository;

    public Order create(Order order) {

        BigDecimal total = BigDecimal.ZERO;

        if (order.getOrder_items() != null) {

            for (OrderItem item : order.getOrder_items()) {

                item.setOrder(order);

                BigDecimal subtotal = item.getPrice()
                        .multiply(BigDecimal.valueOf(item.getQuantity()));

                item.setSubtotal(subtotal);

                total = total.add(subtotal);
            }
        }

        order.setTotalPrice(total);
        order.setStatus(Status.PENDING);
        order.setOrder_date(LocalDateTime.now());

        return repository.save(order);
    }

    public List<Order> getAll() {
        return repository.findAll();
    }

    public Order getById(Integer id) {
        return repository.findById(id)
                .orElseThrow(() ->
                        new ResponseStatusException(
                                HttpStatus.NOT_FOUND,
                                "Order not found"
                        ));
    }

    public Order updateStatus(Integer id, Status status) {

        Order order = getById(id);

        order.setStatus(status);

        return repository.save(order);
    }

    public void delete(Integer id) {
        repository.deleteById(id);
    }
}