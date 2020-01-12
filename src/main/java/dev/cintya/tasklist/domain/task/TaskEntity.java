package dev.cintya.tasklist.domain.task;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
@EqualsAndHashCode
@Entity
@Table(name = "TASK")
public class TaskEntity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "TK_ID")
	private Long id;
	
	@NotNull @NotEmpty @NotBlank
	@Column(name = "TK_TITULO", unique = true)
	private String titulo;
	
	@NotNull
	@Column(name = "TK_STATUS")
	private TaskStatus status;
	
	@Lob
	@Column(name = "TK_DESCRICAO")
	private String descricao;
	
	@Column(name = "TK_DATA_CRIACAO")
	private LocalDateTime dataCriacao = LocalDateTime.now();
	
	@Column(name = "TK_DATA_EDICAO")
	private LocalDateTime dataEdicao;
	
	@Column(name = "TK_DATA_REMOCAO")
	private LocalDateTime dataRemocao;
	
	@Column(name = "TK_DATA_CONCLUSAO")
	private LocalDateTime dataConclusao;
}
