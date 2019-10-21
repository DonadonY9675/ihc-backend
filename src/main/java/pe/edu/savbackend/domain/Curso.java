package pe.edu.savbackend.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(schema = "IHC_BD", name = "curso")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Curso {
	@Id
	@Column(name = "id_curso")
	private Integer idCurso;
	@Column(name = "nombre")
	private String nombre;
	@Column(name = "imagen")
	private String imagen;
	@Column(name = "ciclo")
	private Integer ciclo;
}
