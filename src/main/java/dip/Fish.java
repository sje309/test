package dip;

/** @Author: shuyizhi @Date: 2018-10-09 14:55 @Description: */
/*public class Fish {
// region 构造函数注入

*/
/* private Water water;

public Fish(Water water) {
    this.water = water;
}

public void Live() {
    System.out.println("我的生活靠：");
    water.giveNutrition();
}*/
/*

// endregion

// region setter方式注入

*/
/*   private Water water;

public void setWater(Water water) {
    this.water = water;
}
public Fish(){

}
public void live(){
    System.out.println("我的生活靠: ");
    water.giveNutrition();
}*/
/*
    // endregion
}*/

/** 接口方式注入 */
public class Fish implements ISetWater {
    private Water water;

    public Fish() {}

    public void live() {
        if (null != water) {
            System.out.println("我的生活靠：");
            water.giveNutrition();
        }
    }

    @Override
    public void setWater(Water water) {
        this.water = water;
    }
}
