package gyc.java.main;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @author guoyc on 2016/4/10.
 */
public class CardProxyHandler implements InvocationHandler {

    private Object proxied;

    public CardProxyHandler(Object proxied) {
        this.proxied = proxied;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("1111");
        return method.invoke(proxied, args);
    }
}
class Test {

    public static void main(String[] args) {
        Card card = (Card) Proxy.newProxyInstance(Card.class.getClassLoader(), new Class[]{Card.class}, new CardProxyHandler(new ICBCCard()));
        card.cost(100);
    }
}
