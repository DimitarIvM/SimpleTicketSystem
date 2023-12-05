package bg.softuni.stssoftuniproject.web;

import bg.softuni.stssoftuniproject.model.dto.ProductDTO;
import bg.softuni.stssoftuniproject.model.dto.TicketDTO;
import bg.softuni.stssoftuniproject.service.TicketService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin("*")
@RestController
@RequestMapping("/api/tickets")
public class TicketRestController {

    private final TicketService ticketService;

    public TicketRestController(TicketService ticketService) {
        this.ticketService = ticketService;
    }

    @GetMapping("/{serialNumber}")
    public ResponseEntity<List<Object[]>> findById(@PathVariable("serialNumber") String serialNumber){
        List<Object[]> ticketsForProduct = ticketService.findTicketsForProduct(serialNumber);

        return ResponseEntity.ok(ticketsForProduct);


    }




    }

