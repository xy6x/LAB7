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
@RequestMapping
@RequiredArgsConstructor
public class StudentController {
    private final ServiceStudent serviceStudent;
    public ResponseEntity getTeacher(){
        ArrayList<ModelLayer> m1 =serviceStudent.getAr();
        return ResponseEntity.status(HttpStatus.OK).body(m1);
    }
    @PostMapping("/add")
    public ResponseEntity addArticle(@RequestBody @Valid ModelLayer model, Errors errors) {
        if (errors.hasErrors()) {
            String message = errors.getFieldError().getDefaultMessage();
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(message);

        }
        serviceStudent.addModel(model);
        return ResponseEntity.status(HttpStatus.OK).body("Article added");
    }
    @PutMapping("/put/{id}")
    public ResponseEntity updateArticle(@PathVariable String id, @RequestBody @Valid ModelLayer model, Errors errors) {
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
    public ResponseEntity deleteArticle(@PathVariable String id) {
        boolean isDelete = serviceStudent.deleteMo(id);
        if (isDelete) {
            return ResponseEntity.status(HttpStatus.OK).body("blog deleted");

        }
        return ResponseEntity.status(400).body("wrong id");
    }

}
