package cn.itcast.day18.demo08.WNTest;

import org.w3c.dom.ls.LSOutput;

public class Consumer implements Runnable{
    private Baozi bz;

    public Consumer(Baozi bz){
        this.bz = bz;
    }

    @Override
    public void run() {
        while (true){
            synchronized (bz){
                if(bz.flag==false){
                    try {
                        bz.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                System.out.println("吃包子");
                try {
                    Thread.sleep(5000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                bz.flag = false;
                System.out.println("包子吃完了");
                bz.notify();
            }
        }



    }
}
