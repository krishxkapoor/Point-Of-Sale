
import java.sql.*;
import com.vmm.JHTTPServer;
import com.vmm.NanoHTTPD;
import static com.vmm.NanoHTTPD.HTTP_OK;
import java.io.IOException;
import java.sql.ResultSet;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;

public class myServer extends JHTTPServer{
    public Response serve (String uri , String method , Properties header , Properties parms , Properties files)
    {
        if (uri.equals("/AdminLogin"))
        {
            String ans = " ";
            try{
            String email = parms.getProperty("email");
            String password = parms.getProperty("password");
            ResultSet rs = DBLoader.executeQuery("select * from admin where email='"+email+"' and password = '"+password+"'");
            if(rs.next())
            {
                ans="Success";
            }
            else
            {
                ans="fail";
            }
            }catch(Exception e){
                e.printStackTrace();
            }
            Response res = new Response(HTTP_OK,"text/plain", ans);
            return res;
        }
        else if (uri.equals("/addcategory"))
        {
            
                String ans = "";
                String name = parms.getProperty("name");
                String desc = parms.getProperty("desc");
                String photo = saveFileOnServerWithRandomName(files, parms, "photo", "src/myuploads/");
                ResultSet rs = DBLoader.executeQuery("select * from categories where name ='"+name+"'");
                try {
                if (rs.next())
                {
                    ans= "fail";
                    
                }
                else
                {
                    rs.moveToInsertRow();
                    rs.updateString("name", name);
                    rs.updateString("discription", desc);
                    rs.updateString("Photo", "src/myuploads/"+photo);
                    rs.insertRow();
                    ans="success";
                    
                }
            } catch (SQLException ex) {
                Logger.getLogger(myServer.class.getName()).log(Level.SEVERE, null, ex);
            }
                 Response res = new Response(HTTP_OK,"text/plain", ans);
            return res;
                
        }
        else if (uri.equals("/getcategory"))
        {
            String ans = "";
            try
            {
                ResultSet rs = DBLoader.executeQuery("select * from categories");
                while (rs.next())
                {
                    String name = rs.getString("name");
                    String desc = rs.getString("discription");
                    String photo = rs.getString("photo");
                    String row = name+";;"+desc+";;"+photo;
                    ans+=row+"$";
                }
            }catch(Exception ex )
            {
                ex.printStackTrace();
            }
            Response res = new Response(HTTP_OK,"text/plain", ans);
            return res;
        }
        else if (uri.equals("/addproduct"))
        {
            String ans = "";
                String name = parms.getProperty("name");
                String desc = parms.getProperty("desc");
                String photo = saveFileOnServerWithRandomName(files, parms, "photo", "src/myuploads/");
                String price = parms.getProperty("price");
                String quantity = parms.getProperty("quantity");
                String cat=parms.getProperty("cat");
                ResultSet rs = DBLoader.executeQuery("select * from products where name ='"+name+"'");
                try {
                if (rs.next())
                {
                    ans= "fail";
                }
                else
                {
                    rs.moveToInsertRow();
                    rs.updateString("name", name);
                    rs.updateString("desc", desc);
                    rs.updateString("Photo", "src/myuploads/"+photo);
                    rs.updateString("price", price);
                    rs.updateString("catname", cat);
                    rs.updateString("quantity", quantity);
                    rs.insertRow();
                    ans="success";
                }
            } catch (SQLException ex) {
                Logger.getLogger(myServer.class.getName()).log(Level.SEVERE, null, ex);
            }
                Response res = new Response(HTTP_OK,"text/plain", ans);
            return res;
        }
        else if (uri.equals("/getproduct"))
        {
           
            String ans = "";
            try
            {
                ResultSet rs = DBLoader.executeQuery("select * from products ");
                while(rs.next())
                {
                    
                    String name = rs.getString("name");
                    String cat = rs.getString("catname");
                    String desc = rs.getString("desc");
                    String photo = rs.getString("photo");
                    String price = rs.getString("price");
                    String quantity = rs.getString("quantity");
                    String row = name+";;"+cat+";;"+desc+";;"+photo+";;"+price+";;"+quantity;
                    ans+=row+"$";
                }
            }catch(Exception ex )
            {
                ex.printStackTrace();
            }
            Response res = new Response(HTTP_OK,"text/plain", ans);
            return res;
        }
        else if (uri.equals("/getproductbill"))
        {
            String name2=parms.getProperty("name");
            String ans = "";
            try
            {
                ResultSet rs = DBLoader.executeQuery("select * from products where catname='"+name2+"'");
                while(rs.next())
                {
                    int id = rs.getInt("id");
                    String name = rs.getString("name");
                   
                    String photo = rs.getString("photo");
                    String price = rs.getString("price");
                    String quantity = rs.getString("quantity");
                    String row = name+";;"+price+";;"+quantity+";;"+photo+";;"+id;
                    ans+=row+"$";
                }
            }catch(Exception ex )
            {
                ex.printStackTrace();
            }
            Response res = new Response(HTTP_OK,"text/plain", ans);
            return res;
        }
        else if (uri.equals("/getcart"))
        {
            String ans = "";
            try
            {
                ResultSet rs = DBLoader.executeQuery("select p.name,c.* from products p inner join cart c on  p.id=c.pid;");
                while(rs.next())
                {
                    
                    String name = rs.getString("name");                    
                    
                    String quantity = rs.getString("quantity");
                    String price = rs.getString("price");
                    String row =name+";;"+quantity+";;"+price;
                    ans+=row+"$";
                }
            }catch(Exception ex )
            {
                ex.printStackTrace();
            }
            Response res = new Response(HTTP_OK,"text/plain", ans);
            return res;
        }
        else if (uri.equals("/checkquantity")) {
            String ans = "";

            String pname = parms.getProperty("name");
            int quant = Integer.parseInt(parms.getProperty("quantity"));

            ResultSet rs = DBLoader.executeQuery("select * from products where name = '" + pname + "' and quantity >= '" + quant + "' ");
            try {
                if (rs.next()) {
                    int currentQuantity = rs.getInt("quantity");
                    int newQuantity = currentQuantity - quant;

                    rs.updateInt("quantity", newQuantity);
                    rs.updateRow();

                    ans = "success";
                } else {
                    ans = "fail";
                }
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
            Response res = new Response(HTTP_OK, "text/plain", ans);
            return res;
        }
        else if(uri.equals("/addcart"))
                {
                    String ans = "";
            try {
                int pid = Integer.parseInt(parms.getProperty("pid"));
                String name = parms.getProperty("name");
                int qty = Integer.parseInt(parms.getProperty("qty"));
                int price = Integer.parseInt(parms.getProperty("price"));
                int uprice=qty*price;
                
                ResultSet rs = DBLoader.executeQuery("select * from cart");
                rs.moveToInsertRow();
                rs.updateInt("pid", pid);
               
                rs.updateInt("quantity",qty);
                rs.updateInt("price", uprice);
                rs.insertRow();
                ans = "success";

            } catch (SQLException ex) {
                Logger.getLogger(myServer.class.getName()).log(Level.SEVERE, null, ex);
            }
            NanoHTTPD.Response res = new NanoHTTPD.Response(HTTP_OK, "text/plain", ans);
            return res;
                    
                }
        else if (uri.equals("/adminchangepassword")) {
            String ans = "";
            String oldp = parms.getProperty("oldpass");
            String newp = parms.getProperty("newpass");
            System.out.println(Global.email + " Loggeg In Email");
            ResultSet rs = DBLoader.executeQuery("select * from admin where email ='" + Global.email + "' and pass ='" + oldp + "' ");

            try {
                if (rs.next()) {
                    rs.updateString("pass", newp);
                    rs.updateRow();

                    ans = "success";
                } else {
                    ans = "fail";
                }
            } catch (SQLException ex) {
                Logger.getLogger(myServer.class.getName()).log(Level.SEVERE, null, ex);
            }
            Response res = new Response(HTTP_OK, "text/plain", ans);
            return res;

        }
        else if(uri.equals("/pay"))
        {
            String ans="";
            int bid=0;
            String num=parms.getProperty("number");
            String type=parms.getProperty("type");
            int total = Integer.parseInt( parms.getProperty("total") );
            
//           int total=Global.gtotal;
           
            System.out.println("Total "+total);
            ResultSet rs=DBLoader.executeQuery("select * from booking");
            try {
                rs.moveToInsertRow();
                rs.updateString("number", num);
                rs.updateString("type", type);
                rs.updateInt("total", total);
                rs.insertRow();
                
                
                ResultSet rs2=DBLoader.executeQuery("select MAX(id) as max_id from booking");
                if(rs2.next())
                {
                    bid=rs2.getInt("max_id");
                }
                
                ResultSet rs3=DBLoader.executeQuery("select * from cart");
                ResultSet rs4=DBLoader.executeQuery("select * from booking_detail");
                while(rs3.next())
                {
                    int pid=rs3.getInt("pid");
                    int qty=rs3.getInt("quantity");
                    int price=rs3.getInt("price");
                    rs4.moveToInsertRow();
                    rs4.updateInt("pid", pid);
                    rs4.updateInt("qty", qty);
                    rs4.updateInt("price", price);
                    rs4.updateInt("bid", bid);
                    rs4.insertRow();
                    
                    
                    rs3.deleteRow();
                    
                    ResultSet rs5=DBLoader.executeQuery("select * from products where id='"+pid+"'");
                    if(rs5.next())
                    {
                        String quant=rs5.getString("quantity");
                        int quant1=Integer.parseInt(quant);
                        int quant3=quant1-qty;
                        String quant4 =quant3+"";
                        
                        rs5.updateString("quantity", quant4);
                        rs5.updateRow();
                    }
                    
                   ans="success"; 
                }
                
            } catch (SQLException ex) {
                ex.printStackTrace();
                
            }
            
            Response res=new Response(HTTP_OK, "text/plain", ans);
            return res;
        }
        else if (uri.equals("/booking"))
        {
            String ans = "";
            try
            {
                ResultSet rs = DBLoader.executeQuery("select * from booking");
                while(rs.next())
                {
                    int id = rs.getInt("id");
                    String num = rs.getString("number");
                    String type = rs.getString("type");
                    int total = rs.getInt("total");
                    String row =id+";;"+num+";;"+type+";;"+total;
                    ans+=row+"$";
                }
            }catch(Exception ex )
            {
                ex.printStackTrace();
            }
            Response res = new Response(HTTP_OK,"text/plain", ans);
            return res;
        }

        else if (uri.equals("/booking_detail"))
        {
            int id = Integer.parseInt(parms.getProperty("id"));
            
            String ans = "";
            try
            {
                ResultSet rs = DBLoader.executeQuery("SELECT p.name as pname,bd.* from booking_detail bd inner join products p on bd.pid='"+id+"'");
                while(rs.next())
                {
                    String pname = rs.getString("pname");
                    int qty = rs.getInt("qty");
                    
                    int price = rs.getInt("price");
                    String row =pname+";;"+qty+";;"+price;
                    ans+=row+"$";
                }
            }catch(Exception ex )
            {
                ex.printStackTrace();
            }
            Response res = new Response(HTTP_OK,"text/plain", ans);
            return res;
        }
        else if (uri.equals("/delcat"))
        {
            String name = parms.getProperty("id");
            
            String ans = "";
            try
            {
                ResultSet rs = DBLoader.executeQuery("select * from categories where name ='"+name+"'");
                if(rs.next())
                {
                    rs.deleteRow();
                    ans = "success";
                }
                else {
                    ans ="fail";
                }
            }catch(Exception ex )
            {
                ex.printStackTrace();
            }
            Response res = new Response(HTTP_OK,"text/plain", ans);
            return res;
        }
        else if (uri.equals("/delpro")) {
            String ans = "";
            try {
                String pname = parms.getProperty("pname");

                ResultSet rs = DBLoader.executeQuery("select * from products where pname='" + pname + "' ");
                if (rs.next()) {
                    rs.deleteRow();
                    ans = "success";
                }
            } catch (Exception e) {
                ans = e.toString();
                e.printStackTrace();
            }
            Response res = new Response(HTTP_OK, "text/plain", ans);
            return res;
        }
        else
        {
           return null; 
        }
    }
    
    public myServer(int port) throws IOException {
        super(port);
    }
    
}
