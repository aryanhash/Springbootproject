package com.example._stproject.dto;

import java.time.LocalDate;

public class EmployeeDto {

   private Long id;
   private String name;
   private String email;
   private LocalDate dateOfJoining;
   private Boolean isActive;
   public EmployeeDto(){

   }

    public EmployeeDto(Long id, String name, String email, LocalDate dateOfJoining, Boolean isActive) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.dateOfJoining = dateOfJoining;
        this.isActive = isActive;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setDateOfJoining(LocalDate dateOfJoining) {
        this.dateOfJoining = dateOfJoining;
    }

    public void setActive(Boolean active) {
        isActive = active;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public LocalDate getDateOfJoining() {
        return dateOfJoining;
    }

    public Boolean getActive() {
        return isActive;
    }
}
