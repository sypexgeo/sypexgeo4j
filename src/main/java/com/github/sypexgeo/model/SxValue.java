package com.github.sypexgeo.model;

import com.github.sypexgeo.model.value.StringValue;
import org.jetbrains.annotations.NotNull;

/**
 * Unified representation for any field name in Sypex response for City, Region or Country fields.
 */
public class SxValue extends StringValue {
    public static final String ID = "id";
    public static final String LAT = "lat";
    public static final String LON = "lon";

    public static final String NAME_RU = "name_ru";
    public static final String NAME_EN = "name_en";
    public static final String NAME_DE = "name_de";
    public static final String NAME_FR = "name_fr";
    public static final String NAME_IT = "name_it";
    public static final String NAME_ES = "name_es";
    public static final String NAME_PT = "name_pt";

    public static final String OKATO = "okato";
    public static final String VK = "vk";
    public static final String POPULATION = "population";
    public static final String ISO = "iso";
    public static final String TIMEZONE = "timezone";
    public static final String AUTO = "auto";
    public static final String UTC = "utc";
    public static final String CONTINENT = "continent";
    public static final String AREA = "area";
    public static final String CAPITAL_ID = "capital_id";
    public static final String CAPITAL_RU = "capital_ru";
    public static final String CAPITAL_EN = "capital_en";
    public static final String CUR_CODE = "cur_code";
    public static final String PHONE = "phone";
    public static final String NEIGHBOURS = "neighbours";

    public SxValue(@NotNull String value) {
        super(value);
    }
}
