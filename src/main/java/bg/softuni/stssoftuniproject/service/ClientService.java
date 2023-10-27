package bg.softuni.stssoftuniproject.service;

import bg.softuni.stssoftuniproject.model.dto.ClientRegistrationDTO;

public interface ClientService {
    void register(ClientRegistrationDTO clientRegistrationDTO);
}
