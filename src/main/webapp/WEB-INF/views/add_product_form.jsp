<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
  <%@ include file="./base.jsp" %>
</head>
<body>


<form class="container mt-5" action="handleproduct" method="post"> 
   <h1 class="text-center">Fill the Product Detail</h1>
  <div class="form-group">
    <label for="exampleInputEmail1">Name</label>
    <input type="text" class="form-control" name="name"  placeholder="Enter Name">
  </div>
  <div class="form-group">
    <label for="exampleInputPassword1">Description</label>
    <textarea  class="form-control" name="description" placeholder="Description" rows="5"></textarea>
  </div>
  <div class="form-group">
    <label for="exampleInputPassword1">Price</label>
    <input type="text" class="form-control" name="price" placeholder="Enter Price">
  </div>
  <div class="container text-center">
  <a href="/crud/" class="btn btn-primary align-center">Back</a>
  <button type="submit" class="btn btn-primary align-center">Add</button>
  </div>
  
</form>

</body>
</html>