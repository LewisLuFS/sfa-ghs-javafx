package hello;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.NoSuchBeanDefinitionException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;

import javafx.util.Builder;
import javafx.util.BuilderFactory;

@Component
public class SpringFxmlBuilderFactory implements InitializingBean, BuilderFactory {

	@Autowired
	private ApplicationContext applicationContext;

	private List<String> packages;

	@Override
	public void afterPropertiesSet() throws Exception {
		packages = applicationContext.getBeansWithAnnotation(ComponentScan.class).values().stream()
				.map(obj -> obj.getClass().getPackage().getName()).collect(Collectors.toList());
	}

	@Override
	public Builder<?> getBuilder(Class<?> type) {
		if (packages.stream().anyMatch(p -> type.getPackage().getName().indexOf(p) == 0)) {
			try {
				Object bean = applicationContext.getBean(type);
				return () -> bean;
			} catch (NoSuchBeanDefinitionException e) {
				return null;
			}
		}
		return null;
	}

}
