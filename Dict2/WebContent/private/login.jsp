<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>Авторизация</h1>
<form action="j_security_check" method="POST">
    <div id="loginBox">
        <p><strong>Ваш логин:</strong>
            <input placeholder="Введите логин" type="text" size="20" name="j_username"></p>
        <p><strong>Пароль:</strong>
            <input placeholder="Введите пароль" type="password" size="20" name="j_password"></p>
        <p><input type="submit" value="Авторизоваться"></p>
    </div>
</form>
</body>
</html>