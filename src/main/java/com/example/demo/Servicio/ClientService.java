/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.demo.Servicio;

import com.example.demo.Modelo.Client;
import com.example.demo.Repositorio.ClientRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *CjVm93
 */
@Service
public class ClientService {
      @Autowired
    private ClientRepository clientRepository;
    
    public List<Client> getAll(){
        return clientRepository.getAll();
    }
    public Optional<Client> getClient(int id){
        return clientRepository.getClient(id);
    }
    public Client save (Client client){
            if (client.getIdClient() == null){
        return clientRepository.save(client);
    }else{
    Optional<Client> client1 = clientRepository.getClient(client.getIdClient());
    if(client1.isEmpty()){
        return clientRepository.save(client);
    }else{
        return client;
    }
}           
} 
    public Client update(Client client){
        if(client.getIdClient() !=null){
            Optional<Client>e= clientRepository.getClient(client.getIdClient());
            if(!e.isEmpty()){
            if(client.getName()!=null){
                e.get().setName(client.getName());
            }
            if(client.getAge()!=null){
                e.get().setAge(client.getAge());
            }    
            if(client.getPassword()!=null){
                e.get().setPassword(client.getPassword());
            }
            clientRepository.save(e.get());
            return e.get();
        }else{
                return client;
            }
        }else{
            return client;
        }
    }
    
    
    public boolean deleteClient(int id){
        Boolean d = getClient(id).map(client ->{
            clientRepository.delete(client);
            return true;
            
        }).orElse(false);
        return d;
    }
} 

