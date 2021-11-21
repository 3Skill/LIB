package kadamm.hibernate.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "usuari")
public class Usuari {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long idUsuaris;
	
	@Column(name = "nick_name")
	private String nickName;
	
	@Column(name = "password")
	private String password;
	
	@OneToMany(mappedBy = "usuari", cascade = CascadeType.ALL, orphanRemoval = true)
	private List<Kahoot> kahoots;
	
	
	public Usuari() {
		super();
	}


	public Usuari(String nickName, String password) {
		super();
		this.nickName = nickName;
		this.password = password;
	}


	public long getIdUsuaris() {
		return idUsuaris;
	}


	public void setIdUsuaris(long idUsuaris) {
		this.idUsuaris = idUsuaris;
	}


	public String getNickName() {
		return nickName;
	}


	public void setNickName(String nickName) {
		this.nickName = nickName;
	}


	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}
	
	
	

}