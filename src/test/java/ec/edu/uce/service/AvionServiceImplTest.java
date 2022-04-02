package ec.edu.uce.service;

import static org.junit.jupiter.api.Assertions.*;

import javax.transaction.Transactional;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;

@SpringBootTest
@Transactional
@Rollback(false)
class AvionServiceImplTest {

	@Test
	void testInsertar() {
		fail("Not yet implemented");
	}

}
