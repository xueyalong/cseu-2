package com.cseu.common.core;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.*;
import lombok.experimental.Accessors;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;

import java.io.Serializable;
import java.util.Date;

/**
 * <p>
 * 用户表
 * </p>
 *
 * @author bzcoder
 * @since 2019-12-04
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Document(indexName = "sys_user",type = "docs",shards = 1,replicas = 0)
public class SysUser implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 主键ID
     */
    @Id
    private Long userId;

    /**
     * 用户名
     */
    @Field(type = FieldType.Keyword)
    private String username;

    private String password;

    /**
     * 随机盐
     */
    private String salt;

    /**
     * 简介
     */
    @Field(type = FieldType.Keyword)
    private String phone;

    /**
     * 头像
     */
    @Field(type = FieldType.Keyword)
    private String avatar;

    /**
     * 部门ID
     */
    @Field(type = FieldType.Long)
    private Long deptId;

    /**
     * 创建时间
     */
    @Field(type = FieldType.Date)
    private Date createTime;

    /**
     * 修改时间
     */
    @Field(type = FieldType.Date)
    private Date updateTime;

    /**
     * 0-正常，9-锁定
     */
    @Field(type = FieldType.Integer)
    private Integer lockFlag;

    /**
     * 0-正常，1-删除
     */
    @Field(type = FieldType.Integer)
    private Integer delFlag;

    /**
     * 微信openid
     */
    @Field(type = FieldType.Keyword)
    private String wxOpenid;

    /**
     * QQ openid
     */
    @Field(type = FieldType.Keyword)
    private String qqOpenid;


}
