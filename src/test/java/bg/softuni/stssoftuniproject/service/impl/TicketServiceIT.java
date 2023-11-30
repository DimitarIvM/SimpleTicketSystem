package bg.softuni.stssoftuniproject.service.impl;

import bg.softuni.stssoftuniproject.model.dto.TicketAnswerDTO;
import bg.softuni.stssoftuniproject.model.dto.TicketDTO;
import bg.softuni.stssoftuniproject.model.dto.TicketSubmitDTO;
import bg.softuni.stssoftuniproject.model.entity.Role;
import bg.softuni.stssoftuniproject.model.entity.Ticket;
import bg.softuni.stssoftuniproject.model.entity.UserEntity;
import bg.softuni.stssoftuniproject.model.enums.PriorityEnum;
import bg.softuni.stssoftuniproject.model.enums.RolesEnum;
import bg.softuni.stssoftuniproject.repository.RoleRepository;
import bg.softuni.stssoftuniproject.repository.TicketRepository;
import bg.softuni.stssoftuniproject.repository.UserRepository;
import bg.softuni.stssoftuniproject.service.RoleService;
import bg.softuni.stssoftuniproject.service.TicketService;
import bg.softuni.stssoftuniproject.service.UserService;
import org.junit.Before;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.test.context.support.WithUserDetails;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

import static org.mockito.Mockito.when;
import static org.springframework.security.test.context.support.TestExecutionEvent.TEST_METHOD;

@SpringBootTest
@AutoConfigureMockMvc
public class TicketServiceIT {

    @Autowired
   private TicketService testService;

    @MockBean
    private TicketRepository ticketRepository;

  @MockBean
  private static RoleService roleService;

      @MockBean
     private UserService userService;

    @Autowired
    private UserRepository userRepository;


    @BeforeEach
    void setUp(){

        UserEntity user = createTestUser();

        userRepository.save(user);

        Authentication auth = SecurityContextHolder.getContext().getAuthentication();

        when(auth.getName()).thenReturn("Test@Assignee.com");
    }
      @Test
    void testSubmitTicket(){


          TicketSubmitDTO ticketSubmitDTO = ticketSubmitDTO();
          testService.submitTicket(ticketSubmitDTO);

        Ticket saved = ticketRepository.findById(ticketSubmitDTO.getId()).get();

Assertions.assertNotNull(saved);





      }

      private TicketSubmitDTO ticketSubmitDTO(){

          TicketSubmitDTO ticketSubmitDTO =new TicketSubmitDTO();

          ticketSubmitDTO.setId(1L);
          ticketSubmitDTO.setDescription("TestDEsc");
          ticketSubmitDTO.setClient(userService.getLoggedUser().getEmail());
          ticketSubmitDTO.setSubject("testSubkect");
          ticketSubmitDTO.setCreated(LocalDateTime.now());
                    return ticketSubmitDTO;
      }

    private static UserEntity createTestUser() {
        UserEntity user = new UserEntity();
        Role byRoleName = roleService.findByRoleName(RolesEnum.USER);


        Set<Role> roles = new HashSet<>();
        roles.add(byRoleName);
        user.setEmail("Test@Assignee.com");
        user.setFirstName("testFirstName");
        user.setLastName("testLastName");
        user.setPassword("testpass");
        user.setRoles(roles);



        return user;
    }



}
