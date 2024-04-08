
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Edit Product</title>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/css/bootstrap.min.css"
          integrity="sha384-xOolHFLEh07PJGoPkLv1IbcEPTNtaed2xpHsD9ESMhqIYd0nLMwNLD69Npy4HI+N" crossorigin="anonymous">
    <script src="https://cdn.jsdelivr.net/npm/jquery@3.5.1/dist/jquery.slim.min.js"
            integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj"
            crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/js/bootstrap.bundle.min.js"
            integrity="sha384-Fy6S3B9q64WdZWQUiU+q4/2Lc9npb8tCaSX9FK7E8HnRr0Jz8D6OP9dO5Vg3Q9ct"
            crossorigin="anonymous"></script>
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
            <nav class="navbar navbar-expand-lg nav-bg">
                <a class="navbar-brand color-white" href="http://localhost:8080/adminProduct?action=home">Mini Mart</a>
                <button class="navbar-toggler" type="button" data-toggle="collapse"
                        data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent"
                        aria-expanded="false" aria-label="Toggle navigation">
                    <span class="navbar-toggler-icon"></span>
                </button>

                <div class="collapse navbar-collapse" id="navbarSupportedContent">
                    <ul class="navbar-nav mr-auto">
                        <li class="nav-item active">
                            <a class="nav-link color-white" href="http://localhost:8080/adminProduct?action=edit">Edit Product <span
                                    class="sr-only">(current)</span></a>
                        </li>
                        <li class="nav-item active">
                            <a class="nav-link color-white" href="">Logout<span class="sr-only">(current)</span></a>
                        </li>
                    </ul>
                </div>
            </nav>
        </div>
        <div class="col-12 mt-5">
            <form action="http://localhost:8080/adminProduct?action=edit" method="post">
                <div>
                    <label>ID</label>
                    <input type="number" name="id" placeholder="ID" value="${productEdit.id}" readonly></input>
                </div>
                <div class="row">
                    <div class="form-group col-md-6">
                        <label for="inputEmail4">Name</label>
                        <input type="text" class="form-control" id="inputEmail4" name="name" value="${productEdit.name}">
                    </div>

                    <div class="form-group col-md-6">
                        <label for="inputPassword4">Price</label>
                        <input type="number" class="form-control" id="inputPassword4" name="price" value="${productEdit.price}">
                    </div>
                </div>

                <div class="row">
                    <div class="form-group col-md-12">
                        <label for="inputZip">Quantity</label>
                        <input type="number" class="form-control" id="inputZip" name="quantity" value="${productEdit.quantity}">
                    </div>

                    <div class="form-group col-md-12">
                        <label for="inputImg">Image</label>
                        <input type="text" class="form-control" id="inputImg" name="image" value="${productEdit.image}">
                    </div>
                </div>

                <div class="row">
                    <div class="form-group col-md-12">
                        <label for="inputState">Category</label>
                        <select id="inputState" class="form-control" name="idCategory">
                            <c:forEach var="item" items="${list}">
                                <option value="${item.id}">${item.name}</option>
                            </c:forEach>
                        </select>
                    </div>
                </div>

                <button type="submit" class="btn btn-primary">Edit Product</button>
            </form>
        </div>
    </div>
</div>
</body>
</html>
