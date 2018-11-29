package com.aliyun.gumiho.sql.bvt.translate.oracle2.mysql.version5_6;

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
public class Oracle2MySQLTest_Version5_6 {


    @Test
    public void test() {
        String sql = "CREATE OR REPLACE VIEW \"EFMIS_33\".\"BGT_V_DATA\" (\"AGENCYNAME\", \"SPFNAME\", \"AGENCYCODE\", \"SPFID\", \"AGENCYID\", \"SPFCODE\", \"PROJCODE\", \"FINYEAR\", \"BUDGETNUM\", \"PROJTYPEID\", \"DATAID\", \"SUPERID\", \"LEVELNO\", \"PROJTYPECODE\", \"ISSPF\", \"ORDERID\", \"NEEDUPDATE\", \"DATAKEY\", \"DATAFLAG\", \"DBVERSION\") AS \n" +
                "  SELECT CAST('' AS VARCHAR2(200)) AGENCYNAME,\n" +
                "       CAST('' AS VARCHAR2(200)) SPFNAME,\n" +
                "       CAST('' AS VARCHAR2(200)) AGENCYCODE,\n" +
                "       CAST(SYS_GUID() AS VARCHAR2(32)) SPFID,\n" +
                "       CAST(SYS_GUID() AS VARCHAR2(32)) AGENCYID,\n" +
                "       CAST('' AS VARCHAR2(200)) SPFCODE,\n" +
                "       CAST('' AS VARCHAR2(200)) PROJCODE,\n" +
                "       CAST(TO_CHAR(SYSDATE, 'YYYY') AS VARCHAR2(4)) FINYEAR,\n" +
                "       CAST('' AS NUMBER(24, 6)) BUDGETNUM,\n" +
                "       CAST(SYS_GUID() AS VARCHAR2(32)) PROJTYPEID,\n" +
                "       CAST(SYS_GUID() AS VARCHAR2(32)) DATAID,\n" +
                "       CAST(SYS_GUID() AS VARCHAR2(32)) SUPERID,\n" +
                "       CAST(0 AS NUMBER(28)) LEVELNO,\n" +
                "       CAST('' AS VARCHAR2(32)) PROJTYPECODE,\n" +
                "       CAST('0' AS CHAR(1)) ISSPF,\n" +
                "       CAST('' AS VARCHAR2(32)) ORDERID,\n" +
                "       CAST('' AS VARCHAR2(4000)) NEEDUPDATE,\n" +
                "       CAST(SYS_GUID() AS VARCHAR2(32)) DATAKEY,\n" +
                "       CAST('0' AS CHAR(1)) DATAFLAG,\n" +
                "       CAST(to_date('2012-01-01', 'yyyy-MM-dd') AS TIMESTAMP(6)) DBVERSION\n" +
                "  FROM DUAL";
        String format = OracleUtils.format(sql);
        SQLTransformResult result = SQLTransformUtils.oracleToMySQL(sql);
        System.out.println(format);
        System.out.println("--------------------------");
        System.out.println(result.targetSql);
        Assert.assertEquals("select t1.id task_flow_id,\n" +
                "       func_get_task_item_name(t2.type, t2.temp_id) temp_name,\n" +
                "       t1.task_owner,\n" +
                "       case\n" +
                "         when t2.type = 1 or t2.type = 4 then\n" +
                "          '报表'\n" +
                "         when t2.type = 2 then\n" +
                "          '问卷'\n" +
                "       end type,\n" +
                "        '期别:' || func_get_period(t.period) comments ,\n" +
                "       'taskflow-process.action?iseditable=1&taskFlow.id=' || t1.id ||\n" +
                "       '&type=' || t2.type || '&temp_id=' || t2.temp_id url\n" +
                "  from e_oa_task t, e_oa_task_flow t1, e_oa_task_item t2\n" +
                " where t.id = t1.task_id\n" +
                "   and (t.father_id = t2.TASK_ID or t.id = t2.task_id)\n" +
                "   and t1.isdel != 1\n" +
                "   and t1.owner_type = 4\n" +
                "   and sysdate > t.start_date;", result.targetSql);

    }


}
