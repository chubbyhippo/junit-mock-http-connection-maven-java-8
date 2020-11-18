import java.io.InputStream;

public class MockConnectionFactory implements ConnectionFactory {
	private InputStream inputstream;

	public void setData(InputStream stream) {
		this.inputstream = stream;
	}

	@Override
	public InputStream getData() throws Exception {
		return inputstream;
	}

}
