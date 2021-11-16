package kadamm.hibernate.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "kahoot")
public class Kahoot {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id_Kahoot")
    private long idKahoot;

    @Column(name = "nom")
    private String nom;

    @Column(name = "id_Usuari")
    private long idUsuari;

    public Kahoot() {

    }

    public Kahoot(String nom, long idUsuari) {
        this.nom = nom;
        this.idUsuari = idUsuari;
    }

    public long getIdKahoot() {
        return idKahoot;
    }

    public void setIdKahoot(int idKahoot) {
        this.idKahoot = idKahoot;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public long getIdUsuari() {
        return idUsuari;
    }

    public void setIdUsuari(int idUsuari) {
        this.idUsuari = idUsuari;
    }

}
