package models;

import javax.persistence.*;

import static javax.persistence.GenerationType.IDENTITY;

/**
 * Created by rofi on 8/24/16.
 */
@Entity
@Table(name="students")
public class Student {
    private int id;
    private String firstName;
    private String lastName;
    private int age;

    @Id
    @GeneratedValue(strategy = IDENTITY)
    @Column(name = "id")
    public int getId(){
        return this.id;
    }
    @Column(name = "firstName")
    public String getFirstName(){
        return this.firstName;
    }
    @Column(name="lastName")
    public String getLastName(){
        return this.lastName;
    }
    @Column(name="age")
    public int getAge(){
        return this.age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
}