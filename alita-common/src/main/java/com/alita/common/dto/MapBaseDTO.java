package com.alita.common.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @author Lydia
 * @version V1.0
 * @since 2020-01-10 10:02:49
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class MapBaseDTO implements Serializable {

    @ApiModelProperty(value = "城市ID", required = true)
    private Long cityId;
    @ApiModelProperty(value = "某业务下具体请求类型", required = true)
    private Integer type;
    @ApiModelProperty(value = "入参键值对", required = false)
    private KeyValue[] params;
    /**
     * 用户登录信息
     */
    private String staffCreated;
    private String staffModified;
    //邮箱前缀
    private String currentUserName;
    //中文名
    private String currentUserAlias;

    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    public static class KeyValue {

        @ApiModelProperty(value = "入参变量名称", required = false)
        private String key;
        @ApiModelProperty(value = "入参变量值", required = false)
        private Object value;

        public String getKey() {
            return key;
        }

        public void setKey(String key) {
            this.key = key;
        }

        public Object getValue() {
            return value;
        }

        public void setValue(Object value) {
            this.value = value;
        }
    }
}
