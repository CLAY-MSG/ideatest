package cn.itcast.day10.demo01;

public class Mouse implements Usb{

    @Override
    public void UsbPowerOn() {
        System.out.println("鼠标开启");
    }

    @Override
    public void UsbPowerOff() {
        System.out.println("鼠标关闭");
    }

    public void chick(){
        System.out.println("鼠标敲击");
    }
}
