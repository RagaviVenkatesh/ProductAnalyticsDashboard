import java.util.*;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        List<Product> products = Arrays.asList(
            new Product("Laptop", "Electronics", 900.0, 3, 4.7, false, Arrays.asList("tech", "work")),
            new Product("Book", "Books", 30.0, 10, 4.2, false, Arrays.asList("read", "education")),
            new Product("Mixer", "Kitchen", 120.0, 0, 4.4, false, Arrays.asList("cook", "home")),
            new Product("T-shirt", "Fashion", 25.0, 15, 4.6, false, Arrays.asList("style", "summer")),
            new Product("Milk", "Groceries", 2.0, 4, 4.0, true, Arrays.asList("dairy", "daily")),
            new Product("Headphones", "Electronics", 150.0, 2, 4.8, false, Arrays.asList("tech", "audio"))
        );

        // Step 1: Filter out expired and out-of-stock
        List<Product> activeProducts = products.stream()
            .filter(p -> !p.isExpired() && p.getQuantity() > 0)
            .collect(Collectors.toList());

        // Step 2: Flatten tags
        Set<String> allTags = activeProducts.stream()
            .flatMap(p -> p.getTags().stream())
            .collect(Collectors.toSet());

        // Step 3: Group by category
        Map<String, List<Product>> productsByCategory = activeProducts.stream()
            .collect(Collectors.groupingBy(Product::getCategory));

        // Step 4: Average price per category
        Map<String, Double> avgPriceByCategory = activeProducts.stream()
            .collect(Collectors.groupingBy(
                Product::getCategory,
                Collectors.averagingDouble(Product::getPrice)
            ));

        // Step 5: Total inventory value
        double totalInventoryValue = activeProducts.stream()
            .mapToDouble(p -> p.getPrice() * p.getQuantity())
            .sum();

        // Step 6: Low stock alerts
        List<Product> restockAlerts = activeProducts.stream()
            .filter(p -> p.getQuantity() < 5)
            .collect(Collectors.toList());

        // Step 7: Top-rated products
        List<Product> topRatedProducts = activeProducts.stream()
            .filter(p -> p.getRating() >= 4.5)
            .sorted(Comparator.comparingDouble(Product::getRating).reversed())
            .collect(Collectors.toList());

        // Step 8: Build summary report
        ProductReport report = new ProductReport();
        report.setTotalActiveProducts(activeProducts.size());
        report.setCategoryCount(productsByCategory.size());
        report.setTotalInventoryValue(totalInventoryValue);
        report.setTopRatedProducts(topRatedProducts.subList(0, Math.min(3, topRatedProducts.size())));
        report.setLowStockProducts(restockAlerts);
        report.setAllTags(allTags);
        report.setAvgPricePerCategory(avgPriceByCategory);

        // Step 9: Print the report
        System.out.println(report);
    }
}
