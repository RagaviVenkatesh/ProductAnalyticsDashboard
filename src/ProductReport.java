import java.util.*;

public class ProductReport {
    private long totalActiveProducts;
    private int categoryCount;
    private double totalInventoryValue;
    private List<Product> topRatedProducts;
    private List<Product> lowStockProducts;
    private Set<String> allTags;
    private Map<String, Double> avgPricePerCategory;

    // Setters
    public void setTotalActiveProducts(long count) { this.totalActiveProducts = count; }
    public void setCategoryCount(int count) { this.categoryCount = count; }
    public void setTotalInventoryValue(double value) { this.totalInventoryValue = value; }
    public void setTopRatedProducts(List<Product> products) { this.topRatedProducts = products; }
    public void setLowStockProducts(List<Product> products) { this.lowStockProducts = products; }
    public void setAllTags(Set<String> tags) { this.allTags = tags; }
    public void setAvgPricePerCategory(Map<String, Double> avgPrice) { this.avgPricePerCategory = avgPrice; }

    @Override
    public String toString() {
        return "Report Summary:\n" +
               "Total Active Products: " + totalActiveProducts + "\n" +
               "Category Count: " + categoryCount + "\n" +
               "Total Inventory Value: $" + totalInventoryValue + "\n" +
               "Top Rated Products: " + topRatedProducts + "\n" +
               "Low Stock Products: " + lowStockProducts + "\n" +
               "All Tags: " + allTags + "\n" +
               "Average Price Per Category: " + avgPricePerCategory + "\n";
    }
}
