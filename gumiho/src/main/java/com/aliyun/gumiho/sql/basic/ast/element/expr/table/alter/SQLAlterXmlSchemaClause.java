package com.aliyun.gumiho.sql.basic.ast.element.expr.table.alter;

import com.aliyun.gumiho.sql.basic.ast.element.expr.AbstractSQLExpr;
import com.aliyun.gumiho.sql.basic.ast.element.expr.SQLExpr;
import com.aliyun.gumiho.sql.basic.visitor.SQLASTVisitor;

/**
 * ALLOW ANYSCHEMA
 * | ALLOW NONSCHEMA
 * | DISALLOW NONSCHEMA
 * <p>
 * alter_XMLSchema_clause
 * <p>
 * https://docs.oracle.com/en/database/oracle/oracle-database/18/sqlrf/ALTER-TABLE.html#GUID-552E7373-BF93-477D-9DA3-B2C9386F2877
 *
 * @author kongtong.ouyang on 2018/7/18.
 */
public interface SQLAlterXmlSchemaClause extends SQLExpr {

    @Override
    SQLAlterXmlSchemaClause clone();

    /**
     * ALLOW ANYSCHEMA
     */
    class SQLAlterXmlSchemaAllowAnySchemaClause extends AbstractSQLExpr implements SQLAlterXmlSchemaClause {

        @Override
        protected void accept0(SQLASTVisitor visitor) {
            visitor.visit(this);
        }

        @Override
        public SQLAlterXmlSchemaAllowAnySchemaClause clone() {
            return new SQLAlterXmlSchemaAllowAnySchemaClause();
        }
    }

    /**
     * ALLOW NONSCHEMA
     */
    class SQLAlterXmlSchemaAllowNonSchemaClause extends AbstractSQLExpr implements SQLAlterXmlSchemaClause {

        @Override
        protected void accept0(SQLASTVisitor visitor) {
            visitor.visit(this);
        }

        @Override
        public SQLAlterXmlSchemaAllowNonSchemaClause clone() {
            return new SQLAlterXmlSchemaAllowNonSchemaClause();
        }
    }

    /**
     * DISALLOW NONSCHEMA
     */
    class SQLAlterXmlSchemaDisallowNonSchemaClause extends AbstractSQLExpr implements SQLAlterXmlSchemaClause {

        @Override
        protected void accept0(SQLASTVisitor visitor) {
            visitor.visit(this);
        }

        @Override
        public SQLAlterXmlSchemaDisallowNonSchemaClause clone() {
            return new SQLAlterXmlSchemaDisallowNonSchemaClause();
        }
    }
}
