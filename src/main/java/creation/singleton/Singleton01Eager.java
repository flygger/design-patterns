package creation.singleton;

/**
 * SingletonEager
 * <p>
 * 功能描述：饿汉式单例
 *
 * <p>
 * <span>优点：类加载时进行实例初始化，能保证多线程并发安全</span>
 * <span>缺点：非延迟加载，获取实例对象的速度比较快，但可能会造成内存资源浪费，尤其是在类实例比较大的情况下</span>
 * </p>
 *
 * @author LiFei
 * @version v1.0.0
 * @date 2024年05月20日 10:58
 */
public class Singleton01Eager {

    /**
     * 第二步：创建类实例对象
     */
    private static final Singleton01Eager INSTANCE = new Singleton01Eager();

    /**
     * 第一步：私有化构造方法
     */
    private Singleton01Eager() {
        // empty
    }

    /**
     * 第三步：提供全局访问点
     *
     * @return SingletonEager
     */
    public static Singleton01Eager getInstance() {
        return INSTANCE;
    }

}
