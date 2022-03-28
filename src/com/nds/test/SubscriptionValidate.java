package com.nds.test;

public class SubscriptionValidate {

	public boolean ValSubfields(String sub_id, String cus_id, String pub_id, String desc) {
		return (sub_id.equals("") || cus_id.equals("") || pub_id.equals("") || desc.equals("") ? true : false);
	}

	public boolean Validatesub(String sid) {

		String regx = "^[0-9]{1,100}$";
		return sid.matches(regx);
	}

	public boolean Validatecus(String cid) {

		String regx = "[0-9]{1,1000}";
		return cid.matches(regx);
	}

	public boolean Validatepub(String pid) {

		String regx = "[0-9]{1,1000}";
		return pid.matches(regx);
	}

	public boolean Validatdesc(String des) {
		String regx = "[a-zA-z ]{5,20}";
		return des.matches(regx);
	}

	public boolean CheckAllValidate(String sid, String cid, String pid, String des) {
		return (Validatesub(sid) && Validatecus(cid) && Validatepub(pid) && Validatdesc(des));

	}

}
