import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class WebClientTest {
	@Test
	void testGetContentOk() throws Exception {
		MockConnectionFactory mockConnectionFactory = new MockConnectionFactory();
		
		MockInputStream mockInputStream = new MockInputStream();
		mockInputStream.setBuffer("It works");

		
		mockConnectionFactory
				.setData(mockInputStream);

		WebClient client = new WebClient();
		String workingContent = client.getContent(mockConnectionFactory);

		assertEquals("It works", workingContent);
		mockInputStream.verify();

	}
	

}
