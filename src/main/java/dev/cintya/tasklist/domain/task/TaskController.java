package dev.cintya.tasklist.domain.task;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.BasePathAwareController;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@BasePathAwareController
public class TaskController {
	
	@Autowired
	private TaskService taskService;

	@RequestMapping(path = "tasks/{id}", method = RequestMethod.PATCH, produces = "application/hal+json")
	public ResponseEntity<TaskEntity> patchTask(@PathVariable Long id, @Valid @RequestBody TaskEntity body) {
		
		TaskEntity taskEntity = taskService.merge(id, body);
		
		if (taskEntity == null) {
			return ResponseEntity
					.status(HttpStatus.NOT_FOUND)
					.build();
		}
		
		return ResponseEntity
				.status(HttpStatus.OK)
				.body(taskEntity);
	}
	
	@RequestMapping(path = "tasks/{id}", method = RequestMethod.PUT, produces = "application/hal+json")
	public ResponseEntity<TaskEntity> putTask(@PathVariable Long id, @Valid @RequestBody TaskEntity body) {
		
		TaskEntity taskEntity = taskService.copy(id, body);
		
		if (taskEntity == null) {
			return ResponseEntity
					.status(HttpStatus.NOT_FOUND)
					.build();
		}
		
		return ResponseEntity
				.status(HttpStatus.OK)
				.body(taskEntity);
	}
	
	@RequestMapping(path = "tasks/{id}", method = RequestMethod.DELETE, produces = "application/hal+json")
	public ResponseEntity<TaskEntity> deleteTask(@PathVariable Long id) {
		
		TaskEntity taskEntity = taskService.delete(id);
		
		if (taskEntity == null) {
			return ResponseEntity
					.status(HttpStatus.NOT_FOUND)
					.build();
		}
		
		return ResponseEntity
				.status(HttpStatus.NO_CONTENT)
				.build();
	}
}
