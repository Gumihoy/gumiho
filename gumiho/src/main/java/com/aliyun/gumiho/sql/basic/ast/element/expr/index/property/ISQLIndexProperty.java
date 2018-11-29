package com.aliyun.gumiho.sql.basic.ast.element.expr.index.property;

import com.aliyun.gumiho.sql.basic.ast.element.expr.SQLExpr;

/**
 * [ { { global_partitioned_index
 * | local_partitioned_index
 * }
 * | index_attributes
 * }...
 * | INDEXTYPE IS { domain_index_clause
 * | XMLIndex_clause
 * }
 * ]
 * <p>
 * <p>
 * index_properties
 * https://docs.oracle.com/en/database/oracle/oracle-database/18/sqlrf/CREATE-INDEX.html#GUID-1F89BBC0-825F-4215-AF71-7588E31D8BFE
 *
 * @author kongtong.ouyang on 2018/7/9.
 */
public interface ISQLIndexProperty extends SQLExpr {
    @Override
    ISQLIndexProperty clone();
}
