/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package patika.store;

/**
 *
 * @author hasan
 */
public class phone extends TopClass {
    private String id;          // ürünün sistemdeki ünic id si
    private Integer memory;         // hafızası
    private double screen;      // ekran boyutu
    private static Integer idNumber = 99;

        public phone(String name, double price, double discount, Integer stock, String brand, String color, Integer memory, double screen) {
        super(name, price, discount, stock, brand, color);
        idNumber++;
        this.id = brand.substring(0, 2).toLowerCase() + "ph" +idNumber;
        this.memory = memory;
        this.screen = screen;
    }    

    public Integer getMemory() {
        return memory;
    }

    public void setMemory(Integer memory) {
        this.memory = memory;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
    

    public double getScreen() {
        return screen;
    }

    public void setScreen(double screen) {
        this.screen = screen;
    }
     public String toPrint(){
        return ("|  "+this.getId() + "   |   "+ this.getName() + "   |   "+ this.getAmount() + "   |   " + this.getBrand());
    }
     public void print(){
       System.out.printf("%1s%20s%20.2f%20s\n", this.getId(), this.getName(), this.getAmount(), this.getBrand());
    }   
}
