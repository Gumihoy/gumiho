package com.aliyun.gumiho.sql.dialect.oracle.ast.element.expr.common;

import com.aliyun.gumiho.sql.basic.ast.element.identifier.SQLName;
import com.aliyun.gumiho.sql.dialect.oracle.ast.element.expr.AbstractOracleSQLExpr;
import com.aliyun.gumiho.sql.dialect.oracle.ast.element.expr.OracleSQLExpr;
import com.aliyun.gumiho.sql.dialect.oracle.visitor.OracleSQLASTVisitor;

/**
 * { [ ELEMENT ] IS OF [ TYPE ] ( ONLY type ) | [ NOT ] SUBSTITUTABLE AT ALL LEVELS }
 * <p>
 * https://docs.oracle.com/en/database/oracle/oracle-database/18/sqlrf/CREATE-MATERIALIZED-VIEW.html#GUID-EE262CA4-01E5-4618-B659-6165D993CA1B
 *
 * @author kongtong.ouyang on 2018/6/22.
 */
public interface IOracleSQLSubstitutableColumnClause extends OracleSQLExpr {
    @Override
    IOracleSQLSubstitutableColumnClause clone();

    class OracleSQLSubstitutableColumnIsOFClause extends AbstractOracleSQLExpr implements IOracleSQLSubstitutableColumnClause {
        protected boolean element;
        protected boolean type;
        protected SQLName onlyType;

        @Override
        public void accept0(OracleSQLASTVisitor visitor) {
            if (visitor.visit(this)) {
                this.acceptChild(visitor, onlyType);
            }

        }

        @Override
        public OracleSQLSubstitutableColumnIsOFClause clone() {
            OracleSQLSubstitutableColumnIsOFClause x = new OracleSQLSubstitutableColumnIsOFClause();
            x.element = this.element;
            x.type = this.type;
            SQLName onlyTypeClone = this.onlyType.clone();
            x.setOnlyType(onlyTypeClone);
            return x;
        }

        public boolean isElement() {
            return element;
        }

        public void setElement(boolean element) {
            this.element = element;
        }

        public boolean isType() {
            return type;
        }

        public void setType(boolean type) {
            this.type = type;
        }

        public SQLName getOnlyType() {
            return onlyType;
        }

        public void setOnlyType(SQLName onlyType) {
            setChildParent(onlyType);
            this.onlyType = onlyType;
        }
    }

    /**
     * [ NOT ] SUBSTITUTABLE AT ALL LEVELS
     *
     * https://docs.oracle.com/en/database/oracle/oracle-database/18/sqlrf/CREATE-MATERIALIZED-VIEW.html#GUID-EE262CA4-01E5-4618-B659-6165D993CA1B
     */
    class OracleSQLSubstitutableColumnAtAllLevelsClause extends AbstractOracleSQLExpr implements IOracleSQLSubstitutableColumnClause {

        protected boolean not;

        @Override
        public void accept0(OracleSQLASTVisitor visitor) {
            visitor.visit(this);
        }

        @Override
        public OracleSQLSubstitutableColumnAtAllLevelsClause clone() {
            OracleSQLSubstitutableColumnAtAllLevelsClause x = new OracleSQLSubstitutableColumnAtAllLevelsClause();
            x.not = this.not;
            return x;
        }

        public boolean isNot() {
            return not;
        }

        public void setNot(boolean not) {
            this.not = not;
        }
    }
}
