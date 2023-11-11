package bg.softuni.stssoftuniproject.repository;

import bg.softuni.stssoftuniproject.model.dto.AllTicketsDTO;
import bg.softuni.stssoftuniproject.model.entity.Ticket;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Set;

@Repository
public interface TicketRepository extends JpaRepository<Ticket,Long> {

    Set<Ticket> findAllByClientId(Long id);

}
