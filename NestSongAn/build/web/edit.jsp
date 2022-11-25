<%-- 
    Document   : edit
    Created on : Nov 11, 2022, 1:42:16 PM
    Author     : WIN10
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1">
       
        <link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Roboto|Varela+Round">
        <link rel="stylesheet" href="https://fonts.googleapis.com/icon?family=Material+Icons">
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
        <link href="css/manager.css" rel="stylesheet" type="text/css"/>
        <style>
            img{
                width: 200px;
                height: 120px;
            }
        </style>
    <body>
        <div class="container">
            <div class="table-wrapper">
                <div class="table-title">
                    <div class="row">
                        <div class="col-sm-6">
                            <h2>Sửa <b>Sản Phẩm</b></h2>
                        </div>
                        <div class="col-sm-6">
                        </div>
                    </div>
                </div>
            </div>
            <div id="editEmployeeModal">
                <div class="modal-dialog">
                    <div class="modal-content">
                        <form action="EditController" method="post">
                            <div class="modal-header">						
                                <h4 class="modal-title">Sửa Sản Phẩm</h4>
                                <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                            </div>
                            <div class="modal-body">					
                                <div class="form-group">
                                    <label>ID</label>
                                    <input value="${product.productID}" name="id" type="text" class="form-control" readonly required>
                                </div>
                                <div class="form-group">
                                    <label>Tên Sản Phẩm</label>
                                    <input value="${product.productName}" name="name" type="text" class="form-control" required>
                                </div>
                                <div class="form-group">
                                    <label>Hình Ảnh</label>
                                    <input value="${product.productImage}" name="image" type="text" class="form-control" required>
                                </div>
                                <div class="form-group">
                                    <label>Giá</label>
                                    <input value="${product.price}" name="price" type="text" class="form-control" required>
                                </div>
                                <div class="form-group">
                                <label>Đơn Vị</label>
                                <input value="${product.unit}" name="unit" type="text" class="form-control" required>
                                </div>                                
                                <div class="form-group">
                                <label>Trọng Lượng</label>
                                <input value="${descrip.weight}" name="weight" type="text" class="form-control" required>
                                </div>                                
                                <div class="form-group">
                                <label>Loại</label>
                                <input value="${descrip.type}" name="type" type="text" class="form-control" required>
                                </div>                                
                                <div class="form-group">
                                <label>Mùi</label>
                                <input value="${descrip.smell}" name="smell" type="text" class="form-control" required>
                                </div>                                
                                <div class="form-group">
                                <label>Đặc Trưng</label>
                                <input value="${descrip.specific}" name="specific" type="text" class="form-control" required>
                                </div>                                
                                <div class="form-group">
                                <label>Bảo Quản</label>
                                <input value="${descrip.preserve}" name="preserve" type="text" class="form-control" required>
                                </div>                                
                                <div class="form-group">
                                    <label>Hạng Mục</label>
                                    <select name="category" class="form-select" aria-label="Default select example">
                                        <c:forEach items="${listC}" var="o">
                                            <option value="${o.cid}">${o.cname}</option>
                                        </c:forEach>
                                    </select>
                                </div>

                            </div>
                            <div class="modal-footer">
                                <input type="submit" class="btn btn-success" value="Sửa">
                                
                            </div>
                        </form>
                    </div>
                </div>
            </div>

        </div>


        <script src="js/manager.js" type="text/javascript"></script>
    </body>
</html>
