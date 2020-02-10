package com.alita.common.bo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author Lydia
 * @version V1.0
 * @since 2019-08-14 15:18:13
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class LatLngBO {
    private Double lat;
    private Double lng;
}
