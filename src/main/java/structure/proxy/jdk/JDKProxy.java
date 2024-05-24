package structure.proxy.jdk;

import lombok.extern.slf4j.Slf4j;
import structure.proxy.IUserService;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;

/**
 * JDKProxyFactroy
 * <p>
 * 功能描述：
 *
 * <p></p>
 *
 * @author LiFei
 * @version v1.0.0
 * @date 2024年05月24日 08:23
 */
@Slf4j(topic = "### JDKProxy ###")
public class JDKProxy {

    private JDKProxy() {
        // empty
    }

    public static Object getProxyInstance(IUserService userService) {
        ClassLoader classLoader = userService.getClass().getClassLoader();
        Class<?>[] interfaces = userService.getClass().getInterfaces();
        InvocationHandler invocationHandler = (proxy, method, args) -> {
            log.info("JDK代理执行before");
            Object invoke = method.invoke(userService, args);
            log.info("JDK代理执行after");
            return invoke;
        };
        return Proxy.newProxyInstance(classLoader, interfaces, invocationHandler);
    }

}
