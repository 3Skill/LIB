package kadamm.hibernate.model;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="concurs")
public class Concurs {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long idConcurs;

    @Column(name = "idKahoot")
    private long idKahoot;
    
//    @Column(name = "idConcursant")
//    private long idConcursant;
    
    	// Save
//    @ManyToMany(cascade={CascadeType.PERSIST, CascadeType.MERGE}, 
//    		mappedBy = "concursos",
//    		targetEntity=Concursant.class
//    		)
//	private List<Concursant> concursants = new ArrayList<Concursant>();
    
    @OneToMany
    private List<Concursant> concursants = new ArrayList<Concursant>();
    
    public void addConcursant(Concursant concursant) {
        this.concursants.add(concursant);
        concursant.setConcurs(this);
    }
    
    @OneToMany(mappedBy = "concurs")
    Set<Torn> torns = new HashSet<>();
    


    public Concurs(long idKahoot) {
        this.idKahoot = idKahoot;
    }

    public Concurs() {
    }
    
    public Concurs(long idKahoot, List<Concursant>concursants) {
        this.idKahoot = idKahoot;
        this.concursants = concursants;
    }

    public long getIdConcurs() {
        return idConcurs;
    }

    public void setIdConcurs(long idConcurs) {
        this.idConcurs = idConcurs;
    }

    public long getIdKahoot() {
        return idKahoot;
    }

    public void setIdKahoot(long idKahoot) {
        this.idKahoot = idKahoot;
    }

	public List<Concursant> getConcursants() {
		return concursants;
	}

	public void setConcursants(List<Concursant> concursants) {
		this.concursants = concursants;
	}

   
}

