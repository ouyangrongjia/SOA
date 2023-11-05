package example;

import mypackage.HelloWorld;
import mypackage.HelloWorldService;

public class HelloWorldClient {
  public static void main(String[] argv) {
      //          HelloWorldServiceLocator locator = new HelloWorldServiceLocator();
//          Activator service = locator.get();
      // If authorization is required
      //((HelloWorldPortBindingStub)service).setUsername("user3");
      //((HelloWorldPortBindingStub)service).setPassword("pass3");
      // invoke business method
//          service.businessMethod();
      HelloWorld service=new HelloWorldService().getHelloWorldPort();
      String in = "23";
      String name = "tzf";
      String[] t = service.getPhoneStr(in).toArray(new String[0]);
      System.out.print("[");
      for (String s : t) System.out.print(s + (s != t[t.length - 1] ? ", " : ""));
      System.out.println("]");
      System.out.println(service.sayHelloWorldFrom(name));
  }
}
