package gyc.java.main.algorithms.sort;

/**
 * @author guoyc on 2016/8/28.
 */
public class ThreadNoSafeTest implements Runnable  {

    private A a;

    ThreadNoSafeTest(A a) {
        this.a = a;
    }

    @Override
    public void run() {
        for (int i = 0;  i < 10; i ++) {
            if (i % 2 == 0) {
                synchronized(a) {
                    a.count++;
                    a.b ++;
                    System.out.println(Thread.currentThread().getName() + "   " + a.count);
                    System.out.println(Thread.currentThread().getName() + "  b=  " + a.b);
                }
            }

        }

    }

    static class A {
        public static int count = 0;
        public int b = 1;
    }

    public static void main(String[] args) {
        A a = new A();
        A a2 = new A();
        Thread t1 = new Thread(new ThreadNoSafeTest(a));
        Thread t2 = new Thread(new ThreadNoSafeTest(a2));
        t1.start();
        t2.start();
//        System.out.println(a.count);
    }
}
