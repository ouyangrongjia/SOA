package example;

import javax.jws.WebMethod;
import javax.jws.WebService;
import javax.xml.ws.Endpoint;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

@WebService()
public class HelloWorld {
    private static final String[] chars = {" ", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
    private static final List<String> res = new ArrayList<>();
    private static int len;

    @WebMethod
    public String sayHelloWorldFrom(String from) {
        String result = "Hello, world, from " + from;
        System.out.println(result);
        return result;
    }

    @WebMethod
    public static List<String> getPhoneStr(String input) {
        return getPhoneStr(input, input.length());
    }

    @WebMethod
    public static List<String> getPhoneStr(String input, int num) {
        res.clear();
        if (Pattern.matches("[2-9]+", input)) {
            len = Math.min(num, input.length());
            input = String.format("%-" + num + "s", input).replace(' ', '1');
            dfs(0, input, "");
        }
        return res;
    }

    private static void dfs(int dps, String input, String str) {
        boolean ret = (dps + 1 == len);
        for (Character c : chars[input.charAt(dps) - '1'].toCharArray()) {
            if (ret) {
                res.add(str + c);
                continue;
            }
            dfs(dps + 1, input, str + c);
        }
    }

    public static void main(String[] argv) {
        Object implementor = new HelloWorld();
        String address = "http://localhost:22200/HelloWorld";
        Endpoint.publish(address, implementor);
//        System.out.println(getPhoneStr("27954386"));
    }
}
