package com.dongpo.cloud.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @className CommonResult
 * @Description: TODO
 * @Author dongpo
 * @Date 2020/6/4
 * @Version V1.0
 **/
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CommonResult<T> implements Serializable {
    private Integer code;

    private String message;

    private T      data;

    public CommonResult(Integer code, String message) {
        this(code,message,null);
    }
}
