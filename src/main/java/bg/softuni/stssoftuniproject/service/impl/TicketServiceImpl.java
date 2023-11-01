package bg.softuni.stssoftuniproject.service.impl;

import bg.softuni.stssoftuniproject.model.dto.AllTicketsDTO;
import bg.softuni.stssoftuniproject.model.dto.TicketDTO;
import bg.softuni.stssoftuniproject.model.dto.TicketSubmitDTO;
import bg.softuni.stssoftuniproject.model.dto.TicketViewDTO;
import bg.softuni.stssoftuniproject.model.entity.Ticket;
import bg.softuni.stssoftuniproject.repository.TicketRepository;
import bg.softuni.stssoftuniproject.service.ClientService;
import bg.softuni.stssoftuniproject.service.CompanyService;
import bg.softuni.stssoftuniproject.service.TicketService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
public class TicketServiceImpl implements TicketService {
    private final TicketRepository ticketRepository;
    private final CompanyService companyService;
    private final ClientService clientService;
    private final ModelMapper modelMapper;

    public TicketServiceImpl(TicketRepository ticketRepository, CompanyService companyService, ClientService clientService, ModelMapper modelMapper) {
        this.ticketRepository = ticketRepository;
        this.companyService = companyService;
        this.clientService = clientService;
        this.modelMapper = modelMapper;
    }


    @Override
    public void submitTicket(TicketSubmitDTO ticketSubmitDTO) {

        //TODO: just for test - to be implemented
        clientService.clientInit();

        Ticket ticket = modelMapper.map(ticketSubmitDTO, Ticket.class);


        ticket.setClient(clientService.findByEmail("test@mail.com"));
        ticket.setCompany(companyService.findByName("A1").get());


        ticketRepository.save(ticket);
    }

    @Override
    public TicketViewDTO getTicketById(Long id) {

        Ticket ticket = this.ticketRepository.findById(id).get();


        return modelMapper.map(ticket, TicketViewDTO.class);
    }



    @Override
    public AllTicketsDTO getAllById(Long id) {

        AllTicketsDTO allTicketsDTO = new AllTicketsDTO();
        allTicketsDTO.setTickets(getTickets(id));

        return allTicketsDTO;



    }

    @Override
    public void saveNotes(TicketViewDTO ticketViewDTO) {

        Ticket ticket = this.findById(ticketViewDTO.getId());


            ticket.setNotes(ticketViewDTO.getNotes());




        this.ticketRepository.save(ticket);
    }

    private Ticket findById(Long id) {
            return this.ticketRepository.findById(id).isPresent() ? this.ticketRepository.findById(id).get(): null;
    }

    private Set<TicketDTO> getTickets(Long companyId){

        Set<TicketDTO> tickets = new HashSet<>();

        Set<Ticket> allByCompanyId = this.getAllByCompanyId(companyId);

        for (Ticket ticket : allByCompanyId) {

            tickets.add( modelMapper.map(ticket,TicketDTO.class));
        }
        return tickets;

    }


    private Set<Ticket> getAllByCompanyId(Long companyId) {
        return ticketRepository.findAllByCompanyId(companyId);
    }
}
