package study.alone.starcraft;

public class Common {
	public static String building = "BUILDING";
	public static String creature = "CREATURE";
	public static String terran = "TERRAN";
	public static String zerg = "ZERG";
	public static String protoss = "PROTOSS";
	public static String scale_L = "LARGE";
	public static String scale_M	= "MIDDLE";
	public static String scale_S = "SMALL";
	public static int move_speed = 0;
	public boolean can_attack = true;
	
	/*
	static void Move(int speed){ 
		Common.move_speed = speed;
		
	}
	*/
	public static void Production(){
		
	}
	
	public static void Build(){
		
	}
	public static boolean Can_attack(int att){
		if(att == 0){
			return false;
		}
		return true;
	}
}
