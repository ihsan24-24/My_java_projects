public abstract class TopClass {
    private String name;        // ürün adı
    private double price;       // satış fiyatı
    private double discount;    // indirim oranı
    private double amount;      // toplam tutarı
    private Integer stock;      // stok adedi
    private String brand;       // markası
    private String color;       // renk

    public TopClass(String name, double price, double discount, Integer stock, String brand, String color) {
        this.name = name;
        this.price = price;
        this.discount = discount;
        this.amount = (price - (price*discount/100));  // satış fiyatı üzerinden indirim yüzdesi kadar indirim yapıyoruz.
        this.stock = stock;
        this.brand = brand;
        this.color = color;
    }
    
    

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public double getDiscount() {
        return discount;
    }

    public void setDiscount(double discount) {
        this.discount = discount;
    }

    public double getAmount() {
        return amount;
    }

    public Integer getStock() {
        return stock;
    }

    public void setStock(Integer stock) {
        this.stock = stock;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

}
