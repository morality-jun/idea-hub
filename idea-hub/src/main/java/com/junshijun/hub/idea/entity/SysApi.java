package com.junshijun.hub.idea.entity;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableLogic;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.Version;
import java.io.Serializable;
import java.time.LocalDateTime;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

/**
 * <p>
 * 接口表
 * </p>
 *
 * @author 节操君
 * @since 2022-06-05
 */
@Getter
@Setter
@Accessors(chain = true)
@TableName("sys_api")
public class SysApi implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 接口主键
     */
    @TableId(value = "api_id", type = IdType.ASSIGN_ID)
    private Long apiId;

    /**
     * 接口编码
     */
    @TableField("api_code")
    private String apiCode;

    /**
     * 接口名称
     */
    @TableField("api_name")
    private String apiName;

    /**
     * 接口描述
     */
    @TableField("api_comments")
    private String apiComments;

    /**
     * 接口地址
     */
    @TableField("api_url")
    private String apiUrl;

    /**
     * 接口方法类型
     */
    @TableField("api_method_type")
    private String apiMethodType;

    /**
     * 版本号
     */
    @TableField(value = "version", fill = FieldFill.INSERT)
    @Version
    private Integer version;

    /**
     * 是否已删除(1/0)
     */
    @TableField(value = "is_deleted", fill = FieldFill.INSERT)
    @TableLogic
    private Integer isDeleted;

    /**
     * 创建人id
     */
    @TableField(value = "created_by", fill = FieldFill.INSERT)
    private Long createdBy;

    /**
     * 创建时间
     */
    @TableField(value = "created_time", fill = FieldFill.INSERT)
    private LocalDateTime createdTime;

    /**
     * 修改人id
     */
    @TableField(value = "modified_by", fill = FieldFill.UPDATE)
    private Long modifiedBy;

    /**
     * 修改时间
     */
    @TableField(value = "modified_time", fill = FieldFill.UPDATE)
    private LocalDateTime modifiedTime;


    public static final String API_ID = "api_id";

    public static final String API_CODE = "api_code";

    public static final String API_NAME = "api_name";

    public static final String API_COMMENTS = "api_comments";

    public static final String VERSION = "version";

    public static final String IS_DELETED = "is_deleted";

    public static final String CREATED_BY = "created_by";

    public static final String CREATED_TIME = "created_time";

    public static final String MODIFIED_BY = "modified_by";

    public static final String MODIFIED_TIME = "modified_time";

}
