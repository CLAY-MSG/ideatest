package cn.itcast.day18.demo08.WNTest;

//生产者

public class Producer implements Runnable{
    private Baozi bz;

    public Producer(Baozi bz){
        this.bz = bz;
    }

    @Override
    public void run() {
        while (true){
            synchronized (bz){
                if(bz.flag == true){
                    try {
                        bz.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                System.out.println("包子铺正在做包子");
                try {
                    Thread.sleep(5000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                bz.flag = true;
                System.out.println("包子做好了");
                bz.notify();
            }
        }
    }
}
