package creation.singleton;

import java.util.Objects;

/**
 * SingletonEager
 * <p>
 * 功能描述：懒汉式单例
 *
 * <p>
 * <span>优点：延迟加载</span>
 * <span>缺点：多线程情况无法保证单例</span>
 * </p>
 *
 * @author LiFei
 * @version v1.0.0
 * @date 2024年05月20日 10:58
 */
public class Singleton02Lazy {

    /**
     * 第二步：定义类实例变量
     */
    private static Singleton02Lazy instance;

    /**
     * 第一步：私有化构造方法
     */
    private Singleton02Lazy() {
        // empty
    }

    /**
     * 第三步：提供全局访问点（多线程不安全）
     *
     * @return SingletonLazy
     */
    public static Singleton02Lazy getInstance1() {
        if (Objects.isNull(instance)) {
            instance = new Singleton02Lazy();
        }
        return instance;
    }

    /**
     * 第三步：提供全局访问点（多线程安全）
     *
     * <p>synchronized加到方法上，会降低并发访问能力</p>
     *
     * @return SingletonLazy
     */
    public static synchronized Singleton02Lazy getInstance2() {
        if (Objects.isNull(instance)) {
            instance = new Singleton02Lazy();
        }
        return instance;
    }

}
