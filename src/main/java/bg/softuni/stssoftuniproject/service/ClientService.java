package bg.softuni.stssoftuniproject.service;

import bg.softuni.stssoftuniproject.model.dto.ClientRegistrationDTO;
import bg.softuni.stssoftuniproject.model.entity.Client;

import java.util.Map;

public interface ClientService {
    void register(ClientRegistrationDTO clientRegistrationDTO);

    Client findByEmail(String mail);

    void clientInit();
}
