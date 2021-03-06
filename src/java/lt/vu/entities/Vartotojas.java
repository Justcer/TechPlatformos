/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lt.vu.entities;

import java.io.Serializable;
import java.util.Collection;
import java.util.Objects;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Size;

/**
 *
 * @author Justas
 */
@Entity
@Table(name = "VARTOTOJAS")
@NamedQueries({
    @NamedQuery(name = "Vartotojas.findAll", query = "SELECT v FROM Vartotojas v"),
    @NamedQuery(name = "Vartotojas.findById", query = "SELECT v FROM Vartotojas v WHERE v.id = :id"),
    @NamedQuery(name = "Vartotojas.findByVardas", query = "SELECT v FROM Vartotojas v WHERE v.vardas = :vardas"),
    @NamedQuery(name = "Vartotojas.findByPavarde", query = "SELECT v FROM Vartotojas v WHERE v.pavarde = :pavarde")})
public class Vartotojas implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID")
    private Integer id;
    @Size(max = 20)
    @Column(name = "VARDAS")
    private String vardas;
    @Size(max = 20)
    @Column(name = "PAVARDE")
    private String pavarde;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "vartotojas")
    private Collection<Animelist> animelistCollection;

    public Vartotojas() {
    }

    public Vartotojas(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getVardas() {
        return vardas;
    }

    public void setVardas(String vardas) {
        this.vardas = vardas;
    }

    public String getPavarde() {
        return pavarde;
    }

    public void setPavarde(String pavarde) {
        this.pavarde = pavarde;
    }

    public Collection<Animelist> getAnimelistCollection() {
        return animelistCollection;
    }

    public void setAnimelistCollection(Collection<Animelist> animelistCollection) {
        this.animelistCollection = animelistCollection;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 23 * hash + Objects.hashCode(this.vardas);
        hash = 23 * hash + Objects.hashCode(this.pavarde);
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
        final Vartotojas other = (Vartotojas) obj;
        if (!Objects.equals(this.vardas, other.vardas)) {
            return false;
        }
        if (!Objects.equals(this.pavarde, other.pavarde)) {
            return false;
        }
        return true;
    }

    

    @Override
    public String toString() {
        return "lt.vu.entities.Vartotojas[ id=" + id + " ]";
    }
    
}
