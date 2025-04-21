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
import java.util.List;
import com.crio.learning_navigator.controllers.SubjectController;
import com.crio.learning_navigator.models.Subject;
import com.crio.learning_navigator.services.SubjectService;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath; 
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;


@WebMvcTest(SubjectController.class)
public class SubjectControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private SubjectService subjectService;

    @Test
    public void testGetAllSubjects() throws Exception {
    Subject subject = new Subject();
    subject.setId(1L);
    subject.setSubjectName("Physics");  

    Mockito.when(subjectService.getAllSubjects()).thenReturn(List.of(subject));

    mockMvc.perform(get("/subjects"))
            .andExpect(status().isOk())
            .andExpect(jsonPath("$[0].subjectName").value("Physics"));  
}

}
