import com.mashape.unirest.http.*;
import com.mashape.unirest.http.exceptions.UnirestException;
import java.io.File;
import java.util.logging.Level;
import java.util.logging.Logger;

public class myClient {
    public static String AdminLogin (String Email , String Password){
        String ans = "";
        try{
        HttpResponse<String> res = Unirest.get("http://localhost:9000/AdminLogin")
                .queryString("email",Email)
                .queryString("pass",Password)
                .asString();
            ans=res.getBody();
        }catch(Exception e){
            e.printStackTrace();
        }
        return ans;
    }
    
    public static String addcat(String name,String desc,File photo){
        String ans="";
        try {
            HttpResponse<String> res=Unirest.post("http://localhost:9000/addcat")
                    .queryString("name", name)
                    .queryString("desc", desc)
                    .field("photo", photo)
                    .asString();
            ans=res.getBody();
        } catch (UnirestException ex) {
            Logger.getLogger(myClient.class.getName()).log(Level.SEVERE, null, ex);
        }
        return ans;
    }
    
    public static String addprod(String name , String description , String price , String quantity , File photo ,String cat){
         String ans = "";

        try {
            HttpResponse<String> res = Unirest.post("http://localhost:9000/addprod")
                    .queryString("name", name)
                    .queryString("description", description)
                    .queryString("price", price)
                    .queryString("quantity", quantity)
                    .queryString("cat", cat)
                    .field("photo", photo)
                    .asString();
            ans = res.getBody();
            return ans;
        } catch (Exception ex) {
                ex.printStackTrace();
        }
        return ans;
    }
    
    public static String getcategory() {
        String ans = "";
        try{
            HttpResponse<String> res = Unirest.get("http://localhost:9000/getCategory")
                    .asString();
                ans  = res.getBody();
        }
        catch(Exception ex){
           ex.printStackTrace();
        }
        return ans;
        
    }
    
    public static String getproduct(){
         String ans="";
        try {
            HttpResponse<String> res = Unirest.get("http://localhost:9000/getproduct")
                    .asString();
            ans= res.getBody();
            
            
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return ans;
    }
    
    public static String pay(){
        String ans = "";
        HttpResponse<String> res;
        try {
            res = Unirest.get("http://localhost:9000/pay")
                    .asString();
            ans = res.getBody();

        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return ans;
    }
    public static String changePass(String newpass,String oldpass){
        String ans = "";
        HttpResponse<String> res;
        try{
                res = Unirest.get("http://localhost:9000/changePass")
                        .queryString("newPf", newpass)
                        .queryString("oldPf", oldpass)
                .asString();
            ans = res.getBody();
            }catch(Exception ex){
                ex.printStackTrace();
        }
        return ans;
    }
    
    
    
       public static String getproductbill(String name){
         String ans="";
        try {
            HttpResponse<String> res = Unirest.get("http://localhost:9000/getproductbill")
                    .queryString("name", name)
                    .asString();
            ans= res.getBody();
            
            
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return ans;
    }
    
       public static String bill(){
           String ans="";
           try{
               HttpResponse<String> res;
               res = Unirest.get("http://localhost:9000/bill")
                       .asString();
               ans=res.getBody();
           }catch(Exception ex){
               ex.printStackTrace();
           }
           return ans;
       }   
}