package com.aliyun.gumiho.sql.dialect.oracle.ast.element.expr.common;

import com.aliyun.gumiho.sql.basic.ast.enums.SQLReserved;
import com.aliyun.gumiho.sql.dialect.oracle.ast.element.expr.AbstractOracleSQLExpr;
import com.aliyun.gumiho.sql.dialect.oracle.visitor.OracleSQLASTVisitor;

/**
 * COMPRESSION [ FOR { ALL | DIRECT_LOAD } OPERATIONS ]
 * <p>
 * table_compression
 * https://docs.oracle.com/cd/B28359_01/server.111/b28286/statements_6002.htm#SQLRF01302
 * https://docs.oracle.com/en/database/oracle/oracle-database/18/sqlrf/CREATE-MATERIALIZED-VIEW.html#GUID-EE262CA4-01E5-4618-B659-6165D993CA1B
 *
 * @author kongtong.ouyang on 2018/6/22.
 */
public class OracleSQLTableCompressionByCompress extends AbstractOracleSQLExpr implements IOracleSQLTableCompression {

    protected ForOperations forOperations;

    @Override
    public void accept0(OracleSQLASTVisitor visitor) {
        visitor.visit(this);
    }

    @Override
    public OracleSQLTableCompressionByCompress clone() {
        OracleSQLTableCompressionByCompress x = new OracleSQLTableCompressionByCompress();
        x.forOperations = this.forOperations;
        return x;
    }


    public ForOperations getForOperations() {
        return forOperations;
    }

    public void setForOperations(ForOperations forOperations) {
        this.forOperations = forOperations;
    }

    public enum ForOperations {
        ALL(SQLReserved.ALL),
        DIRECT_LOAD(SQLReserved.DIRECT_LOAD),;

        public final SQLReserved name;

        ForOperations(SQLReserved name) {
            this.name = name;
        }
    }
}
