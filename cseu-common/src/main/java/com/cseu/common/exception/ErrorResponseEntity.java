package com.cseu.common.exception;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author xueylf
 * @title: ErrorResponseEntity
 * @projectName cseu
 * @description: TODO
 * @date 2019/12/513:46
 * version 1.0
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ErrorResponseEntity {
    private int code;
    private String message;
}
