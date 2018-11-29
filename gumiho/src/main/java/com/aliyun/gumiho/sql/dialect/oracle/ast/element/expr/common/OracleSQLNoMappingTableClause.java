package com.aliyun.gumiho.sql.dialect.oracle.ast.element.expr.common;

import com.aliyun.gumiho.sql.dialect.oracle.ast.element.expr.AbstractOracleSQLExpr;
import com.aliyun.gumiho.sql.dialect.oracle.visitor.OracleSQLASTVisitor;

/**
 * { MAPPING TABLE | NOMAPPING }
 * <p>
 * mapping_table_clauses
 * https://docs.oracle.com/en/database/oracle/oracle-database/18/sqlrf/CREATE-TABLE.html#GUID-F9CE0CC3-13AE-4744-A43C-EAC7A71AAAB6
 *
 * @author kongtong.ouyang on 2018/6/27.
 */
public class OracleSQLNoMappingTableClause extends AbstractOracleSQLExpr implements IOracleSQLMappingTableClause {
    @Override
    public void accept0(OracleSQLASTVisitor visitor) {
        visitor.visit(this);
    }

    @Override
    public OracleSQLNoMappingTableClause clone() {
        OracleSQLNoMappingTableClause x = new OracleSQLNoMappingTableClause();
        this.cloneTo(x);
        return x;
    }
}
