/**
 * 
 */
package com.qhit.lh.gr3.merida.sbm.utils;

import java.util.UUID;

/**
 * @author ����
 * TODO
 * 2017��12��8������8:54:30
 */
public class IDUtil {
	public static String getUUID(){
		return UUID.randomUUID().toString().replaceAll("-", "");
	}
}
