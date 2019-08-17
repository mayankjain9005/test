package com.cdk.services;

import java.util.Map.Entry;
import java.util.TreeMap;

public class DiscountServiceImpl implements DiscountService{
	private static final TreeMap<Integer, Integer> regular = new TreeMap<Integer, Integer>();
	static {
		regular.put(0, 0);
		regular.put(5001, 10);
		regular.put(10001, 20);

	}
	private static final TreeMap<Integer, Integer> premium = new TreeMap<Integer, Integer>();
	static {
		premium.put(4000, 10);
		premium.put(4001, 15);
		premium.put(8001, 20);
		premium.put(12001, 30);
	}


	public String getFinalAmt(String customerType, String totalPurshaseAmt) {
		int discount = 0;
		int amt=removeSign(totalPurshaseAmt);
		if(null !=customerType && !customerType.equals("") && customerType.equalsIgnoreCase("Regular")){
			discount=mappedValue(regular, amt);	
		}else if(null !=customerType && !customerType.equals("") && customerType.equalsIgnoreCase("Premium")) {
			discount=mappedValue(premium, amt);
		}
		System.out.println(discount);
		amt = amt -  ((amt * discount)/100);
		return addSign(amt);	
	}

	private int removeSign(String amt){
		return Integer.parseInt(amt.replace("$", "")) ;
	}

	private String addSign(int amt){
		return "$"+amt;
	}

	private static <K, V> V mappedValue(TreeMap<K, V> map, K key) {
		Entry<K, V> e = map.floorEntry(key);
		if (e != null && e.getValue() == null) {
			e = map.lowerEntry(key);
		}
		return e == null ? null : e.getValue();
	}
}
