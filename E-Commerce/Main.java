/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package patika.store;

/**
 *
 * @author hasan
 */
import java.util.*;
public class Main {
    public static void main(String args[]){
        Scanner input = new Scanner(System.in);
        Integer count = 0;
        String title;
        String idLaptop;
        String idPhone;
        String brand;
        double price;       // satış fiyatı
        double discount;    // indirim oranı
        double amount;      // toplam tutarı
        double screen;
        Integer stock;      // stok adedi
        String name;
        String color;   
        Integer choose;
        Integer memory;
        Integer idP = 99;
        Integer idL = 99999;
        Integer entry;
        HashMap<String, laptop> laptops = new HashMap<>();
        HashMap<String, phone> phones = new HashMap<>();
        ArrayList<String> basket = new ArrayList<>();
        ArrayList sum = new ArrayList<Double>(); /* sepete eklenen ürün fiyatlarını tuttuğum dizi. Bunu değişken olarak
         tutamadım çünkü ürünler kalıp halinde sepete ekleniyor ve ben sepetten ürün çıkardığımda
         çıkardığım ürünün fiyatına ulaşamıyorum bu yüzden sepettekki her ürünün kendisiyle aynı index numarasına
         sahip bir fiyat dizisi oluşturdum böylece sepetten çıkarılan ürünün fiyatı da bu diziden çıkmış oluyor.
        program sonunda yani mğşteri siparişi tamamladıktan sonra dizilerin hepsi programa ağırlık yapmasın diye 
        silinebilir. */
        double sumBasket = 0;
        while(true){
        System.out.println("Enter your prefer\n1 - Voler menu\n2 - Customer menu : \n0 - exit");
        entry = input.nextInt();
        if(entry == 0){
            break;
        }else if(entry == 1){ // kullanıcı satıcı seçeniğini seçtiğinde karşılaşacağı menü
          while(true){
          System.out.println(" PatikaStore Urun Yonetim Paneli ! \n1 - Notebook islemleri\n2 - Cep Telefonu islemleri\n0 - Cikis Yap ");
          Integer first = input.nextInt();  // kullanıcıdan hangi menüye girmek istediği verisini aldı
          if(first == 0){
              break;
          }else if(first ==1){
              System.out.println("notebook");//notebook işlemleri
              while(true){
                System.out.println("1 - Add product\n2 - Remove Product\n0 - Exit");
                Integer Lfirst = input.nextInt(); // kullanıcının hangi menüye girmek istediğini sorduk
                input.nextLine();  // bir üstte kullanıcıdan veri aldık ve cursor rakamın yanında kaldı. bir aşağıda
                //nextLine ile veri alacağım cursorda rakamın yanında kaldı netxLine satır sonuna kadar al demek
                //cursorda satır sonunda olduğu için veriyi boş geçiyor bu yüzen cursoru bir alt satıra indirdik.
                // Eğer nextLine ile bir veri alacaksak ve öncesinde tek satırlık bir veri aldıysak teak satırlık
                //verinin altına Scanner sınıfından oluşturulan obje.nextLine() yazarak cursoru bir alt satıra indirmek
                // gerekiyor.
                if(Lfirst == 0){
                    break;
                  }else if(Lfirst == 1){
                      idL++;           // ünic bir id vereceğimiz için id nin sonuna eklenecek rakamı artırıyoruz
                    
                    System.out.println("Enter product name : ");
                    name = input.nextLine();
                    System.out.println("Which brand : ");  // marka ismini aldık
                    brand = input.next();
                    
                    System.out.println("Enter stock quantity : "); // stok adedini aldık
                    stock = input.nextInt();
                    idLaptop= brand.substring(0, 2).toLowerCase() + "la" +idL;  // markanın ilk iki harfi + türürü olan laptopın iki harfi "La" + id numarası
                    System.out.println("Enter product color : ");
                    color = input.next();
                    System.out.println("Enter product memory :");
                    memory = input.nextInt();
                    System.out.println("Enter screen size :");
                    screen = input.nextDouble();
                    System.out.println("Enter salling price : ");
                    price = input.nextDouble();
                    System.out.println("Enter discount rate : ");
                    discount = input.nextDouble();
                    laptops.put(idLaptop, new laptop(name, price, discount , stock, brand, color , memory, screen));
                  }else if(Lfirst == 2){
                       System.out.printf("%1s%20s%20s%20s\n", "| ID", "| NAME", "| PRICE", "| BRAND");
                       for(laptop s: laptops.values()){  // laptop classından s ürettik ve laptops hashmap in de ki verilerin valuesi alon laptop verisine ulaşıyoruz.
                            
                            s.print();  // laptopları sıraladık bu sayede satıcı silmek istediği ID yi görebilecek
                            }
                        System.out.println("Enter the ID number you want to delete : ");
                        String rID = input.next();
                        laptops.remove(rID.toLowerCase()); // girilen ID de ki ürünü hashmapten çıkardık.
                        
                        System.out.printf("%1s%20s%20s%20s\n", "| ID", "| NAME", "| PRICE", "| BRAND");
                        for(laptop s: laptops.values()){ // ürünü sildikten sonra ürünleri takrardan listeledik
                            
                            s.print();
                  }
              }else{
                      System.out.println("You entered incorrectly, please try again.");
                  }
          }
           
          }else if(first == 2){ //cep telefonu işlemleri
          while(true){
          System.out.println("1 - Add product\n2 - Remove Product\n0 - Exit");
          Integer Pfirst = input.nextInt(); // kullanıcının hangi menüye girmek istediğini sorduk
          input.nextLine();  // bir üstte kullanıcıdan veri aldık ve cursor rakamın yanında kaldı. bir aşağıda
                //nextLine ile veri alacağım cursorda rakamın yanında kaldığı için sonraki satırı boş geçiyor bu yüzen
                // cursoru bir alt satıra indirdik
          if(Pfirst == 0){
              break;
          }else if(Pfirst == 1){
                    idP++;           // ünic bir id vereceğimiz için id nin sonuna eklenecek rakamı artırıyoruz
                    System.out.println("Enter product name : ");
                    name = input.nextLine();
                    System.out.println("Which brand : ");  // marka ismini aldık
                    brand = input.next();
                    
                    System.out.println("Enter stock quantity : "); // stok adedini aldık
                    stock = input.nextInt();
                    idPhone= brand.substring(0, 2).toLowerCase() + "ph" +idP;  // markanın ilk iki harfi + türürü olan telefonun iki harfi "Ph" + id numarası
                    System.out.println("Enter product color : ");
                    color = input.next();
                    System.out.println("Enter product memory :");
                    memory = input.nextInt();
                    System.out.println("Enter screen size :");
                    screen = input.nextDouble();
                    System.out.println("Enter salling price : ");
                    price = input.nextDouble();
                    System.out.println("Enter discount rate : ");
                    discount = input.nextDouble();

                    phones.put(idPhone, new phone(name, price, discount, stock, brand, color , memory, screen));
          }else if(Pfirst == 2){
              System.out.printf("%1s%20s%20s%20s\n", "| ID", "| NAME", "| PRICE", "| BRAND");
              for(phone s: phones.values()){  // phone classından s ürettik ve phones hashmap in de ki verilerin valuesi alon laptop verisine ulaşıyoruz.
                            
                            s.print();  // telefonları sıraladık bu sayede satıcı silmek istediği ID yi görebilecek
                            }
                        System.out.println("Enter the ID number you want to delete : ");
                        String rID = input.next();
                        phones.remove(rID.toLowerCase()); // girilen ID de ki ürünü hashmapten çıkardık.
                        System.out.printf("%1s%20s%20s%20s\n", "| ID", "| NAME", "| PRICE", "| BRAND");
                           for(phone s: phones.values()){ // ürünü sildikten sonra ürünleri takrardan listeledik
                            
                           s.print();
                        }
          }else{
             System.out.println("You entered incorrectly, please try again."); 
          }
          
          
          }
          }

        }/*müşteri menüsü için basket adında arraylist oluşturup kullanıcı seçtiği ürünlerin id si ile bu listeye alma
          istediği ürünleri ekleyecek. son olarak tutar adında bir değişken oluşturup for-each döngüsü ile
          liste içindeki ürünlerin fiyat bilgisini tutara ekleyeceğim böylece toplam ödemesi gereken tutar ortaya çıkacak
          ürün silme işleminide laptop ta ki ürün silme işlemi ile aynı mantıktan yapacağız.*/
        }else if(entry ==2){ // Customer menü yazılacak
            while(true){
                System.out.println("\n1 - add laptop to basket\n2 - add phone to basket\n3 - list basket\n4 - remove product\n0 - exit");
                Integer Cfirst = input.nextInt();
                
                if(Cfirst == 0){
                    break;
                }else if(Cfirst == 1){
                    System.out.println("musteri menu");
                   System.out.println("Laptop");
                   System.out.printf("%1s%20s%20s%20s\n", "| ID", "| NAME", "| PRICE", "| BRAND");
                   for(laptop l: laptops.values()){ // laptop ürünlerini listeledik    
                        l.print();
                  }
           
                System.out.println("\nEnter the product ID you want to buy : "); 
                String proId = input.next().toLowerCase();
                basket.add(laptops.get(proId).toPrint());
                sum.add(laptops.get(proId).getAmount());
                System.out.println("Laptop add basket...");

                }else if(Cfirst == 2){
                    System.out.println("phone");
                    System.out.printf("%1s%20s%20s%20s\n", "| ID", "| NAME", "| PRICE", "| BRAND");
                    for(phone p: phones.values()){ // telefon ürünlerini listeledik 
                      p.print();
                          }
                   System.out.println("\nEnter the product ID you want to buy : "); 
                   String proId = input.next().toLowerCase();
                   basket.add(phones.get(proId).toPrint());
                   sum.add(phones.get(proId).getAmount());
                   System.out.println("phone add basket..."); 
                  
                }else if(Cfirst ==3){
                    sumBasket = 0;
                    for(Object c: sum){                       
                        sumBasket += (double)c;
                    }
                    for(String s: basket){
                    System.out.println(s);
                }
                    System.out.println("Number of products in the basket : " + basket.size());
                    System.out.println("Total amount of products in the basket  " + sumBasket);
                }else if(Cfirst == 4){
                    Integer index = 0;
                     sumBasket = 0;
                     for(Object c: sum){
                        sumBasket += (double)c;
                    }
                    for(String s: basket){  
                    System.out.println("index no : " + index + " -> " + s);
                    index++;
                }
                    System.out.println("Number of products in the basket : " + basket.size());
                    if(basket.size() == 0){
                        sumBasket = 0;
                    }
                    System.out.println("Total amount of products in the basket  " + sumBasket);
                    System.out.println("\nEnter the product index number you want remove : ");
                    int a = input.nextInt();  // silmek istediği index numarasını aldık
                    basket.remove(a);   // alış veriş sepetinden sildik
                    sum.remove(a);      // silinen ürünün fiyatı fiyat listesinden çıkardık
                    sumBasket = 0;
                     for(Object c: sum){
                        sumBasket += (double)c;
                    }
                    for(String s: basket){                  
                    System.out.println(s);
                    
                }
                    System.out.println("Number of products in the basket : " + basket.size());
                    System.out.println("Total amount of products in the basket  " + sumBasket);
                }
            }
        }
        }
    }
}
      
    
