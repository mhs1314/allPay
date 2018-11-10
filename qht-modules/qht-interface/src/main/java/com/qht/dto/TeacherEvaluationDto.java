package com.qht.dto;

import java.io.Serializable;
import java.util.Date;

public class TeacherEvaluationDto implements Serializable {

    private String head;
    //评论id
    private String uid;
    //时间
    private Date comments_time;

    private String pkg_name;
    //评论星星
    private String comments_star;
    //评论内容
    private String comments_content;
    //学生姓名
    private String name;
}
