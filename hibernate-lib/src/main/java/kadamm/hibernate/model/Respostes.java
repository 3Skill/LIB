package kadamm.hibernate.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "respostes")
public class Respostes {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idResposta")
    private int idResposta;

    @Column(name = "descripcio")
    private String descripcio;

    @Column(name = "respostaCorrecta")
    private boolean respostaCorrecta;

    @Column(name = "idPregunta")
    private long idPregunta;

    public Respostes() {
    }

    public Respostes(String descripcio, boolean respostaCorrecta, long idPregunta) {
        this.descripcio = descripcio;
        this.respostaCorrecta = respostaCorrecta;
        this.idPregunta = idPregunta;
    }

    public int getIdResposta() {
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

    public long getIdPregunta() {
        return idPregunta;
    }

    public void setIdPregunta(long idPregunta) {
        this.idPregunta = idPregunta;
    }


}
