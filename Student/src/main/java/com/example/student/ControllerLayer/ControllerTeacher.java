package com.example.student.ControllerLayer;

import com.example.student.ModelLayer.ModelLayer;
import com.example.student.SericeLayer.ServiceTeacher;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping("/api/v1/teach")
@RequiredArgsConstructor
public class ControllerTeacher {

    private final  ServiceTeacher serviceTeacher;
    @GetMapping("/get")
public ResponseEntity getTeacher(){
    ArrayList<ModelLayer> m1 =serviceTeacher.getAr();
    return ResponseEntity.status(HttpStatus.OK).body(m1);
            }
    @PostMapping("/add")
    public ResponseEntity addTeacher(@RequestBody @Valid ModelLayer model, Errors errors) {
        if (errors.hasErrors()) {
            String message = errors.getFieldError().getDefaultMessage();
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(message);

        }
        serviceTeacher.addModel(model);
        return ResponseEntity.status(HttpStatus.OK).body("Article added");
    }
    @PutMapping("/put/{id}")
    public ResponseEntity updateTeacher(@PathVariable String id, @RequestBody @Valid ModelLayer model, Errors errors) {
        if (errors.hasErrors()) {
            String message = errors.getFieldError().getDefaultMessage();
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(message);

        }
        boolean isUpdate = serviceTeacher.UpdateModel(id, model);
        if (isUpdate) {
            return ResponseEntity.status(HttpStatus.OK).body("blog update");
        }
        return ResponseEntity.status(400).body("wrong id");
    }
    @DeleteMapping("/delete/{id}")
    public ResponseEntity deleteTeacher(@PathVariable String id) {
        boolean isDelete = serviceTeacher.deleteModel(id);
        if (isDelete) {
            return ResponseEntity.status(HttpStatus.OK).body("blog deleted");

        }
        return ResponseEntity.status(400).body("wrong id");
    }
    public ArrayList<ModelLayer> position(@PathVariable String position){
        ArrayList<ModelLayer> z =serviceTeacher.searchTeacher(position);
        return z;
    }

}
