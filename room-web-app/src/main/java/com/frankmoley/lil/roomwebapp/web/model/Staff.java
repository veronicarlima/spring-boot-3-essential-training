package com.frankmoley.lil.roomwebapp.web.model;
import com.frankmoley.lil.roomwebapp.utils.Position;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Staff {
    private String employeeId;
    private String firstName;
    private String lastName;
    private Position position;
}
