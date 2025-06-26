import java.util.List;

public class Product {
    private String name;
    private String category;
    private double price;
    private int quantity;
    private double rating;
    private boolean expired;
    private List<String> tags;

    // Constructor
    public Product(String name, String category, double price, int quantity, double rating, boolean expired, List<String> tags) {
        this.name = name;
        this.category = category;
        this.price = price;
        this.quantity = quantity;
        this.rating = rating;
        this.expired = expired;
        this.tags = tags;
    }

    // Getters
    public String getName() { return name; }
    public String getCategory() { return category; }
    public double getPrice() { return price; }
    public int getQuantity() { return quantity; }
    public double getRating() { return rating; }
    public boolean isExpired() { return expired; }
    public List<String> getTags() { return tags; }

    @Override
    public String toString() {
        return name + " | " + category + " | $" + price + " | Qty: " + quantity + " | ⭐ " + rating;
    }
}
