package kadamm.hibernate.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "preguntes")
public class Preguntes {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "idPreguntes")
    private long idPreguntes;

    @Column(name = "descripcio")
    private String descripcio;

    @Column(name = "idKahoot")
    private long idKahoot;

    public Preguntes() {
    }

    public Preguntes(String descripcio, long idKahoot) {
        this.descripcio = descripcio;
        this.idKahoot = idKahoot;
    }

    public long getIdPreguntes() {
        return idPreguntes;
    }

    public void setIdPreguntes(long idPreguntes) {
        this.idPreguntes = idPreguntes;
    }

    public String getDescripcio() {
        return descripcio;
    }

    public void setDescripcio(String descripcio) {
        this.descripcio = descripcio;
    }

    public long getIdKahoot() {
        return idKahoot;
    }

    public void setIdKahoot(long idKahoot) {
        this.idKahoot = idKahoot;
    }


}

