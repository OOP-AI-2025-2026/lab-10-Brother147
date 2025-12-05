package ua.opnu;

import ua.opnu.util.Customer;
import ua.opnu.util.DataProvider;
import ua.opnu.util.Order;
import ua.opnu.util.Product;

import java.util.*;
import java.util.stream.Collectors;

public class HardTasks {

    private final List<Customer> customers = DataProvider.customers;
    private final List<Order> orders = DataProvider.orders;
    private final List<Product> products = DataProvider.products;

    public static void main(String[] args) {
        // Запустіть тести з папки src/test, щоб перевірити правильність реалізації методів.
    }

    /**
     * Завдання 1
     * Повертає товари категорії "Books" з ціною більше 100.
     */
    public List<Product> getBooksWithPrice() {
        return products.stream()
                .filter(p -> "Books".equals(p.getCategory()) && p.getPrice() > 100)
                .sorted(Comparator.comparingInt(Product::getId))
                .collect(Collectors.toList());
    }

    /**
     * Завдання 2
     * Повертає замовлення, в яких є хоча б один товар з категорії "Baby".
     */
    public List<Order> getOrdersWithBabyProducts() {
        return orders.stream()
                .filter(o -> o.getProducts().stream()
                        .anyMatch(p -> "Baby".equals(p.getCategory())))
                .sorted(Comparator.comparingInt(Order::getId))
                .collect(Collectors.toList());
    }

    /**
     * Завдання 3
     * Знаходить усі товари категорії "Toys" та застосовує до їх ціни знижку 50%.
     * Повертає список цих товарів.
     */
    public List<Product> applyDiscountToToys() {
        return products.stream()
                .filter(p -> "Toys".equals(p.getCategory()))
                .peek(p -> p.setPrice(p.getPrice() * 0.5))
                .sorted(Comparator.comparingInt(Product::getId))
                .collect(Collectors.toList());
    }

    /**
     * Завдання 4
     * Повертає найдешевшу книгу як Optional<Product>.
     */
    public Optional<Product> getCheapestBook() {
        return products.stream()
                .filter(p -> "Books".equals(p.getCategory()))
                .min(Comparator.comparingDouble(Product::getPrice));
    }

    /**
     * Завдання 5
     * Повертає три останні замовлення (найсвіжіші за датою) у зворотньому хронологічному порядку.
     */
    public List<Order> getRecentOrders() {
        return orders.stream()
                .sorted(Comparator.comparing(Order::getOrderDate).reversed())
                .limit(3)
                .collect(Collectors.toList());
    }

    /**
     * Завдання 6
     * Повертає статистику по цінах товарів категорії "Books".
     */
    public DoubleSummaryStatistics getBooksStats() {
        return products.stream()
                .filter(p -> "Books".equals(p.getCategory()))
                .mapToDouble(Product::getPrice)
                .summaryStatistics();
    }

    /**
     * Завдання 7
     * Повертає мапу, де ключ — id замовлення, значення — кількість товарів у цьому замовленні.
     */
    public Map<Integer, Integer> getOrdersProductsMap() {
        return orders.stream()
                .collect(Collectors.toMap(
                        Order::getId,
                        o -> o.getProducts().size()
                ));
    }

    /**
     * Завдання 8
     * Повертає мапу, де ключ — назва категорії, а значення — відсортований за зростанням
     * список id товарів, що належать до цієї категорії.
     */
    public Map<String, List<Integer>> getProductsByCategory() {

        return products.stream()
                .collect(Collectors.groupingBy(
                        Product::getCategory,
                        Collectors.collectingAndThen(
                                Collectors.mapping(Product::getId, Collectors.toList()),
                                list -> {
                                    list.sort(Integer::compareTo);
                                    return list;
                                }
                        )
                ));
    }

}
