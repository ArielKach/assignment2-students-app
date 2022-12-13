package com.example.assignment2_students_app.model;

import com.example.assignment2_students_app.R;

import java.util.LinkedList;
import java.util.List;

public class Model {
    private static final Model _instance = new Model();

    public static Model getInstance(){
        return _instance;
    }

    private Model(){
        for (int i = 0; i < 20; i++) {
            studentList.add(new Student( Integer.toString(i),"name: " + i, R.drawable.student_image,"","",false ));
        }
    }

    public void addStudent (Student newStudent) {
        studentList.add(newStudent);
    }

    public void deleteStudent(int studentPos) {
        studentList.remove(studentPos);
    }

    List<Student> studentList = new LinkedList<>();

    public List<Student> getAllStudents(){
        return studentList;
    }

}
