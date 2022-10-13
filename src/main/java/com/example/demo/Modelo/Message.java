/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.demo.Modelo;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 *
 * @author @CjVm93
 */
@Entity
@Table(name = "message")
public class Message {
   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY) 
   private Integer idMessage;
   private String messageText;
   
  @ManyToOne
  @JoinColumn(name = "roomId")
  @JsonIgnoreProperties({"messages","reservations"})
  private Room room;
  
   @ManyToOne
  @JoinColumn(name = "clientId")
  @JsonIgnoreProperties({"messages","reservations"})
  private Client client;

    public Integer getIdMessage() {
        return idMessage;
    }

    public void setIdMessage(Integer idMessage) {
        this.idMessage = idMessage;
    }

    public String getMessageText() {
        return messageText;
    }

    public void setMessageText(String messageText) {
        this.messageText = messageText;
    }

    public Room getRoom() {
        return room;
    }

    public void setRoom(Room room) {
        this.room = room;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    
}
