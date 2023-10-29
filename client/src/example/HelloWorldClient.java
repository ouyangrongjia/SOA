package example;

import mypackage.HelloWorld;
import mypackage.HelloWorldServiceLocator;

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
          String in = "1234";
          String name = "tzf";
          System.out.println(service.getPhoneStr(in));
          System.out.println(service.sayHelloWorldFrom(name));
      } catch (javax.xml.rpc.ServiceException ex) {
          ex.printStackTrace();
      } catch (java.rmi.RemoteException ex) {
          ex.printStackTrace();
      }
  }
}
