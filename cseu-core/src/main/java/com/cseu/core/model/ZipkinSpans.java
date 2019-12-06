package com.cseu.core.model;

import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

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
public class ZipkinSpans implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * If non zero, this means the trace uses 128 bit traceIds instead of 64 bit
     */
    private Long traceIdHigh;

    private Long traceId;

    private String name;

    private Long parentId;

    private Boolean debug;

    /**
     * Span.timestamp(): epoch micros used for endTs query and to implement TTL
     */
    private Long startTs;

    /**
     * Span.duration(): micros used for minDuration and maxDuration query
     */
    private Long duration;


}
