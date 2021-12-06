package spark_01.controller;

import static spark.Spark.get;
import static spark.Spark.post;
import static spark.Spark.put;
import static spark.Spark.delete;

import com.fasterxml.jackson.databind.ObjectMapper;

import spark_01.entity.Item;
import spark_01.jsonwriter.JsonWriter;
import spark_01.repository.ItemRepository;

public class ItemController {

	private static final String JSON = "application/json";
	private ItemRepository itemRepository = new ItemRepository();
	private ObjectMapper objectMapper = new ObjectMapper();

	public void itemApis() {
		get("/items", (req, res) -> {
			res.type(JSON);
			return itemRepository.selectAllItems();
		}, new JsonWriter());

		post("/items", (req, res) -> {
			res.type(JSON);
			Item item = objectMapper.readValue(req.body(), Item.class);
			return itemRepository.insertItem(item);
		});
		
		put("/items/:id", (req, res) -> {
			res.type(JSON);
			Item item = objectMapper.readValue(req.body(), Item.class);
			return itemRepository.updateItem(req.params("id"), item);
		});
		
		delete("/items/:id", (req, res) -> {
			res.type(JSON);
			return itemRepository.deleteItem(req.params("id"));
		});
	}

}
