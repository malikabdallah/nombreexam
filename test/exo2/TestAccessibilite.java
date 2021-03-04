package exo2;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

class TestAccessibilite {
	private static CommunauteAgglomeration communaute;
	
	@BeforeAll
	public  static void setUp() throws Exception{
		communaute=new CommunauteAgglomeration();
	}

	@Test
	void testAccesibilite() {
		communaute.ajouteVille("Paris");
		communaute.ajouteEcole("Paris");
		assertEquals(true,communaute.accessibilite());
	}
	@Test
	void testNonAccesibilite() {
		communaute.retireEcole("Paris");
		assertEquals(false,communaute.accessibilite());
	}

}
