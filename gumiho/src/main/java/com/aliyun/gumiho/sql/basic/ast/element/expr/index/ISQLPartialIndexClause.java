package com.aliyun.gumiho.sql.basic.ast.element.expr.index;

import com.aliyun.gumiho.sql.basic.ast.element.expr.index.attribute.ISQLIndexAttribute;
import com.aliyun.gumiho.sql.basic.ast.element.expr.SQLExpr;

/**
 * INDEXING { PARTIAL | FULL }
 * <p>
 * partial_index_clause
 * https://docs.oracle.com/en/database/oracle/oracle-database/18/sqlrf/CREATE-INDEX.html#GUID-1F89BBC0-825F-4215-AF71-7588E31D8BFE
 *
 * @author kongtong.ouyang on 2018/7/9.
 */
public interface ISQLPartialIndexClause extends SQLExpr, ISQLIndexAttribute {
    @Override
    ISQLPartialIndexClause clone();
}
