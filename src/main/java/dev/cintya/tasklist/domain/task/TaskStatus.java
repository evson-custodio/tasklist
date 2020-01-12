package dev.cintya.tasklist.domain.task;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

@AllArgsConstructor
@Getter
@ToString
public enum TaskStatus {
	A_FAZER (1L, "A Fazer"),
	FAZENDO (2L, "Fazendo"),
	FEITO	(3L, "Feito");
	
	private final Long id;
	private final String messagem;
}
