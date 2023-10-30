import client.HelloWorldServiceLocator;
import client.HelloWorld_PortType;
import example.HelloWorld;

import javax.xml.rpc.ServiceException;
import java.rmi.RemoteException;

public class Client {
    public static void main(String[] args) throws ServiceException {
        try{
            HelloWorldServiceLocator serviceLocator = new HelloWorldServiceLocator();
            HelloWorld_PortType service = serviceLocator.getHelloWorld();
            System.out.println(service.sayHelloWorldFrom("1234"));
            String in = "23";
            String[] t = service.getPhoneStr(in);
            System.out.print("[");
            for (String s : t) System.out.print(s + (!s.equals(t[t.length - 1]) ? ", " : ""));
            System.out.print("]");
        }catch (ServiceException | RemoteException e){
            e.printStackTrace();
        }

    }
}
