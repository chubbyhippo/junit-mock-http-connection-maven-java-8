import java.io.ByteArrayInputStream;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class WebClientTest {
	@Test
	void testGetContentOk() throws Exception {
		MockConnectionFactory mockConnectionFactory = new MockConnectionFactory();

		mockConnectionFactory
				.setData(new ByteArrayInputStream("It works".getBytes()));

		WebClient client = new WebClient();
		String workingContent = client.getContent(mockConnectionFactory);

		assertEquals("It works", workingContent);

	}

}
