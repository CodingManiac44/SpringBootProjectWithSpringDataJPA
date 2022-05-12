package com.example.student;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class ViewController {
    //field autowire
//    @Autowired
//    StudentRepository repo;
    //parameterized autowire
    StudentRepository repo;

    @Autowired
    public ViewController(StudentRepository repo) {
        this.repo = repo;
    }

    //   for view data button
    //  get list of students from db
    @GetMapping("/getAllStudentsDb")
    public List<StudentForm> getAllDbStudents(){
        return  repo.findAll();
    };


    //show edit form
    @GetMapping("/showForm")
    public String showFormpage(Model model){
        StudentForm student= new StudentForm();
        model.addAttribute("students",student);
        return "create_form";
    };

// edit item
    @GetMapping("/showEditForm/{id}")
    public String showFormpagex(Model model, @PathVariable("id") Long id){
        StudentForm studentModel=repo.findStudentFormById(id);
        model.addAttribute("students",studentModel);
        return "edit";
    };


    //controller for landing page
    @GetMapping("/")
    public String landingPage(Model model){
        List<StudentForm> studentList= new ArrayList<>();
        studentList = repo.findAll();
        List<StudentForm> studentModelList= new ArrayList<>();
        Map<String, Object> map = new HashMap<>();
        Long countStudent = repo.count();

        StudentForm student = null;
        if (studentList != null & studentList.size() > 0) {
            for (StudentForm studentForm : studentList) {
                student = new StudentForm();
                student.setId(studentForm.getId());
                student.setFirstName(studentForm.getFirstName());
                student.setLastName(studentForm.getLastName());
                student.setDepartment(studentForm.getDepartment());
                studentModelList.add(student);
            }
        }
        map.put("totalNotFiltered", countStudent);
        map.put("rows", studentModelList);
        model.addAttribute("students",studentModelList);
        model.addAttribute("saidur","saidur");

        return "register_success";
    }


    @PostMapping("/addNewStudentsDb")
    public String addNewStudent(@ModelAttribute("students")  StudentForm students){
        repo.save(students);
        return "details";
    };

    @GetMapping("/addStudentList/{id}")
    public String showDeatailsPagex(Model model, @PathVariable("id") Long id){
        StudentForm studentModel=repo.findStudentFormById(id);
        model.addAttribute("students",studentModel);
        return "details";
    };

    //  Delete
    @GetMapping("/deleteFromDb/{id}")
    public String deleteStudentDb(@PathVariable("id") Long id)  {
        repo.deletestudentById(id);
        return "success";
    };

    @PostMapping("/addNewStudentsDb/{id}")
    public String updateMethod(@PathVariable("id") Long id,@ModelAttribute("students")  StudentForm students) throws SQLException {
        repo.updateStudentToDb(id,students.getFirstName(),students.getLastName(),students.getDepartment());
        return "details";
    };



}
