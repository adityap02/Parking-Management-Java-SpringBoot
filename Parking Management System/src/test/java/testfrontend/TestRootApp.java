package testfrontend;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.epam.parking.database.DatabaseModule;
import com.epam.parking.frontend.App;

class TestRootApp {
	DatabaseModule databaseModule;
	App app;
	@BeforeEach
	void instantiateObject() {
		 databaseModule = new DatabaseModule();
		 app = new App(databaseModule);
	}

	@Test
	void test() {
		//assertEquals(app.showMenu(), );
		app.showMenu();
	}

}
