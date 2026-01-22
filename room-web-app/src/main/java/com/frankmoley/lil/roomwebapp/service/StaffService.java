package com.frankmoley.lil.roomwebapp.service;

import com.frankmoley.lil.roomwebapp.data.entity.EmployeesEntity;
import com.frankmoley.lil.roomwebapp.data.repository.EmployeesRepository;
import com.frankmoley.lil.roomwebapp.utils.Position;
import com.frankmoley.lil.roomwebapp.web.model.Staff;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import javax.swing.text.html.Option;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class StaffService {

    private final EmployeesRepository staffRepository;


    public StaffService(EmployeesRepository staffRepository) {
        this.staffRepository = staffRepository;
    }

    public List<Staff> getAllStaffs(){
        List<EmployeesEntity> employeesEntities = this.staffRepository.findAll();
        List<Staff> staffList = new ArrayList<>(employeesEntities.size());
        employeesEntities.forEach( s -> staffList.add(getStaffFromEmployeeEntity(s)));
        return staffList;
    }
    

    public Staff getStaffbyId( UUID staffId){
       Optional<EmployeesEntity> employeesEntity = this.staffRepository.findById(staffId);
       if(employeesEntity.isEmpty()){
           return null;
       }else{
            return this.getStaffFromEmployeeEntity(employeesEntity.get());
       }
    }


    public Staff addNewStaff(Staff staff){
        EmployeesEntity employeesEntityStaff = this.getEmployeeEntityFromStaff(staff);
         employeesEntityStaff = this.staffRepository.save(employeesEntityStaff);
        return this.getStaffFromEmployeeEntity(employeesEntityStaff);
    }


    public Staff updateStaff(Staff staff){
        EmployeesEntity employeesEntityStaff = this.getEmployeeEntityFromStaff(staff);
        employeesEntityStaff = this.staffRepository.save(employeesEntityStaff);
        return this.getStaffFromEmployeeEntity(employeesEntityStaff);
    }


    public void deleteStaff(UUID staffId){
        this.staffRepository.deleteById(staffId);
    }


    private Staff getStaffFromEmployeeEntity(EmployeesEntity entity){
        return new Staff( entity.getEmployeeId(),entity.getFirstName(),entity.getLastName(),entity.getPosition().toString());
    }

    private EmployeesEntity getEmployeeEntityFromStaff(Staff staff){
        return new EmployeesEntity(staff.getEmployeeId(),staff.getFirstName(),staff.getLastName(), Position.valueOf(staff.getPosition()));
    }


}
