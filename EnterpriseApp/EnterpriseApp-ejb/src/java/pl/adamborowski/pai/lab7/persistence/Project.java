/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pl.adamborowski.pai.lab7.persistence;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 *
 * @author adam
 */
@Entity
@Getter
@Setter
@EqualsAndHashCode
@ToString(of = {"id"})
public class Project implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column 
    private String name;
    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)//mamy lazy zatem ta klasa może udawać TransferObject
    private ProjectManager manager;
    @ManyToMany(cascade = CascadeType.PERSIST, fetch = FetchType.LAZY)//mamy lazy zatem ta klasa może udawać TransferObject
    private Collection<Task> tasks;
}
