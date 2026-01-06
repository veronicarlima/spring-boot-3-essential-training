package com.frankmoley.lil.roomwebapp.web.model;
import lombok.*;
import java.util.UUID;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Room {
    private UUID id;
    private String number;
    private String name;
    private String info;

}
