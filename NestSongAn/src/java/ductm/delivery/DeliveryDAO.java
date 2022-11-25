/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ductm.delivery;

import ductm.utils.DBHelper;
import java.io.Serializable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 *
 * @author ACER
 */
public class DeliveryDAO implements Serializable{

    public static int addDelivery(int orderID, String deliName) throws SQLException, ClassNotFoundException {
        Connection conn = null;
        PreparedStatement stm = null;
        try {
             conn = DBHelper.getConnection();
//        boolean check = checkID(orderID);//check xem đã có đơn giao chưa
//        if (check == true) {//có rồi thì báo về controller để báo trùng
//            return 0;
//        } else {//chưa có thì tiến hành tạo đơn giao dưới db
            String sql = "INSERT tblDelivery(OrderID,DeliName) "
                    + "VALUES(?, ?)";
            
               
                stm = conn.prepareStatement(sql);
                stm.setInt(1, orderID);
                stm.setString(2, deliName);
                stm.executeUpdate();
        
            } catch (Exception e) {
                System.out.println(e.toString());
            } finally {
            }
            if (stm != null) {
                stm.close();
            }
            if (conn != null) {
                conn.close();
            }
          
        return 1;
    }

    public static boolean checkID(int orderID) throws SQLException {
        Connection conn = null;
        PreparedStatement stm = null;
        ResultSet rs = null;
        boolean check = true;
        try {
            conn = DBHelper.getConnection();
             String sql = "Select * "
                     + "from tblDelivery "
                     + "where OrderID = ?";
            stm = conn.prepareStatement(sql);
            stm.setInt(1, orderID);
            rs = stm.executeQuery();
            if ( rs == null) {
                check = false;
            }
        } catch (Exception e) {
                System.out.println(e.toString());
        } finally {
            rs.close();
            if (stm != null) {
                stm.close();
            }
            if (conn != null) {
                conn.close();
            }
        }
        return check;
    }
}
