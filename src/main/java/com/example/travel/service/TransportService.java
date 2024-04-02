package com.example.travel.service;

import com.example.travel.model.Transport;
import com.example.travel.repository.TransportRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TransportService {
    @Autowired
    private TransportRepository transportRepository;

    public List<Transport> getAllTransport(){
        return transportRepository.findAll();
    }

    public Transport getTransportById(long id){
        return transportRepository.findById(id).orElse(null);
    }

    public List<Transport> getAllByType(String type){
        return transportRepository.findAllByType(type);
    }

    public List<Transport> getAllByComfort(int comfort){
        return transportRepository.findAllByComfort(comfort);
    }

    public List<Transport> getAllByFirma(String firma){
        return transportRepository.findAllByFirma(firma);
    }



    public Transport createTransport(Transport transport){
        return transportRepository.save(transport);
    }

    public void deleteTransport (Long transportId){
        transportRepository.deleteById(transportId);
    }


}