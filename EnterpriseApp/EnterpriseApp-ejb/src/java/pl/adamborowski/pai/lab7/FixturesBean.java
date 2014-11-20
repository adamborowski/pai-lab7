/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pl.adamborowski.pai.lab7;

import java.util.ArrayList;
import javax.ejb.Stateless;
import javax.ejb.LocalBean;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import pl.adamborowski.pai.lab7.persistence.Project;
import pl.adamborowski.pai.lab7.persistence.ProjectManager;
import pl.adamborowski.pai.lab7.persistence.Task;

/**
 *
 * @author adam
 */
@Stateless
@LocalBean
public class FixturesBean {

    @PersistenceContext
    private EntityManager em;

    public void fill() {
        em.createQuery("delete from Project").executeUpdate();
        em.createQuery("delete from ProjectManager").executeUpdate();
        em.createQuery("delete from Task").executeUpdate();
        createEntities();
    }

    private void createEntities() {
        Project p1 = new Project();
        p1.setName("Projekt strony WWW");
        final ArrayList<Task> tasks = new ArrayList<>();
        p1.setTasks(tasks);
        final ProjectManager adam = new ProjectManager((long) 1, "Adam Borowski");
        p1.setManager(adam);
        tasks.add(task("Planowanie"));
        tasks.add(task("Wymagania"));
        tasks.add(task("Projekt Architektury"));
        tasks.add(task("Implementacja"));
        tasks.add(task("Testowanie"));
        tasks.add(task("Akceptacja"));
        em.persist(p1);
        //
        Project p2 = new Project();
        p2.setName("Aplikacja do głosowania");
        p2.setManager(adam);
        final ArrayList<Task> tasks2 = new ArrayList<>();
        p2.setTasks(tasks2);
        tasks2.add(task("Projekt"));
        tasks2.add(task("Implementacja"));
        tasks2.add(task( "Testowanie"));
        em.persist(p2);
    }
    private Task task(String desc){
        Task t = new Task();
        t.setDescription(desc);
        return t;
    }
}
