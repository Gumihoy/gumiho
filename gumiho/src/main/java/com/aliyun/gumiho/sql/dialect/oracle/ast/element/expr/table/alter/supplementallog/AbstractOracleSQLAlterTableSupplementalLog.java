package com.aliyun.gumiho.sql.dialect.oracle.ast.element.expr.table.alter.supplementallog;

import com.aliyun.gumiho.sql.basic.ast.SQLObject;
import com.aliyun.gumiho.sql.dialect.oracle.ast.element.expr.AbstractOracleSQLExpr;
import com.aliyun.gumiho.sql.dialect.oracle.ast.element.expr.table.element.IOracleSQLSupplementLog;

import java.util.ArrayList;
import java.util.List;

/**
 * ADD iSupplementalLog (COMMA iSupplementalLog)*
 * DROP iSupplementalLog (COMMA iSupplementalLog)*
 *
 * https://docs.oracle.com/en/database/oracle/oracle-database/18/sqlrf/ALTER-TABLE.html#GUID-552E7373-BF93-477D-9DA3-B2C9386F2877
 * supplemental_table_logging
 *
 * @author kongtong.ouyang on 2018/7/16.
 */
public abstract class AbstractOracleSQLAlterTableSupplementalLog extends AbstractOracleSQLExpr implements IOracleSQLAlterTableSupplementalLog {

    protected final List<IOracleSQLSupplementLog> items = new ArrayList<>();

    @Override
    public AbstractOracleSQLAlterTableSupplementalLog clone() {
        throw new UnsupportedOperationException(getClass().getName());
    }

    public void cloneTo(AbstractOracleSQLAlterTableSupplementalLog x) {
        super.cloneTo(x);
    }

    @Override
    public void cloneTo(SQLObject x) {
        super.cloneTo(x);
    }

    public List<IOracleSQLSupplementLog> getItems() {
        return items;
    }

    public void addItem(IOracleSQLSupplementLog item) {
        if (item == null) {
            return;
        }
        setChildParent(item);
        this.items.add(item);
    }
}
