package Training.HRMS.core.utilities.results;

public class DataResult<T> extends Result {

	private T Data;

	public DataResult(T data, boolean success) {
		super(success);
		this.Data = data;
	}

	public DataResult(T data, boolean success, String message) {
		super(success, message);
		this.Data = data;
	}

	public T getData() {
		return Data;
	}

	public void setData(T data) {
		Data = data;
	}
}
