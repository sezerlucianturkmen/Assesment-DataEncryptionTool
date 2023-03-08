import assestment.ApplicationManager;

public class Main {

	public static void main(String[] args) {
		ApplicationManager app = new ApplicationManager();
		try {
			app.menu();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
