/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.example.demo.Interface;

import com.example.demo.Modelo.Room;
import org.springframework.data.repository.CrudRepository;

/**
 *
 * @author @CjVm93
 */
public interface RoomInterface extends CrudRepository<Room, Integer> {
    
}
