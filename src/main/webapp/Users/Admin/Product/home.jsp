
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>home</title>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/css/bootstrap.min.css" integrity="sha384-xOolHFLEh07PJGoPkLv1IbcEPTNtaed2xpHsD9ESMhqIYd0nLMwNLD69Npy4HI+N" crossorigin="anonymous">
    <script src="https://cdn.jsdelivr.net/npm/jquery@3.5.1/dist/jquery.slim.min.js" integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj" crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-Fy6S3B9q64WdZWQUiU+q4/2Lc9npb8tCaSX9FK7E8HnRr0Jz8D6OP9dO5Vg3Q9ct" crossorigin="anonymous"></script>
    <style>
        .nav-bg{
               background-color: #272882;
           }
        .color-white{
            color: white;
        }
        img {
            width: 100px;
            height: 100px;
        }

    </style>

</head>
<body>
<div class="container">
    <div class="row">
        <div class="col-12">
            <nav class="navbar navbar-expand-lg  nav-bg">
                <a class="navbar-brand color-white" href="http://localhost:8080/adminProduct?action=home">Mini Mart</a>
                <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
                    <span class="navbar-toggler-icon"></span>
                </button>

                <div class="collapse navbar-collapse" id="navbarSupportedContent">
                    <ul class="navbar-nav mr-auto">
                        <li class="nav-item active">
                            <a class="nav-link color-white" href="http://localhost:8080/adminCustomer?action=home">Customer <span class="sr-only">(current)</span></a>
                        </li>
                        <li class="nav-item active">
                            <a class="nav-link color-white" href="http://localhost:8080/adminOrder?action=home">Order<span class="sr-only">(current)</span></a>
                        </li>
                        <li class="nav-item active">
                            <a class="nav-link color-white" href="http://localhost:8080/adminCategory?action=home">Category<span class="sr-only">(current)</span></a>
                        </li>
                        <li class="nav-item active">
                            <a class="nav-link color-white" href="http://localhost:8080/login?action=logout">Logout<span class="sr-only">(current)</span></a>
                        </li>

                    </ul>
                    <form class="form-inline my-2 my-lg-0">
                        <input class="form-control mr-sm-2" type="search" placeholder="Search" aria-label="Search">
                        <button class="btn btn-outline-success my-2 my-sm-0" type="submit">Search</button>
                    </form>
                </div>
            </nav>
        </div>
        <div class="col-6 mt-5" >
            <button type="button" class="btn btn-outline-primary"><a href="http://localhost:8080/adminProduct?action=add">Create Product</a></button>
        </div>
        <div class="col-12 mt-3">
            <table class="table">
                <thead>
                <tr class="nav-bg color-white">
                    <th scope="col">STT</th>
                    <th scope="col">Name</th>
                    <th scope="col">Price</th>
                    <th scope="col">Quantity</th>
                    <th scope="col">Image</th>
                    <th scope="col">IdCategory</th>
                    <th scope="col" colspan="2" style="padding-left: 10%">Action</th>

                </tr>
                </thead>
                <tbody>
                <c:forEach items="${productList}" var="item">
                    <tr>
                        <th scope="row">${item.id}</th>
                        <td>${item.name}</td>
                        <td>${item.price}</td>
                        <td>${item.quantity}</td>
                        <td><img src="${item.image}" alt=""></td>
                        <td>${item.category.name}</td>
                        <td><a href="http://localhost:8080/adminProduct?action=edit&idEdit=${item.id}" class="btn btn-outline-warning">edit</a></td>
                        <td><a href="http://localhost:8080/adminProduct?action=delete&idDelete=${item.id}" class="btn btn-outline-danger">delete</a></td>
                    </tr>
                </c:forEach>
                </tbody>
            </table>
        </div>
    </div>
</div>
</body>
</html>
