/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lt.vu.entities;

import java.io.Serializable;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.Size;

/**
 *
 * @author Justas
 */
@Entity
@Table(name = "ANIMELIST")
@NamedQueries({
    @NamedQuery(name = "Animelist.findAll", query = "SELECT a FROM Animelist a"),
    @NamedQuery(name = "Animelist.findByAnimeId", query = "SELECT a FROM Animelist a WHERE a.animelistPK.animeId = :animeId"),
    @NamedQuery(name = "Animelist.findByVartotojasId", query = "SELECT a FROM Animelist a WHERE a.animelistPK.vartotojasId = :vartotojasId"),
    @NamedQuery(name = "Animelist.findByStatusas", query = "SELECT a FROM Animelist a WHERE a.statusas = :statusas"),
    @NamedQuery(name = "Animelist.findByPerziurejo", query = "SELECT a FROM Animelist a WHERE a.perziurejo = :perziurejo")})
public class Animelist implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected AnimelistPK animelistPK;
    @Size(max = 20)
    @Column(name = "STATUSAS")
    private String statusas;
    @Column(name = "PERZIUREJO")
    private Integer perziurejo;
    @JoinColumn(name = "ANIME_ID", referencedColumnName = "ID", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Anime anime;
    @JoinColumn(name = "VARTOTOJAS_ID", referencedColumnName = "ID", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Vartotojas vartotojas;

    public Animelist() {
    }

    public Animelist(AnimelistPK animelistPK) {
        this.animelistPK = animelistPK;
    }

    public Animelist(int animeId, int vartotojasId) {
        this.animelistPK = new AnimelistPK(animeId, vartotojasId);
    }

    public AnimelistPK getAnimelistPK() {
        return animelistPK;
    }

    public void setAnimelistPK(AnimelistPK animelistPK) {
        this.animelistPK = animelistPK;
    }

    public String getStatusas() {
        return statusas;
    }

    public void setStatusas(String statusas) {
        this.statusas = statusas;
    }

    public Integer getPerziurejo() {
        return perziurejo;
    }

    public void setPerziurejo(Integer perziurejo) {
        this.perziurejo = perziurejo;
    }

    public Anime getAnime() {
        return anime;
    }

    public void setAnime(Anime anime) {
        this.anime = anime;
    }

    public Vartotojas getVartotojas() {
        return vartotojas;
    }

    public void setVartotojas(Vartotojas vartotojas) {
        this.vartotojas = vartotojas;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 79 * hash + Objects.hashCode(this.anime);
        hash = 79 * hash + Objects.hashCode(this.vartotojas);
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
        final Animelist other = (Animelist) obj;
        if (!Objects.equals(this.anime, other.anime)) {
            return false;
        }
        if (!Objects.equals(this.vartotojas, other.vartotojas)) {
            return false;
        }
        return true;
    }

    

    @Override
    public String toString() {
        return "lt.vu.entities.Animelist[ animelistPK=" + animelistPK + " ]";
    }
    
}
