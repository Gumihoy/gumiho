/*
 * Copyright (C) 2017-2018 kent(kent.bohai@gmail.com).
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.aliyun.gumiho.sql.bvt.dialect.oracle.ddl.type.create;

import com.aliyun.gumiho.sql.enums.DBType;
import com.aliyun.gumiho.sql.util.SQLUtils;
import org.junit.Assert;
import org.junit.Test;

/**
 * @author kongtong.ouyang on 2018/3/15.
 */
public class OracleCreateTypeTest_8_SQLJ_Object {

    @Test
    public void test1() {
        String s = "CREATE TYPE address_t AS OBJECT\n" +
                "  EXTERNAL NAME 'Examples.Address' LANGUAGE JAVA \n" +
                "  USING SQLData(\n" +
                "    street_attr varchar(250) EXTERNAL NAME 'street',\n" +
                "    city_attr varchar(50) EXTERNAL NAME 'city',\n" +
                "    state varchar(50) EXTERNAL NAME 'state',\n" +
                "    zip_code_attr number EXTERNAL NAME 'zipCode',\n" +
                "    STATIC FUNCTION recom_width RETURN NUMBER\n" +
                "      EXTERNAL VARIABLE NAME 'recommendedWidth',\n" +
                "    STATIC FUNCTION create_address RETURN address_t\n" +
                "      EXTERNAL NAME 'create() return Examples.Address',\n" +
                "    STATIC FUNCTION construct RETURN address_t\n" +
                "      EXTERNAL NAME 'create() return Examples.Address',\n" +
                "    STATIC FUNCTION create_address (street VARCHAR, city VARCHAR, \n" +
                "        state VARCHAR, zip NUMBER) RETURN address_t\n" +
                "      EXTERNAL NAME 'create (java.lang.String, java.lang.String, java.lang.String, int) return Examples.Address',\n" +
                "    STATIC FUNCTION construct (street VARCHAR, city VARCHAR, \n" +
                "        state VARCHAR, zip NUMBER) RETURN address_t\n" +
                "      EXTERNAL NAME \n" +
                "        'create (java.lang.String, java.lang.String, java.lang.String, int) return Examples.Address',\n" +
                "    MEMBER FUNCTION to_string RETURN VARCHAR\n" +
                "      EXTERNAL NAME 'tojava.lang.String() return java.lang.String',\n" +
                "    MEMBER FUNCTION strip RETURN SELF AS RESULT \n" +
                "      EXTERNAL NAME 'removeLeadingBlanks () return Examples.Address'\n" +
                "  ) NOT FINAL; ";


        String formatSQL = SQLUtils.format(s, DBType.Oracle);
        System.out.println(s);
        System.out.println("------------------");
        System.out.println(formatSQL);
        Assert.assertEquals("CREATE TYPE address_t AS OBJECT\n" +
                "EXTERNAL NAME 'Examples.Address' LANGUAGE JAVA USING SQLData (\n" +
                "\tstreet_attr VARCHAR(250) EXTERNAL NAME 'street',\n" +
                "\tcity_attr VARCHAR(50) EXTERNAL NAME 'city',\n" +
                "\tstate VARCHAR(50) EXTERNAL NAME 'state',\n" +
                "\tzip_code_attr NUMBER EXTERNAL NAME 'zipCode',\n" +
                "\tSTATIC FUNCTION recom_width RETURN NUMBER\n" +
                "\t\tEXTERNAL VARIABLE NAME 'recommendedWidth',\n" +
                "\tSTATIC FUNCTION create_address RETURN address_t\n" +
                "\t\tEXTERNAL NAME 'create() return Examples.Address',\n" +
                "\tSTATIC FUNCTION construct RETURN address_t\n" +
                "\t\tEXTERNAL NAME 'create() return Examples.Address',\n" +
                "\tSTATIC FUNCTION create_address (\n" +
                "\t\tstreet VARCHAR,\n" +
                "\t\tcity VARCHAR,\n" +
                "\t\tstate VARCHAR,\n" +
                "\t\tzip NUMBER\n" +
                "\t) RETURN address_t\n" +
                "\t\tEXTERNAL NAME 'create (java.lang.String, java.lang.String, java.lang.String, int) return Examples.Address',\n" +
                "\tSTATIC FUNCTION construct (\n" +
                "\t\tstreet VARCHAR,\n" +
                "\t\tcity VARCHAR,\n" +
                "\t\tstate VARCHAR,\n" +
                "\t\tzip NUMBER\n" +
                "\t) RETURN address_t\n" +
                "\t\tEXTERNAL NAME 'create (java.lang.String, java.lang.String, java.lang.String, int) return Examples.Address',\n" +
                "\tMEMBER FUNCTION to_string RETURN VARCHAR\n" +
                "\t\tEXTERNAL NAME 'tojava.lang.String() return java.lang.String',\n" +
                "\tMEMBER FUNCTION strip RETURN SELF AS RESULT\n" +
                "\t\tEXTERNAL NAME 'removeLeadingBlanks () return Examples.Address'\n" +
                ")\n" +
                "NOT FINAL;", formatSQL);
    }



    @Test
    public void test2() {
        String s = "CREATE OR REPLACE TYPE long_address_t\n" +
                "UNDER address_t\n" +
                "EXTERNAL NAME 'Examples.LongAddress' LANGUAGE JAVA \n" +
                "USING SQLData(\n" +
                "    street2_attr VARCHAR(250) EXTERNAL NAME 'street2',\n" +
                "    country_attr VARCHAR (200) EXTERNAL NAME 'country',\n" +
                "    address_code_attr VARCHAR (50) EXTERNAL NAME 'addrCode',    \n" +
                "    STATIC FUNCTION create_address RETURN long_address_t \n" +
                "      EXTERNAL NAME 'create() return Examples.LongAddress',\n" +
                "    STATIC FUNCTION  construct (street VARCHAR, city VARCHAR, \n" +
                "        state VARCHAR, country VARCHAR, addrs_cd VARCHAR) \n" +
                "      RETURN long_address_t \n" +
                "      EXTERNAL NAME \n" +
                "        'create(java.lang.String, java.lang.String,\n" +
                "        java.lang.String, java.lang.String, java.lang.String) \n" +
                "          return Examples.LongAddress',\n" +
                "    STATIC FUNCTION construct RETURN long_address_t\n" +
                "      EXTERNAL NAME 'Examples.LongAddress() \n" +
                "        return Examples.LongAddress',\n" +
                "    STATIC FUNCTION create_longaddress (\n" +
                "      street VARCHAR, city VARCHAR, state VARCHAR, country VARCHAR, \n" +
                "      addrs_cd VARCHAR) return long_address_t\n" +
                "      EXTERNAL NAME \n" +
                "        'Examples.LongAddress (java.lang.String, java.lang.String,\n" +
                "         java.lang.String, java.lang.String, java.lang.String)\n" +
                "           return Examples.LongAddress',\n" +
                "    MEMBER FUNCTION get_country RETURN VARCHAR\n" +
                "      EXTERNAL NAME 'country_with_code () return java.lang.String'\n" +
                "  ); ";


        String formatSQL = SQLUtils.format(s, DBType.Oracle);
        System.out.println(s);
        System.out.println("------------------");
        System.out.println(formatSQL);
        Assert.assertEquals("CREATE OR REPLACE TYPE long_address_t UNDER address_t\n" +
                "EXTERNAL NAME 'Examples.LongAddress' LANGUAGE JAVA USING SQLData (\n" +
                "\tstreet2_attr VARCHAR(250) EXTERNAL NAME 'street2',\n" +
                "\tcountry_attr VARCHAR(200) EXTERNAL NAME 'country',\n" +
                "\taddress_code_attr VARCHAR(50) EXTERNAL NAME 'addrCode',\n" +
                "\tSTATIC FUNCTION create_address RETURN long_address_t\n" +
                "\t\tEXTERNAL NAME 'create() return Examples.LongAddress',\n" +
                "\tSTATIC FUNCTION construct (\n" +
                "\t\tstreet VARCHAR,\n" +
                "\t\tcity VARCHAR,\n" +
                "\t\tstate VARCHAR,\n" +
                "\t\tcountry VARCHAR,\n" +
                "\t\taddrs_cd VARCHAR\n" +
                "\t) RETURN long_address_t\n" +
                "\t\tEXTERNAL NAME 'create(java.lang.String, java.lang.String,\n" +
                "        java.lang.String, java.lang.String, java.lang.String) \n" +
                "          return Examples.LongAddress',\n" +
                "\tSTATIC FUNCTION construct RETURN long_address_t\n" +
                "\t\tEXTERNAL NAME 'Examples.LongAddress() \n" +
                "        return Examples.LongAddress',\n" +
                "\tSTATIC FUNCTION create_longaddress (\n" +
                "\t\tstreet VARCHAR,\n" +
                "\t\tcity VARCHAR,\n" +
                "\t\tstate VARCHAR,\n" +
                "\t\tcountry VARCHAR,\n" +
                "\t\taddrs_cd VARCHAR\n" +
                "\t) RETURN long_address_t\n" +
                "\t\tEXTERNAL NAME 'Examples.LongAddress (java.lang.String, java.lang.String,\n" +
                "         java.lang.String, java.lang.String, java.lang.String)\n" +
                "           return Examples.LongAddress',\n" +
                "\tMEMBER FUNCTION get_country RETURN VARCHAR\n" +
                "\t\tEXTERNAL NAME 'country_with_code () return java.lang.String'\n" +
                ");", formatSQL);
    }
}
