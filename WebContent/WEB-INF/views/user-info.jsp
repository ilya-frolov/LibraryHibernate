<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>User jsp</title>
</head>
<body>
    <h2>Welcome ${username}</h2>
    <h2>Your age is ${age}</h2>

    <form action="book-start" method="get">
        <input type="submit" value="Add new book">
    </form>
</body>
</html>
