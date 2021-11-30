package kadamm.hibernate.model;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;
import javax.persistence.Table;

@Entity

public class Torn {
	@EmbeddedId
    private TornId tornId;
 
    @ManyToOne
    @MapsId("concursId")
    private Concurs concurs;
 
    @ManyToOne
    @MapsId("preguntaId")
    private Preguntes preguntes;
 
    @ManyToOne
    @MapsId("concursantId")
    private Concursant concursant;
    
    
    private long resposta;
    
    
 
//    public TornId getId() {
//		return id;
//	}



//	public void setId(TornId id) {
//		this.id = id;
//	}
    
    



	public Concurs getConcurs() {
		return concurs;
	}



	public void setConcurs(Concurs concurs) {
		this.concurs = concurs;
	}



	public Preguntes getPregunta() {
		return preguntes;
	}



	public void setPregunta(Preguntes preguntes) {
		this.preguntes = preguntes;
	}



	public Concursant getConcursant() {
		return concursant;
	}



	public void setConcursant(Concursant concursant) {
		this.concursant = concursant;
	}



	public Torn(Concurs concurs, Preguntes preguntes, Concursant concursant, long resposta) {
		super();
		this.concurs = concurs;
		this.preguntes = preguntes;
		this.concursant = concursant;
		this.resposta = resposta;
	}
	

	

//	public Torn(TornId id, long resposta) {
//		super();
//		this.id = id;
//		this.resposta = resposta;
//	}
	
//	public Torn(TornId id) {
//		super();
//		this.id = id;
//	}




	public Torn(TornId tornId,Concurs concurs, Preguntes preguntes, Concursant concursant, long resposta) {
		super(); 
		this.tornId = tornId;
		this.concurs = concurs;
		this.preguntes = preguntes;
		this.concursant = concursant;
		this.resposta = resposta;
	}



	public TornId getTornId() {
		return tornId;
	}



	public void setTornId(TornId tornId) {
		this.tornId = tornId;
	}



	public Preguntes getPreguntes() {
		return preguntes;
	}



	public void setPreguntes(Preguntes preguntes) {
		this.preguntes = preguntes;
	}



	public long getResposta() {
		return resposta;
	}



	public void setResposta(long resposta) {
		this.resposta = resposta;
	}




	
	@Embeddable
    public static class TornId implements Serializable {
        
		
		/**
		 * 
		 */
		private static final long serialVersionUID = 1L;
		private Long concursId;
        private Long preguntaId;
        private Long concursantId;
 
        public TornId(Long concursId, Long preguntaId, Long concursantId) {
			super();
			this.concursId = concursId;
			this.preguntaId = preguntaId;
			this.concursantId = concursantId;
		}

		@Override
		public int hashCode() {
			return Objects.hash(concursId, preguntaId, concursantId);
		}

		@Override
		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			if (obj == null || getClass() != obj.getClass()){
				return false;
			}
			TornId tornId = (TornId) obj;
			return concursId.equals(tornId.concursId) && preguntaId.equals(tornId.preguntaId) && concursantId.equals(tornId.concursantId); 
		}

		public Long getConcursId() {
			return concursId;
		}

		public void setConcursId(Long concursId) {
			this.concursId = concursId;
		}

		public Long getPreguntaId() {
			return preguntaId;
		}

		public void setPreguntaId(Long preguntaId) {
			this.preguntaId = preguntaId;
		}

		public Long getConcursantId() {
			return concursantId;
		}

		public void setConcursantId(Long concursantId) {
			this.concursantId = concursantId;
		}

		public TornId() {}
    } 
}
