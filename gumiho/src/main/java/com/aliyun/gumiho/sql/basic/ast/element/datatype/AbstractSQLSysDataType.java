package com.aliyun.gumiho.sql.basic.ast.element.datatype;

import com.aliyun.gumiho.sql.basic.ast.element.identifier.SQLName;

/**
 * SYS.XXX
 * 系统数据类型
 * https://docs.oracle.com/en/database/oracle/oracle-database/18/sqlrf/Data-Types.html#GUID-A3C0D836-BADB-44E5-A5D4-265BA5968483
 *
 * @author kongtong.ouyang on 2018/10/16.
 */
public abstract class AbstractSQLSysDataType extends AbstractSQLDataType implements SQLSysDataType {

    protected boolean sysOwner;

    public AbstractSQLSysDataType() {
    }

    public AbstractSQLSysDataType(String name) {
        setName(name);
    }

    public AbstractSQLSysDataType(SQLName name) {
        setName(name);
    }

    public AbstractSQLSysDataType(boolean sysOwner, String name) {
        super(name);
        this.sysOwner = sysOwner;
    }

    public AbstractSQLSysDataType(boolean sysOwner, SQLName name) {
        super(name);
        this.sysOwner = sysOwner;
    }

    @Override
    public AbstractSQLSysDataType clone() {
        throw new UnsupportedOperationException(getClass().getName());
    }

    public void cloneTo(AbstractSQLSysDataType x) {
        super.cloneTo(x);
        x.sysOwner = this.sysOwner;
    }


    public boolean isSysOwner() {
        return sysOwner;
    }

    public void setSysOwner(boolean sysOwner) {
        this.sysOwner = sysOwner;
    }
}
