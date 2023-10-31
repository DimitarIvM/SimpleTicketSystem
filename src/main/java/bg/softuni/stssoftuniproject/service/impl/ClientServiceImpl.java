package bg.softuni.stssoftuniproject.service.impl;

import bg.softuni.stssoftuniproject.model.dto.ClientRegistrationDTO;
import bg.softuni.stssoftuniproject.model.entity.Client;
import bg.softuni.stssoftuniproject.repository.ClientRepository;
import bg.softuni.stssoftuniproject.service.ClientService;
import bg.softuni.stssoftuniproject.service.CompanyService;
import org.modelmapper.ModelMapper;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class ClientServiceImpl implements ClientService {
    private final ClientRepository clientRepository;
    private final ModelMapper modelMapper;
    private CompanyService companyService;
    private PasswordEncoder passwordEncoder;

    public ClientServiceImpl(ClientRepository clientRepository, ModelMapper modelMapper, CompanyService companyService, PasswordEncoder passwordEncoder) {
        this.clientRepository = clientRepository;
        this.modelMapper = modelMapper;
        this.companyService = companyService;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public void register(ClientRegistrationDTO clientRegistrationDTO) {

        this.clientRepository.save(modelMapper.map(clientRegistrationDTO, Client.class));

    }

    @Override
    public Client findByEmail(String mail) {
        return this.clientRepository.findByEmail(mail);
    }

    @Override
    public void clientInit() {
        if (clientRepository.count()==0){

            Client client = new Client();

            client.setCompany(companyService.findByName("A1").get());
            client.setEmail("test@mail.com");
            client.setFirstName("Charlie");
            client.setLastName("Sheen");
            client.setPassword(passwordEncoder.encode("12345"));

            clientRepository.save(client);
        }

    }
}
