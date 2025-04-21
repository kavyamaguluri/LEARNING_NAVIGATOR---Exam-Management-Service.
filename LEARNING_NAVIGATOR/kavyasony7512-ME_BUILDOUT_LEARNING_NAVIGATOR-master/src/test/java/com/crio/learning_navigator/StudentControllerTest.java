package com.crio.learning_navigator;


import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post; 
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status; 
import com.crio.learning_navigator.controllers.StudentController;
import com.crio.learning_navigator.models.Student;
import com.crio.learning_navigator.services.StudentService;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath; 

@WebMvcTest(StudentController.class)
public class StudentControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private StudentService studentService;

    @Test
    public void testCreateStudent() throws Exception {
        
        Student mockStudent = new Student();
        mockStudent.setId(1L);
        mockStudent.setName("Alice");

        Mockito.when(studentService.createStudent(Mockito.any(Student.class))).thenReturn(mockStudent);

        
        mockMvc.perform(post("/students")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("{\"name\":\"Alice\"}"))
                .andExpect(status().isCreated())
                .andExpect(jsonPath("$.id").value(1))
                .andExpect(jsonPath("$.name").value("Alice")); 
    }
}
