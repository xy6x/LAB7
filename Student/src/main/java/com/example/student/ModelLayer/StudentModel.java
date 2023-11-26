package com.example.student.ModelLayer;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class StudentModel {
    @NotNull(message = "please enter name ")
    @Pattern(regexp = "^[a-zA-Z]*$+",message = "please enter string")
    private String name;
    @NotNull(message = "please enter id ")
    @Size(min = 8)
    private String id;
    private String college;
    @NotNull(message = "please enter Curricula")
    private String Curricula;
    @NotNull(message = "please enter level")
    private int level;
    @NotNull(message = "please enter salary")
    private double salary;
    @NotNull(message = "please enter GPA")

    private double GPA;
}
