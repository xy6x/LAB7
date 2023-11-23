package com.example.student.ModelLayer;
import jakarta.validation.constraints.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class ModelLayer {
    @NotNull(message = "please enter name ")
    @Pattern(regexp = "^[a-zA-Z]*$+",message = "please enter string")
    private String name;
    @NotNull(message = "please enter id ")
    @Size(min = 8)
    private String id;
    @NotNull(message = "please enter position")
    @Pattern(regexp = "^[a-zA-Z]*$+",message = "please enter string")
    @Size(min = 2)
    @Pattern(regexp = "(Teacher|student|Administrative)")

    private String position;
    @NotNull(message = "please enter college")

    private String college;
    @NotNull(message = "please enter Curricula")

    private String Curricula;


    @NotNull(message = "please enter level")

    private int level;
    @NotNull(message = "please enter salary")
    private double salary;
    private double GPA;
    private int teachingHours;
    private int officeHours;
}
