package com.github.stu.utils;

import java.util.UUID;

/**
 * UUID������
 * @author 
 *
 */
public class UUIDUtil {

	/**
	 * ��ȡUUID
	 * @return
	 */
	public static String getUUID(){
		UUID uuid=UUID.randomUUID();
		return uuid.toString();
	}
	
	public static void main(String[] args) {
		System.out.println(UUIDUtil.getUUID());
	}
}
