package com.example.student.SericeLayer;

import com.example.student.ModelLayer.ModelLayer;
import com.example.student.ModelLayer.StudentModel;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
@Service
public class ServiceStudent {
    public ArrayList<StudentModel> modelStudent = new ArrayList<>();
ArrayList<StudentModel> student =new ArrayList<>();
    public ArrayList<StudentModel> getAr() {

        return modelStudent;
    }

    public void addModel(StudentModel mod) {

        modelStudent.add(mod);
    }

    public boolean UpdateMo(String id, StudentModel mod) {
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


        public ArrayList<StudentModel>  curricula(String id){
            ArrayList<StudentModel> st =new ArrayList<>();
            for (int i = 0; i <modelStudent.size() ; i++) {
                if (modelStudent.get(i).getId().equals(id)) {
                    st.add(modelStudent.get(i));
                }

            }
            return st;
        }
        public double getLevel(int level){
            for (StudentModel s:student
                 ) {
                if (s.getLevel()>=4) {
                    System.out.println("a graduate");
                }else  if (s.getLevel()>=3) {
                    System.out.println("level 3");
                }else  if (s.getLevel()>=2) {
                    System.out.println("level 2");
                }else  if (s.getLevel()>=1) {
                    System.out.println("Fresh");
                }
            }
            return 0;
        }
        }


