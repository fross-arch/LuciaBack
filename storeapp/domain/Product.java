package storeapp.domain;

public class Product {


    private int idProduct;
    private String description;
    private double price;
    private int stock;
    private boolean state;
    Category category;

    public Product(int idProduct, String description, double price, int stock, boolean state, Category category) {
        this.idProduct = idProduct;
        this.description = description;
        this.price = price;
        this.stock = stock;
        this.state = state;
        this.category = category;
    }

    public Product() {
    }


    public int getIdProduct() {
        return idProduct;
    }

    public void setIdProduct(int idProduct) {
        this.idProduct = idProduct;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public boolean isState() {
        return state;
    }

    public void setState(boolean state) {
        this.state = state;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    @Override
    public String toString() {
        return "Product{" +
                "idProduct=" + idProduct +
                ", description='" + description + '\'' +
                ", price=" + price +
                ", stock=" + stock +
                ", state=" + state +
                ", category=" + category +
                '}';
    }
}
