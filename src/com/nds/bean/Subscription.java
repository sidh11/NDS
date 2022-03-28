package com.nds.bean;

public class Subscription {

		int sub_id;
		int cus_id;

		int pub_id;
		String desc;
		
		public Subscription(int sub_id, int cus_id, int pub_id, String desc) {
			super();
			this.sub_id = sub_id;
			this.cus_id = cus_id;
			this.pub_id = pub_id;
			this.desc = desc;
		}
		public Subscription() {
			
		}
		public int getSub_id() {
			return sub_id;
		}
		public void setSub_id(int sub_id) {
			this.sub_id = sub_id;
		}
		public int getCus_id() {
			return cus_id;
		}
		public void setCus_id(int cus_id) {
			this.cus_id = cus_id;
		}
		public int getPub_id() {
			return pub_id;
		}
		public void setPub_id(int pub_id) {
			this.pub_id = pub_id;
		}
		public String getdesc() {
			return desc;
		}
		public void setdesc(String desc) {
			this.desc = desc;

		}
		}