
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Login</title>
    <link rel="stylesheet" href="<c:url value='Users/Login/login.css'/>">
    <link rel="stylesheet" href="font/fonts/themify-icons/themify-icons.css">
</head>
<body>
<form action="http://localhost:8080/login?action=login" method="post">
    <div class="modal ">
        <div class="modal-container ">

            <header class="modal-header">
                <i class="modal-heading-icon ti-bag"></i>
                Mini Mart
            </header>

            <div class="modal-body">
                <label for="ticket-user" class="modal-label">
                    <i class="ti-user"></i>
                    Username
                </label>
                <input id="ticket-user" type="text" class="modal-input" placeholder="Username?" name="username">

                <label for="ticket-password" class="modal-label">
                    <i class="ti-unlock"></i>
                    Password
                </label>
                <input id="ticket-password" type="password" class="modal-input" placeholder="Password?" name="password">

                <button id="buy-tickets" type="submit">
                    log in <i class="ti-check"></i>
                </button>
            </div>

            <footer class="modal-footer">
                <p class="modal-help">Need <a href="">help?</a></p>
            </footer>

        </div>
</form>

</div>

</body>
