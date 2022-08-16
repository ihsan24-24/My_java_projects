
public class laptop extends TopClass {
    private String id;          // ürünün sistemdeki ünic id si
    private Integer memory;         // hafızası
    private double screen;      // ekran boyutu
    private static Integer idNumber = 99999;

    public laptop(String name, double price, double discount, Integer stock, String brand, String color, Integer memory, double screen) {
        super(name, price, discount, stock, brand, color);
        this.memory = memory;
        this.screen = screen;
        idNumber++;
        this.id = brand.substring(0, 2).toLowerCase() + "la" +idNumber;
        
    }
  
    
    

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Integer getMemory() {
        return memory;
    }

    public void setMemory(Integer memory) {
        this.memory = memory;
    }

    public double getScreen() {
        return screen;
    }

    public void setScreen(double screen) {
        this.screen = screen;
    }

    public void selling(){
        System.out.println("ürün satildi ");
        this.setStock(this.getStock()-1);
        System.out.println("kalan stok adedi : " + this.getStock());
    }
   
    public String toPrint(){
        return ("|  "+this.getId() + "   |   "+ this.getName() + "   |   "+ this.getAmount() + "   |   " + this.getBrand());
    }
    public void print(){
        System.out.printf("%1s%20s%20.2f%20s\n", this.getId(), this.getName(), this.getAmount(), this.getBrand());
    }
}
