package com.alita.common.bo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @author Lydia
 * @version V1.0
 * @since Thu Dec 05 17:53:14 CST 2019
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class AlitaDataSelectBO implements Serializable {

    private String key;

    private String value;

}
