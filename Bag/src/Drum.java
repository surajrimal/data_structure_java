
public class Drum<T> {
	private T a;
	Drum(T b){
		this.a = b;
	}
	Drum(){
		
	}
	
	private T Sum(T a) {
		return a;
	}
	public T getA() {
		return Sum(a);
	}
	public void setA(T a) {
		this.a = a;
	}
	
	
	

}
