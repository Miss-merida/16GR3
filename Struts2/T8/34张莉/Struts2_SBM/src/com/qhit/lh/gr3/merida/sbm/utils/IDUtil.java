/**
 * 
 */
package com.qhit.lh.gr3.merida.sbm.utils;

import java.util.UUID;

/**
 * @author 张莉
 * TODO
 * 2017年12月8日下午8:54:30
 */
public class IDUtil {
	public static String getUUID(){
		return UUID.randomUUID().toString().replaceAll("-", "");
	}
}
