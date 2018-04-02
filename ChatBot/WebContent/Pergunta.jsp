<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="model.Pergunta" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Pergunta</title>
</head>
<body>
	<%Pergunta pergunta = (Pergunta)request.getAttribute("pergunta"); %>

	Pergunta_Pergunta: <%=pergunta.getPergunta_Pergunta() %><br>
</body>
</htm>