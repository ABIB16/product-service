package productMicroService.productService.exceptions;

public class EntityNotFoundExecption extends RuntimeException {

	public EntityNotFoundExecption(String  message ) {
		super(message);
	}
}
