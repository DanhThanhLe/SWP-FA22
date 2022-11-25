<%-- 
    Document   : ViewOrder
    Created on : Nov 12, 2022, 10:46:43 AM
    Author     : ACER
--%>

<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<%@page import="java.util.List"%>
<%@page import="ductm.order.OrderDTO"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
        <link href="//maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
        <script src="//maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"></script>
        <script src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
        <link href="css/style.css" rel="stylesheet" type="text/css"/>
        <link href="//maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
        <script src="//maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"></script>
        <script src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
        <!------ Include the above in your HEAD tag ---------->
        <link href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css" rel="stylesheet" integrity="sha384-wvfXpqpZZVQGK6TAh5PVlGOfQNHSoD2xbE+QkPxCAFlNEevoEH3Sl0sibVcOQVnN" crossorigin="anonymous">
        <link href="css/style.css" rel="stylesheet" type="text/css"/>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Hiển Thị Đơn Hàng</title>
    </head>
    <body>
        <div class="container">
            <br>
            <div class="row">

                <%
                    List<OrderDTO> listOrder = (List<OrderDTO>) request.getAttribute("listOrder");
                %>
               

                <!--            <div class="container">
                                <div class="row">-->
                 <div class="alert alert-secondary" role="alert">
                    ${message}
                </div>
                <table id="datatable-buttons" class="table table-striped table-bordered" border="1" cellspacing="1" cellpadding="10">
                    <thead>
                        <tr>
                            <th>Tên khách hàng</th>
                            <th>Email</th>
                            <th>SĐT nhận hàng</th>
                            <th>Địa chỉ nhận hàng</th>
                            <th>Ngày đặt hàng</th>
                            <th>Tổng tiền</th>
                            <th>Chi tiết</th>
                        </tr>
                    </thead>
                    <tbody>
                        <c:forEach items="${listOrder}" var="order">
                            <tr>
                                <td>
                                    <c:out value="${order.getName()}"></c:out>
                                    </td>
                                    <td>
                                    <c:out value="${order.getEmail()}"></c:out>
                                    </td>
                                    <td>
                                    <c:out value="${order.getPhoneNumber()}"></c:out>
                                    </td>
                                    <td>
                                    <c:out value="${order.getAddress()}"></c:out>
                                    </td>
                                    <td>
                                    <c:out value="${order.getOrderDate()}"></c:out>
                                    </td>

                                    <td>
                            <fmt:formatNumber type="currency" value="${order.getTotal()}"/>
                        </td>
                        <td>
                            <a href="OrderViewController?op=view_Detail&OrderID=${order.getOrderID()}">Chi tiết</a>
                        </td>
                        </tr>
                    </c:forEach>

                    </tbody>
                </table>
                 <div class="col-sm-6">
                            <a href="ManagerController"  class="btn btn-success"><span>Trở Về Trang Chủ</span></a>
                           						
                        </div>
            </div>
        </div>
        <!-- jQuery -->
        <script src="vendors/jquery/dist/jquery.min.js"></script>
        <!-- Bootstrap -->
        <script src="vendors/bootstrap/dist/js/bootstrap.min.js"></script>
        <!-- datatable -->
        <script src="vendors/datatables.net/js/jquery.dataTables.min.js"></script>
        <script src="vendors/datatables.net-bs/js/dataTables.bootstrap.min.js"></script>
        <script src="vendors/datatables.net-buttons/js/dataTables.buttons.min.js"></script>
        <script src="vendors/datatables.net-buttons-bs/js/buttons.bootstrap.min.js"></script>
        <script src="vendors/datatables.net-buttons/js/buttons.flash.min.js"></script>
        <script src="vendors/datatables.net-buttons/js/buttons.html5.min.js"></script>
        <script src="vendors/datatables.net-buttons/js/buttons.print.min.js"></script>
        <script src="vendors/datatables.net-fixedheader/js/dataTables.fixedHeader.min.js"></script>
        <script src="vendors/datatables.net-keytable/js/dataTables.keyTable.min.js"></script>
        <script src="vendors/datatables.net-responsive/js/dataTables.responsive.min.js"></script>
        <script src="vendors/datatables.net-responsive-bs/js/responsive.bootstrap.js"></script>
        <script src="vendors/datatables.net-scroller/js/dataTables.scroller.min.js"></script>
        <script src="vendors/jszip/dist/jszip.min.js"></script>
        <script src="vendors/pdfmake/build/pdfmake.min.js"></script>
        <script src="vendors/pdfmake/build/vfs_fonts.js"></script>


        <!-- Custom Theme Scripts -->
        <script src="build/js/custom.min.js"></script>


    </body>
</html>
