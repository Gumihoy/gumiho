package com.aliyun.gumiho.sql.basic.ast.element.datatype.any;

import com.aliyun.gumiho.sql.basic.ast.element.datatype.AbstractSQLSysDataType;
import com.aliyun.gumiho.sql.basic.ast.enums.SQLReserved;
import com.aliyun.gumiho.sql.basic.visitor.SQLASTVisitor;

/**
 * SYS.AnyDataSet
 * <p>
 * https://docs.oracle.com/en/database/oracle/oracle-database/12.2/sqlrf/Data-Types.html#GUID-A3C0D836-BADB-44E5-A5D4-265BA5968483
 *
 * @author kongtong.ouyang on 2018/4/19.
 */
public class SQLAnyDataSetDataType extends AbstractSQLSysDataType {

    public SQLAnyDataSetDataType() {
        super(SQLReserved.AnyDataSet.ofExpr());
    }

    public SQLAnyDataSetDataType(boolean sysOwner) {
        super(sysOwner, SQLReserved.AnyDataSet.ofExpr());
    }

    @Override
    public void accept0(SQLASTVisitor visitor) {
        visitor.visit(this);
    }


}
