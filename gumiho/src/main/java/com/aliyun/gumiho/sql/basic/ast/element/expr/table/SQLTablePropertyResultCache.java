package com.aliyun.gumiho.sql.basic.ast.element.expr.table;

import com.aliyun.gumiho.sql.basic.ast.element.expr.AbstractSQLExpr;
import com.aliyun.gumiho.sql.basic.ast.enums.ISQLEnum;
import com.aliyun.gumiho.sql.basic.ast.enums.SQLReserved;
import com.aliyun.gumiho.sql.basic.visitor.SQLASTVisitor;

/**
 * RESULT_CACHE ( MODE {DEFAULT | FORCE })
 * <p>
 * https://docs.oracle.com/en/database/oracle/oracle-database/18/sqlrf/CREATE-TABLE.html#GUID-F9CE0CC3-13AE-4744-A43C-EAC7A71AAAB6
 *
 * @author kongtong.ouyang on 2018/7/10.
 */
public class SQLTablePropertyResultCache extends AbstractSQLExpr {

    protected SQLModelType modelType;

    @Override
    protected void accept0(SQLASTVisitor visitor) {
        visitor.visit(this);
    }

    @Override
    public SQLTablePropertyResultCache clone() {
        SQLTablePropertyResultCache x = new SQLTablePropertyResultCache();
        x.modelType = this.modelType;
        return x;
    }

    public enum SQLModelType implements ISQLEnum {

        DEFAULT(SQLReserved.DEFAULT),
        FORCE(SQLReserved.FORCE),;

        public final SQLReserved name;

        SQLModelType(SQLReserved name) {
            this.name = name;
        }


        @Override
        public SQLReserved getName() {
            return name;
        }
    }
}
