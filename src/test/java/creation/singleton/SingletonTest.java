package creation.singleton;

import org.junit.Assert;
import org.junit.Test;

import java.io.*;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.CountDownLatch;

/**
 * SingletonEagerTest
 * <p>
 * 功能描述：
 *
 * <p></p>
 *
 * @author LiFei
 * @version v1.0.0
 * @date 2024年05月20日 11:07
 */
public class SingletonTest {

    @Test
    public void testEager() {
        Singleton01Eager instance01 = Singleton01Eager.getInstance();
        Singleton01Eager instance02 = Singleton01Eager.getInstance();
        Assert.assertEquals(instance01, instance02);
    }

    @Test
    public void testLazy() throws InterruptedException {
        int number = 200;
        CountDownLatch cdl = new CountDownLatch(number);
        Set<Singleton02Lazy> instances = new HashSet<>();
        for (int i = 0; i < number; i++) {
            Thread thread = new Thread(() -> {
                instances.add(Singleton02Lazy.getInstance1());
            });
            thread.start();
            cdl.countDown();
        }
        cdl.await();
        Assert.assertEquals(1, instances.size());
    }

    /**
     * 反射对单例的破坏性
     */
    @Test
    public void reflect() throws NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {
        Class<Singleton04StaticInnerClass> clazz = Singleton04StaticInnerClass.class;
        Constructor<Singleton04StaticInnerClass> constructor = clazz.getDeclaredConstructor();
        constructor.setAccessible(true);
        Singleton04StaticInnerClass instance1 = constructor.newInstance();
        Singleton04StaticInnerClass instance2 = Singleton04StaticInnerClass.getInstance();
        Assert.assertEquals(instance2, instance1);
    }

    @Test
    public void serialize() throws IOException, ClassNotFoundException {

        FileOutputStream fos = new FileOutputStream("Singleton03DoubleCheck.obj");
        ObjectOutputStream oos = new ObjectOutputStream(fos);
        oos.writeObject(Singleton03DoubleCheck.getInstance2());

        FileInputStream fis = new FileInputStream("Singleton03DoubleCheck.obj");
        ObjectInputStream ois = new ObjectInputStream(fis);
        Singleton03DoubleCheck instance1 = (Singleton03DoubleCheck) ois.readObject();

        Singleton03DoubleCheck instance2 = Singleton03DoubleCheck.getInstance2();
        Assert.assertEquals(instance2, instance1);
    }

    /**
     * 反射对单例的破坏性
     */
    @Test
    public void reflectEnum() throws NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {
        Class<Singleton05Enum> clazz = Singleton05Enum.class;
        Constructor<Singleton05Enum> constructor = clazz.getDeclaredConstructor();
        constructor.setAccessible(true);
        Singleton05Enum instance1 = constructor.newInstance();
        Singleton05Enum instance2 = Singleton05Enum.getInstance();
        Assert.assertEquals(instance2, instance1);
    }

    @Test
    public void serializeEnum() throws IOException, ClassNotFoundException {

        FileOutputStream fos = new FileOutputStream("Singleton05Enum.obj");
        ObjectOutputStream oos = new ObjectOutputStream(fos);
        oos.writeObject(Singleton05Enum.getInstance());

        FileInputStream fis = new FileInputStream("Singleton05Enum.obj");
        ObjectInputStream ois = new ObjectInputStream(fis);
        Singleton05Enum instance1 = (Singleton05Enum) ois.readObject();

        Singleton05Enum instance2 = Singleton05Enum.getInstance();
        Assert.assertEquals(instance2, instance1);
    }

}
