/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ductm.account;

import ductm.utils.DBHelper;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author HP
 */
public class AccountDAO {

    public AccountDTO checkLogin(String userID, String password) throws SQLException {

        Connection conn = null;
        PreparedStatement stm = null;
        ResultSet rs = null;
        try {
            conn = DBHelper.getConnection();
            if (conn != null) {
                String sql = "Select UserName, Password, FullName, Role from tblAccount where UserName = ? and Password = ? and Status = 'True' ";
                stm = conn.prepareStatement(sql);
                stm.setString(1, userID);
                stm.setString(2, password);
                rs = stm.executeQuery();
                if(rs.next()) {
                    return new AccountDTO(rs.getString(1),
                            rs.getString(2),
                            rs.getString(3),
                            rs.getString(4));
                        
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (rs != null) {
                rs.close();
            }
            if (stm != null) {
                stm.close();
            }
            if (conn != null) {
                conn.close();
            }
        }
        return null;
    }
      public AccountDTO checkAccountExist(String user) throws SQLException{
        Connection conn = null;
        PreparedStatement stm = null;
        ResultSet rs = null;
        try {
            conn = DBHelper.getConnection();
            if (conn != null) {
                String sql = "select * from tblAccount\n"
                        + "where UserName = ?\n";
                stm = conn.prepareStatement(sql);
                stm.setString(1, user);
                rs = stm.executeQuery();
                while(rs.next()){
                    return new AccountDTO(rs.getString(1),
                            rs.getString(2),
                            rs.getString(3),
                            rs.getString(4),
                            rs.getString(5),
                            rs.getString(6),
                            rs.getString(7));
                }
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
                conn.close();
            }
        }
        return null ;
    }
    
    public void signup(String username, String password, String fullName, String mail, String role, String phone) throws SQLException{
        Connection conn = null;
        PreparedStatement stm = null;
        ResultSet rs = null;
        try {
             conn = DBHelper.getConnection();
            if (conn != null) {
                String sql = "insert into tblAccount\n"
                        + "(UserName, Password, FullName, Mail, Role, PhoneNumber)\n"
                        + "values(?,?,?,?,?,?)";
                stm = conn.prepareStatement(sql);
                stm.setString(1, username);
                stm.setString(2, password);
                stm.setString(3, fullName);
                stm.setString(4, mail);
                stm.setString(5, role);
                stm.setString(6, phone);
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
                conn.close();
            }
        }
    }
    
    public void deleteAccount(String id) throws SQLException{
        Connection conn = null;
        PreparedStatement stm = null;
        ResultSet rs = null;
         try {
             conn = DBHelper.getConnection();
            if (conn != null) {
                String sql = "Update tblAccount\n"
                        + "set Status = 'False' "
                        + "where ID = ?";
                stm = conn.prepareStatement(sql);
                stm.setString(1, id);
                stm.executeUpdate();
            }
         }catch(Exception e){
             
         }finally{
            if (rs != null) {
                rs.close();
            }
            if (stm != null) {
                stm.close();
            }
            if (conn != null) {
                conn.close();
            }
        }
    }
    
    public void editAccount(String username, String password, String fullName, String mail, String role, String phone,String id) throws SQLException{
        Connection conn = null;
        PreparedStatement stm = null;
        ResultSet rs = null;
         try {
             conn = DBHelper.getConnection();
            if (conn != null) {
                String sql = "update tblAccount\n"
                        + "set UserName = ?,\n"
                        + "Password = ?,\n"
                        + "FullName = ?,\n"
                        + "Mail = ?,\n"
                        + "Role = ?,\n"
                        + "PhoneNumber = ?\n"
                        + "where ID = ?";
                stm = conn.prepareStatement(sql);
                stm.setString(1, username);
                stm.setString(2, password);
                stm.setString(3, fullName);
                stm.setString(4, mail);
                stm.setString(5, role);
                stm.setString(6, phone);
                stm.setString(7, id);
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
                conn.close();
            }
        }
    }
    
    public List<AccountDTO> getAllAccount() throws SQLException{
        List<AccountDTO> list = new ArrayList<>();
        Connection conn = null;
        PreparedStatement stm = null;
        ResultSet rs = null;
         try {
             conn = DBHelper.getConnection();
            if (conn != null) {
                String sql = "select * from tblAccount "
                        + "where Status = 'True'";
                stm = conn.prepareStatement(sql);
                rs = stm.executeQuery();
                while(rs.next()){
                    list.add(new AccountDTO(rs.getString(1),
                    rs.getString(2),
                    rs.getString(3),
                    rs.getString(4),
                    rs.getString(5),
                    rs.getString(6),
                    rs.getString(7)));
                }
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
                conn.close();
            }
        }
        return list;
    }
    
    public AccountDTO getAccountByID(String id) throws SQLException{
        Connection conn = null;
        PreparedStatement stm = null;
        ResultSet rs = null;
         try {
             conn = DBHelper.getConnection();
            if (conn != null) {
                String sql = "select * from tblAccount\n"
                        + "where ID = ?";
                stm = conn.prepareStatement(sql);
                stm.setString(1, id);
                rs = stm.executeQuery();
                while(rs.next()){
                    return new AccountDTO(rs.getString(1),
                            rs.getString(2),
                            rs.getString(3),
                            rs.getString(4),
                            rs.getString(5),
                            rs.getString(6),
                            rs.getString(7));
                }
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
                conn.close();
            }
        }
        return null;
    }
}
