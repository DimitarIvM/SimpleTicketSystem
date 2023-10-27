package bg.softuni.stssoftuniproject.init;

import bg.softuni.stssoftuniproject.model.entity.Company;
import bg.softuni.stssoftuniproject.model.entity.Employee;
import bg.softuni.stssoftuniproject.repository.CompanyRepository;
import bg.softuni.stssoftuniproject.service.PriorityService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.Set;

@Component
public class DataInit implements CommandLineRunner {
    private PriorityService priorityService;


    public DataInit(PriorityService priorityService) {
        this.priorityService = priorityService;

    }


    @Override
    public void run(String... args) throws Exception {

        this.priorityService.priorityInit();



    }
}
