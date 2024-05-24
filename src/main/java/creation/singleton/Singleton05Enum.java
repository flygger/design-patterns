package creation.singleton;

/**
 * Singleton05Enum
 * <p>
 * 功能描述：枚举
 *
 * <p>阻止发射的破坏性，在反射方法中不允许使用反射创建枚举对象</p>
 * <p>阻止序列化的，在反射方法中不允许使用反射创建枚举对象</p>
 *
 * @author LiFei
 * @version v1.0.0
 * @date 2024年05月20日 12:27
 */
public enum Singleton05Enum{

    INSTANCE;

    public static Singleton05Enum getInstance() {
        return INSTANCE;
    }
}
