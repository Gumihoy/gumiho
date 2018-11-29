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
package com.aliyun.gumiho.sql.bvt.dialect.oracle.ddl.view.create;

import com.aliyun.gumiho.sql.enums.DBType;
import com.aliyun.gumiho.sql.util.SQLUtils;
import org.junit.Assert;
import org.junit.Test;

/**
 * @author kongtong.ouyang on 2018/3/15.
 */
public class OracleCreateViewTest_6_XmlType {

    @Test
    public void test1() {
        String s = "CREATE VIEW warehouse_view OF XMLTYPE\n" +
                " XMLSCHEMA \"http://www.example.com/xwarehouses.xsd\" \n" +
                "    ELEMENT \"Warehouse\"\n" +
                "    WITH OBJECT ID \n" +
                "    (extract(OBJECT_VALUE, '/Warehouse/Area/text()').getnumberval())\n" +
                " AS SELECT XMLELEMENT(\"Warehouse\",\n" +
                "            XMLFOREST(WarehouseID as \"Building\",\n" +
                "                      area as \"Area\",\n" +
                "                      docks as \"Docks\",\n" +
                "                      docktype as \"DockType\",\n" +
                "                      wateraccess as \"WaterAccess\",\n" +
                "                      railaccess as \"RailAccess\",\n" +
                "                      parking as \"Parking\",\n" +
                "                      VClearance as \"VClearance\"))\n" +
                "  FROM warehouse_table; ";


        String formatSQL = SQLUtils.format(s, DBType.Oracle);
        System.out.println(s);
        System.out.println("------------------");
        System.out.println(formatSQL);
        Assert.assertEquals("CREATE VIEW warehouse_view OF XMLTYPE\n" +
                "XMLSCHEMA \"http://www.example.com/xwarehouses.xsd\"\n" +
                "ELEMENT \"Warehouse\"\n" +
                "WITH OBJECT ID (extract(OBJECT_VALUE, '/Warehouse/Area/text()').getnumberval())\n" +
                "AS\n" +
                "\tSELECT XMLELEMENT(\"Warehouse\", XMLFOREST(WarehouseID AS \"Building\", area AS \"Area\", docks AS \"Docks\", docktype AS \"DockType\", wateraccess AS \"WaterAccess\", railaccess AS \"RailAccess\", parking AS \"Parking\", VClearance AS \"VClearance\"))\n" +
                "\tFROM warehouse_table;", formatSQL);
    }


}
