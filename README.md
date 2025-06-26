# 🛍️ Java Streams Product Report

A fun and functional deep dive into Java 8+ Streams and Functional Interfaces — wrapped around a simple product reporting use case. 

---

## 🚀 What's Inside

This project showcases:

- **Filtering** expired/out-of-stock products using `filter`
- **Flattening** tags from all products using `flatMap`
- **Grouping** by category using `Collectors.groupingBy`
- **Calculating** average price with `averagingDouble`
- **Summing** total inventory value with `mapToDouble + sum`
- **Sorting** and picking top-rated items
- **Building** a summary report using clean OOP

---

## 🧱 Project Structure

```bash
.
├── Product.java          # Model class for products
├── ProductReport.java    # Report class to hold results
└── Main.java             # Stream magic + execution logic
