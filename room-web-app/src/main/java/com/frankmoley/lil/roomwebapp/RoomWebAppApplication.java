package com.frankmoley.lil.roomwebapp;

import com.frankmoley.lil.roomwebapp.data.repository.EmployeesRepository;
import com.frankmoley.lil.roomwebapp.data.repository.RoomRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class RoomWebAppApplication {

  public static void main(String[] args) {
    SpringApplication.run(RoomWebAppApplication.class, args);
  }

  @Bean
  public CommandLineRunner run(RoomRepository roomRepository, EmployeesRepository employeesRepository){
    //    return args -> {
    //      roomRepository.findAll().forEach(System.out::println);
    //    };
    //criar uma nova instrucao para poder logar o que traz com o novo repositorio criado para testar no console
    return args -> {

      System.out.println("******room**********");
      roomRepository.findAll().forEach(System.out::println);

      System.out.println("*****Employees*********");
      employeesRepository.findAll().forEach(System.out::println);
    };
  }

}
