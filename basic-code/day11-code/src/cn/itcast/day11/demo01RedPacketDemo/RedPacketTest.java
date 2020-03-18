package cn.itcast.day11.demo01RedPacketDemo;

import cn.itcast.day11.demo01known.OpenMode;

public class RedPacketTest {

    public static void main(String[] args) {
        RedPacket rd =new RedPacket("红包");
        rd.setOwnerName("米帅广");
        OpenMode openMode = new Common();
        rd.setOpenWay(openMode);
        /*OpenMode openMode1 = new Lucky();
        rd.setOpenWay(openMode1);*/
    }
}
