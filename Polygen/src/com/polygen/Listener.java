package com.polygen;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.HashMap;

public class Listener extends KeyAdapter{
	private HashMap<Integer, Boolean> keys = new HashMap<Integer, Boolean>(123);
	  

	public Listener(){
		/*keys.put(10, false);
		  keys.put(8, false);
		  keys.put(9, false);
		  keys.put(3, false);
		  keys.put(12, false);
		  keys.put(16, false);
		  keys.put(17, false);
		  keys.put(18, false);
		  keys.put(19, false);
		  keys.put(20, false);
		  keys.put(27, false);
		  keys.put(32, false);
		  keys.put(33, false);
		  keys.put(34, false);
		  keys.put(35, false);
		  keys.put(36, false);
		  keys.put(37, false);
		  keys.put(8, false);
		  keys.put(39, false);
		  keys.put(40, false);
		  keys.put(44, false);
		  keys.put(45, false);
		  keys.put(46, false);
		  keys.put(47, false);
		  keys.put(48, false);
		  keys.put(49, false);
		  keys.put(50, false);
		  keys.put(51, false);
		  keys.put(52, false);
		  keys.put(53, false);
		  keys.put(54, false);
		  keys.put(55, false);
		  keys.put(56, false);
		  keys.put(57, false);
		  keys.put(59, false);
		  keys.put(61, false);
		  keys.put(65, false);
		  keys.put(66, false);
		  keys.put(67, false);
		  keys.put(68, false);
		  keys.put(69, false);
		  keys.put(70, false);
		  keys.put(71, false);
		  keys.put(72, false);
		  keys.put(73, false);
		  keys.put(74, false);
		  keys.put(75, false);
		  keys.put(76, false);
		  keys.put(77, false);
		  keys.put(78, false);
		  keys.put(79, false);
		  keys.put(80, false);
		  keys.put(81, false);
		  keys.put(82, false);
		  keys.put(83, false);
		  keys.put(84, false);
		  keys.put(85, false);
		  keys.put(86, false);
		  keys.put(87, false);
		  keys.put(88, false);
		  keys.put(89, false);
		  keys.put(90, false);
		  keys.put(91, false);
		  keys.put(92, false);
		  keys.put(93, false);
		  keys.put(96, false);
		  keys.put(97, false);
		  keys.put(98, false);
		  keys.put(99, false);
		  keys.put(100, false);
		  keys.put(101, false);
		  keys.put(102, false);
		  keys.put(103, false);
		  keys.put(104, false);
		  keys.put(105, false);
		  keys.put(106, false);
		  keys.put(107, false);
		  keys.put(108, false);
		  keys.put(108, false);
		  keys.put(109, false);
		  keys.put(110, false);
		  keys.put(111, false);
		  keys.put(127, false);
		  keys.put(144, false);
		  keys.put(145, false);
		  keys.put(112, false);
		  keys.put(113, false);
		  keys.put(114, false);
		  keys.put(115, false);
		  keys.put(116, false);
		  keys.put(117, false);
		  keys.put(118, false);
		  keys.put(119, false);
		  keys.put(120, false);
		  keys.put(121, false);
		  keys.put(122, false);
		  keys.put(123, false);
		  keys.put(154, false);
		  keys.put(155, false);
		  keys.put(192, false);
		  keys.put(222, false);
		  keys.put(224, false);
		  keys.put(225, false);
		  keys.put(226, false);
		  keys.put(227, false);
		  keys.put(150, false);
		  keys.put(151, false);
		  keys.put(152, false);
		  keys.put(153, false);
		  keys.put(160, false);
		  keys.put(161, false);
		  keys.put(162, false);
		  keys.put(512, false);
		  keys.put(513, false);
		  keys.put(515, false);
		  keys.put(517, false);
		  keys.put(519, false);
		  keys.put(520, false);
		  keys.put(521, false);
		  keys.put(522, false);
		  keys.put(523, false);
		  keys.put(524, false);
		  keys.put(525, false);*/
	}
	
	public boolean isKeyPressed(int key_constant){
		try{
			if (keys.get(key_constant){
				return true;
			}
		}
		catch (exception e){
			keys.put(key_constant, false);
		}
		return false;
	}
	
	@Override
	public void keyPressed(KeyEvent e){
		keys.put(e.getKeyCode(), true);
		
	}
	
	@Override
	public void keyReleased(KeyEvent e){
		keys.put(e.getKeyCode(), false);
	}
}
