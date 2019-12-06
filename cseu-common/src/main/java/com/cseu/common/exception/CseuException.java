package com.cseu.common.exception;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author xueylf
 * @title: CseuException
 * @projectName cseu
 * @description: TODO
 * @date 2019/12/513:45
 * version 1.0
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CseuException extends Exception {
    private static final long serialVersionUID = 4564124491192825748L;
    private int code;
    private String message;

}
