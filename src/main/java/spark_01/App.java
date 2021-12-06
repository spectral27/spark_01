package spark_01;

import spark_01.configuration.CorsFilter;
import spark_01.controller.ItemController;

public class App {
	
	static {
		CorsFilter.add();
	}

	public static void main(String[] args) {
		new ItemController().itemApis();
	}

}
