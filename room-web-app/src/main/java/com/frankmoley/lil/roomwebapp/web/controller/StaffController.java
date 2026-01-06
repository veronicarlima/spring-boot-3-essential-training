package com.frankmoley.lil.roomwebapp.web.controller;

import com.frankmoley.lil.roomwebapp.data.entity.EmployeesEntity;
import com.frankmoley.lil.roomwebapp.data.repository.EmployeesRepository;
import com.frankmoley.lil.roomwebapp.web.model.Staff;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/staff")
public class StaffController {

    private final EmployeesRepository employeesRepository;

    public StaffController(EmployeesRepository employeesRepository) {
        this.employeesRepository = employeesRepository;
    }

    public String getStaffPage(Model model){
        List<EmployeesEntity> employeesEntityList = this.employeesRepository.findAll();
        List<Staff> staff = new ArrayList<>(employeesEntityList.size());
        staff.forEach(e->
                staff.add(
                        new Staff(
                                e.getEmployeeId(),
                                e.getFirstName(),
                                e.getLastName(),
                                e.getPosition())));
        model.addAttribute("staffs", staff);
        return "staffs";
    }
}
