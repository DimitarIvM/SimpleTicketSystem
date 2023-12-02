package bg.softuni.stssoftuniproject.web;

import bg.softuni.stssoftuniproject.model.dto.*;
import bg.softuni.stssoftuniproject.service.TicketService;
import bg.softuni.stssoftuniproject.service.UserService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

public class TicketControllerTestIT {

    private TicketController ticketController;

    @Mock
    private TicketService ticketService;

    @Mock
    private UserService userService;

    private MockMvc mockMvc;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
        ticketController = new TicketController(ticketService, userService);
        mockMvc = MockMvcBuilders.standaloneSetup(ticketController).build();
    }

    @Test
    public void testGetAllTicketsForAdmin() throws Exception {
        when(ticketService.getAllAvailableTickets()).thenReturn(new AllTicketsDTO());

        mockMvc.perform(get("/tickets/all"))
                .andExpect(status().isOk())
                .andExpect(view().name("all-tickets"))
                .andExpect(model().attributeExists("allAvailableTicketsDTO"));

        verify(ticketService, times(1)).getAllAvailableTickets();
    }

    @Test
    public void testAnswerTicket() throws Exception {
        Long ticketId = 1L;
        TicketViewDTO ticketViewDTO = new TicketViewDTO();
        when(ticketService.getTicketById(ticketId)).thenReturn(ticketViewDTO);

        mockMvc.perform(get("/ticket/answer/{id}", ticketId))
                .andExpect(status().isOk())
                .andExpect(view().name("ticket-view-admin"))
                .andExpect(model().attribute("ticketViewDTO", ticketViewDTO));

        verify(ticketService, times(1)).getTicketById(ticketId);
    }
}


