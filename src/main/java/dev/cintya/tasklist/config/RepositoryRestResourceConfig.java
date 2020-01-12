package dev.cintya.tasklist.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;
import org.springframework.data.rest.webmvc.config.RepositoryRestConfigurer;
import org.springframework.http.HttpMethod;

import dev.cintya.tasklist.domain.task.TaskEntity;

@Configuration
public class RepositoryRestResourceConfig implements RepositoryRestConfigurer {
	
	@Override
	public void configureRepositoryRestConfiguration(RepositoryRestConfiguration config) {
		config.exposeIdsFor(TaskEntity.class);
		config.getCorsRegistry()
			.addMapping("/**")
			.allowedMethods(
					HttpMethod.POST.name(),
					HttpMethod.GET.name(),
					HttpMethod.PUT.name(),
					HttpMethod.PATCH.name(),
					HttpMethod.DELETE.name(),
					HttpMethod.HEAD.name());
	}
}