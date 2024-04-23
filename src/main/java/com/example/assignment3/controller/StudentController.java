// package com.example.controller;

// public class StudentController {
    
// }


package com.example.assignment3.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
// import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
// import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.assignment3.exception.ResourceNotFoundException;
import com.example.assignment3.model.Student;
import com.example.assignment3.repository.StudentRepository;


// @CrossOrigin(origins = "http://localhost:4200")

@RestController
public class StudentController {

	@Autowired 
	private StudentRepository studentrepository;
	

	@GetMapping("/surveys") 
	public List<Student> getAllStudents(){
		return studentrepository.findAll();
	}
	
	//insert student survey in db
	@PostMapping("/survey")
	public Student createStudent(@RequestBody Student student){
		return studentrepository.save(student);
	}
	
	@GetMapping("/surveys/{id}")
	public ResponseEntity<Student>getStudentById(@PathVariable Long id) {		
	Student student=  studentrepository.findById(id)
			.orElseThrow(()->new ResourceNotFoundException("Employee doesn't exist with Id:" +id));
		return ResponseEntity.ok(student);
	}
	
	
	
	@PutMapping("/surveys/{id}")
	public ResponseEntity<Student>updateStudent(@PathVariable Long id, @RequestBody Student studentDetails)
	{
		Student student=  studentrepository.findById(id)
				.orElseThrow(()->new ResourceNotFoundException("Employee doesn't exist with Id:" +id));
		student.setFirstName(studentDetails.getFirstName());
		student.setLastName(studentDetails.getLastName());
		student.setEmail(studentDetails.getEmail());
		student.setCity(studentDetails.getCity());
		student.setComments(studentDetails.getComments());
		student.setDateOfSurvey(studentDetails.getDateOfSurvey());
		student.setLikedOptions(studentDetails.getLikedOptions());
		student.setLikelihoodToRecommend(studentDetails.getLikelihoodToRecommend());
		student.setSourceOfInterest(studentDetails.getSourceOfInterest());
		student.setState(studentDetails.getState());
		student.setStreetAddress(studentDetails.getStreetAddress());
		student.setTelephone(studentDetails.getTelephone());
		student.setZip(studentDetails.getZip());
		
		Student updatedStudent = studentrepository.save(student);
		System.out.println("Received data: " + studentDetails.toString());

	    // Your existing update logic

	    System.out.println("Updated student: " + updatedStudent.toString());
		return ResponseEntity.ok(updatedStudent);
		
	}
	
	@DeleteMapping("/surveys/{id}")
	public  ResponseEntity<Map<String, Boolean>> deleteStudent(@PathVariable Long id){
		Student student=  studentrepository.findById(id)
        .orElseThrow(()->new ResourceNotFoundException("Employee doesn't exist with Id:" +id));
		studentrepository.delete(student);
		Map<String, Boolean> response = new HashMap<>();
		response.put("Deleted", Boolean.TRUE);
		return ResponseEntity.ok(response);
	
	}
	
}