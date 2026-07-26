<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Order Success - ADPS Restaurant</title>
    <link href="https://fonts.googleapis.com/css2?family=Plus+Jakarta+Sans:wght@300;400;500;600;700&display=swap" rel="stylesheet">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.4.0/css/all.min.css">
    <style>
        * {
            margin: 0;
            padding: 0;
            box-sizing: border-box;
            font-family: 'Plus Jakarta Sans', sans-serif;
        }

        body {
            background-color: #0f172a;
            color: #f8fafc;
            min-height: 100vh;
            display: flex;
            align-items: center;
            justify-content: center;
            padding: 20px;
        }

        .success-card {
            width: 100%;
            max-width: 460px;
            background: rgba(30, 41, 59, 0.7);
            backdrop-filter: blur(16px);
            border: 1px solid rgba(255, 255, 255, 0.1);
            border-radius: 24px;
            padding: 44px 32px;
            box-shadow: 0 25px 50px -12px rgba(0, 0, 0, 0.5);
            text-align: center;
        }

        .check-circle {
            width: 80px;
            height: 80px;
            background: linear-gradient(135deg, #10b981, #059669);
            border-radius: 50%;
            display: flex;
            align-items: center;
            justify-content: center;
            font-size: 36px;
            color: white;
            margin: 0 auto 24px;
            box-shadow: 0 10px 25px -5px rgba(16, 185, 129, 0.5);
        }

        h1 {
            font-size: 26px;
            font-weight: 800;
            color: #34d399;
            margin-bottom: 10px;
        }

        p.subtitle {
            color: #94a3b8;
            font-size: 14px;
            line-height: 1.6;
            margin-bottom: 32px;
        }

        .btn-group {
            display: flex;
            flex-direction: column;
            gap: 12px;
        }

        .btn {
            display: block;
            padding: 14px;
            border-radius: 14px;
            font-size: 15px;
            font-weight: 600;
            text-decoration: none;
            transition: all 0.2s ease;
        }

        .btn-primary {
            background: linear-gradient(135deg, #6366f1, #4f46e5);
            color: white;
            box-shadow: 0 10px 20px -5px rgba(99, 102, 241, 0.4);
        }

        .btn-primary:hover {
            transform: translateY(-2px);
            box-shadow: 0 15px 25px -5px rgba(99, 102, 241, 0.6);
        }

        .btn-secondary {
            background: rgba(15, 23, 42, 0.6);
            border: 1px solid rgba(255, 255, 255, 0.1);
            color: #cbd5e1;
        }

        .btn-secondary:hover {
            background: rgba(15, 23, 42, 0.9);
            color: white;
        }
    </style>
</head>
<body>

<div class="success-card">
    <div class="check-circle">
        <i class="fa-solid fa-check"></i>
    </div>

    <h1>Order Placed Successfully!</h1>
    <p class="subtitle">Thank you for dining with ADPS Restaurant. Your order has been sent directly to our kitchen staff for preparation.</p>

    <div class="btn-group">
        <a href="menu" class="btn btn-primary"><i class="fa-solid fa-utensils"></i> Order More Items</a>
        <a href="User.jsp" class="btn btn-secondary"><i class="fa-solid fa-house"></i> Return to Dashboard</a>
    </div>
</div>

</body>
</html>