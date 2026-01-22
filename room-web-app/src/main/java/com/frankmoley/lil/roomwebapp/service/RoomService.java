package com.frankmoley.lil.roomwebapp.service;

import com.frankmoley.lil.roomwebapp.data.entity.RoomEntity;
import com.frankmoley.lil.roomwebapp.data.repository.RoomRepository;
import com.frankmoley.lil.roomwebapp.web.model.Room;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class RoomService {

    private final RoomRepository roomRepository;


    public RoomService(RoomRepository roomRepository) {
        this.roomRepository = roomRepository;
    }

    public List<Room> getAllRooms(){
    List<RoomEntity> roomEntityList = this.roomRepository.findAll();
    List<Room> rooms = new ArrayList<>(roomEntityList.size());
    roomEntityList.forEach(e ->rooms.add(getRoomFromEntity(e)));
    return rooms;
    }

    public Room getRoomById(UUID id){
        Optional<RoomEntity> entity = this.roomRepository.findById(id);
        if(entity.isEmpty()){
            return null;
        }else {
            return this.getRoomFromEntity(entity.get());
        }
    }

    public Room addRoom(Room room){
        RoomEntity entity = this.getEntityFromRoom(room);
        entity = this.roomRepository.save(entity); //pode dar nullpointer se nao voltar*
        return this.getRoomFromEntity(entity); //aqui so para retornar o id.*
    }

    public Room updateRoom(Room room){ //mesma coisa do salvar

        RoomEntity entity = this.getEntityFromRoom(room);
        entity = this.roomRepository.save(entity);
        return this.getRoomFromEntity(entity);
    }

    public void deleteRoom(UUID idRoom){
        this.roomRepository.deleteById(idRoom);
    }

    private Room getRoomFromEntity(RoomEntity entity){
        return  new Room( entity.getRoomId(),entity.getName(),entity.getNumber(), entity.getBedInfo());
    }

    private RoomEntity getEntityFromRoom(Room room){
        return new RoomEntity(room.getId(),room.getName(),room.getNumber(),room.getInfo());
    }

}
