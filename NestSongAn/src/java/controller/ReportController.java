/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import ductm.report.ReportDAO;
import ductm.report.ReportDTO;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;
import java.util.Map;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author minhd
 */
@WebServlet(name = "ReportController", urlPatterns = {"/ReportController"})
public class ReportController extends HttpServlet {

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
        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");

        String action = request.getParameter("action");
        if (action == null) {

        } else if (action.equals("TheoThang")) {
            String month = request.getParameter("thang");
            Map<String, ReportDTO> map = new ReportDAO().thongKeTheoThang(month);
            String okthang = "none";
            if (map.size() != 0) {
                okthang = "ok";
            }
            HttpSession session = request.getSession();
            session.setAttribute("okthang", okthang);
            session.setAttribute("month", month);
            response.sendRedirect("theothang.jsp");
        } else if (action.equals("TheoNgay")) {
            String ngay = request.getParameter("ngay");
            Map<String, ReportDTO> map = new ReportDAO().thongKeTheoNgay(ngay);
            String okngay = "none";
            if (map.size() != 0) {
                okngay = "ok";
            }
            HttpSession session = request.getSession();
            session.setAttribute("okngay", okngay);
            session.setAttribute("ngay", ngay);
            response.sendRedirect("theongay.jsp");
        } else if (action.equals("TheoTuan")) {
            String tuan = request.getParameter("tuan");
            String thang = request.getParameter("thangTheoTuan");
            Map<String, ReportDTO> map = new ReportDAO().thongKeTheoTuan(tuan, thang);
            String oktuan = "none";
            if (map.size() != 0) {
                oktuan = "ok";
            }
            HttpSession session = request.getSession();
            session.setAttribute("oktuan", oktuan);
            session.setAttribute("tuan", tuan);
            session.setAttribute("thangTheoTuan", thang);
            response.sendRedirect("theotuan.jsp");
        } else if (action.equals("KhoangNgay")) {
            String ngayBatDau = request.getParameter("ngayBatDau");
            String ngayKetThuc = request.getParameter("ngayKetThuc");
            Map<String, ReportDTO> map = new ReportDAO().thongKeTheoKhoanNgay(ngayBatDau, ngayKetThuc);
            String okkn = "none";
            if (map.size() != 0) {
                okkn = "ok";
            }
            HttpSession session = request.getSession();
            session.setAttribute("okkn", okkn);
            session.setAttribute("ngayBatDau", ngayBatDau);
            session.setAttribute("ngayKetThuc", ngayKetThuc);
            response.sendRedirect("theokhoangngay.jsp");
        }
    }

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
