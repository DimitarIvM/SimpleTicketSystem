package bg.softuni.stssoftuniproject.web;

import bg.softuni.stssoftuniproject.service.UserService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.web.servlet.ModelAndView;

import static org.mockito.Mockito.mock;
import static org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors.csrf;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
@SpringBootTest
@AutoConfigureMockMvc
public class UserControllerTestIT {

    @Autowired
    private MockMvc mockMvc;

    @Mock
    private UserService userService;


    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
        ModelAndView modelAndView = mock(ModelAndView.class);
    }



    @Test
    void testMakeAdmin() throws Exception {

        mockMvc.perform
                (MockMvcRequestBuilders.post("/users/promote-admin-role")
                        .param("userId", "2")
                        .with(csrf())
                ).andExpect(status().is3xxRedirection());
    }


    @Test
    void testRegister() throws Exception {
        mockMvc.perform(
                MockMvcRequestBuilders.post("/users/register")
                        .param("firstName", "testFirstName")
                        .param("lastName", "testLastName")
                        .param("email", "test@mail.com")
                        .param("password", "testpass")
                        .param("confirmPassword", "testpass")
                        .with(csrf())

        ).andExpect(status().is3xxRedirection());


    }
}