<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.1.3/dist/css/bootstrap.min.css" integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO" crossorigin="anonymous">
<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/popper.js@1.14.3/dist/umd/popper.min.js" integrity="sha384-ZMP7rVo3mIykV+2+9J3UJ46jBk0WLaUAdn689aCwoqbBJiSnjAK/l8WvCWPIPm49" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.1.3/dist/js/bootstrap.min.js" integrity="sha384-ChfqqxuZUCnJSK3+MXmPNIyE6ZbWh2IMqE241rYiqJxyMiZ6OW/JmZQ5stwEULTy" crossorigin="anonymous"></script>

<form action="search" method="get">
<input type="text" name="keyword"><br>
<button type="submit" id="btn1" class="btn btn-danger">Search</button>
<a href="display.jsp" class="btn btn-secondary">Back</a>
</form>

<table border="1px" class="table">
<tr>
<th>ID</th>
<th>Name</th>
<th>Email</th>
<th>Password</th>
<th>Gender</th>
<th>state</th>
<th>Images</th>
<th>Action</th>
</tr>

<c:forEach items="${temp}" var="e">
<tr>
<td>${e.mid}</td>
<td>${e.mname}</td>
<td>${e.memail}</td>
<td>${e.mpass}</td>
<td>${e.gender}</td>
<td>${e.state}</td>
<td>

<img src="/images/${e.filename}" height="50px" weight="100px">
</td>
<td>
<a href="deldata/${e.mid}" class="btn btn-danger">Delete</a>
<a href="editdata/${e.mid}" class="btn btn-primary">Edit</a>

</td>

</tr>
</c:forEach>
</table>


<style>

input[type=text] {
  width: 20%;
  padding: 15px;
  margin: 5px 0 22px 0;
  display: inline-block;
  border: 1px;
  margin-left:40%;
  margin-top:20px;
  background: #f7f7f7;
	font-family: Montserrat,Arial, Helvetica, sans-serif;
}

#btn1{

  width: 20%;
  padding: 15px;
  margin: 5px 0 22px 0;
  display: inline-block;
  border: 1px;
  margin-left:40%;
  margin-top:20px;
  background: #f7f7f7;
	font-family: Montserrat,Arial, Helvetica, sans-serif;


}

</style>