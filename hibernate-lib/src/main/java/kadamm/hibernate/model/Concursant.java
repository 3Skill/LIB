package kadamm.hibernate.model;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="concursant")
public class Concursant {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
    private long idConcursant;
	
	@Column(name="nick_name")
    private String nickname;
	
	@Column(name="password")
    private String password;
	
//	@ManyToMany( cascade = {
//			CascadeType.PERSIST,
//			CascadeType.MERGE
//	})
//	@JoinTable(name="concursant_concurs",
//	joinColumns = {@JoinColumn(name="idConcursant")},
//	inverseJoinColumns = {@JoinColumn(name="idConcurs")}
//	)
//	private List<Concurs> concursos;


//    public List<Concurs> getConcurs() {
//		return concursos;
//	}
//
//	public void setConcurs(List<Concurs> concursos) {
//		this.concursos = concursos;
//	}
	
	@ManyToOne
    private Concurs concurs;
	
	public void setConcurs(Concurs concurs) {
		this.concurs = concurs;
	};
	
	@OneToMany(mappedBy = "concursant")
    Set<Torn> torns = new HashSet<>();

	public Concursant() {
		super();
	}

	public Concursant(String nickname, String password) {
        this.nickname = nickname;
        this.password = password;
    }

    public Concursant(String nickname) {
    	this.nickname = nickname;
	}

	public long getIdConcursant() {
        return idConcursant;
    }

    public void setIdConcursant(long idConcursant) {
        this.idConcursant = idConcursant;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }


}
