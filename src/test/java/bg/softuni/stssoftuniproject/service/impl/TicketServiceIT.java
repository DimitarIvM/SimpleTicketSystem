package bg.softuni.stssoftuniproject.service.impl;

import bg.softuni.stssoftuniproject.model.dto.*;
import bg.softuni.stssoftuniproject.model.entity.*;
import bg.softuni.stssoftuniproject.repository.TicketRepository;
import bg.softuni.stssoftuniproject.service.PriorityService;
import bg.softuni.stssoftuniproject.service.ProductService;
import bg.softuni.stssoftuniproject.service.UserService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.modelmapper.ModelMapper;

import java.time.LocalDateTime;
import java.util.*;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class TicketServiceIT {

    private TicketServiceImpl ticketService;

    @Mock
    private TicketRepository ticketRepository;

    @Mock
    private PriorityService priorityService;

    @Mock
    private UserService userService;

    @Mock
    private ProductService productService;

    @Mock
    private ModelMapper modelMapper;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
        ticketService = new TicketServiceImpl(ticketRepository, priorityService, userService, productService, modelMapper);
    }

    @Test
    public void testSubmitTicket() {

        TicketSubmitDTO ticketSubmitDTO = new TicketSubmitDTO();
        ticketSubmitDTO.setSubject("Test Ticket");
        ticketSubmitDTO.setDescription("Test Description");
        UserEntity userEntity = new UserEntity();
        userEntity.setId(1L);
        when(userService.getLoggedUser()).thenReturn(userEntity);
        when(modelMapper.map(ticketSubmitDTO, Ticket.class)).thenReturn(new Ticket());


        ticketService.submitTicket(ticketSubmitDTO);


        verify(ticketRepository, times(1)).save(any(Ticket.class));
    }



    @Test
    public void testGetAllById() {

        Long userId = 1L;
        Set<Ticket> tickets = new HashSet<>();
        tickets.add(new Ticket());
        when(ticketRepository.findAllByClientId(userId)).thenReturn(tickets);
        when(modelMapper.map(any(Ticket.class), eq(TicketDTO.class))).thenReturn(new TicketDTO());


        AllTicketsDTO allTicketsDTO = ticketService.getAllById(userId);


        assertNotNull(allTicketsDTO);
        assertEquals(1, allTicketsDTO.getTickets().size());
    }



    @Test
    public void testSaveAnswer() {

        TicketAnswerDTO ticketAnswerDTO = new TicketAnswerDTO();
        ticketAnswerDTO.setId(1L);
        when(ticketRepository.findById(ticketAnswerDTO.getId())).thenReturn(Optional.of(new Ticket()));
        when(productService.findAllBySerialNumber(anyString())).thenReturn(new HashSet<>());
        when(userService.findByEmail(anyString())).thenReturn(new UserEntity());


        ticketService.saveAnswer(ticketAnswerDTO);


        verify(ticketRepository, times(1)).save(any(Ticket.class));
    }

    @Test
    public void testDeleteOldTickets() {

        List<Ticket> allTickets = Arrays.asList(new Ticket(), new Ticket());
        LocalDateTime oneDayAgo = LocalDateTime.now().minusDays(100);
        allTickets.get(0).setModified(oneDayAgo.minusMinutes(101));
        allTickets.get(1).setModified(oneDayAgo.plusMinutes(30));
        when(ticketRepository.findAll()).thenReturn(allTickets);


        ticketService.deleteOldTickets();


        verify(ticketRepository, times(1)).delete(allTickets.get(0));
        verify(ticketRepository, never()).delete(allTickets.get(1));
    }


}
