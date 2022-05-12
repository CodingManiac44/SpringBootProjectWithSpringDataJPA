package com.example.student;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class StudentService {
    private static Map<Long, Student> students = new HashMap<>();
    private static Long index= 2L;
    static {
        Student student1= new Student("saidur","rahman","ICT",1L);
        Student student2= new Student("sabbir","alam","Health",2L);
        students.put(1l,student1);
        students.put(2l,student2);
    }



    //for adding an Student
    public static Student saveStudent(Student student){
        index+=1;
        student.setId(index);
        students.put(index,student);
//        StudentRepository.save(student);
        return student;
    }
   // get list of all students
    public static List<Student> getAllStudents() {
        return new ArrayList<>(students.values());
    }
    // get by id
    public static Student getStudentByID(Long id) {
        return (students.get(id));
    }
    //delete by id
    public static Student deleteStudentByID(Long id) {
        return (students.remove(id));
    }

    public static Student updateStudent(Long id, Student student) {
        student.setId(id);
        students.put(id,student);
        return student;
    }


}
