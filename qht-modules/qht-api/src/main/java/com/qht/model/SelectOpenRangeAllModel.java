package com.qht.model;

import java.io.Serializable;

public class SelectOpenRangeAllModel implements Serializable {
		//课程包范围id
		private String uid;
		//范围名称
		private String name;
		public String getUid() {
			return uid;
		}
		public void setUid(String uid) {
			this.uid = uid;
		}
		public String getName() {
			return name;
		}
		public void setName(String name) {
			this.name = name;
		}

}
