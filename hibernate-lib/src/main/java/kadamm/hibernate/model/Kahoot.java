package kadamm.hibernate.model;

import java.util.List;

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
@Table(name = "kahoot")
public class Kahoot {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long idKahoot;

    @Column(name = "nom")
    private String nom;
    
    
    @ManyToOne(targetEntity=Usuari.class, cascade = CascadeType.ALL)
	@JoinColumn(name="idUsuari")
    private Usuari usuari;
    
    @OneToMany(mappedBy = "kahoot", cascade = CascadeType.ALL, orphanRemoval = true)
	private List<Preguntes> preguntes;

    public Kahoot() {

    }
    
    public Kahoot(String nom) {
    	this.nom = nom;
    }

    public Kahoot(String nom, Usuari usuari) {
        this.nom = nom;
        this.usuari = usuari;
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

    public Usuari getIdUsuari() {
        return usuari;
    }

    public void setIdUsuari(Usuari usuari) {
        this.usuari = usuari;
    }

}
