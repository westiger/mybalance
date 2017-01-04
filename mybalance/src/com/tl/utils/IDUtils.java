package com.tl.utils;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.UUID;

import sun.misc.BASE64Encoder;

public class IDUtils {
	
	public static String createNewId(){
		String id = UUID.randomUUID().toString();
		/*
		MessageDigest md;
		try {
			md = MessageDigest.getInstance("md5");
			byte[] bs = md.digest(id.getBytes());
			BASE64Encoder base = new BASE64Encoder();
			id = base.encode(bs);
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}
		*/
		return id;
	}
	
	/*
	public static String URLEncode(String id){
		try {
			return URLEncoder.encode(id,"UTF-8");
		} catch (Exception e) {
			throw new RuntimeException("±‡¬Î ß∞‹");
		}
	}
	*/
	
}
