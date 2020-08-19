<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="controller.GetChartData" %>
<%@ String data[][] = (String)session.getAttribute("data"); %>
<!DOCTYPE html>
<html lang="ja">
<head>
<meta charset="UTF-8">
<title>chart-js</title>
</head>
<body>

テスト：<%=data[1][2] %>

</body>
</html>