package com.aliyun.gumiho.sql.dependenv.translate.oracle2.ppas;

import com.aliyun.gumiho.sql.dependenv.basic.SQLTest_By_DB;
import com.aliyun.gumiho.sql.enums.DBVersion;
import com.aliyun.gumiho.sql.translate.SQLTransformConfig;
import com.aliyun.gumiho.sql.util.SQLTransformUtils;
import org.junit.Test;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * @author kongtong.ouyang on 2018/10/29.
 */
public class Oracle2PPASTest_By_DB extends SQLTest_By_DB {

    @Test
    public void test_0() throws Exception {
        long dbid = 1801196429L;
        test_by_dbid(dbid);
    }

    public void test_by_dbid(long dbid) throws SQLException {
        List<SQL> sqls = new ArrayList<>();
        loadPPASDDL(dbid, sql -> {
            sqls.add(sql);
        });

        SQLTransformConfig config = new SQLTransformConfig();
        config.targetVersion = DBVersion.PPAS_VERSION_9_6;
        for (SQL sql : sqls) {
            SQLTransformUtils.oracleToPPAS(sql.sourceSQL);
        }
    }

}
