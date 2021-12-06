package spark_01.jsonwriter;

import com.fasterxml.jackson.databind.ObjectMapper;

import spark.ResponseTransformer;

public class JsonWriter implements ResponseTransformer {

	private ObjectMapper objectMapper = new ObjectMapper();
	
	@Override
	public String render(Object model) throws Exception {
		return objectMapper.writeValueAsString(model);
	}

}
