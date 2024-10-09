package com.example.service;

import com.example.model.Attendance;
import com.example.util.DatabaseConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class AttendanceService {
    public void addAttendance(Attendance attendance) {
        try (Connection conn = DatabaseConnection.getConnection()) {
            String sql = "INSERT INTO attendance (studentName, className, date, time, teacherName, present) VALUES (?, ?, ?, ?, ?, ?)";
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, attendance.getStudentName());
            pstmt.setString(2, attendance.getClassName());
            pstmt.setString(3, attendance.getDate());
            pstmt.setString(4, attendance.getTime());
            pstmt.setString(5, attendance.getTeacherName());
            pstmt.setBoolean(6, attendance.isPresent());
            pstmt.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public List<Attendance> getAllAttendance() {
        List<Attendance> attendanceList = new ArrayList<>();
        try (Connection conn = DatabaseConnection.getConnection()) {
            String sql = "SELECT * FROM attendance";
            PreparedStatement pstmt = conn.prepareStatement(sql);
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                Attendance attendance = new Attendance();
                attendance.setId(rs.getInt("id"));
                attendance.setStudentName(rs.getString("studentName"));
                attendance.setClassName(rs.getString("className"));
                attendance.setDate(rs.getString("date"));
                attendance.setTime(rs.getString("time"));
                attendance.setTeacherName(rs.getString("teacherName"));
                attendance.setPresent(rs.getBoolean("present"));
                attendanceList.add(attendance);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return attendanceList;
    }
}
