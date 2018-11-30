package com.julu.qht.entity;

import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.activerecord.Model;
import java.io.Serializable;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
/**
 * <p>
 * 学生
 * </p>
 *
 * @author qht
 * @since 2018-11-29
 */
@ApiModel("学生")
public class Student extends Model<Student> {

    private static final long serialVersionUID = 1L;

    /**
     * 主键
     */
    @ApiModelProperty("主键")
    private String uid;
    /**
     * 运营商ID
     */
    @ApiModelProperty("运营商ID")
    @TableField("tenant_id")
    private String tenantId;
    /**
     * 昵称
     */
    @ApiModelProperty("昵称")
    private String nickname;
    /**
     * 姓名
     */
    @ApiModelProperty("姓名")
    private String name;
    /**
     * 头像
     */
    @ApiModelProperty("头像")
    private String head;
    /**
     * 性别
     */
    @ApiModelProperty("性别")
    private String sex;
    /**
     * 年龄
     */
    @ApiModelProperty("年龄")
    private String age;
    /**
     * 学校
     */
    @ApiModelProperty("学校")
    @TableField("school_id")
    private String schoolId;
    /**
     * 班级
     */
    @ApiModelProperty("班级")
    private String clazz;
    /**
     * 账号
     */
    @ApiModelProperty("账号")
    private String account;
    /**
     * 密码
     */
    @ApiModelProperty("密码")
    private String password;
    /**
     * 年级id
     */
    @ApiModelProperty("年级id")
    @TableField("grade_id")
    private String gradeId;
    /**
     * 学生总积分
     */
    @ApiModelProperty("学生总积分")
    private String integral;
    /**
     * 状态：0、待审核；1、成功；2、失败；3、禁用
     */
    @ApiModelProperty("状态：0、待审核；1、成功；2、失败；3、禁用")
    private Integer status;
    /**
     * 身份证号码
     */
    @ApiModelProperty("身份证号码")
    @TableField("card_number")
    private String cardNumber;
    /**
     * 积分余额
     */
    @ApiModelProperty("积分余额")
    private Integer balance;
    /**
     * PC;0;未登录；1、登录中
     */
    @ApiModelProperty("PC;0;未登录；1、登录中")
    @TableField("pc_login")
    private Integer pcLogin;
    /**
     * APP:0;未登录；1、登录中
     */
    @ApiModelProperty("APP:0;未登录；1、登录中")
    @TableField("app_login")
    private Integer appLogin;
    private String school;


    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    public String getTenantId() {
        return tenantId;
    }

    public void setTenantId(String tenantId) {
        this.tenantId = tenantId;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getHead() {
        return head;
    }

    public void setHead(String head) {
        this.head = head;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getSchoolId() {
        return schoolId;
    }

    public void setSchoolId(String schoolId) {
        this.schoolId = schoolId;
    }

    public String getClazz() {
        return clazz;
    }

    public void setClazz(String clazz) {
        this.clazz = clazz;
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getGradeId() {
        return gradeId;
    }

    public void setGradeId(String gradeId) {
        this.gradeId = gradeId;
    }

    public String getIntegral() {
        return integral;
    }

    public void setIntegral(String integral) {
        this.integral = integral;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getCardNumber() {
        return cardNumber;
    }

    public void setCardNumber(String cardNumber) {
        this.cardNumber = cardNumber;
    }

    public Integer getBalance() {
        return balance;
    }

    public void setBalance(Integer balance) {
        this.balance = balance;
    }

    public Integer getPcLogin() {
        return pcLogin;
    }

    public void setPcLogin(Integer pcLogin) {
        this.pcLogin = pcLogin;
    }

    public Integer getAppLogin() {
        return appLogin;
    }

    public void setAppLogin(Integer appLogin) {
        this.appLogin = appLogin;
    }

    public String getSchool() {
        return school;
    }

    public void setSchool(String school) {
        this.school = school;
    }

    @Override
    protected Serializable pkVal() {
        return this.uid;
    }

    @Override
    public String toString() {
        return "Student{" +
        ", uid=" + uid +
        ", tenantId=" + tenantId +
        ", nickname=" + nickname +
        ", name=" + name +
        ", head=" + head +
        ", sex=" + sex +
        ", age=" + age +
        ", schoolId=" + schoolId +
        ", clazz=" + clazz +
        ", account=" + account +
        ", password=" + password +
        ", gradeId=" + gradeId +
        ", integral=" + integral +
        ", status=" + status +
        ", cardNumber=" + cardNumber +
        ", balance=" + balance +
        ", pcLogin=" + pcLogin +
        ", appLogin=" + appLogin +
        ", school=" + school +
        "}";
    }
}
