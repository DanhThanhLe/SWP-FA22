/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ductm.report;

import ductm.utils.DBHelper;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author minhd
 */
public class ReportDAO {

    public ReportDAO() {

    }

    public Map<String, ReportDTO> thongKeTheoTuan(String tuan, String text) {
        ArrayList<String> list = danhSachKhoangNgayTheoTuan(tuan, text);
        return thongKeTheoKhoanNgay(list.get(0), list.get(1));
    }

    public ArrayList<String> danhSachKhoangNgayTheoTuan(String tuan, String text) {
        int week = Integer.parseInt(tuan);
        String year = text.substring(0, text.indexOf("-"));
        String month = text.substring(text.indexOf("-") + 1, text.length());
        ArrayList<String> list = new ArrayList<>();
        switch (week) {
            case 1:
                list.add(year + "-" + month + "-" + 1);
                list.add(year + "-" + month + "-" + 7);
                break;
            case 2:
                list.add(year + "-" + month + "-" + 8);
                list.add(year + "-" + month + "-" + 14);
                break;
            case 3:
                list.add(year + "-" + month + "-" + 15);
                list.add(year + "-" + month + "-" + 21);
                break;
            case 4:
                list.add(year + "-" + month + "-" + 22);
                list.add(year + "-" + month + "-" + 31);
                break;
            default:
                break;
        }
        return list;
    }

    public Map<String, ReportDTO> thongKeTheoKhoanNgay(String dateStart, String dateEnd) {
        Map<String, ReportDTO> map = new HashMap<>();
        Connection conn = null;
        PreparedStatement stm = null;
        ResultSet rs = null;
        try {
            conn = DBHelper.getConnection();
            String sql = "select * \n"
                    + " from tblOrders full join tblOrderDetails \n"
                    + " on tblOrders.OrderID = tblOrderDetails.OrderID\n"
                    + " where OrderDate>='" + dateStart + "'and OrderDate<='" + dateEnd + "'";
            stm = conn.prepareStatement(sql);
            rs = stm.executeQuery();
            while (rs.next()) {
                String ID = rs.getString("OrderID");
                String date = rs.getString("OrderDate");
                float total = rs.getFloat("Total");
                String quantity = rs.getString("Quantity");
                String pid = rs.getString("ProductID");
                map.put(ID, new ReportDTO(ID, date, total, quantity, pid));
            }
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Loi thong ke theo thang");
        }
        return map;

    }

    public Map<String, ReportDTO> thongKeTheoNgay(String date) {
        Map<String, ReportDTO> map = new HashMap<>();
        Connection conn = null;
        PreparedStatement stm = null;
        ResultSet rs = null;
        try {
            conn = DBHelper.getConnection();
            String sql = "select * \n"
                    + " from tblOrders full join tblOrderDetails \n"
                    + " on tblOrders.OrderID = tblOrderDetails.OrderID\n"
                    + " where OrderDate>='" + date + "'";
            stm = conn.prepareStatement(sql);
            rs = stm.executeQuery();
            while (rs.next()) {
                String ID = rs.getString("OrderID");
                date = rs.getString("OrderDate");
                float total = rs.getFloat("Total");
                String quantity = rs.getString("Quantity");
                String pid = rs.getString("ProductID");
                map.put(ID, new ReportDTO(ID, date, total, quantity, pid));
            }
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Loi thong ke theo ngay");
        }
        return map;
    }

    public Map<String, ReportDTO> thongKeTheoNgayHeThong() {
        Date toDate = new Date(System.currentTimeMillis());
        SimpleDateFormat fomatTime = new SimpleDateFormat("yyyy-MM-dd");
        String date = fomatTime.format(toDate.getTime());
        Connection conn = null;
        PreparedStatement stm = null;
        ResultSet rs = null;
        Map<String, ReportDTO> map = new HashMap<>();
        try {
            conn = DBHelper.getConnection();
            String sql = "select * \n"
                    + " from tblOrders full join tblOrderDetails \n"
                    + " on tblOrders.OrderID = tblOrderDetails.OrderID\n"
                    + " where OrderDate>='" + date + "'";
            stm = conn.prepareStatement(sql);
            rs = stm.executeQuery();
            while (rs.next()) {
                String ID = rs.getString("OrderID");
                String Orderdate = rs.getString("OrderDate");
                float total = rs.getFloat("Total");
                String quantity = rs.getString("Quantity");
                String pid = rs.getString("ProductID");
                map.put(ID, new ReportDTO(ID, Orderdate, total, quantity, pid));
            }
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Loi thong ke theo ngay");
        }
        return map;
    }

    public Map<String, ReportDTO> thongKeTheoThang(String text) {
        String year = text.substring(0, text.indexOf("-"));
        String month = text.substring(text.indexOf("-") + 1, text.length());

        Map<String, ReportDTO> map = new HashMap<>();
        Connection conn = null;
        PreparedStatement stm = null;
        ResultSet rs = null;
        try {
            conn = DBHelper.getConnection();
            String sql = "select * \n"
                    + " from tblOrders full join tblOrderDetails \n"
                    + " on tblOrders.OrderID = tblOrderDetails.OrderID\n"
                    + " where year(OrderDate)='" + year + "'and month(OrderDate)='" + month + "'";
            stm = conn.prepareStatement(sql);
            rs = stm.executeQuery();
            while (rs.next()) {
                String ID = rs.getString("OrderID");
                String date = rs.getString("OrderDate");
                float total = rs.getFloat("Total");
                String quantity = rs.getString("Quantity");
                String pid = rs.getString("ProductID");
                map.put(ID, new ReportDTO(ID, date, total, quantity, pid));
            }
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println(e.toString());
            System.out.println("Loi thong ke theo thang");
        }
        return map;
    }
 

    public Map<String, ReportDTO> thongKeTheoThangHeThong() {
        Date toDate = new Date(System.currentTimeMillis());
        SimpleDateFormat fomatTime = new SimpleDateFormat("yyyy-MM-dd");
        String date = fomatTime.format(toDate.getTime());

        String year = date.substring(0, date.indexOf("-"));
        String month = date.substring(date.indexOf("-") + 1, date.lastIndexOf("-"));
        Connection conn = null;
        PreparedStatement stm = null;
        ResultSet rs = null;
        Map<String, ReportDTO> map = new HashMap<>();
        try {
            conn = DBHelper.getConnection();
            String sql = "select * \n"
                    + " from tblOrders full join tblOrderDetails \n"
                    + " on tblOrders.OrderID = tblOrderDetails.OrderID\n"
                    + " where year(OrderDate)='" + year + "'and month(OrderDate)='" + month + "'";
            stm = conn.prepareStatement(sql);
            rs = stm.executeQuery();
            while (rs.next()) {
                String ID = rs.getString("OrderID");
                date = rs.getString("OrderDate");
                float total = rs.getFloat("Total");
                String quantity = rs.getString("Quantity");
                String pid = rs.getString("ProductID");
                map.put(ID, new ReportDTO(ID, date, total, quantity, pid));
            }
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Loi thong ke theo thang");
        }
        return map;
    }

    public static Map<String, ReportDTO> mapReport = loadDTB();

    public int layTongDoanhThuTheoNgay(String date) {
        int sum = 0;
        for (ReportDTO ts : mapReport.values()) {
            if (ts.getDate().equals(date)) {
                sum += ts.getTotal();
            }
        }
        return sum;
    }

    public int layTongDoanhThuTheoThang(String text) {
        int sum = 0;
        Map<String, ReportDTO> mapTS = new ReportDAO().thongKeTheoThang(text);
        for (ReportDTO ts : mapTS.values()) {
            if (ts.getID().equals(mapReport.get(ts.getID()).getID())) {
                sum += ts.getTotal();
            }
        }
        return sum;
    }

    public int layTongDoanhThuTheoTuan(String tuan, String text) {
        Map<String, ReportDTO> mapTS = new ReportDAO().thongKeTheoTuan(tuan, text);
        int sum = 0;
        for (ReportDTO ts : mapTS.values()) {
            if (ts.getID().equals(mapReport.get(ts.getID()).getID())) {
                sum += ts.getTotal();
            }
        }
        return sum;
    }

    public int layTongDoanhThuTheoKhoangNgay(String dateStart, String dateEnd) {
        Map<String, ReportDTO> mapTS = new ReportDAO().thongKeTheoKhoanNgay(dateStart, dateEnd);
        int sum = 0;
        for (ReportDTO ts : mapTS.values()) {
            if (ts.getID().equals(mapReport.get(ts.getID()).getID())) {
                sum += ts.getTotal();
            }
        }
        return sum;
    }

    private static Map<String, ReportDTO> loadDTB() {
        Map<String, ReportDTO> map = new HashMap<>();
        Connection conn = null;
        PreparedStatement stm = null;
        ResultSet rs = null;
        try {
            conn = DBHelper.getConnection();
            String sql = "select * "
                    + "from tblOrders full join tblOrderDetails "
                    + "on tblOrders.OrderID = tblOrderDetails.OrderID";
            stm = conn.prepareStatement(sql);

            rs = stm.executeQuery();
            while (rs.next()) {
                String ID = rs.getString("OrderID");
                String date = rs.getString("OrderDate");
                float total = rs.getFloat("Total");
                String quantity = rs.getString("Quantity");
                String pid = rs.getString("ProductID");

                map.put(ID, new ReportDTO(ID, date, total, quantity, pid));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return map;
    }

}
