package com.frankmoley.lil.roomwebapp.web.api;

import com.frankmoley.lil.roomwebapp.service.StaffService;
import com.frankmoley.lil.roomwebapp.web.model.Staff;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping(name = "/api/staff")
public class StaffApiController {

    private final StaffService staffService;

    public StaffApiController(StaffService staffService) {
        this.staffService = staffService;
    }

    @GetMapping
    public List<Staff> getAllStaffs(){
        return this.staffService.getAllStaffs();
    }

    @PostMapping
    public Staff addNewStaff(Staff staff){
       return this.staffService.addNewStaff(staff);
    }

    @PutMapping(name = "/{id}")
    public Staff updateStaffbyId(UUID idStaff, Staff staff){
        return this.staffService.updateStaff(staff);
    }

    @DeleteMapping(name = "/{id}")
    public void deleteStaff(UUID idStaff){
        this.staffService.deleteStaff(idStaff);
    }

}
