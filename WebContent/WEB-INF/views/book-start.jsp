<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <title>Start jsp</title>
</head>
<body>

<h2>Enter book data:</h2>

<form action="book" method="post">
  <input type="text" name="title" placeholder="Enter book title: " required>
  <input type="text" name="author" placeholder="Enter author name: " required>
  <td>Genre:</td>
  <td><select type="text"  name="genre">
    <option>poem</option>
    <option>novel</option>
    <option>science fiction</option>
    <option>fantastic</option>
  </select></td>
  <input type="submit" value="SUBMIT">
</form>

</body>
</html>
