<%-- 
    Document   : ViewOrderDetail
    Created on : Nov 13, 2022, 12:06:53 AM
    Author     : ACER
--%>

<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
        <title>View Order Details</title>
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
    </head>
    <body>
        <table id="datatable-buttons" class="table table-striped table-bordered" border="1" cellspadding="3" cellpadding="10">
            <thead>
                <tr>
                    <th>Mã đơn hàng</th>
                    <th>Mã sản phẩm</th>
                    <th>Giá đơn vị</th>
                    <th>Số lượng</th>
                    <th>Tổng</th>
                </tr>
            </thead>
            <tbody>
                <c:forEach items="${listDetail}" var="detail">
                    <c:set var="orderID" value="${detail.getOrderID()}"></c:set>
                        <tr>
                            <td><c:out value="${detail.getOrderID()}"></c:out></td>
                        <td><c:out value="${detail.getProductID()}"></c:out></td>
                        <td><fmt:formatNumber type="currency" value="${detail.getPrice()}"/></td>
                        <td><c:out value="${detail.getQuantity()}"></c:out></td>
                        <td><fmt:formatNumber type="currency" value="${detail.getPrice()*detail.getQuantity()}"/></td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>
             <div class="col-sm-6">
                            <a href="OrderViewController?op=view_Order"  class="btn btn-success"><span>Quay Về</span></a>
                           						
                        </div>
        <form action="DeliveryController?op=make_Delivery" method="POST" >
            <label>Tạo giao hàng cho đơn số <c:out value="${orderID}"></c:out></label><br>
            <input type="number" name="orderID" value="${orderID}" readonly="" hidden="">
            <select name="deliveryName">
                <option value="grab">Grab</option>
                <option value="viettelpost">Viettel Post</option>
                <option value="ahamove">Ahamove</option>
                <option value="ninjavan">Ninja Van</option>
                <option value="ghn">GHN</option>
                <option value="self">Dịch vụ giao hàng của cửa hàng</option>
            </select>
            <input type="submit" value="Giao Hàng">
        </form>



    </body>
</html>
