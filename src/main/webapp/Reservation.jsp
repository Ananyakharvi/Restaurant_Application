<!DOCTYPE html>
<html>
<head>
<title>Table Reservation</title>
<style>
body{
    font-family: Arial;
    text-align:center;
}
form{
    display:inline-block;
    padding:20px;
    border:1px solid #ccc;
}
</style>
</head>
<body>

<h2>Book Your Table</h2>

<form action="ReservationServlet" method="post">

    Date:<br>
    <input type="date" name="date" required><br><br>

    Time:<br>
    <input type="time" name="time" required><br><br>

    Guests:<br>
    <input type="number" name="guests" required><br><br>

    <input type="submit" value="Reserve">

</form>

</body>
</html>