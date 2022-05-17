package com.example.student;

//import  org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
public interface StudentRepository extends JpaRepository<StudentForm, Integer> {

//    @Query(nativeQuery = true, value = "SELECT * FROM student order by id_student")
//    @Query("SELECT s FROM StudentForm s")

    List<StudentForm> findAll();



//    @Query(nativeQuery = true,value = "SELECT * FROM student where id_student =:id")
//    @Query("SELECT s FROM StudentForm s where s.id =:id")
//    StudentForm getStudentById(@Param("id") Long id);
    StudentForm findStudentFormById(Long id);

    //method for update

    @Modifying
    @Transactional
    @Query(nativeQuery = true, value = "UPDATE student SET first_name =:fName, last_name =:lName, department =:department WHERE id_student =:id")
    void updateStudentToDb(@Param("id") Long id,
                                        @Param("fName") String firstName,
                                        @Param("lName") String lastName,
                                        @Param("department") String department);




//    @Modifying
//    @Transactional
//    @Query(nativeQuery = true, value = "DELETE  From student WHERE id_student =:id")
    @Modifying
    @Transactional
    void deleteStudentFormById(Long id);

//    @Modifying
//    @Transactional
//    @Query(nativeQuery = true, value = "DELETE  From student WHERE id_student =:id")
//    void deletestudentById(@Param("id") Long id);

    //new methods that support update by jpa query method
    void save(Long id);
    StudentForm findById(Long id);

//    @Modifying
//    @Transactional
//    void updateStudentFormById(Long id);
//@Query(nativeQuery = true, value = "Select * from student un ORDER BY un.id_student DESC LIMIT 1")
//StudentForm getLastSequence();


}
