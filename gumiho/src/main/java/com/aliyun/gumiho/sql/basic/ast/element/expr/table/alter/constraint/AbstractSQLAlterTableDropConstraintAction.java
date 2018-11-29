package com.aliyun.gumiho.sql.basic.ast.element.expr.table.alter.constraint;

import com.aliyun.gumiho.sql.basic.ast.element.expr.AbstractSQLExpr;
import com.aliyun.gumiho.sql.basic.ast.enums.SQLCascadeType;
import com.aliyun.gumiho.sql.basic.ast.enums.SQLKeepIndexType;

/**
 * DROP { { PRIMARY KEY | UNIQUE (column [, column ]...) } [ CASCADE ] [ { KEEP | DROP } INDEX ] | CONSTRAINT constraint_name [ CASCADE ] } [ ONLINE ]
 * https://docs.oracle.com/en/database/oracle/oracle-database/18/sqlrf/ALTER-TABLE.html#GUID-552E7373-BF93-477D-9DA3-B2C9386F2877
 *
 * @author kongtong.ouyang on 2018/7/11.
 */
public abstract class AbstractSQLAlterTableDropConstraintAction extends AbstractSQLExpr implements ISQLAlterTableDropTableConstraintAction {

    protected SQLKeepIndexType index;
    protected SQLCascadeType cascade;
    protected boolean online;

    @Override
    public AbstractSQLAlterTableDropConstraintAction clone() {
        throw new UnsupportedOperationException(getClass().getName());
    }


    public void cloneTo(AbstractSQLAlterTableDropConstraintAction x) {
        super.cloneTo(x);
        x.index = this.index;
        x.cascade = this.cascade;
        x.online = this.online;
    }

    public SQLKeepIndexType getIndex() {
        return index;
    }

    public void setIndex(SQLKeepIndexType index) {
        this.index = index;
    }

    public SQLCascadeType getCascade() {
        return cascade;
    }

    public void setCascade(SQLCascadeType cascade) {
        this.cascade = cascade;
    }

    public boolean isOnline() {
        return online;
    }

    public void setOnline(boolean online) {
        this.online = online;
    }

}
