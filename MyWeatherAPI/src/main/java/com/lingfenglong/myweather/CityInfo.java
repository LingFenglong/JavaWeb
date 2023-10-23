package com.lingfenglong.rpc;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CityInfo {
    private String provinces;
    private String city;
    private String area;

}