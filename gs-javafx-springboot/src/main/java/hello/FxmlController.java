package hello;

import java.util.ResourceBundle;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javafx.scene.Parent;

@Component
public abstract class FxmlController implements InitializingBean {

	private static final Logger logger = LoggerFactory.getLogger(SpringFxmlLoader.class);

	@Autowired
	private SpringFxmlLoader fxmlLoader;

	@Value("${app.resources: message}")
	private String resources;

	private final String fxml;
	private Parent view;

	public FxmlController(String fxml) {
		this.fxml = fxml;
	}

	@Override
	public void afterPropertiesSet() throws Exception {
		logger.debug("load fxml : '" + fxml + "' ...");
		view = fxmlLoader.load(getClass().getResource(fxml), ResourceBundle.getBundle(resources), this);
	}

	public Parent getView() {
		return view;
	}

}
