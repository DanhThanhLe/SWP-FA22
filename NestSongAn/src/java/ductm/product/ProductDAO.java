/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ductm.product;

import ductm.category.CategoryDTO;
import ductm.utils.DBHelper;
import java.io.Serializable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.naming.NamingException;

/**
 *
 * @author minhd
 */
public class ProductDAO implements Serializable {

    public List<ProductDTO> getAllProduct() throws SQLException {
        Connection conn = null;
        PreparedStatement stm = null;
        ResultSet rs = null;
        List<ProductDTO> list = new ArrayList<>();
        try {
            conn = DBHelper.getConnection();
            if (conn != null) {
                String sql = "Select * "
                        + "From tblProduct "
                        + "Where status = 'true'";

                stm = conn.prepareStatement(sql);
                rs = stm.executeQuery();
                while (rs.next()) {
                    String productID = rs.getString("ProductID");
                    String productName = rs.getString("ProductName");
                    String categoryID = rs.getString("CategoryID");
                    float price = rs.getFloat("Price");
                    String unit = rs.getString("Unit");
                    String productImage = rs.getString("ProductImage");
                    ProductDTO dto = new ProductDTO(productID, productName, categoryID, price, unit, productImage);
                    list.add(dto);
                }
            }
        } catch (Exception e) {
        } finally {
            if (rs != null) {
                rs.close();
            }
            if (stm != null) {
                stm.close();
            }
            if (conn != null) {
                stm.close();
            }
        }
        return list;
    }

    public ArrayList<ProductDTO> searchProduct(String productName) throws SQLException, ClassNotFoundException {
        Connection con = null;
        PreparedStatement stm = null;
        ResultSet rs = null;
        try {
            con = DBHelper.getConnection();
            if (con != null) {
                String sql = "Select * "
                        + "From tblProduct "
                        + "Where ProductName Like ?";
                stm = con.prepareStatement(sql);
                stm.setString(1, "%" + productName + "%");
                ArrayList<ProductDTO> list = new ArrayList<>();
                rs = stm.executeQuery();
                while (rs.next()) {

                    productName = rs.getString("ProductName");
                    String categoryID = rs.getString("CategoryID");
                    float price = rs.getFloat("Price");
                    String unit = rs.getString("Unit");
                    String productImage = rs.getString("ProductImage");
                    ProductDTO o = new ProductDTO(productImage, productName, categoryID, price, unit, productImage);
                    list.add(o);
                }
                return list;
            }
        } finally {
            if (rs != null) {
                rs.close();
            }
            if (stm != null) {
                stm.close();
            }
            if (con != null) {
                con.close();
            }
        }
        return null;
    }

    public ProductDTO newProduct() throws SQLException, ClassNotFoundException {
        Connection conn = null;
        PreparedStatement stm = null;
        ResultSet rs = null;
        try {
            conn = DBHelper.getConnection();
            if (conn != null) {
                String sql = "select top 1 * from tblProduct "
                        + "where status = 'True' "
                        + "order by ProductID desc";
                stm = conn.prepareStatement(sql);
                rs = stm.executeQuery();
                while (rs.next()) {
                    String productID = rs.getString("ProductID");
                    String productName = rs.getString("ProductName");
                    String categoryID = rs.getString("CategoryID");
                    float price = rs.getFloat("Price");
                    String unit = rs.getString("Unit");
                    String productImage = rs.getString("ProductImage");
                    return new ProductDTO(productID, productName, categoryID, price, unit, productImage);

                }
            }
        } catch (Exception e) {
        } finally {
            if (rs != null) {
                rs.close();
            }
            if (stm != null) {
                stm.close();
            }
            if (conn != null) {
                stm.close();
            }
        }
        return null;
    }

    public List<ProductDTO> getProductByCID(String cid) throws SQLException {
        Connection conn = null;
        PreparedStatement stm = null;
        ResultSet rs = null;
        List<ProductDTO> list = new ArrayList<>();
        try {
            conn = DBHelper.getConnection();
            if (conn != null) {
                String sql = "Select * "
                        + "From tblProduct "
                        + "Where CategoryID = ?";

                stm = conn.prepareStatement(sql);
                stm.setString(1, cid);
                rs = stm.executeQuery();
                while (rs.next()) {
                    String productID = rs.getString("ProductID");
                    String productName = rs.getString("ProductName");
                    float price = rs.getFloat("Price");
                    String unit = rs.getString("Unit");
                    String productImage = rs.getString("ProductImage");
                    ProductDTO dto = new ProductDTO(productID, productName, cid, price, unit, productImage);
                    list.add(dto);
                }
            }
        } catch (Exception e) {
        } finally {
            if (rs != null) {
                rs.close();
            }
            if (stm != null) {
                stm.close();
            }
            if (conn != null) {
                stm.close();
            }
        }
        return list;
    }

    public static ProductDTO getProductByID(String id) throws SQLException {
        Connection conn = null;
        PreparedStatement stm = null;
        ResultSet rs = null;
        try {
            conn = DBHelper.getConnection();
            if (conn != null) {
                String sql = "Select * "
                        + "From tblProduct "
                        + "Where ProductID = ?";

                stm = conn.prepareStatement(sql);
                stm.setString(1, id);
                rs = stm.executeQuery();
                while (rs.next()) {
                    String productID = rs.getString("ProductID");
                    String productName = rs.getString("ProductName");
                    float price = rs.getFloat("Price");
                    String unit = rs.getString("Unit");
                    String productImage = rs.getString("ProductImage");
                    return new ProductDTO(productID, productName, id, price, unit, productImage);

                }
            }
        } catch (Exception e) {
        } finally {
            if (rs != null) {
                rs.close();
            }
            if (stm != null) {
                stm.close();
            }
            if (conn != null) {
                stm.close();
            }
        }
        return null;
    }

    public ProductDescriptionDTO getDes(String id) throws SQLException {
        Connection conn = null;
        PreparedStatement stm = null;
        ResultSet rs = null;
        try {
            conn = DBHelper.getConnection();
            if (conn != null) {
                String sql = "select * "
                        + "from tblProductDescription "
                        + "where ProductID = ?";

                stm = conn.prepareStatement(sql);
                stm.setString(1, id);
                rs = stm.executeQuery();
                while (rs.next()) {
                    String productID = rs.getString("ProductID");
                    String Weight = rs.getString("Weight");
                    String Type = rs.getString("Type");
                    String Specific = rs.getString("Specific");
                    String Smell = rs.getString("Smell");
                    String Preserve = rs.getString("Preserve");
                    return new ProductDescriptionDTO(productID, Weight, Type, Specific, Smell, Preserve);

                }
            }
        } catch (Exception e) {
           
        } finally {
            if (rs != null) {
                rs.close();
            }
            if (stm != null) {
                stm.close();
            }
            if (conn != null) {
                stm.close();
            }
        }
        return null;
    }
    public void deleteProduct(String pid) throws SQLException{
        Connection conn = null;
        PreparedStatement stm = null;
        ResultSet rs = null;
        try {
            conn = DBHelper.getConnection();
            if(conn!=null){
                String sql="Update tblProduct\n"
                        + "set status = 'false' "
                        + "where ProductID =?";
                stm = conn.prepareStatement(sql);
                stm.setString(1, pid);
                stm.executeUpdate();
            }
        }catch(Exception e){
            System.out.println(e.toString());
        }finally {
            if (rs != null) {
                rs.close();
            }
            if (stm != null) {
                stm.close();
            }
            if (conn != null) {
                stm.close();
            }
        }
    }
    
    public void insertProduct(String name, String category, String price, String unit, String image) throws SQLException{
        Connection conn = null;
        PreparedStatement stm = null;
        ResultSet rs = null;
        try {
            conn = DBHelper.getConnection();
            if(conn!=null){
                String sql="Insert tblProduct\n"
                        + "(ProductName, CategoryID, Price, Unit, ProductImage)\n"
                        + "values(?,?,?,?,?)";
                stm = conn.prepareStatement(sql);
                stm.setString(1, name);
                stm.setString(2, category);
                stm.setString(3, price);
                stm.setString(4, unit);
                stm.setString(5, image);
                stm.executeUpdate();
            }
        }catch(Exception e){
            System.out.println(e.toString());
        }finally {
            if (rs != null) {
                rs.close();
            }
            if (stm != null) {
                stm.close();
            }
            if (conn != null) {
                stm.close();
            }
        }
    }
    
    public void editProduct(String name, String category, String price, String unit, String image, String pid) throws SQLException{
        Connection conn = null;
        PreparedStatement stm = null;
        ResultSet rs = null;
        try {
            conn = DBHelper.getConnection();
            if(conn!=null){
                String sql = "Update tblProduct\n"
                        + "set ProductName = ?,\n"
                        + "CategoryID = ?,\n"
                        + "Price = ?,\n"
                        + "Unit = ?,\n"
                        + "ProductImage = ?\n"
                        + "where ProductID = ?";
                stm = conn.prepareStatement(sql);
                stm.setString(1, name);
                stm.setString(2, category);
                stm.setString(3, price);
                stm.setString(4, unit);
                stm.setString(5, image);
                stm.setString(6, pid);
                stm.executeUpdate();
            }
        }catch(Exception e){
            System.out.println(e.toString());
        }finally{
            if (rs != null) {
                rs.close();
            }
            if (stm != null) {
                stm.close();
            }
            if (conn != null) {
                stm.close();
            }
        }
    }
    
   
    
     public int getLastProductID() throws NamingException, SQLException, ClassNotFoundException{
        Connection conn = null;
        PreparedStatement stm = null;
        ResultSet rs = null;
        try {
            conn = DBHelper.getConnection();
            if (conn != null){
                String sql = "Select top 1 ProductID "
                        + "From tblProduct "
                        + "Order By ProductID Desc";
                        
                stm = conn.prepareStatement(sql);
                rs = stm.executeQuery();
                if(rs.next()){
                    return rs.getInt("ProductID");
                }
                
            }
        }finally{
            if ( rs != null){
                rs.close();
            }
            if ( stm !=null){
                stm.close();
            }
            if ( conn != null){
                conn.close();
            }
        }
        return 0;
        
    }
}
