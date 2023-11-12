package bg.softuni.stssoftuniproject.service;


import bg.softuni.stssoftuniproject.model.entity.Priority;
import bg.softuni.stssoftuniproject.model.enums.PriorityEnum;

public interface PriorityService {
    void priorityInit();

    Priority findByName(PriorityEnum name);
}
