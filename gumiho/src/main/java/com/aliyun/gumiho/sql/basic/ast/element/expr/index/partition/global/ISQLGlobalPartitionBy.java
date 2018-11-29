package com.aliyun.gumiho.sql.basic.ast.element.expr.index.partition.global;

import com.aliyun.gumiho.sql.basic.ast.element.expr.index.property.ISQLIndexProperty;

/**
 * GLOBAL PARTITION By
 * <p>
 * https://docs.oracle.com/en/database/oracle/oracle-database/18/sqlrf/CREATE-INDEX.html#GUID-1F89BBC0-825F-4215-AF71-7588E31D8BFE
 *
 * @author kongtong.ouyang onCondition 2018/4/10.
 */
public interface ISQLGlobalPartitionBy extends ISQLIndexProperty {

    @Override
    ISQLGlobalPartitionBy clone();

}
