package me.mkweb.techtalk.streams.o_operators;

import me.mkweb.techtalk.util.Mock;
import me.mkweb.techtalk.util.Repository;
import me.mkweb.techtalk.util.internal.OrderRepository;
import me.mkweb.techtalk.util.model.Order;

import java.util.Optional;

public class Find {
    private static Repository<Order> orderRepository = OrderRepository.INSTANCE;

    public static void main(String[] args) {
        Mock.init();

        Optional<Order> any = orderRepository.findAll().parallelStream()
                .filter(order -> order.getAssignedTo().equals(Mock.RAYMOND))
                .findAny();

        Optional<Order> first = orderRepository.findAll().parallelStream()
                .filter(order -> order.getAssignedTo().equals(Mock.RAYMOND))
                .findFirst();

        System.out.print("** Any: ");
        any.map(Order::getDescription).ifPresent(System.out::println); // any changes over multiple executions
        System.out.print("** First: ");
        first.map(Order::getDescription).ifPresent(System.out::println); // first stays the same every time
    }
}
