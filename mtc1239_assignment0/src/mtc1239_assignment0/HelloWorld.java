package mtc1239_assignment0;

public class HelloWorld implements HelloWorld_Interface {


	  public HelloWorld ( ) { // default constructor
	    // explicitly include this
	    // we need to have the default constructor
	    // if you then write others, this one will still be there
	  }

	@Override
	public String say_it() {
		return "hello world";
	}

	@Override
	public String say_it_loud() {
		return "HELLO WORLD";
	}
	  
	  // rest of your code to implement the various operations
	}
