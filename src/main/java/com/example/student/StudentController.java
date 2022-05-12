package com.example.student;

import org.springframework.web.bind.annotation.RestController;

@RestController
public class StudentController {
//    PreparedStatement preparedStatement= null;

//    StudentRepository repo;
//
//    @Autowired
//    public StudentController(StudentRepository repo) {
//        this.repo = repo;
//    }


//   for view data button
//  get list of students from db
//    @GetMapping("/getAllStudentsDb")
//    public List<StudentForm> getAllDbStudents(){
//        return  repo.findAll();
//    };

//  create new/save item
//    @PostMapping("/addNewStudentsDb")
//    public String addNewStudent(@ModelAttribute("students")  StudentForm students){
//        repo.save(students);
//        return "register_success";
//    };
//  update
//    @PostMapping("/addNewStudentsDb/{id}")
//    public String updateMethod(@PathVariable("id") Long id,@ModelAttribute("students")  StudentForm students) throws SQLException {
//        repo.updateStudentToDb(id,students.getFirstName(),students.getLastName(),students.getDepartment());
//        return "sucess";
//    };

//  Delete
//    @GetMapping("/deleteFromDb/{id}")
//    public String deleteStudentDb(@PathVariable("id") Long id)  {
//        repo.deletestudentById(id);
//        return "sucessfully deleted";
//    };






}
