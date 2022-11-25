/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import ductm.order.*;
import ductm.order.OrderDAO;
import ductm.order.OrderDTO;
import ductm.order.OrderDetailDTO;
import ductm.product.ProductDTO;
import ductm.product.ProductDAO;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author ACER
 */
@WebServlet(name = "OrderViewController", urlPatterns = {"/OrderViewController"})
public class OrderViewController extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        String op = request.getParameter("op");
        switch (op) {
            case "view_Order":
                getOrderList(request, response);
                break;
            case "view_Detail":
                getOrderDetailList(request, response);
                break;
        }

    }

    protected void getOrderList(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        OrderDAO orderDao = new OrderDAO();
        //OrderDAO orderDetailDao = new OrderDAO();
        List<OrderDTO> listOrder = new ArrayList<OrderDTO>();
        try {
            listOrder = orderDao.getAllOrders();
        } catch (SQLException ex) {
            Logger.getLogger(OrderViewController.class.getName()).log(Level.SEVERE, null, ex);
        }
        //OrderDetailDTO orderDetail = new OrderDetailDTO();
        //List<OrderDetailDTO>
        /*
            gọi tiếp hàm getOrderDetailByID để lấy orderdetail
            -->có đc danh sách orderDetail(của 1 order)
            sau đó làm thêm để giúp lấy đc dánh sách tên sp từ id sản phầm trong mảng orderdetail
            cái này để làm trong getOrderDetailByID sau
         */
        request.setAttribute("listOrder", listOrder);
        request.getRequestDispatcher("ViewOrder.jsp").forward(request, response);

    }

    protected void getOrderDetailList(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        int OrderID = Integer.parseInt(request.getParameter("OrderID"));
        System.out.println(OrderID);
        List<OrderDetailDTO> listDetail = new ArrayList<OrderDetailDTO>();
        List<String> listProductName = new ArrayList<String>();
        OrderDAO orderDao = new OrderDAO();
        try {
            listDetail = orderDao.getOrderDetailsByID(OrderID);
//            for (OrderDetailDTO orderDetailDTO : listDetail) {
//                String name = getProductNameByID(orderDetailDTO.getProductID());
//                listProductName.add(name);
//            }
        } catch (SQLException ex) {
            Logger.getLogger(OrderViewController.class.getName()).log(Level.SEVERE, null, ex);
        }
        request.setAttribute("listDetail", listDetail);
        //request.setAttribute("listProductName",listProductName);
        request.getRequestDispatcher("ViewOrderDetail.jsp").forward(request, response);//cái này để dẫn đường sau
    }

//    protected String getProductNameByID(int productID)
//            throws SQLException {
//        ProductDAO productDao = new ProductDAO();
//        try {
//            String name = productDao.getProductNameByID(productID);
//            return name;
//        } catch (Exception e) {
//        }
//        return null;
//    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
