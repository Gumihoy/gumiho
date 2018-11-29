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
package com.aliyun.gumiho.sql.bvt.dialect.oracle.dml.select;

import com.aliyun.gumiho.sql.enums.DBType;
import com.aliyun.gumiho.sql.util.SQLUtils;
import org.junit.Assert;
import org.junit.Test;

/**
 * @author kongtong.ouyang onCondition 2018/3/22.
 */
public class OracleSelectTest_15_Subqueries {

    @Test
    public void test1() {
        String sql = "SELECT last_name, department_id FROM employees\n" +
                "   WHERE department_id =\n" +
                "     (SELECT department_id FROM employees\n" +
                "      WHERE last_name = 'Lorentz')\n" +
                "   ORDER BY last_name, department_id; ";
        String format = SQLUtils.format(sql, DBType.Oracle);
        System.out.println(sql);
        System.out.println("----------------------");
        System.out.println(format);
        Assert.assertEquals("SELECT last_name, department_id\n" +
                "FROM employees\n" +
                "WHERE department_id = (\n" +
                "\t\tSELECT department_id\n" +
                "\t\tFROM employees\n" +
                "\t\tWHERE last_name = 'Lorentz'\n" +
                "\t)\n" +
                "ORDER BY last_name, department_id;", format);
    }

    @Test
    public void test2() {
        String sql = "SELECT Pur.Id, Pur.Mds_Item_Id, Pur.Status, Pur.Gross_Qty, Pur.Req_Date\n" +
                "\t, Pur.Mrp_Pickup_List_Id, Pur.Purnet_Qty, Pur.Mo_Mds_Item_Id, Pur.Pro_Mds_Item_Id, Pur.Parent_Mds_Item_Id\n" +
                "\t, Pur.Manufacture_Lotno, Pur.Main_Hr_Dept_Id, Pur.Org_Mds_Item_Id, Pur.Project_Code, Pur.Current_Onhand_Qty\n" +
                "\t, Pur.New_porqty, Pur.Add_porqty, Pur.Mo_Plan_Type, Pur.Balance_Flag\n" +
                "FROM (\n" +
                "\tSELECT Pur.Id, Pur.Mds_Item_Id, Pur.Status, Pur.Gross_Qty, Pur.Req_Date\n" +
                "\t\t, Pur.Mrp_Pickup_List_Id, Pur.Purnet_Qty, Pur.Mo_Mds_Item_Id, Pur.Pro_Mds_Item_Id, Pur.Parent_Mds_Item_Id\n" +
                "\t\t, Pur.Manufacture_Lotno, Pur.Main_Hr_Dept_Id, Pur.Org_Mds_Item_Id, Pur.Project_Code, Pur.Current_Onhand_Qty\n" +
                "\t\t, New_porqty + '0' AS New_porqty\n" +
                "\t\t, CASE \n" +
                "\t\t\tWHEN New_porqty - Gross_Qty > 0 THEN New_porqty - Gross_Qty\n" +
                "\t\t\tELSE 0\n" +
                "\t\tEND AS Add_porqty, Mo_Plan_Type, Balance_Flag\n" +
                "\tFROM (\n" +
                "\t\tSELECT Pur.Id, Pur.Mds_Item_Id, Pur.Status, Pur.Gross_Qty, Pur.Req_Date\n" +
                "\t\t\t, Pur.Mrp_Pickup_List_Id, Pur.Purnet_Qty, Pur.Mo_Mds_Item_Id, Pur.Pro_Mds_Item_Id, Pur.Parent_Mds_Item_Id\n" +
                "\t\t\t, Pur.Manufacture_Lotno, Pur.Main_Hr_Dept_Id, Pur.Org_Mds_Item_Id, Pur.Project_Code, Pur.Current_Onhand_Qty\n" +
                "\t\t\t, CASE \n" +
                "\t\t\t\tWHEN First_Value(Current_Surplus_Qty) OVER (PARTITION BY Mds_Item_Id, Project_Code ORDER BY Mo_Plan_Type DESC, Mds_Item_Id, Project_Code, Balance_Flag, Status DESC, Req_Date, Manufacture_Lotno, Id ROWS 1 PRECEDING) - Gross_Qty > 0 THEN 0\n" +
                "\t\t\t\tELSE Abs(First_Value(Current_Surplus_Qty) OVER (PARTITION BY Mds_Item_Id, Project_Code ORDER BY Mo_Plan_Type DESC, Mds_Item_Id, Project_Code, Balance_Flag, Status DESC, Req_Date, Manufacture_Lotno, Id ROWS 1 PRECEDING) - Gross_Qty)\n" +
                "\t\t\tEND AS New_porqty, Pur.Mo_Plan_Type, Pur.Balance_Flag\n" +
                "\t\tFROM Mrp_Net_Balance_For_Pur_Tp Pur\n" +
                "\t) Pur\n" +
                ") Pur ";
        String format = SQLUtils.format(sql, DBType.Oracle);
        System.out.println(sql);
        System.out.println("----------------------");
        System.out.println(format);
        Assert.assertEquals("SELECT Pur.Id, Pur.Mds_Item_Id, Pur.Status, Pur.Gross_Qty, Pur.Req_Date,\n" +
                "\tPur.Mrp_Pickup_List_Id, Pur.Purnet_Qty, Pur.Mo_Mds_Item_Id,\n" +
                "\tPur.Pro_Mds_Item_Id, Pur.Parent_Mds_Item_Id,\n" +
                "\tPur.Manufacture_Lotno, Pur.Main_Hr_Dept_Id, Pur.Org_Mds_Item_Id,\n" +
                "\tPur.Project_Code, Pur.Current_Onhand_Qty, Pur.New_porqty,\n" +
                "\tPur.Add_porqty, Pur.Mo_Plan_Type, Pur.Balance_Flag\n" +
                "FROM (\n" +
                "\tSELECT Pur.Id, Pur.Mds_Item_Id, Pur.Status, Pur.Gross_Qty, Pur.Req_Date,\n" +
                "\t\tPur.Mrp_Pickup_List_Id, Pur.Purnet_Qty, Pur.Mo_Mds_Item_Id,\n" +
                "\t\tPur.Pro_Mds_Item_Id, Pur.Parent_Mds_Item_Id,\n" +
                "\t\tPur.Manufacture_Lotno, Pur.Main_Hr_Dept_Id, Pur.Org_Mds_Item_Id,\n" +
                "\t\tPur.Project_Code, Pur.Current_Onhand_Qty,\n" +
                "\t\tNew_porqty + '0' AS New_porqty,\n" +
                "\t\tCASE\n" +
                "\t\t\tWHEN New_porqty - Gross_Qty > 0 THEN New_porqty - Gross_Qty\n" +
                "\t\t\tELSE 0\n" +
                "\t\tEND AS Add_porqty,\n" +
                "\t\tMo_Plan_Type, Balance_Flag\n" +
                "\tFROM (\n" +
                "\t\tSELECT Pur.Id, Pur.Mds_Item_Id, Pur.Status, Pur.Gross_Qty, Pur.Req_Date,\n" +
                "\t\t\tPur.Mrp_Pickup_List_Id, Pur.Purnet_Qty, Pur.Mo_Mds_Item_Id,\n" +
                "\t\t\tPur.Pro_Mds_Item_Id, Pur.Parent_Mds_Item_Id,\n" +
                "\t\t\tPur.Manufacture_Lotno, Pur.Main_Hr_Dept_Id, Pur.Org_Mds_Item_Id,\n" +
                "\t\t\tPur.Project_Code, Pur.Current_Onhand_Qty,\n" +
                "\t\t\tCASE\n" +
                "\t\t\t\tWHEN First_Value(Current_Surplus_Qty) OVER (PARTITION BY Mds_Item_Id, Project_Code ORDER BY Mo_Plan_Type DESC, Mds_Item_Id, Project_Code, Balance_Flag, Status DESC, Req_Date, Manufacture_Lotno, Id ROWS 1 PRECEDING) - Gross_Qty > 0 THEN 0\n" +
                "\t\t\t\tELSE Abs(First_Value(Current_Surplus_Qty) OVER (PARTITION BY Mds_Item_Id, Project_Code ORDER BY Mo_Plan_Type DESC, Mds_Item_Id, Project_Code, Balance_Flag, Status DESC, Req_Date, Manufacture_Lotno, Id ROWS 1 PRECEDING) - Gross_Qty)\n" +
                "\t\t\tEND AS New_porqty,\n" +
                "\t\t\tPur.Mo_Plan_Type, Pur.Balance_Flag\n" +
                "\t\tFROM Mrp_Net_Balance_For_Pur_Tp Pur\n" +
                "\t) Pur\n" +
                ") Pur", format);
    }
}
