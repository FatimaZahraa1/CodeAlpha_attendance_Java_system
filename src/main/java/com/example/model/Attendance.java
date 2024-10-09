package com.example.model;

public class Attendance {
    private int id;
    private String studentName;
    private boolean present;
    private String date;
    private String className;
    private String time;         
    private String teacherName; 


    public Attendance() {}

    public Attendance(int id, String studentName, boolean present,String date, String className, String time, String teacherName) {
        this.id = id;
        this.studentName = studentName;
        this.date = date;
        this.className = className;
        this.time = time;
        this.teacherName = teacherName;
        this.present = present;
        
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public boolean isPresent() {
        return present;
    }

    public void setPresent(boolean present) {
        this.present = present;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getTeacherName() {
        return teacherName;
    }

    public void setTeacherName(String teacherName) {
        this.teacherName = teacherName;
    }
}
