package com.example.student.ControllerLayer;


import com.example.student.ModelLayer.ModelLayer;
import com.example.student.SericeLayer.ServiceStudent;
import com.example.student.SericeLayer.ServiceTeacher;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
@RestController
@RequestMapping("/api/v1/Stu")
@RequiredArgsConstructor
public class StudentController {
    private final ServiceStudent serviceStudent;

    @GetMapping("/get")
    public ResponseEntity getStudent() {
        ArrayList<ModelLayer> m1 = serviceStudent.getAr();
        return ResponseEntity.status(HttpStatus.OK).body(m1);
    }

    @PostMapping("/add")
    public ResponseEntity addStudent(@RequestBody @Valid ModelLayer model, Errors errors) {
        if (errors.hasErrors()) {
            String message = errors.getFieldError().getDefaultMessage();
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(message);

        }
        serviceStudent.addModel(model);
        return ResponseEntity.status(HttpStatus.OK).body("Student added");
    }

    @PutMapping("/put/{id}")
    public ResponseEntity updateStudent(@PathVariable String id, @RequestBody @Valid ModelLayer model, Errors errors) {
        if (errors.hasErrors()) {
            String message = errors.getFieldError().getDefaultMessage();
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(message);

        }
        boolean isUpdate = serviceStudent.UpdateMo(id, model);
        if (isUpdate) {
            return ResponseEntity.status(HttpStatus.OK).body("blog update");
        }
        return ResponseEntity.status(400).body("wrong id");
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity deleteStudent(@PathVariable String id) {
        boolean isDelete = serviceStudent.deleteMo(id);
        if (isDelete) {
            return ResponseEntity.status(HttpStatus.OK).body("blog deleted");

        }
        return ResponseEntity.status(400).body("wrong id");
    }

    @GetMapping("/get/{position}")
    public ArrayList<ModelLayer> getPosition(@PathVariable String position) {
        ArrayList<ModelLayer> v = serviceStudent.searchStudent(position);
        return v;
    }
    @GetMapping("/curr/{id}")
    public ArrayList<ModelLayer> getCurricula(@PathVariable String id) {
        ArrayList<ModelLayer> curr = serviceStudent.curricula(id);
        return curr;
    }
}
