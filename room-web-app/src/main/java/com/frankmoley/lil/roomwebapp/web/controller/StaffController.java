package com.frankmoley.lil.roomwebapp.web.controller;
import com.frankmoley.lil.roomwebapp.data.entity.EmployeesEntity;
import com.frankmoley.lil.roomwebapp.data.repository.EmployeesRepository;
import com.frankmoley.lil.roomwebapp.web.model.Staff;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/staffs")
public class StaffController {

    private final EmployeesRepository employeesRepository;

    public StaffController(EmployeesRepository employeesRepository) {
        this.employeesRepository = employeesRepository;
    }

    @GetMapping
    public String getStaffPage(Model model){
        List<EmployeesEntity> employeesEntityList = this.employeesRepository.findAll();
        List<Staff> staffs = new ArrayList<>(employeesEntityList.size());
        employeesEntityList.forEach(e->
                staffs.add(
                        new Staff(
                                e.getEmployeeId(),
                                e.getFirstName(),
                                e.getLastName(),
                                e.getPosition().toString())));
        model.addAttribute("staffs", staffs);
        return "staffs";
    }
}
