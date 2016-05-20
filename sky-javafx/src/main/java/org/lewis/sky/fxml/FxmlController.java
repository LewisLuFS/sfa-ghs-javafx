package org.lewis.sky.fxml;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javafx.scene.Parent;

@Component
public abstract class FxmlController implements InitializingBean {

	private static final Logger logger = LoggerFactory.getLogger(SpringFxmlLoader.class);

	@Autowired
	private SpringFxmlLoader fxmlLoader;

	private final String fxml;
	private Parent view;

	public FxmlController(String fxml) {
		this.fxml = fxml;
	}

	@Override
	public void afterPropertiesSet() throws Exception {
		logger.debug("load fxml... " + fxml);
		view = fxmlLoader.load(getClass().getResource(fxml), this);
	}

	public Parent getView() {
		return view;
	}

}
