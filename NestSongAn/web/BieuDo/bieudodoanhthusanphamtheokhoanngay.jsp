<%@page import="ductm.report.ReportDAO"%>
<%@page import="ductm.report.ReportDTO"%>
<%@page import="java.util.HashMap"%>
<%@page import="java.util.Map"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<html>
  <head>
    <script type="text/javascript" src="https://www.gstatic.com/charts/loader.js"></script>
    
    		<%Map<String,ReportDTO> mapTS =new HashMap<>();
        		String ok = (String) session.getAttribute("okkn");
        		String ngayBatDau= (String) session.getAttribute("ngayBatDau");
        		String ngayKetThuc= (String) session.getAttribute("ngayKetThuc");
        		if(ok!=null){
        			if(ok.equals("ok")){
        				mapTS=new ReportDAO().thongKeTheoKhoanNgay(ngayBatDau, ngayKetThuc);
        			}
        		}
        %>
    <script type="text/javascript">
      google.charts.load("current", {packages:["corechart"]});
      google.charts.setOnLoadCallback(drawChart);
      function drawChart() {
        var data = google.visualization.arrayToDataTable([
          ['Task', 'Hours per Day'],
		<% if(mapTS.size()!=0){
			for(ReportDTO ts:mapTS.values()){
		%>	          
          ['<%=ts.getProductID()%>',     <%out.print(new ReportDAO().layTongDoanhThuTheoKhoangNgay(ngayBatDau, ngayKetThuc));%>],
          <%}
		}%>
          
        ]);

        var options = {
          title: 'Biểu đồ thống kê doanh thu theo tháng',
          is3D: true,
        };

        var chart = new google.visualization.PieChart(document.getElementById('piechart_3d'));
        chart.draw(data, options);
      }
    </script>
  </head>
  <body>
    <div id="piechart_3d" style="width: 900px; height: 500px;"></div>
  </body>
</html>