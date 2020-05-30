package com.designPatterns.里氏替换;

/**
 * 
 * @author imac
 * 
 * 里氏替换原则通俗来讲就是：子类可以扩展父类的功能，但不能改变父类原有的功能。
 * 
 * 也就是说：子类继承父类时，除添加新的方法完成新增功能外，尽量不要重写父类的方法。
 *
 * 如果通过重写父类的方法来完成新的功能，这样写起来虽然简单，但是整个继承体系的可复用性会比较差，特别是运用多态比较频繁时，程序运行出错的概率会非常大。
 *
 * 如果程序违背了里氏替换原则，则继承类的对象在基类出现的地方会出现运行错误。这时其修正方法是：取消原来的继承关系，重新设计它们之间的关系。
 *
 */
public class LSPtest {
	public static void main(String[] args) {
		
		Bird swallow = new Swallow();
		Bird brownKiwi = new BrownKiwi();
		double distance = 300; //如果飞行距离是300
		double speed = 120;
		
		
		swallow.setSpeed(speed);
		brownKiwi.setSpeed(speed);
		
		System.out.println("如果飞行距离是300");
		
		try {
			System.out.println("燕子将飞行"+swallow.getFlyTime(distance) +"小时.");
			System.out.println("几维鸟将飞行"+brownKiwi.getFlyTime(distance) +"小时.");
			
		}catch(Exception e){
			System.out.println("发生错误了!");
		}
		
		
	}
}

/**
 * 
 * @author imac
 *
 * 定义鸟类 (父类)
 *
 */
class Bird{
	
	double flySpeed;// 飞行速度
	
	/**
	 * 设置飞行速度
	 * @param flySpeed
	 */
	public void setSpeed(double flySpeed) {
		this.flySpeed = flySpeed;
	}
	
	
	/**
	 * 获取飞行时间
	 * @param distance  距离
	 * @return
	 */
	public double getFlyTime(double distance) {
		return distance / flySpeed;
	}
	
}

/**
 * 
 * @author imac
 * 燕子类
 */
class Swallow extends Bird {
	
}


/**
 * 
 * @author imac
 * 几维鸟类
 */
class BrownKiwi extends Bird{
	/**
	 * 重写速度设置
	 */
	@Override
	public void setSpeed(double flySpeed) {
		flySpeed = 0;
	}
}


