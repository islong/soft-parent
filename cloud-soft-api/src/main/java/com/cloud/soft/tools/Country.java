package com.cloud.soft.tools;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

/**
 * @program: soft-parent
 * @description:
 * @author: caiSJ
 * @create: 2020-06-05 10:53
 */
@AllArgsConstructor
public enum  Country {
    COUNTRY_ZG(1,"赵国"),
    COUNTRY_QG(2,"齐国"),
    COUNTRY_HG(3,"韩国"),
    COUNTRY_WG(4,"魏国"),
    COUNTRY_CG(5,"楚国"),
    COUNTRY_YG(6,"燕国");

    @Getter
    @Setter
    private Integer id;
    @Getter
    @Setter
    private String name;

    /**
     *
     * @param code
     * @return
     */
    public static Country getCountryByCode(Integer code){
        Country[] values = Country.values();
        for(Country country : values){
            if(code==country.getId()){
                return country;
            }
        }
        return null;
    }


}
