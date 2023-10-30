package example;

import mypackage.HelloWorld;
import mypackage.HelloWorldServiceLocator;

import java.util.Arrays;

public class HelloWorldClient {
  public static void main(String[] argv) {
      try {
//          HelloWorldServiceLocator locator = new HelloWorldServiceLocator();
//          Activator service = locator.get();
          // If authorization is required
          //((HelloWorldPortBindingStub)service).setUsername("user3");
          //((HelloWorldPortBindingStub)service).setPassword("pass3");
          // invoke business method
//          service.businessMethod();
          HelloWorld service=new HelloWorldServiceLocator().getHelloWorldPort();
          String in = "23";
          String name = "tzf";
          String[] t = service.getPhoneStr(in);
          System.out.print("[");
          for (String s : t) System.out.print(s + (s != t[t.length - 1] ? ", " : ""));
          System.out.print("]");
          System.out.println(service.sayHelloWorldFrom(name));
      } catch (javax.xml.rpc.ServiceException ex) {
          ex.printStackTrace();
      } catch (java.rmi.RemoteException ex) {
          ex.printStackTrace();
      }
  }
}
