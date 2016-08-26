package services;

import models.Student;
import play.db.jpa.JPA;

/**
 * Created by rofi on 8/26/16.
 */
public class StudentService {
    public Student getById(int id){
        return JPA.em().find(Student.class, id);
    }
}
