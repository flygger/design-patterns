package creation.singleton;

/**
 * Singleton04StaticInnerClass
 * <p>
 * 功能描述： 静态内部类
 *
 * <p>延迟加载，多线程安全</p>
 *
 * @author LiFei
 * @version v1.0.0
 * @date 2024年05月20日 12:02
 */
public class Singleton04StaticInnerClass {

    private Singleton04StaticInnerClass() {
        // empty
        throw new IllegalCallerException("it is not allowed to create instance via reflection");
    }

    public static Singleton04StaticInnerClass getInstance() {
        return SingletonHolder.INSTANCE;
    }

    /**
     * 静态内部类
     */
    private static class SingletonHolder {

        // 在静态内部类中创建单例,在装载内部类的时候,才会创建单例对象
        private static final Singleton04StaticInnerClass INSTANCE = new Singleton04StaticInnerClass();

        private SingletonHolder() {

        }
    }

}
