package spark_01;

public class App {
	
	private static ItemController itemController = new ItemController();

	public static void main(String[] args) {
		CorsFilter.add();
		itemController.itemApis();
	}

}
