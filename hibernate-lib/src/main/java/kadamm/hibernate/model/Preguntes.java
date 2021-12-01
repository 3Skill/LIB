package kadamm.hibernate.model;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "preguntes")
public class Preguntes {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long idPreguntes;

    @Column(name = "descripcio")
    private String descripcio;
    
    @ManyToOne(targetEntity=Kahoot.class, cascade = CascadeType.ALL)
    @JoinColumn(name = "idKahoot")
    private Kahoot kahoot;
    
    @OneToMany(mappedBy = "preguntes", cascade = CascadeType.ALL, orphanRemoval = true)
   	private List<Respostes> respostes;
    
    @OneToMany(mappedBy = "preguntes")
    Set<Torn> torns = new HashSet<>();
    

    public Preguntes() {
    }
    
    public Preguntes(String descripcio) {
        this.descripcio = descripcio;
    }

    public Preguntes(String descripcio, Kahoot kahoot) {
        this.descripcio = descripcio;
        this.kahoot = kahoot;
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

    public Kahoot getIdKahoot() {
        return kahoot;
    }

    public void setIdKahoot(Kahoot kahoot) {
        this.kahoot = kahoot;
    }


}

