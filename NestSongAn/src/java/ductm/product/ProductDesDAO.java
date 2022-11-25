/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ductm.product;

import ductm.utils.DBHelper;
import java.io.Serializable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author minhd
 */
public class ProductDesDAO implements Serializable{
    public void insertDetail(int ID, String weight, String type, String specific, String smell, String preserve) throws SQLException{
        Connection conn = null;
        PreparedStatement stm = null;
        ResultSet rs = null;
        try {
            conn = DBHelper.getConnection();
            if(conn!=null){
                String sql="Insert tblProductDescription\n"
                        + "(productID, Weight, Type, Specific, Smell, Preserve)\n"
                        + "values(?,?,?,?,?,?)";
                stm = conn.prepareStatement(sql);
                stm.setInt(1, ID);
                stm.setString(2, weight);
                stm.setString(3, type);
                stm.setString(4, specific);
                stm.setString(5, smell);
                stm.setString(6, preserve);
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
    public static ProductDescriptionDTO getProductDetailByID(String id) throws SQLException {
        Connection conn = null;
        PreparedStatement stm = null;
        ResultSet rs = null;
        try {
            conn = DBHelper.getConnection();
            if (conn != null) {
                String sql = "Select * "
                        + "From tblProductDescription "
                        + "Where ProductID = ?";

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
     public void editProductDetail(String pid ,String weight, String type, String smell, String specific, String preserve) throws SQLException{
        Connection conn = null;
        PreparedStatement stm = null;
        ResultSet rs = null;
        try {
            conn = DBHelper.getConnection();
            if(conn!=null){
                String sql = "Update tblProductDescription\n"
                        + "set Weight = ?,\n"
                        + "Type = ?,\n"
                        + "Smell = ?,\n"
                        + "Specific = ?,\n"
                        + "Preserve = ?\n"
                        + "where ProductID = ?";
                stm = conn.prepareStatement(sql);
                stm.setString(1, weight);
                stm.setString(2, type);
                stm.setString(3, smell);
                stm.setString(4, specific);
                stm.setString(5, preserve);
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
}
