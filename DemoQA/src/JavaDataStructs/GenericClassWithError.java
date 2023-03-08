package JavaDataStructs;

class TestError<T>{
	T obj;
	TestError(T obj){
		this.obj=obj;
	}
	public T getObject() {
		return this.obj;
	}
}

public class GenericClassWithError {

	public static void main(String[] args) {

		TestError<Integer> iObj= new TestError<Integer>(15);
		System.out.println(iObj.getObject());
		TestError<String> sObj= new TestError<String>("Test String Generic Parameter");
		System.out.println(sObj.getObject());
		//iObj=sObj; // This results an error

	}
}