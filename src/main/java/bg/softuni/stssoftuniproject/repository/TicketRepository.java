package bg.softuni.stssoftuniproject.repository;

import bg.softuni.stssoftuniproject.model.dto.AllTicketsDTO;
import bg.softuni.stssoftuniproject.model.entity.Ticket;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Set;

@Repository
public interface TicketRepository extends JpaRepository<Ticket,Long> {

    Set<Ticket> findAllByClientId(Long id);

@Query(value = "select  t.subject " +
        "from `tickets` t " +
        "join `tickets_products`  " +
        "tp on t.id=tp.ticket_id " +
        "join `products` p " +
        "on tp.product_id=p.id " +
        "where p.serial_number=:serialNumber",nativeQuery = true)
    List<Object[]> findAllByProductSerialNumber(String serialNumber);

    List<Ticket> findAllByOrderByIdAsc();
    List<Ticket> findAll();
}
