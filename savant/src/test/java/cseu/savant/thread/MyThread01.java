package cseu.savant.thread;

/**
 * @author xueylf
 * @title: MyThread01
 * @projectName cseu
 * @description: TODO
 * @date 2019/12/2016:14
 * version 1.0
 */
public class MyThread01 extends Thread {
    private int count = 5;

    @Override
    synchronized public  void run() {
        super.run();
        count--;
        //此示例不要用for语句，因为使用同步后其他线程就得不到运行的机会了，
        //一直由一个线程进行减法运算
        System.out.println("由 " + this.currentThread().getName() + " 计算，count=" + count);
    }

    public static void main(String[] args) {
        MyThread01 mythread=new MyThread01();
        Thread a=new Thread(mythread,"A");
        Thread b=new Thread(mythread,"B");
        Thread c=new Thread(mythread,"C");
        Thread d=new Thread(mythread,"D");
        Thread e=new Thread(mythread,"E");
        a.start();
        b.start();
        c.start();
        d.start();
        e.start();
    }
}
