package es.leanmind.springbootusersignupapi.infrastructure.http;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class SignUpUserControllerShould {

    @Autowired
    private MockMvc mockMvc;

    @Test
    void returnsOkOnSuccessUserSignUp() throws Exception {

        mockMvc.perform(MockMvcRequestBuilders
                .post("/api/users")
                .content("{ \"username\": \"peter@company.org\", \"password\": \"123.Asdf\" }"))
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.user").exists())
                .andExpect(MockMvcResultMatchers.jsonPath("$.user.username").value("peter@company.org"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.user.role").value("USER"));
    }
}
