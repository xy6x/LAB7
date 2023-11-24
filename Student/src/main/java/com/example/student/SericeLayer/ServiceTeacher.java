package com.example.student.SericeLayer;

import com.example.student.ModelLayer.ModelLayer;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
@Service
public class ServiceTeacher {
    public ArrayList<ModelLayer> model =new ArrayList<>();

    public ArrayList<ModelLayer> getAr(){

        return model;
    }
    public void addModel(ModelLayer mod){

        model.add(mod);
    }
    public boolean UpdateModel(String id,ModelLayer mod){
        for (int i = 0; i <=model.size() ; i++) {
            ArrayList<ModuleLayer> m =new ArrayList<>();

            if (model.get(i).getId().equals(id)) {
                model.set(i,mod);
                return true;
            }
        }
        return false;
    }
    public boolean deleteModel(String id) {
        for (int i = 0; i <= model.size(); i++) {
            if (!model.get(i).getId().equals(id)) {
                continue;
            }
            model.remove(i);
            return true;

        }
        return false;
    }
    public ArrayList<ModelLayer> searchTeacher(String position){
        ArrayList<ModelLayer> tea =new ArrayList<>();
        for (int i = 0; i <model.size() ; i++) {
            if (model.get(i).getPosition().equals(position)) {
                tea.add(model.get(i));
            }

        }
        return tea;
    }
    public void  getRange(int time){
        for (ModelLayer m:model) {
          int a= m.getOfficeHours()+m.getTeachingHours();
        }

    }
    public ArrayList<ModelLayer>  getCurricula(String id){
        ArrayList<ModelLayer> teacher =new ArrayList<>();
        for (int i = 0; i <model.size() ; i++) {
            if (model.get(i).getId().equals(id)) {
                teacher.add(model.get(i));
            }

        }
        return teacher;
    }

}
