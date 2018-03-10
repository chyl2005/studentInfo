package com.github.stu.utils;

public class NavUtil {

	public static String getNavgation(String mainMenu,String subMenu){
		StringBuffer navCode=new StringBuffer();
		navCode.append("��ǰλ�ã�&nbsp;&nbsp;");
		navCode.append("<a href='"+PropertiesUtil.getValue("projectName")+"/main.jsp'>��ҳ</a>&nbsp;&nbsp;>&nbsp;&nbsp;");
		navCode.append("<a href='#'>"+mainMenu+"</a>&nbsp;&nbsp;>&nbsp;&nbsp;");
		navCode.append("<a href='#'>"+subMenu+"</a>");
		return navCode.toString();
	}
}
