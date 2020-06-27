package com.dongpo.cloud.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @className Payment
 * @Description: TODO
 * @Author dongpo
 * @Date 2020/6/4
 * @Version V1.0
 **/
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Payment implements Serializable {
    private Integer id;

    private String serial;
}
