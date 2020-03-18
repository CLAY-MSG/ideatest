package cn.itcast.day10.demo01;

public class BiJiBen {

    public void BiJiBenPowerOn(){
        System.out.println("笔记本运行");
    }
    public void BiJiBenPowerOff(){
        System.out.println("笔记本关机");
    }
    public void useUsb(Usb usb){

        if (usb != null) {
            usb.UsbPowerOn();
            if (usb instanceof Mouse) {
                Mouse mouse = (Mouse) usb;
                mouse.chick();
            }else if(usb instanceof JianPan){
                JianPan jianPan = (JianPan) usb;
                jianPan.type();
            }
            usb.UsbPowerOff();
        }

    }

}
