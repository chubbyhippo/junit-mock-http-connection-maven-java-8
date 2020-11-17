import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class WebClientTest {

	private class TestableWebClient extends WebClient {
		private HttpURLConnection connection;

		public void setHttpURLConnection(HttpURLConnection connection) {
			this.connection = connection;
		}

		public HttpURLConnection createHttpURLConnection(URL url)
				throws IOException {
			return this.connection;
		}
	}

	@Test
	void testGetContentOk() throws Exception {
		MockHttpURLConnection mockHttpURLConnection = new MockHttpURLConnection();
		mockHttpURLConnection.setExpectedInputStream(
				new ByteArrayInputStream("It works".getBytes()));
		TestableWebClient client = new TestableWebClient();
		client.setHttpURLConnection(mockHttpURLConnection);
		String workingContent = client.getContent(new URL("http://localhost"));

		assertEquals("It works", workingContent);

	}

}
