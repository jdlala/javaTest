import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class MainClass {
    private static int flag = 0;
    public static void main(String[] args) throws Exception {

        final Lock lock = new ReentrantLock();

        Thread a = new Thread(new Runnable() {//
            @Override
            public void run() {
                while (flag <= 30) {
                    lock.lock();
                    if (flag % 3 == 0) {
                        System.out.println("A");
                        flag ++;
                    }
                    lock.unlock();
                }
            }
        });
        Thread b = new Thread(new Runnable() {
            @Override
            public void run() {
                while (flag <= 30) {
                    lock.lock();
                    if (flag % 3 == 1) {
                        System.out.println("B");
                        flag ++;
                    }
                    lock.unlock();
                }
            }
        });
        Thread c = new Thread(new Runnable() {
            @Override
            public void run() {
                while (flag <= 30) {
                    lock.lock();
                    if (flag % 3 == 2) {
                        System.out.println("C");
                        flag ++;
                    }
                    lock.unlock();
                }
            }
        });
        a.start();
        b.start();
        c.start();
    }
}
