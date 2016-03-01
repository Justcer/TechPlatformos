/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lt.vu.entities;

import java.io.Serializable;
import java.util.List;
import java.util.Objects;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.Size;

/**
 *
 * @author Justas
 */
@Entity
@Table(name = "ANIME")
@NamedQueries({
    @NamedQuery(name = "Anime.findAll", query = "SELECT a FROM Anime a"),
    @NamedQuery(name = "Anime.findById", query = "SELECT a FROM Anime a WHERE a.id = :id"),
    @NamedQuery(name = "Anime.findByPavadinimas", query = "SELECT a FROM Anime a WHERE a.pavadinimas = :pavadinimas")})
public class Anime implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID")
    private Integer id;
    @Size(max = 50)
    @Column(name = "PAVADINIMAS")
    private String pavadinimas;
    @JoinTable(name = "ANIMELIST", joinColumns = {
        @JoinColumn(name = "ANIME_ID", referencedColumnName = "ID")}, inverseJoinColumns = {
        @JoinColumn(name = "VARTOTOJAS_ID", referencedColumnName = "ID")})
    @ManyToMany
    private List<Vartotojas> vartotojasList;

    public Anime() {
    }

    public Anime(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getPavadinimas() {
        return pavadinimas;
    }

    public void setPavadinimas(String pavadinimas) {
        this.pavadinimas = pavadinimas;
    }

    public List<Vartotojas> getVartotojasList() {
        return vartotojasList;
    }

    public void setVartotojasList(List<Vartotojas> vartotojasList) {
        this.vartotojasList = vartotojasList;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 11 * hash + Objects.hashCode(this.id);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Anime other = (Anime) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "lt.vu.entities.Anime[ id=" + id + " ]";
    }
    
}
