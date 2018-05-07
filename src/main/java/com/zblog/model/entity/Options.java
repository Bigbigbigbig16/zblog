package com.zblog.model.entity;

import com.blade.jdbc.annotation.Table;
import com.blade.jdbc.core.ActiveRecord;
import lombok.Data;

/**
 * 配置选项
 */
@Data
@Table(value = "t_options", pk = "name")
public class Options extends ActiveRecord {

    // 配置名称
    private String name;

    // 配置值
    private String value;

    // 配置描述
    private String description;

}