package com.aliyun.gumiho.sql.bvt.translate.oracle2.mysql.version5_6.ddl.view.create;

import com.aliyun.gumiho.sql.translate.result.SQLTransformResult;
import com.aliyun.gumiho.sql.util.OracleUtils;
import com.aliyun.gumiho.sql.util.SQLTransformUtils;
import org.junit.Assert;
import org.junit.Test;

/**
 * https://docs.oracle.com/en/database/oracle/oracle-database/18/sqlrf/CASE-Expressions.html#GUID-CA29B333-572B-4E1D-BA64-851FABDBAE96
 *
 * @author kongtong.ouyang on 2018/5/15.
 */
public class Oracle2MySQLCreateViewTest_SubQuery {


    @Test
    public void test_0() {
        String sql = "CREATE OR REPLACE VIEW \"OMS2B\".\"VIEW_ORDER_TASK_STATUS\" (\"CUST_ORD_NO\", \"STATUS\", \"SO_NO\", \"IMPORT_DATE\", \"SO_DATE\", \"ALLOCATE_DATE\", \"SHIP_DATE\", \"DEPART_DATE\", \"ARRIVE_DATE\", \"SIGN_DATE\", \"AREA_NAME\", \"DRIVER_NAME\", \"MOBILE\", \"CAR_NO\", \"CUST_CUSTOMER_CODE\", \"ORDER_TYPE\") AS \n" +
                "  SELECT EOWO.EOWO_LOGISTIC_NO              AS CUST_ORD_NO, --客户订单号\n" +
                "       EOWA.EOWA_STATUS_NAME              AS STATUS, --任务状态\n" +
                "       EOWO.EOWO_ORDER_NO                 AS SO_NO, --系统订单号(物流订单号)\n" +
                "       EOOR.CREATE_TIME                   AS IMPORT_DATE, --订单创建时间\n" +
                "       EOOR.EOOR_ORDER_TIME               AS SO_DATE, --客户下单时间\n" +
                "       ''                                  AS ALLOCATE_DATE, --分库时间\n" +
                "       EOWA_TIME.EOWA_ACTUAL_TIME           AS SHIP_DATE, --实际发货时间\n" +
                "       EOWO.EOWO_DEPARTURE_DATE           AS DEPART_DATE, --发车时间\n" +
                "       EOWO.EOWO_REAL_ARRIVAL_DATE        AS ARRIVE_DATE, --到达时间\n" +
                "       EOWO.EOWO_SIGN_DATE                AS SIGN_DATE, --签收时间\n" +
                "       EOWO.EOWO_CONSIGNEE_LOCATION_ADDRE AS AREA_NAME, --收货详细地址\n" +
                "       EOWO.EOWO_DRIVER_NAME              AS DRIVER_NAME, --司机名称\n" +
                "       EOWO.EOWO_DRIVER_PHONE             AS MOBILE, --司机联系电话\n" +
                "       EOWO.EOWO_CAR_NO                   AS CAR_NO, --车牌号\n" +
                "       MICC.CUST_CUSTOMER_CODE            AS CUST_CUSTOMER_CODE,--客户的对照客户代码\n" +
                "       EOWO.EOWO_CUSTOMER_ORDER_TYPE_NAME AS ORDER_TYPE --客户订单类型名称\n" +
                "  FROM EO_WORK_ORDER EOWO\n" +
                "  LEFT JOIN (select *\n" +
                "               from (select item.*,\n" +
                "                            Row_Number() over(partition by item.EOWA_WORK_NO order by item.CREATE_TIME desc) as px1\n" +
                "                       from EO_WORK_STATUS ITEM)\n" +
                "              where px1 = 1) EOWA\n" +
                "  ON EOWA.EOWA_WORK_NO = EOWO.EOWO_WORK_ORDER_NO\n" +
                "  LEFT JOIN (select *\n" +
                "             from (select ITEM_TIME.*,\n" +
                "                          Row_Number() over(partition by ITEM_TIME.EOWA_WORK_NO order by ITEM_TIME.EOWA_ACTUAL_TIME desc) as px\n" +
                "                     from EO_WORK_STATUS ITEM_TIME WHERE ITEM_TIME.EOWA_STATUS_NAME = '已装货')\n" +
                "            where px = 1) EOWA_TIME\n" +
                "  ON EOWA_TIME.EOWA_WORK_NO = EOWO.EOWO_WORK_ORDER_NO\n" +
                "  LEFT JOIN EO_ORDER EOOR\n" +
                "    ON EOOR.EOOR_ORDER_NO = EOWO.EOWO_ORDER_NO\n" +
                "  LEFT JOIN MID_CUSTOMER_CONTROL MICC\n" +
                "    ON MICC.ANN_CUSTOMER_CODE = EOWO.EOWO_CUSTOMER_CODE AND MICC.PLANT_ID='CCS' AND MICC.STATUS='0'\n" +
                " WHERE EOWO.REC_STATUS = 0\n" +
                "   AND EOWO.EOWO_UPPER_TASK_NO != '-1'\n" +
                "   AND EOWO.EOWO_UPSTREAM_SYS = 'CCS'\n" +
                "   AND EOWO.EOWO_STATUS_NAME != '冲销'\n" +
                "   AND EOWO.EOWO_PACKAGE_QUANTITY > 0\n" +
                " ORDER BY EOWA.CREATE_TIME";
        String format = OracleUtils.format(sql);
        SQLTransformResult result = SQLTransformUtils.oracleToMySQL(sql);
        System.out.println(format);
        System.out.println("--------------------------");
        System.out.println(result.targetSql);
        Assert.assertEquals("CREATE OR REPLACE VIEW `OMS2B`.`VIEW_ORDER_TASK_STATUS_4`\n" +
                "AS\n" +
                "\tSELECT `ITEM_TIME`.*,\n" +
                "\t\tRow_Number() OVER (PARTITION BY `ITEM_TIME`.`EOWA_WORK_NO` ORDER BY `ITEM_TIME`.`EOWA_ACTUAL_TIME` DESC) AS `px`\n" +
                "\tFROM `EO_WORK_STATUS` `ITEM_TIME`\n" +
                "\tWHERE `ITEM_TIME`.`EOWA_STATUS_NAME` = '已装货';\n" +
                "CREATE OR REPLACE VIEW `OMS2B`.`VIEW_ORDER_TASK_STATUS_3`\n" +
                "AS\n" +
                "\tSELECT *\n" +
                "\tFROM `OMS2B`.`VIEW_ORDER_TASK_STATUS_4`\n" +
                "\tWHERE `px` = 1;\n" +
                "CREATE OR REPLACE VIEW `OMS2B`.`VIEW_ORDER_TASK_STATUS_2`\n" +
                "AS\n" +
                "\tSELECT `item`.*,\n" +
                "\t\tRow_Number() OVER (PARTITION BY `item`.`EOWA_WORK_NO` ORDER BY `item`.`CREATE_TIME` DESC) AS `px1`\n" +
                "\tFROM `EO_WORK_STATUS` `ITEM`;\n" +
                "CREATE OR REPLACE VIEW `OMS2B`.`VIEW_ORDER_TASK_STATUS_1`\n" +
                "AS\n" +
                "\tSELECT *\n" +
                "\tFROM `OMS2B`.`VIEW_ORDER_TASK_STATUS_2`\n" +
                "\tWHERE `px1` = 1;\n" +
                "CREATE OR REPLACE VIEW `OMS2B`.`VIEW_ORDER_TASK_STATUS` (\n" +
                "\t`CUST_ORD_NO`,\n" +
                "\t`STATUS`,\n" +
                "\t`SO_NO`,\n" +
                "\t`IMPORT_DATE`,\n" +
                "\t`SO_DATE`,\n" +
                "\t`ALLOCATE_DATE`,\n" +
                "\t`SHIP_DATE`,\n" +
                "\t`DEPART_DATE`,\n" +
                "\t`ARRIVE_DATE`,\n" +
                "\t`SIGN_DATE`,\n" +
                "\t`AREA_NAME`,\n" +
                "\t`DRIVER_NAME`,\n" +
                "\t`MOBILE`,\n" +
                "\t`CAR_NO`,\n" +
                "\t`CUST_CUSTOMER_CODE`,\n" +
                "\t`ORDER_TYPE`\n" +
                ")\n" +
                "AS\n" +
                "\tSELECT `EOWO`.`EOWO_LOGISTIC_NO` AS `CUST_ORD_NO`,\n" +
                "\t\t`EOWA`.`EOWA_STATUS_NAME` AS `STATUS`,\n" +
                "\t\t`EOWO`.`EOWO_ORDER_NO` AS `SO_NO`,\n" +
                "\t\t`EOOR`.`CREATE_TIME` AS `IMPORT_DATE`,\n" +
                "\t\t`EOOR`.`EOOR_ORDER_TIME` AS `SO_DATE`, '' AS `ALLOCATE_DATE`,\n" +
                "\t\t`EOWA_TIME`.`EOWA_ACTUAL_TIME` AS `SHIP_DATE`,\n" +
                "\t\t`EOWO`.`EOWO_DEPARTURE_DATE` AS `DEPART_DATE`,\n" +
                "\t\t`EOWO`.`EOWO_REAL_ARRIVAL_DATE` AS `ARRIVE_DATE`,\n" +
                "\t\t`EOWO`.`EOWO_SIGN_DATE` AS `SIGN_DATE`,\n" +
                "\t\t`EOWO`.`EOWO_CONSIGNEE_LOCATION_ADDRE` AS `AREA_NAME`,\n" +
                "\t\t`EOWO`.`EOWO_DRIVER_NAME` AS `DRIVER_NAME`,\n" +
                "\t\t`EOWO`.`EOWO_DRIVER_PHONE` AS `MOBILE`,\n" +
                "\t\t`EOWO`.`EOWO_CAR_NO` AS `CAR_NO`,\n" +
                "\t\t`MICC`.`CUST_CUSTOMER_CODE` AS `CUST_CUSTOMER_CODE`,\n" +
                "\t\t`EOWO`.`EOWO_CUSTOMER_ORDER_TYPE_NAME` AS `ORDER_TYPE`\n" +
                "\tFROM `EO_WORK_ORDER` `EOWO`\n" +
                "\t\tLEFT JOIN `OMS2B`.`VIEW_ORDER_TASK_STATUS_1` `EOWA` ON `EOWA`.`EOWA_WORK_NO` = `EOWO`.`EOWO_WORK_ORDER_NO`\n" +
                "\t\tLEFT JOIN `OMS2B`.`VIEW_ORDER_TASK_STATUS_3` `EOWA_TIME` ON `EOWA_TIME`.`EOWA_WORK_NO` = `EOWO`.`EOWO_WORK_ORDER_NO`\n" +
                "\t\tLEFT JOIN `EO_ORDER` `EOOR` ON `EOOR`.`EOOR_ORDER_NO` = `EOWO`.`EOWO_ORDER_NO`\n" +
                "\t\tLEFT JOIN `MID_CUSTOMER_CONTROL` `MICC` ON `MICC`.`ANN_CUSTOMER_CODE` = `EOWO`.`EOWO_CUSTOMER_CODE` AND `MICC`.`PLANT_ID` = 'CCS' AND `MICC`.`STATUS` = '0'\n" +
                "\tWHERE `EOWO`.`REC_STATUS` = 0 AND `EOWO`.`EOWO_UPPER_TASK_NO` != '-1'\n" +
                "\t\tAND `EOWO`.`EOWO_UPSTREAM_SYS` = 'CCS'\n" +
                "\t\tAND `EOWO`.`EOWO_STATUS_NAME` != '冲销'\n" +
                "\t\tAND `EOWO`.`EOWO_PACKAGE_QUANTITY` > 0\n" +
                "\tORDER BY `EOWA`.`CREATE_TIME`", result.targetSql);

    }

}
