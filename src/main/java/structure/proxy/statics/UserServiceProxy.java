package structure.proxy.statics;

import lombok.extern.slf4j.Slf4j;
import structure.proxy.IUserService;

/**
 * UserServiceProxy
 * <p>
 * 功能描述：
 *
 * <p></p>
 *
 * @author LiFei
 * @version v1.0.0
 * @date 2024年05月24日 17:02
 */
@Slf4j(topic = "### UserServiceProxy ###")
public class UserServiceProxy implements IUserService {

    private IUserService userService;

    public UserServiceProxy(IUserService userService) {
        this.userService = userService;
    }

    @Override
    public boolean save() {
        log.info("用户代理类执行before");
        this.userService.save();
        log.info("用户代理类执行after");
        return true;
    }

}
