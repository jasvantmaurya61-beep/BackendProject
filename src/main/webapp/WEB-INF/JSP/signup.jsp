<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Sign Up</title>

    <style>
        body {
            font-family: Arial, sans-serif;
            background-color: #f2f2f2;
        }

        .signup-form {
            width: 400px;
            margin: 50px auto;
            padding: 25px;
            background-color: white;
            border-radius: 8px;
            box-shadow: 0 0 10px gray;
        }

        h2 {
            text-align: center;
        }

        label {
            display: block;
            margin-top: 15px;
            margin-bottom: 5px;
            font-weight: bold;
        }

        input[type="text"],
        textarea {
            width: 100%;
            padding: 8px;
            box-sizing: border-box;
        }

        .gender {
            margin-top: 8px;
        }

        input[type="submit"] {
            width: 100%;
            margin-top: 20px;
            padding: 10px;
            background-color: #007bff;
            color: white;
            border: none;
            border-radius: 4px;
            cursor: pointer;
        }

        input[type="submit"]:hover {
            background-color: #0056b3;
        }
    </style>
</head>

<body>

    <div class="signup-form">

        <h2>Sign Up</h2>

<form action="/BackendProject/sign-up"
          method="post">
            <!-- Name -->
            <label for="name">Name:</label>
            <input type="text"
                   id="name"
                   name="name"
                   placeholder="Enter your name"
                   required>

            <!-- Gender -->
            <label>Gender:</label>

            <div class="gender">
                <input type="radio"
                       id="male"
                       name="gender"
                       value="Male"
                       required>
                <label for="male">Male</label>

                <input type="radio"
                       id="female"
                       name="gender"
                       value="Female">
                <label for="female">Female</label>

                <input type="radio"
                       id="other"
                       name="gender"
                       value="Other">
                <label for="other">Other</label>
            </div>

            <!-- Address -->
            <label for="address">Address:</label>
            <textarea id="address"
                      name="address"
                      rows="4"
                      placeholder="Enter your address"
                      required></textarea>

            <!-- Submit -->
            <input type="submit" value="Sign Up">

        </form>

    </div>

</body>
</html>