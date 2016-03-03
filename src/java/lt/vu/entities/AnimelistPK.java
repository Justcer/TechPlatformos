/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lt.vu.entities;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.validation.constraints.NotNull;

/**
 *
 * @author Justas
 */
@Embeddable
public class AnimelistPK implements Serializable {

    @Basic(optional = false)
    @NotNull
    @Column(name = "ANIME_ID")
    private int animeId;
    @Basic(optional = false)
    @NotNull
    @Column(name = "VARTOTOJAS_ID")
    private int vartotojasId;

    public AnimelistPK() {
    }

    public AnimelistPK(int animeId, int vartotojasId) {
        this.animeId = animeId;
        this.vartotojasId = vartotojasId;
    }

    public int getAnimeId() {
        return animeId;
    }

    public void setAnimeId(int animeId) {
        this.animeId = animeId;
    }

    public int getVartotojasId() {
        return vartotojasId;
    }

    public void setVartotojasId(int vartotojasId) {
        this.vartotojasId = vartotojasId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) animeId;
        hash += (int) vartotojasId;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof AnimelistPK)) {
            return false;
        }
        AnimelistPK other = (AnimelistPK) object;
        if (this.animeId != other.animeId) {
            return false;
        }
        if (this.vartotojasId != other.vartotojasId) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "lt.vu.entities.AnimelistPK[ animeId=" + animeId + ", vartotojasId=" + vartotojasId + " ]";
    }
    
}
