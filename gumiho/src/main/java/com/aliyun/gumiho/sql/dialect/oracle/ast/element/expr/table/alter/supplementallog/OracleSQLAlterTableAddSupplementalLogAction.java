package com.aliyun.gumiho.sql.dialect.oracle.ast.element.expr.table.alter.supplementallog;

import com.aliyun.gumiho.sql.dialect.oracle.visitor.OracleSQLASTVisitor;

/**
 * ADD iSupplementalLog (COMMA iSupplementalLog)*
 * <p>
 * https://docs.oracle.com/en/database/oracle/oracle-database/18/sqlrf/ALTER-TABLE.html#GUID-552E7373-BF93-477D-9DA3-B2C9386F2877
 * supplemental_table_logging
 *
 * @author kongtong.ouyang on 2018/7/16.
 */
public class OracleSQLAlterTableAddSupplementalLogAction extends AbstractOracleSQLAlterTableSupplementalLog {

    @Override
    public void accept0(OracleSQLASTVisitor visitor) {
        if (visitor.visit(this)) {
            this.acceptChild(visitor, items);
        }
    }

}
