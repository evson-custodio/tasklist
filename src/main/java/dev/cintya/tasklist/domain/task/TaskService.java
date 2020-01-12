package dev.cintya.tasklist.domain.task;

import java.time.LocalDateTime;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TaskService {
	
	@Autowired
	private TaskRepository taskRepository;
	
	@Transactional
	public TaskEntity merge(Long id, TaskEntity other) {
		Optional<TaskEntity> optionalTaskEntity = this.taskRepository.findById(id);
		
		if (!optionalTaskEntity.isPresent()) {
			return null;
		}
		
		TaskEntity taskEntity = optionalTaskEntity.get();
		
		if (other != null) {
			if (other.getTitulo() != null) {
				taskEntity.setTitulo(other.getTitulo());
			}
			if (other.getStatus() != null) {
				taskEntity.setStatus(other.getStatus());
				if (TaskStatus.FEITO.equals(taskEntity.getStatus())) {
					taskEntity.setDataConclusao(LocalDateTime.now());
				}
				else {
					taskEntity.setDataConclusao(null);
				}
			}
			if (other.getDescricao() != null) {
				taskEntity.setDescricao(other.getDescricao());
			}
		}
		
		taskEntity.setDataEdicao(LocalDateTime.now());
		
		return taskEntity;
	}
	
	@Transactional
	public TaskEntity copy(Long id, TaskEntity other) {
		Optional<TaskEntity> optionalTaskEntity = this.taskRepository.findById(id);
		
		if (!optionalTaskEntity.isPresent()) {
			return null;
		}
		
		TaskEntity taskEntity = optionalTaskEntity.get();
		
		if (other != null) {
			taskEntity.setTitulo(other.getTitulo());
			taskEntity.setStatus(other.getStatus());
			if (TaskStatus.FEITO.equals(taskEntity.getStatus())) {
				taskEntity.setDataConclusao(LocalDateTime.now());
			}
			else {
				taskEntity.setDataConclusao(null);
			}
			taskEntity.setDescricao(other.getDescricao());
		}
		
		taskEntity.setDataEdicao(LocalDateTime.now());
		
		return taskEntity;
	}

	
	@Transactional
	public TaskEntity delete(Long id) {
		Optional<TaskEntity> optionalTaskEntity = this.taskRepository.findById(id);
		
		if (!optionalTaskEntity.isPresent()) {
			return null;
		}
		
		TaskEntity taskEntity = optionalTaskEntity.get();
		
		taskEntity.setDataRemocao(LocalDateTime.now());
		
		return taskEntity;
	}
}
