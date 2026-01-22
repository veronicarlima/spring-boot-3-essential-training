package com.frankmoley.lil.roomwebapp.data.entity;

import com.frankmoley.lil.roomwebapp.utils.Position;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.UUID;

@Entity
@Table(name = "EMPLOYEES")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class EmployeesEntity {

    @Id
    @Column(name = "EMPLOYEE_ID")
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID employeeId;

    @Column(name = "FIRST_NAME")
    private String firstName;

    @Column(name = "LAST_NAME")
    private String lastName;

//    @Column(name = "POSITION")
//    private String position;

    @Column(name = "POSITION")
    @Enumerated(EnumType.STRING)
    private Position position;


    @Override
    public String toString() {
        return "EmployeesEntity{" +
                "employeeId=" + employeeId +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", position=" + position +
                '}';
    }
}
