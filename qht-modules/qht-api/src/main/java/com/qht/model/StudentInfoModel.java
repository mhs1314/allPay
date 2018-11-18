package com.qht.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class StudentInfoModel implements Serializable {
    //學生id
    private String uid;
    //學生頭像
    private String head;
    //學校id
    private String schoolid;
    //性別
    private String sex;
    //姓名
    private String name;
    //昵稱
    private String nickname;
    //學校id
    private String school_name;
    //班級名稱
    private String calnzz;
    //練級名稱
    private String clanzzName;
    //年紀名稱
    private String age;
    //標簽集合
    private List<TatModel> tatModels =new ArrayList<>();
    //監護人
    private List<GuardianModel> guardianModels=new ArrayList<>();

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    public String getHead() {
        return head;
    }

    public void setHead(String head) {
        this.head = head;
    }

    public String getSchoolid() {
        return schoolid;
    }

    public void setSchoolid(String schoolid) {
        this.schoolid = schoolid;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getSchool_name() {
        return school_name;
    }

    public void setSchool_name(String school_name) {
        this.school_name = school_name;
    }

    public String getCalnzz() {
        return calnzz;
    }

    public void setCalnzz(String calnzz) {
        this.calnzz = calnzz;
    }

    public String getClanzzName() {
        return clanzzName;
    }

    public void setClanzzName(String clanzzName) {
        this.clanzzName = clanzzName;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

	@Override
	public String toString() {
		return "StudentInfoModel [uid=" + uid + ", head=" + head + ", schoolid=" + schoolid + ", sex=" + sex + ", name="
				+ name + ", nickname=" + nickname + ", school_name=" + school_name + ", calnzz=" + calnzz
				+ ", clanzzName=" + clanzzName + ", age=" + age + ", tatModels=" + tatModels + ", guardianModels="
				+ guardianModels + "]";
	}
    
    
}
