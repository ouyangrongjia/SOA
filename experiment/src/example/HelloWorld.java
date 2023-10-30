package example;

import javax.jws.WebMethod;
import javax.jws.WebService;
import javax.xml.ws.Endpoint;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

@WebService()
public class HelloWorld {
    public static final String[] chars = {" ", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
    public static final List<String> res = new ArrayList<>();
    public static int len;

    @WebMethod
    public String sayHelloWorldFrom(String from) {
        String result = "Hello, world, from " + from;
        System.out.println(result);
        return result;
    }

    @WebMethod
    public String[] getPhoneStr(String input) {
        int num = 2;
        res.clear();
        if (Pattern.matches("[2-9]{1,2}", input)) {
            input = String.format("%-" + num + "s", input).replace(' ', '1');
            len = num;
            dfs(0, input, "");
        }
        return res.toArray(new String[res.size()]);
    }

    private void dfs(int dps, String input, String str) {
        boolean ret = (dps + 1 == len);
        for (Character c : chars[input.charAt(dps) - '1'].toCharArray()) {
            if (ret) {
                String temp = (str + c).trim();
                if (!temp.isEmpty()) res.add(temp);
                continue;
            }
            dfs(dps + 1, input, str + c);
        }
    }

    public static void main(String[] argv) {
        Object implementor = new HelloWorld();
        String address = "http://localhost:22200/HelloWorld";
        Endpoint.publish(address, implementor);
    }
}
