package bg.softuni.stssoftuniproject.web;

import bg.softuni.stssoftuniproject.model.entity.UserEntity;
import bg.softuni.stssoftuniproject.repository.UserRepository;
import bg.softuni.stssoftuniproject.service.UserService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors.csrf;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
class UserControllerTestIT {



    @Autowired
    private MockMvc mockMvc;


    @Test
    void testRegister() throws Exception {
mockMvc.perform(
        MockMvcRequestBuilders.post("/users/register")
                .param("firstName","testFirstName")
                .param("lastName","testLastName")
                .param("email","test@mail.com")
                .param("password","testpass")
                .param("confirmPassword","testpass")
                .with(csrf())

).andExpect(status().is3xxRedirection());




    }


    @Test
    void testMakeAdmin() throws Exception {

            mockMvc.perform
                    (MockMvcRequestBuilders.post("/users/promote-admin-role")
                            .param("userId", "2")
                            .with(csrf())
                    ).andExpect(status().is3xxRedirection());
        }
    }






