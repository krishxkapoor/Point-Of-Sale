import com.mashape.unirest.http.Unirest;
import com.vmm.JHTTPServer;
import java.io.IOException;
import java.sql.*;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;

public class myserver extends JHTTPServer{
    @Override
    public Response serve (String uri , String method , Properties header , Properties parms , Properties files)
    {
        if (uri.equals("/AdminLogin")){
            String ans = "";
            System.out.println("In AdminLogin Server");
            try{
            String email = parms.getProperty("email");
            String password = parms.getProperty("pass");
            ResultSet rs = DBLoader.executeQuery("select * from admin where email='"+email+"' and password = '"+password+"'");
            if(rs.next()){
                ans="Succes";
                Global.email=email;
            }
            else{
                ans="fail";
            }
            }catch(Exception e){
                 e.printStackTrace();
            }
            Response res = new Response(HTTP_OK,"text/plain", ans);
            return res;
        }
        else if(uri.equals("/addcat")){
            String ans="";
            try {
                String name=parms.getProperty("name");
                String desc=parms.getProperty("desc");
                String photo=saveFileOnServerWithRandomName(files, parms, "photo", "src/myuploads/");
                
                ResultSet rs=DBLoader.executeQuery("select * from categories where name='"+name+"'");
                if(rs.next()){
                 ans="fail";
                }
                else{
                    rs.moveToInsertRow();
                    rs.updateString("name", name);
                    rs.updateString("description", desc);
                    rs.updateString("photo", "src/myuploads/"+photo);
                    rs.insertRow();
                    ans="success";  
                }
            } catch (SQLException ex) {
                ex.printStackTrace();
                ans=ex.toString();
            }
            Response res=new Response(HTTP_OK,"text/plain", ans);
            return res; 
        }
        else if(uri.equals("/addprod")){
            String ans="";
            try {
            String name = parms.getProperty("name");
            String description = parms.getProperty("description");
            int price = Integer.parseInt( parms.getProperty("price"));
            int quantity = Integer.parseInt(parms.getProperty("quantity"));
            String cat=parms.getProperty("cat");
            String photo=saveFileOnServerWithRandomName(files, parms, "photo", "src/myuploads/");
            
            ResultSet rs = DBLoader.executeQuery("select * from products where name='"+name+"'");
            
                if(rs.next()){
                    ans = "fail";
                }
                else{
                    rs.moveToInsertRow();
                    rs.updateString("name",name);
                    rs.updateString("description",description);
                    rs.updateInt("price",price);
                    rs.updateInt("quantity",quantity);
                    rs.updateString("catname", cat);
                    rs.updateString("photo","src/myuploads"+photo);
                    rs.insertRow();
                    ans="success";
                }
            } catch (Exception ex) {
                ex.printStackTrace();
                ans=ex.toString();
            }
            Response res = new Response(HTTP_OK,"text/plain",ans);
            return res;

        }
        else if(uri.equals("/getCategory")){
            String ans = "";
            try{
                ResultSet rs = DBLoader.executeQuery("select * from categories");
                while(rs.next()){
                    String name = rs.getString("name");
                    String description = rs.getString("description");
                    String photo = rs.getString("photo");
                    String row = name+";;"+description+";;"+photo;
                    ans +=row+"$";
                }
            }catch(Exception ex){
                ex.printStackTrace();
                ans=ex.toString();
            }
            Response res = new Response(HTTP_OK, "text/plain", ans);
            return res;
        }
        else if(uri.equals("/getproduct")){
            String ans="";
            try{
                ResultSet rs = DBLoader.executeQuery("select * from products");
                while(rs.next()){
                String name = rs.getString("name");
                String catname = rs.getString("catname");
                String description = rs.getString("description");
                int price = Integer.parseInt( rs.getString("price"));
                int quantity =  Integer.parseInt(rs.getString("quantity"));
                String photo = rs.getString("photo");
                String row = name+";;"+catname+";;"+description+";;"+price+";;"+quantity+";;"+photo;
                ans +=row+"$";
                }
            }catch(Exception ex){
                ex.printStackTrace();
                ans=ex.toString();
            }
            Response res = new Response(HTTP_OK,"text/plain",ans);
            return res;
        }
        else if(uri.equals("/pay")){
            String ans="";
            int bid=0;
            String number=parms.getProperty("number");
            String type=parms.getProperty("type");
            int total=Global.gtotal;
            ResultSet rs=DBLoader.executeQuery("select * from bill");
            try {
                rs.moveToInsertRow();
                rs.updateString("number", number);
                rs.updateString("type", type);
                rs.updateInt("total", total);
                rs.insertRow();

                ResultSet rs2=DBLoader.executeQuery("select MAX(id) as max_id from bill");
                if(rs2.next()){
                    bid=rs2.getInt("max_id");
                }
                ResultSet rs3=DBLoader.executeQuery("select * from cart");
                ResultSet rs4=DBLoader.executeQuery("select * from bill_detail");
                while(rs3.next()){
                    int pid=rs3.getInt("pid");
                    int quantity=rs3.getInt("quantity");
                    int price=rs3.getInt("price");
                    rs4.moveToInsertRow();
                    rs4.updateInt("pid", pid);
                    rs4.updateInt("quantity", quantity);
                    rs4.updateInt("price", price);
                    rs4.updateInt("bid", bid);
                    rs4.insertRow();
                    
                    rs3.deleteRow();
                    
                    ResultSet rs5=DBLoader.executeQuery("select * mngproducts where id='"+pid+"'");
                    if(rs5.next()){
                        String quantity1=rs5.getString("quantity");
                        int quantity2=Integer.parseInt(quantity1);
                        int quantity3=quantity2-quantity;
                        String quantity4 =quantity3+"";
                        rs5.updateString("quantity", quantity4);
                        rs5.updateRow();
                    }
                   ans="success"; 
                }
                
            } catch (SQLException ex) {
                ex.printStackTrace();
                ans = ex.toString();
            }
            Response res=new Response(HTTP_OK, "text/plain", ans);
             return res;
        }
        else if(uri.equals("/changePass")){
            String ans="";
            String pass=parms.getProperty("oldPf");
            String newpass=parms.getProperty("newPf");
            String email=Global.email;
            try{
                ResultSet rs = DBLoader.executeQuery("select * from admin where email='"+email+"' and password ='"+pass+"'");
                if(rs.next())
                {
                    rs.moveToCurrentRow();
                    rs.updateString("password", newpass);
                    rs.updateRow();
                    ans="success";
                }
                else{
                    ans="fail";
                }
                
            }catch(Exception ex){
                ex.printStackTrace();
                ans=ex.toString();
            }
            Response res = new Response(HTTP_OK, "text/plain", ans);
            return res;
        }
        
          else if(uri.equals("/getproductbill")){
            String ans="";
            String cname=parms.getProperty("name");
            try{
                ResultSet rs = DBLoader.executeQuery("select * from products where catname='"+cname+"'");
                while(rs.next()){
                String name = rs.getString("name");
                String catname = rs.getString("catname");
                String description = rs.getString("description");
                int price = Integer.parseInt( rs.getString("price"));
                int quantity =  Integer.parseInt(rs.getString("quantity"));
                String photo = rs.getString("photo");
                String row = name+";;"+catname+";;"+description+";;"+price+";;"+quantity+";;"+photo;
                ans +=row+"$";
                }
            }catch(Exception ex){
                ex.printStackTrace();
                ans=ex.toString();
            }
            Response res = new Response(HTTP_OK,"text/plain",ans);
            return res;
        }
          
          else if(uri.equals("/bill")){
              String ans = "";
              ResultSet rs = DBLoader.executeQuery("select * from bill");
              try{
                  while(rs.next()){
                      int id = rs.getInt("id");
                      String number = rs.getString("number");
                      String type = rs.getString("type");
                      int total = rs.getInt("total");
                      String row = id+";;"+number+";;"+type+";;"+total;
                      ans +=row+"$";
                  }
              }catch(Exception ex){
                  ex.printStackTrace();
                  ans=ex.toString();
              }
              Response res = new Response(HTTP_OK,"text/plain",ans);
              return res;
          }
        
        else{
           return null; 
        }
    }
//    FOR SERVER ON OFF 
    public myserver(int port) throws IOException {
        super(port);
    } 
}        