package structure.proxy.cglib;

import lombok.extern.slf4j.Slf4j;
import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;
import structure.proxy.IUserService;

import java.lang.reflect.Method;

/**
 * CglibProxyFactory
 * <p>
 * 功能描述：
 *
 * <p></p>
 *
 * @author LiFei
 * @version v1.0.0
 * @date 2024年05月24日 08:30
 */
@Slf4j(topic = "### CglibProxy ###")
public class CglibProxy implements MethodInterceptor {

    public Object getProxyInstance(IUserService userService) {
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(userService.getClass());
        enhancer.setCallback(this);
        return enhancer.create();
    }

    @Override
    public Object intercept(Object o, Method method, Object[] args, MethodProxy methodProxy) throws Throwable {
        log.info("Cglib代理执行before");
        Object invoke = methodProxy.invokeSuper(o, args);
        log.info("Cglib代理执行after");
        return invoke;
    }
}
