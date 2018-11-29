package com.aliyun.gumiho.sql.basic.ast.element.datatype.any;

import com.aliyun.gumiho.sql.basic.ast.element.datatype.AbstractSQLSysDataType;
import com.aliyun.gumiho.sql.basic.ast.enums.SQLReserved;
import com.aliyun.gumiho.sql.basic.visitor.SQLASTVisitor;
import com.aliyun.gumiho.sql.dialect.oracle.visitor.OracleSQLASTVisitor;

/**
 * SYS.AnyData
 * "SYS"."AnyData"
 * <p>
 * https://docs.oracle.com/en/database/oracle/oracle-database/12.2/sqlrf/Data-Types.html#GUID-A3C0D836-BADB-44E5-A5D4-265BA5968483
 *
 * @author kongtong.ouyang on 2018/4/19.
 */
public class SQLAnyDataDataType extends AbstractSQLSysDataType {

    public SQLAnyDataDataType() {
        super(SQLReserved.AnyData.ofExpr());
    }

    public SQLAnyDataDataType(boolean sysOwner) {
        super(sysOwner, SQLReserved.AnyData.ofExpr());
    }

    @Override
    public void accept0(SQLASTVisitor visitor) {
        visitor.visit(this);
    }


}
