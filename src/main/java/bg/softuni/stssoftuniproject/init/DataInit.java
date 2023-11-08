package bg.softuni.stssoftuniproject.init;

import bg.softuni.stssoftuniproject.service.PriorityService;
import bg.softuni.stssoftuniproject.service.RoleService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DataInit implements CommandLineRunner {
    private PriorityService priorityService;
    private RoleService roleService;



    public DataInit(PriorityService priorityService, RoleService roleService ) {
        this.priorityService = priorityService;

        this.roleService = roleService;
    }


    @Override
    public void run(String... args) throws Exception {

        this.priorityService.priorityInit();
        this.roleService.rolesInit();




    }
}
