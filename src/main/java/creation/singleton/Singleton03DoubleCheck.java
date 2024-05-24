package creation.singleton;

import java.io.Serializable;
import java.util.Objects;

/**
 * SingletonDoubleCheck
 * <p>
 * 功能描述：双重校验锁
 *
 * <p></p>
 *
 * @author LiFei
 * @version v1.0.0
 * @date 2024年05月20日 11:47
 */
public class Singleton03DoubleCheck implements Serializable {

    /**
     * 第二步：定义类实例变量
     *
     * <p>volatile：解决多线程环境下的指令重排序问题，保证可见性和有序性</p>
     */
    private static volatile Singleton03DoubleCheck instance;

    /**
     * 第一步：私有化构造方法
     */
    private Singleton03DoubleCheck() {
        // empty
    }

    /**
     * 第三步：提供全局访问点
     *
     * @return SingletonLazy
     */
    public static Singleton03DoubleCheck getInstance1() {
        if (Objects.isNull(instance)) {
            // 锁加到方法内，但是由于操作系统的线程优先级算法，多线程时依然可能会导致创建多个实例
            synchronized (Singleton03DoubleCheck.class) {
                instance = new Singleton03DoubleCheck();
            }
        }
        return instance;
    }

    /**
     * 第三步：提供全局访问点
     *
     * @return SingletonLazy
     */
    public static Singleton03DoubleCheck getInstance2() {
        // 第一次判断, 如果instance不为null, 不抢锁,直接返回实例
        if (Objects.isNull(instance)) {
            synchronized (Singleton03DoubleCheck.class) {
                // 第二次判断, 抢到锁之后再次进行判断,判断是否为null
                if (Objects.isNull(instance)) {
                    // 由于编译器的指令重排序，可能会改变指令的执行顺序
                    // JVM创建对象步骤：①分配内存空间，② 对象初始化 ③ 把实例对象指向已分配的内存空间
                    instance = new Singleton03DoubleCheck();
                }
            }
        }
        return instance;
    }

    /**
     * 解决序列化的破坏性
     *
     * @return Object
     */
    public Object readResolve() {
        return instance;
    }

}
