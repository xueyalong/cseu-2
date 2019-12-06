package com.cseu.core.model;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.util.Date;

/**
 * <p>
 * 
 * </p>
 *
 * @author bzcoder
 * @since 2019-12-04
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class ZipkinDependencies implements Serializable {

    private static final long serialVersionUID = 1L;

    private Date day;

    private String parent;

    private String child;

    private Long callCount;

    private Long errorCount;


}
