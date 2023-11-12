package bg.softuni.stssoftuniproject.repository;

import bg.softuni.stssoftuniproject.model.entity.Priority;
import bg.softuni.stssoftuniproject.model.enums.PriorityEnum;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PriorityRepository extends JpaRepository<Priority,Long> {
    Priority findByName(PriorityEnum name);
}
