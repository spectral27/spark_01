package spark_01.configuration;

import static spark.Spark.after;
import static spark.Spark.options;

public class CorsFilter {

	public static void add() {
		after("/*", (request, response) -> {
			response.header("Access-Control-Allow-Origin", "*");
			response.header("Access-Control-Allow-Headers", "Content-Type");
			response.header("Access-Control-Allow-Methods", "GET, POST, PUT, DELETE");
		});

		options("/*", (request, response) -> {
			return "Ok";
		});
	}

}
