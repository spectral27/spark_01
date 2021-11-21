package spark_01;

import static spark.Spark.after;
import static spark.Spark.options;

public class CorsFilter {

	public static void add() {
		after("/*", (request, response) -> {
			response.header("Access-Control-Allow-Origin", "*");
		});

		options("/*", (request, response) -> {
			return "Ok";
		});
	}

}
