<%-- 
    Document   : theothang
    Created on : Nov 13, 2022, 6:12:40 PM
    Author     : minhd
--%>

<%@page import="java.text.NumberFormat"%>
<%@page import="java.util.Locale"%>
<%@page import="ductm.report.ReportDAO"%>
<%@page import="ductm.report.ReportDTO"%>
<%@page import="java.util.Map"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Thống kê theo tháng</title>
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
	<!-- datatable -->
	<link href="vendors/datatables.net-bs/css/dataTables.bootstrap.min.css" rel="stylesheet">
    <link href="vendors/datatables.net-buttons-bs/css/buttons.bootstrap.min.css" rel="stylesheet">
    <link href="vendors/datatables.net-fixedheader-bs/css/fixedHeader.bootstrap.min.css" rel="stylesheet">
    <link href="vendors/datatables.net-responsive-bs/css/responsive.bootstrap.min.css" rel="stylesheet">
    <link href="vendors/datatables.net-scroller-bs/css/scroller.bootstrap.min.css" rel="stylesheet">
</head>
<body>
     <%
        Locale loc = new Locale("nv","VN");
       
        
    NumberFormat nf = NumberFormat.getCurrencyInstance(loc);
    %>
<div class="container">
        <div class="row">
           	<jsp:include page="ReportHeader.jsp"></jsp:include>
        </div>
        <div class="row">
            <div class="col-sm-3">
                <h1>Mời chọn tháng:</h1>
                <form action="ReportController?action=TheoThang" method="post">
	                 <input type="month" name="thang">
	                <button class="btn btn-sm btn-defaut" type="submit">Thống kê</button>
	            </form>
	                
            </div>
        </div>
        <div class="row" style="float:right">
            	<button class="btn btn-info btn-sm" data-toggle="modal" data-target="#bieudotheothang">Xem biểu đồ</button>
            	<div class="modal fade" id="bieudotheothang" role="dialog">
				    <div class="modal-dialog">
				    
				      <!-- Modal content-->
				      <div class="modal-content">
				        <div class="modal-header">
				          <button type="button" class="close" data-dismiss="modal">&times;</button>
				          <h4 class="modal-title" style="text-align:center">Biểu đồ doanh thu sản phẩm theo tháng</h4>
				        </div>
				        <div class="modal-body">
				        	<jsp:include page="BieuDo/bieudodoanhthusanphamtheothang.jsp"></jsp:include>
				        </div>
				        <div class="modal-footer">
				          <button type="button" class="btn btn-default" data-dismiss="modal">Đóng</button>
				        </div>
				      </div>
				      
				    </div>
				  </div>
				  
				</div>
        <div class="row">
        <% Map<String,ReportDTO> mapTS = new ReportDAO().thongKeTheoThangHeThong();
        		String ok = (String) session.getAttribute("okthang");
        		String thang= (String) session.getAttribute("month");
        		if(ok!=null){
        			if(ok.equals("ok")){
        				mapTS=new ReportDAO().thongKeTheoThang(thang);
        			}else{
        				mapTS=new ReportDAO().thongKeTheoThangHeThong();
        			}
        		}
        %>
        	<table id="datatable-buttons" class="table table-striped table-bordered">
                      <thead>
                        <tr>
                          <th>STT</th>
                          <th>Mã Sản Phẩm</th>
                          <th>Số lượng bán ra</th>
                          <th>Doanh thu</th>
                          <th>Ngày</th>
                        </tr>
                      </thead>
                      <tbody>
                      <%int count=0;for(ReportDTO ts : mapTS.values()){ count++;%>
           				 <TR>
               				 <TD> <%= count%></td>
               				 <TD> <%= ts.getProductID()%></TD>
              				
              				  <TD> <%= ts.getQuantity()%></TD>
              				  <TD><%= nf.format(ts.getTotal())%></TD>
              				  <TD> <%=ts.getDate()%></TD>
           				 </TR>
           				 <%} %>
                      </tbody>
                    </table>
        </div>
    </div>
</body>
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
</html>
