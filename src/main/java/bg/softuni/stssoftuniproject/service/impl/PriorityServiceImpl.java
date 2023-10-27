package bg.softuni.stssoftuniproject.service.impl;

import bg.softuni.stssoftuniproject.model.entity.Priority;
import bg.softuni.stssoftuniproject.model.enums.PriorityEnum;
import bg.softuni.stssoftuniproject.repository.PriorityRepository;
import bg.softuni.stssoftuniproject.service.PriorityService;
import org.springframework.stereotype.Service;

import static bg.softuni.stssoftuniproject.model.enums.PriorityDescriptions.*;

@Service
public class PriorityServiceImpl implements PriorityService {
    private PriorityRepository priorityRepository;

    public PriorityServiceImpl(PriorityRepository priorityRepository) {
        this.priorityRepository = priorityRepository;
    }

    @Override
    public void priorityInit() {

        if (priorityRepository.count() == 0){

            Priority low = new Priority();
            Priority medium = new Priority();
            Priority high = new Priority();

            low.setName(PriorityEnum.LOW);
            low.setDescription(LOW_DESC);

            medium.setName(PriorityEnum.MEDIUM);
            medium.setDescription(MEDIUM_DESC);

            high.setName(PriorityEnum.HIGH);
            high.setDescription(HIGH_DESC);

            priorityRepository.save(low);
            priorityRepository.save(medium);
            priorityRepository.save(high);
        }

    }
}
