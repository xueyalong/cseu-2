package com.cseu.core.model;

import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 角色与部门对应关系
 * </p>
 *
 * @author bzcoder
 * @since 2019-12-04
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class SysRoleDept implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 角色ID
     */
    private Integer roleId;

    /**
     * 部门ID
     */
    private Integer deptId;


}
