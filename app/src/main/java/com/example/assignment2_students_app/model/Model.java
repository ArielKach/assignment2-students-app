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
        studentList.add(new Student( "1","Moshe", R.drawable.student_image,"1111","aaaa",false ));
        studentList.add(new Student("2" ,"David", R.drawable.student_image,"2222","bbbb",false ));
        studentList.add(new Student( "3","Yossi", R.drawable.student_image,"3333","cccc",false ));
        studentList.add(new Student( "4","Hezi", R.drawable.student_image,"4444","dddd",false ));
        studentList.add(new Student( "5","Dudi", R.drawable.student_image,"5555","eeee",false ));
        studentList.add(new Student( "6","Asi", R.drawable.student_image,"6666","ffff",false ));
        studentList.add(new Student( "7","Yotam", R.drawable.student_image,"7777","gggg",false ));
        studentList.add(new Student( "8","Yoni", R.drawable.student_image,"8888","hhhh",false ));
        studentList.add(new Student( "9","Rossi", R.drawable.student_image,"9999","iiii",false ));
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
