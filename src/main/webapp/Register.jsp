<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Register - ADPS Restaurant</title>

<style>
body {
    margin: 0;
    font-family: Arial, sans-serif;
    background: linear-gradient(rgba(0,0,0,0.6), rgba(0,0,0,0.6)),
                url('https://images.unsplash.com/photo-1414235077428-338989a2e8c0') no-repeat center;
    background-size: cover;
}

/* Center box */
.register-box {
    width: 380px;
    background: white;
    padding: 30px;
    margin: 80px auto;
    border-radius: 10px;
    box-shadow: 0px 0px 10px gray;
    text-align: center;
}

.register-box h2 {
    margin-bottom: 20px;
}

/* Input fields */
.register-box input {
    width: 90%;
    padding: 10px;
    margin: 10px 0;
    border-radius: 5px;
    border: 1px solid #ccc;
}

/* Button */
.register-btn {
    width: 95%;
    padding: 10px;
    background-color: #ff5722;
    color: white;
    border: none;
    font-size: 16px;
    border-radius: 5px;
    cursor: pointer;
}

.register-btn:hover {
    background-color: #e64a19;
}

/* Links */
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

<div class="register-box">
    <h2>Create Account</h2>

    <form action="RegisterServlet" method="post">
        
        <input type="text" name="name" placeholder="Full Name" required>
        
        <input type="email" name="email" placeholder="Email Address" required>
        
        <input type="text" name="phone" placeholder="Phone Number" required>
        
        <input type="password" name="password" placeholder="Password" required>
        
        <input type="submit" value="Register" class="register-btn">
        
    </form>

    <div class="link">
        <p>Already have an account? <a href="login.jsp">Login</a></p>
    </div>
</div>

</body>
</html>