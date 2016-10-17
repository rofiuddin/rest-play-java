package models;

import play.*;
import play.mvc.*;
import play.db.jpa.*;
import java.util.List;
import java.util.Date;

import javax.persistence.*;

public class UserDAO {
    /**
     * Create an user
     *
     * @param model User
     *
     * @return User
     */
    public static User create (User model) {
        model.emptyToNull();
        JPA.em().persist(model);
        // Flush and refresh for check
        JPA.em().flush();
        JPA.em().refresh(model);
        return model;
    }

    /**
     * Find an user by id
     *
     * @param Integer id
     *
     * @return User
     */
    public static User find(Integer id) {
        return JPA.em().find(User.class, id);
    }

    /**
     * Update an user
     *
     * @param model
     *
     * @return User
     */
    public static User update(User model) {
        return JPA.em().merge(model);
    }

    /**
     * Delete an user by id
     *
     * @param Integer id
     */
    public static void delete(Integer id) {
        User model = JPA.em().getReference(User.class, id);
        JPA.em().remove(model);
    }

    /**
     * Get all users
     *
     * @return List<User>
     */
    public static List<User> all() {
        return (List<User>) JPA.em().createQuery("SELECT m FROM " + User.TABLE + " m ORDER BY id").getResultList();
    }

    /**
     * Get the page of users
     *
     * @param Integer page
     * @param Integer size
     *
     * @return List<User>
     */
    public static List<User> paginate(Integer page, Integer size) {
        return (List<User>) JPA.em().createQuery("SELECT m FROM " + User.TABLE + " m ORDER BY id").setFirstResult(page*size).setMaxResults(size).getResultList();
    }

    /**
     * Get the number of total row
     *
     * @return Long
     */
    public static Long count() {
        return (Long) JPA.em().createQuery("SELECT count(m) FROM " + User.TABLE + " m").getSingleResult();
    }
}