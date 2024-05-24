package structure.proxy.statics;

import lombok.extern.slf4j.Slf4j;
import structure.proxy.IUserService;

/**
 * UserServiceImpl
 * <p>
 * 功能描述：
 *
 * <p></p>
 *
 * @author LiFei
 * @version v1.0.0
 * @date 2024年05月24日 16:42
 */
@Slf4j(topic = "### UserServiceImpl ###")
public class UserServiceImpl implements IUserService {

    @Override
    public boolean save() {
        log.info("用户业务类执行");
        return true;
    }
}
