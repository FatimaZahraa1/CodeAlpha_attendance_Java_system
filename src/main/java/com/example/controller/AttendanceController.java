package com.example.controller;

import com.example.model.Attendance;
import com.example.service.AttendanceService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class AttendanceController extends HttpServlet {
    private final AttendanceService attendanceService = new AttendanceService();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Attendance> attendanceList = attendanceService.getAllAttendance();
        request.setAttribute("attendanceList", attendanceList);
        request.getRequestDispatcher("/index.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String studentName = request.getParameter("studentName");
        boolean present = Boolean.parseBoolean(request.getParameter("present"));
        String date = request.getParameter("date");
        String className = request.getParameter("className");
        String time = request.getParameter("time");
        String teacherName = request.getParameter("teacherName");

        Attendance attendance = new Attendance();
        attendance.setStudentName(studentName);
        attendance.setPresent(present);
        attendance.setDate(date);
        attendance.setClassName(className);
        attendance.setTime(time);
        attendance.setTeacherName(teacherName);
        attendanceService.addAttendance(attendance);
        response.sendRedirect("attendance");
    }
}
