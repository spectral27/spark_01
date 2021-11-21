package spark_01;

import static spark.Spark.after;
import static spark.Spark.options;

import spark.Filter;

public class CorsFilter {
	
	public static void add() {
		after((Filter) (request, response) -> {
            response.header("Access-Control-Allow-Origin", "*");
            response.header("Access-Control-Allow-Headers", "Content-Type");
            response.header("Access-Control-Allow-Methods", "GET, POST, PUT, DELETE");
        });
		
		options("/*", (request, response) -> {
			String accessControlRequestHeaders = request.headers("Access-Control-Request-Headers");
			if (accessControlRequestHeaders != null) {
				response.header("Access-Control-Allow-Headers", accessControlRequestHeaders);
			}
			String accessControlRequestMethod = request.headers("Access-Control-Request-Method");
			if (accessControlRequestMethod != null) {
				response.header("Access-Control-Allow-Methods", accessControlRequestMethod);
			}
			return "Ok";
		});
	}

}
