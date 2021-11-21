package kadamm.hibernate.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "respostes")
public class Respostes {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long idResposta;

    @Column(name = "descripcio")
    private String descripcio;

    @Column(name = "respostaCorrecta")
    private boolean respostaCorrecta;
    
    @ManyToOne(targetEntity = Preguntes.class, cascade = CascadeType.ALL)
	@JoinColumn(name="idPreguntes")
    private Preguntes preguntes;

    public Respostes() {
    }

    public Respostes(String descripcio, boolean respostaCorrecta, Preguntes pregunta) {
        this.descripcio = descripcio;
        this.respostaCorrecta = respostaCorrecta;
        this.preguntes = pregunta;
    }

    public long getIdResposta() {
        return idResposta;
    }

    public void setIdResposta(int idResposta) {
        this.idResposta = idResposta;
    }

    public String getDescripcio() {
        return descripcio;
    }

    public void setDescripcio(String descripcio) {
        this.descripcio = descripcio;
    }

    public boolean isRespostaCorrecta() {
        return respostaCorrecta;
    }

    public void setRespostaCorrecta(boolean respostaCorrecta) {
        this.respostaCorrecta = respostaCorrecta;
    }

    public Preguntes getIdPregunta() {
        return preguntes;
    }

    public void setIdPregunta(Preguntes pregunta) {
        this.preguntes = pregunta;
    }


}
