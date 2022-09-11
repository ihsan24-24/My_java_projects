/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package patika.JDBC;
import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Date;
/**
 *
 * @author hasan
 */
public class patikaSorgu {
   private Connection c;
   private Statement st;

    public patikaSorgu() {
    c = DriverManager.getConnection(""); /* hangi veri tabanının kullanılacağını bilmediğimden boş bıraktım 
    başka bir main classında patikaSorgu classı oluştuğunda veri tabanıyla bağlantıyı kurmuş olacak.*/
    st = c.createStatement();
    }
    
   
    public void urunYorum(String araId) throws SQLException{  // 1. soru - ürüne ait yorumları sıralayan method
    String query = "SELECT UrunYorum.Yorum, Urun.Adı FROM Urun INNER JOIN UrunYorum ON UrunYorum.urunId = "+ araId + " GROUP BY UrunYorum.urunId";
    ResultSet rst = st.executeQuery(query);
    while(rst.next()){
        System.out.println(rst.getString("Adı") + rst.getString("Yorum"));
    }
    }
    public void tarihArasiYorum(String urunId, String first, String end) throws SQLException{ // 2. soru - iki tarih arası bir ürüne yapılan yorumları gösterir.
    String query = "SELECT UrunYorum.Yorum, Urun.Adı FROM Urun INNER JOIN UrunYorum ON UrunYorum.urunId = "+ urunId + " WHERE UrunYorum.yorumTarihi BETWEEN " + first + " and " + end +" GROUP BY UrunYorum.urunId";
    ResultSet rst = st.executeQuery(query);
    while(rst.next()){
        System.out.println(rst.getString("Adı") + rst.getString("Yorum"));
    }
    }
    public void kullaniciYorum(String kId) throws SQLException{ // 3. soru - bir kullanıcının yapmış olduğu yorumları gösterir
        String query = "SELECT UrunYorum.Yorum, Kullanıcı.Adı FROM Kullanıcı INNER JOIN UrunYorum ON UrunYorum.kullaniciId = "+ kId + " GROUP BY UrunYorum.kullaniciId";
    ResultSet rst = st.executeQuery(query);
    while(rst.next()){
        System.out.println(rst.getString("Adı") + rst.getString("Yorum"));
    }
 
    }
    public void ktrhArasiYorum(String kId, String first, String end) throws SQLException{ // +. soru - iki tarih arası bir kullanıcının yapılan yorumlarını gösterir.
    String query = "SELECT UrunYorum.Yorum, Kullanıcı.Adı FROM Kullanıcı INNER JOIN UrunYorum ON UrunYorum.kullaniciId = "+ kId + " WHERE UrunYorum.yorumTarihi BETWEEN " + first + " and " + end +" GROUP BY UrunYorum.kullaniciId";
    ResultSet rst = st.executeQuery(query);
    while(rst.next()){
        System.out.println(rst.getString("Adı") + rst.getString("Yorum"));
        
    }
    }
    public void tarihEx() throws SQLException{  // 5. soru - son kullanma tarihi geçmiş ürünler
    SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
    Date tdy = new Date();
    String today;
    today = sdf.format(tdy);
    String query = "SELECT * FROM Urun WHERE SonKullanmaTarihi >" + today ;
    ResultSet rst = st.executeQuery(query);
    while(rst.next()){
        System.out.println(rst.getString("Adı") + rst.getDate("SonKullanmaTarihi"));
    }
    }
    public void tarihpossible() throws SQLException{  // 6. soru - son kullanma tarihi geçmemiş ürünler
    SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
    Date tdy = new Date();
    String today;
    today = sdf.format(tdy);
    String query = "SELECT * FROM Urun WHERE SonKullanmaTarihi <=" + today ;
    ResultSet rst = st.executeQuery(query);
    while(rst.next()){
        System.out.println(rst.getString("Adı") + rst.getDate("SonKullanmaTarihi"));
    }
    }
    }

