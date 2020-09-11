package com.cjh.utils;

import com.cjh.entity.Admin;
import com.cjh.entity.Dept;
import com.cjh.entity.Emp;
import org.apache.commons.codec.digest.DigestUtils;

public class Md5Encode {

	//md5加密
	public static String md5Encode(byte[] input){//byte[] ("abc")-->String("123134fjdf")
		String md5Hex = DigestUtils.md5Hex(input);
		
		StringBuffer sb=new StringBuffer(md5Hex);
		sb.insert(0, "upwdencode");
        return sb.toString();
    }
	
	public static void main(String[] args) {
		String str="123";
		str=md5Encode(str.getBytes());
		System.out.println(str);

	}

}
