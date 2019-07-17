package com.xuhu.cloud.entity.user;

import com.baomidou.mybatisplus.extension.activerecord.Model;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableField;
import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 
 * </p>
 *
 * @author Auto Generator
 * @since 2019-07-17
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class UserInfo extends Model<UserInfo> {

    private static final long serialVersionUID=1L;

    @TableId("ID")
    private String id;

    @TableField("USER_NAME")
    private String userName;

    @TableField("AGE")
    private Integer age;


    @Override
    protected Serializable pkVal() {
        return this.id;
    }

}
