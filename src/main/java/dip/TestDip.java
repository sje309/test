package dip;

/** @Author: shuyizhi @Date: 2018-10-09 14:58 @Description: */
public class TestDip {
    public static void main(String[] args) {
        /** 1、构造函数注入 */
        /*  Water water = new RiverWater();
        Fish fish = new Fish(water);
        fish.Live();*/

        /** 2、setter方式注入 */
        /* Water water = new LakeWater();
        Fish fish = new Fish();
        fish.setWater(water);
        fish.live();*/

        /** 3、接口方式注入 */
        Water water = new WellWater();
        Fish fish = new Fish();
        fish.setWater(water);
        fish.live();
    }
}
