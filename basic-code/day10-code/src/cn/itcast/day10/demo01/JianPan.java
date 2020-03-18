package cn.itcast.day10.demo01;

public class JianPan implements Usb{

    @Override
    public void UsbPowerOn() {
        System.out.println("键盘开启");
    }

    @Override
    public void UsbPowerOff() {
        System.out.println("键盘关闭");
    }

    public void type(){
        System.out.println("键盘敲击");
    }
}
