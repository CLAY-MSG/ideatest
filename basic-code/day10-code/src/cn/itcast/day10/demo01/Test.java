package cn.itcast.day10.demo01;

public class Test {

    public static void main(String[] args) {
        BiJiBen biJiBen = new BiJiBen();
        biJiBen.BiJiBenPowerOn();
        Usb u = new Mouse();
        biJiBen.useUsb(u);
        JianPan jianPan = new JianPan();
        biJiBen.useUsb(jianPan);
        biJiBen.BiJiBenPowerOff();
    }
}
