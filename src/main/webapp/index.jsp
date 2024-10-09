<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <title>Attendance Management System</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            background-color: #f4f4f4;
            margin: 0;
            padding: 0;
        }
        h1 {
            text-align: center;
            color: #333;
            margin-top: 20px;
        }
        form {
            width: 50%;
            margin: 20px auto;
            background: #fff;
            padding: 20px;
            border-radius: 8px;
            box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
        }
        label {
            display: block;
            margin: 15px 0 5px;
            font-size: 14px;
            color: #333;
        }
        input[type="text"], select {
            width: 100%;
            padding: 8px;
            margin-bottom: 10px;
            border: 1px solid #ddd;
            border-radius: 4px;
        }
        input[type="submit"] {
            width: 100%;
            padding: 10px;
            background-color: #5cb85c;
            color: white;
            border: none;
            border-radius: 4px;
            cursor: pointer;
            font-size: 16px;
        }
        input[type="submit"]:hover {
            background-color: #4cae4c;
        }
        table {
            width: 80%;
            margin: 20px auto;
            border-collapse: collapse;
            background: #fff;
            box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
        }
        table, th, td {
            border: 1px solid #ddd;
        }
        th, td {
            padding: 12px;
            text-align: center;
        }
        th {
            background-color: #5cb85c;
            color: white;
        }
        tr:nth-child(even) {
            background-color: #f2f2f2;
        }
        tr:hover {
            background-color: #e0e0e0;
        }
    </style>
</head>
<body>
    <h1>Attendance List</h1>
    <form action="attendance" method="post">
        <label for="studentName">Student Name:</label>
        <input type="text" name="studentName" required>
        
        <label for="date">Date:</label>
        <input type="text" name="date" required>
        
        <label for="className">Class Name:</label>
        <input type="text" name="className" required>
        
        <label for="time">Time:</label>
        <input type="text" name="time" required>
        
        <label for="teacherName">Teacher Name:</label>
        <input type="text" name="teacherName" required>
        
        <label for="present">Attendance Status:</label>
        <select name="present">
            <option value="true">Present</option>
            <option value="false">Absent</option>
        </select>
        <input type="submit" value="Submit">
    </form>
    
    <table>
        <tr>
            <th>ID</th>
            <th>Student Name</th>
            <th>Class Name</th>
            <th>Date</th>
            <th>Time</th>
            <th>Teacher's Name</th>
            <th>Present</th>
        </tr>
        <c:forEach var="attendance" items="${attendanceList}">
            <tr>
                <td>${attendance.id}</td>
                <td>${attendance.studentName}</td>
                <td>${attendance.className}</td>
                <td>${attendance.date}</td>
                <td>${attendance.time}</td>
                <td>${attendance.teacherName}</td>
                <td>${attendance.present ? 'Yes' : 'No'}</td>
            </tr>
        </c:forEach>
    </table>
</body>
</html>
