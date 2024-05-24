package creation.singleton;

import org.junit.Test;
import structure.proxy.IUserService;
import structure.proxy.cglib.CglibProxy;
import structure.proxy.jdk.JDKProxy;
import structure.proxy.statics.UserServiceImpl;
import structure.proxy.statics.UserServiceProxy;

/**
 * ProxyTest
 * <p>
 * 功能描述：
 *
 * <p></p>
 *
 * @author LiFei
 * @version v1.0.0
 * @date 2024年05月24日 17:04
 */
public class ProxyTest {

    @Test
    public void testStaticProxy() {
        UserServiceImpl userServiceImpl = new UserServiceImpl();
        UserServiceProxy userServiceProxy = new UserServiceProxy(userServiceImpl);
        userServiceProxy.save();
    }

    @Test
    public void testJdkDynamicProxy() {
        IUserService userService = new UserServiceImpl();
        IUserService proxyInstance = (IUserService) JDKProxy.getProxyInstance(userService);
        proxyInstance.save();
    }

    @Test
    public void testCglibDynamicProxy() {
        CglibProxy cglibProxy = new CglibProxy();
        IUserService proxyInstance = (IUserService) cglibProxy.getProxyInstance(new UserServiceImpl());
        proxyInstance.save();
    }
}
