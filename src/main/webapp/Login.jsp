<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Login - ADPS Restaurant</title>

<style>
body {
    margin: 0;
    font-family: Arial, sans-serif;
    background: linear-gradient(rgba(0,0,0,0.6), rgba(0,0,0,0.6)),
                url('https://images.unsplash.com/photo-1504674900247-0877df9cc836') no-repeat center;
    background-size: cover;
}

.login-box {
    width: 350px;
    background: white;
    padding: 30px;
    margin: 100px auto;
    border-radius: 10px;
    box-shadow: 0px 0px 10px gray;
    text-align: center;
}

.login-box h2 {
    margin-bottom: 20px;
}

.login-box input {
    width: 90%;
    padding: 10px;
    margin: 10px 0;
    border-radius: 5px;
    border: 1px solid #ccc;
}

.login-btn {
    width: 95%;
    padding: 10px;
    background-color: #ff5722;
    color: white;
    border: none;
    font-size: 16px;
    border-radius: 5px;
    cursor: pointer;
}

.login-btn:hover {
    background-color: #e64a19;
}

.link {
    margin-top: 15px;
}

.link a {
    text-decoration: none;
    color: #ff5722;
}
</style>

</head>
<body>

<div class="login-box">
    <h2>Login</h2>

    <form action="LoginServlet" method="post">
        
        <input type="email" name="email" placeholder="Enter Email" required>
        
        <input type="password" name="password" placeholder="Enter Password" required>
        
        <input type="submit" value="Login" class="login-btn">
        
    </form>

    <div class="link">
        <p>Don't have an account? <a href="register.jsp">Register</a></p>
    </div>
</div>

</body>
</html>