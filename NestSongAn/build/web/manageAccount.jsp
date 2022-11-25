<%-- 
    Document   : manageAccount
    Created on : Nov 14, 2022, 12:19:53 PM
    Author     : WIN10
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <title>Quản lí Tài khoản</title>
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
                            <h2>Quản lí <b>Tài khoản</b></h2>
                        </div>
                        <div class="col-sm-6">
                            <a href="#addEmployeeModal"  class="btn btn-success" data-toggle="modal"><i class="material-icons">&#xE147;</i> <span>Đăng kí tài khoản</span></a>

                            <div class="alert alert-secondary" role="alert">
                                ${mess}
                            </div>
                        </div>
                    </div>
                </div>
                <table class="table table-striped table-hover">
                    <thead>
                        <tr>

                            <th>ID</th>
                            <th>Tài Khoản</th>
                            <th>Mật Khẩu</th>
                            <th>Họ và tên</th>
                            <th>Vai trò</th>
                            <th>Email</th>
                            <th>Số điện thoại</th>
                            <th>Chỉnh sửa</th>
                        </tr>
                    </thead>
                    <tbody>
                        <c:forEach items="${list}" var="o">
                            <tr>

                                <td>${o.id}</td>
                                <td>${o.username}</td>
                                <td>${o.password}</td>
                                <td>${o.fullName}</td>
                                <td>${o.role}</td>
                                <td>${o.mail}</td>
                                <td>${o.phone}</td>
                                <td>
                                    <a href="LoadAccountController?uid=${o.id}"  class="edit" data-toggle="modal"><i class="material-icons" data-toggle="tooltip" title="Chỉnh Sửa">&#xE254;</i></a>
                                    <c:if test="${o.username!=sessionScope.acc.username}"> <a href="DeleteAccountController?uid=${o.id}" class="delete" data-toggle="modal"><i class="material-icons" data-toggle="tooltip" title="Xóa">&#xE872;</i></a></c:if>


                                    </td>
                                </tr>
                        </c:forEach>
                    </tbody>
                </table>

                <div class="col-sm-6">
                    <a href="AdminController"  class="btn btn-success"><span>Trở Về Trang Chủ</span></a>

                </div>

            </div>
            <!-- Edit Modal HTML -->
            <div id="addEmployeeModal" class="modal fade">
                <div class="modal-dialog">
                    <div class="modal-content">
                        <form action="SignupController" method="post">
                            <div class="modal-header">	

                                <h4 class="modal-title">Add Product</h4>

                                <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                            </div>
                            <div class="modal-body">					
                                <div class="form-group">
                                    <div class="alert alert-primary" role="alert">
                                        ${mess}
                                    </div>
                                    <label>User name</label>
                                    <input name="username" type="text" class="form-control" required>
                                </div>
                                <div class="form-group">
                                    <label>Password</label>
                                    <input name="password" type="text" class="form-control" required>
                                </div>
                                <div class="form-group">
                                    <label>Họ và tên</label>
                                    <input name="fullname" type="text" class="form-control" required>
                                </div>
                                <div class="mb-3">
                                    <label  class="form-label">Mail</label>
                                    <input type="email" name="mail" class="form-control" required>
                                </div>
                                <div class="mb-3">
                                    <label  class="form-label">Số điện thoại</label>
                                    <input name="phone" type="tel" class="form-control" required>
                                </div>
                                <div class="form-group">
                                    <label>Vai trò</label>
                                    <select name="role" >
                                        <option>Admin</option>
                                        <option>Manager</option>
                                    </select>
                                </div>


                            </div>
                            <div class="modal-footer">
                                <input type="button" class="btn btn-default" data-dismiss="modal" value="Cancel">
                                <input type="submit" class="btn btn-success" value="Add">
                            </div>
                        </form>
                    </div>
                </div>
            </div>


            <script src="js/manager.js" type="text/javascript"></script>
    </body>
</html>
