package com.cseu.core.model;

import java.sql.Blob;
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
public class ZipkinAnnotations implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * If non zero, this means the trace uses 128 bit traceIds instead of 64 bit
     */
    private Long traceIdHigh;

    /**
     * coincides with zipkin_spans.trace_id
     */
    private Long traceId;

    /**
     * coincides with zipkin_spans.id
     */
    private Long spanId;

    /**
     * BinaryAnnotation.key or Annotation.value if type == -1
     */
    private String aKey;

    /**
     * BinaryAnnotation.value(), which must be smaller than 64KB
     */
    private Blob aValue;

    /**
     * BinaryAnnotation.type() or -1 if Annotation
     */
    private Integer aType;

    /**
     * Used to implement TTL; Annotation.timestamp or zipkin_spans.timestamp
     */
    private Long aTimestamp;

    /**
     * Null when Binary/Annotation.endpoint is null
     */
    private Integer endpointIpv4;

    /**
     * Null when Binary/Annotation.endpoint is null, or no IPv6 address
     */
    private byte[] endpointIpv6;

    /**
     * Null when Binary/Annotation.endpoint is null
     */
    private Integer endpointPort;

    /**
     * Null when Binary/Annotation.endpoint is null
     */
    private String endpointServiceName;


}
