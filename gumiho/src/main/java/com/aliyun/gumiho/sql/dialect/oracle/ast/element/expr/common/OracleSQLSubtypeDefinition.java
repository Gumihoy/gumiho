package com.aliyun.gumiho.sql.dialect.oracle.ast.element.expr.common;

import com.aliyun.gumiho.sql.basic.ast.element.datatype.SQLDataType;
import com.aliyun.gumiho.sql.basic.ast.element.expr.SQLExpr;
import com.aliyun.gumiho.sql.basic.ast.element.identifier.SQLName;
import com.aliyun.gumiho.sql.basic.ast.element.literal.numeric.SQLIntegerLiteral;
import com.aliyun.gumiho.sql.dialect.oracle.ast.element.expr.AbstractOracleSQLExpr;
import com.aliyun.gumiho.sql.dialect.oracle.ast.element.expr.OracleSQLExpr;
import com.aliyun.gumiho.sql.dialect.oracle.visitor.OracleSQLASTVisitor;

/**
 * subtype_definition
 * <p>
 * SUBTYPE subtype IS base_type [ constraint | CHARACTER SET character_set ] [ NOT NULL ]
 * https://docs.oracle.com/en/database/oracle/oracle-database/18/lnpls/block.html#GUID-9ACEB9ED-567E-4E1A-A16A-B8B35214FC9D__CHDCIGAD
 *
 * @author kongtong.ouyang on 2018/4/25.
 */
public class OracleSQLSubtypeDefinition extends AbstractOracleSQLExpr implements OracleSQLTypeDefinition {

    protected SQLName name;

    protected SQLDataType dataType;

    protected SQLExpr constraint;

    protected boolean notNull;

    @Override
    public void accept0(OracleSQLASTVisitor visitor) {
        if (visitor.visit(this)) {
            this.acceptChild(visitor, name);
            this.acceptChild(visitor, dataType);
            this.acceptChild(visitor, constraint);

        }
    }


    public SQLName getName() {
        return name;
    }

    public void setName(SQLName name) {
        this.name = name;
    }

    public SQLDataType getDataType() {
        return dataType;
    }

    public void setDataType(SQLDataType dataType) {
        this.dataType = dataType;
    }

    public SQLExpr getConstraint() {
        return constraint;
    }

    public void setConstraint(SQLExpr constraint) {
        setChildParent(constraint);
        this.constraint = constraint;
    }

    public boolean isNotNull() {
        return notNull;
    }

    public void setNotNull(boolean notNull) {
        this.notNull = notNull;
    }


    /**
     * https://docs.oracle.com/en/database/oracle/oracle-database/18/lnpls/block.html#GUID-9ACEB9ED-567E-4E1A-A16A-B8B35214FC9D
     */
    public interface IOracleSQLSubtypeConstraint extends OracleSQLExpr {

    }

    /**
     * https://docs.oracle.com/en/database/oracle/oracle-database/18/lnpls/block.html#GUID-9ACEB9ED-567E-4E1A-A16A-B8B35214FC9D
     */
    public class OracleSQLSubtypeConstraint extends AbstractOracleSQLExpr implements IOracleSQLSubtypeConstraint {

        protected SQLIntegerLiteral precision;
        protected SQLIntegerLiteral scale;

        @Override
        public void accept0(OracleSQLASTVisitor visitor) {

        }

        public SQLIntegerLiteral getPrecision() {
            return precision;
        }

        public void setPrecision(SQLIntegerLiteral precision) {
            this.precision = precision;
        }

        public SQLIntegerLiteral getScale() {
            return scale;
        }

        public void setScale(SQLIntegerLiteral scale) {
            this.scale = scale;
        }
    }

    /**
     * https://docs.oracle.com/en/database/oracle/oracle-database/18/lnpls/block.html#GUID-9ACEB9ED-567E-4E1A-A16A-B8B35214FC9D
     */
    public static class OracleSQLSubtypeRangeConstraint extends AbstractOracleSQLExpr implements IOracleSQLSubtypeConstraint {

        protected SQLIntegerLiteral lowValue;
        protected SQLIntegerLiteral highValue;

        @Override
        public void accept0(OracleSQLASTVisitor visitor) {

        }

        public SQLIntegerLiteral getLowValue() {
            return lowValue;
        }

        public void setLowValue(SQLIntegerLiteral lowValue) {
            this.lowValue = lowValue;
        }

        public SQLIntegerLiteral getHighValue() {
            return highValue;
        }

        public void setHighValue(SQLIntegerLiteral highValue) {
            this.highValue = highValue;
        }
    }
}
