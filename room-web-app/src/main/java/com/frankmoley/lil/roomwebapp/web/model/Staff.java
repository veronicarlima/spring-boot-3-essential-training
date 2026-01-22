package com.frankmoley.lil.roomwebapp.web.model;
import com.frankmoley.lil.roomwebapp.utils.Position;
import lombok.*;

import java.util.UUID;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Staff {
    private UUID employeeId;
    private String firstName;
    private String lastName;
    private String position;
}
