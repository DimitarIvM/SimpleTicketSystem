package bg.softuni.stssoftuniproject.service.impl;

import bg.softuni.stssoftuniproject.model.dto.ClientRegistrationDTO;
import bg.softuni.stssoftuniproject.model.entity.Client;
import bg.softuni.stssoftuniproject.repository.ClientRepository;
import bg.softuni.stssoftuniproject.service.ClientService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
public class ClientServiceImpl implements ClientService {
    private final ClientRepository clientRepository;
    private final ModelMapper modelMapper;

    public ClientServiceImpl(ClientRepository clientRepository, ModelMapper modelMapper) {
        this.clientRepository = clientRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public void register(ClientRegistrationDTO clientRegistrationDTO) {

        this.clientRepository.save(modelMapper.map(clientRegistrationDTO, Client.class));

    }
}
