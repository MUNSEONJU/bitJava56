package study.alone.starcraft.unit;

import study.alone.starcraft.Common;

public class SCV extends Unit{
	/** BASIC **/
	public void Birth(){
		species = Common.terran;
		type = Common.creature;
		hp = 60;
		att = 5;
		arm = 0;
		boolean can_att = Common.Can_attack(att);
		System.out.println("SCV생산완료");
	}
	
	public void Move(){
		
	}
	
	public void Stop(){
		
	}
	
	public void Attack(){
		
	}
	/** BASIC **/
	
	public void Build(){
		Common.Build();
	}
}
