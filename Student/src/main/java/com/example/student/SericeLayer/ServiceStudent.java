package com.example.student.SericeLayer;

import com.example.student.ModelLayer.ModelLayer;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
@Service
public class ServiceStudent {
    public ArrayList<ModelLayer> modelStudent = new ArrayList<>();

    public ArrayList<ModelLayer> getAr() {

        return modelStudent;
    }

    public void addModel(ModelLayer mod) {

        modelStudent.add(mod);
    }

    public boolean UpdateMo(String id, ModelLayer mod) {
        for (int i = 0; i <= modelStudent.size(); i++) {
            ArrayList<ModuleLayer> m = new ArrayList<>();

            if (modelStudent.get(i).getId().equals(id)) {
                modelStudent.set(i, mod);
                return true;
            }
        }
        return false;
    }

    public boolean deleteMo(String id) {
        for (int i = 0; i <= modelStudent.size(); i++) {
            if (modelStudent.get(i).getId().equals(id)) {

                modelStudent.remove(i);
                return true;
            }
            }
            return false;
        }
        public ArrayList<ModelLayer> searchStudent(String position){
        ArrayList<ModelLayer> stu =new ArrayList<>();
            for (int i = 0; i <modelStudent.size() ; i++) {
                if (modelStudent.get(i).getPosition().equals(position)) {
                 stu.add(modelStudent.get(i));
                }

            }
            return stu;
        }

        public ArrayList<ModelLayer>  curricula(String id){
            ArrayList<ModelLayer> st =new ArrayList<>();
            for (int i = 0; i <modelStudent.size() ; i++) {
                if (modelStudent.get(i).getId().equals(id)) {
                    st.add(modelStudent.get(i));
                }

            }
            return st;
        }
        }


