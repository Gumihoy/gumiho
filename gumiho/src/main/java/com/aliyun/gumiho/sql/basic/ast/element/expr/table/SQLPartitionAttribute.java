package com.aliyun.gumiho.sql.basic.ast.element.expr.table;

import com.aliyun.gumiho.sql.basic.ast.element.expr.AbstractSQLExpr;
import com.aliyun.gumiho.sql.basic.ast.element.expr.SQLExpr;
import com.aliyun.gumiho.sql.basic.visitor.SQLASTVisitor;

import java.util.ArrayList;
import java.util.List;

/**
 * partition_attributes
 * https://docs.oracle.com/en/database/oracle/oracle-database/18/sqlrf/ALTER-TABLE.html#GUID-552E7373-BF93-477D-9DA3-B2C9386F2877
 *
 * @author kongtong.ouyang on 2018/7/12.
 */
public interface SQLPartitionAttribute extends SQLExpr {

    @Override
    SQLPartitionAttribute clone();

    /**
     * LOB lob_item ( parameter [ parameter...])
     */
    class SQLLobClause extends AbstractSQLExpr implements SQLPartitionAttribute {
        protected SQLExpr name;
        protected final List<SQLExpr> parameters = new ArrayList<>();

        @Override
        protected void accept0(SQLASTVisitor visitor) {
            if (visitor.visit(this)) {
                this.acceptChild(visitor, parameters);
            }
        }

        @Override
        public SQLLobClause clone() {
            SQLLobClause x = new SQLLobClause();
            return x;
        }

        public SQLExpr getName() {
            return name;
        }

        public void setName(SQLExpr name) {
            setChildParent(name);
            this.name = name;
        }

        public List<SQLExpr> getParameters() {
            return parameters;
        }

        public void addParameter(SQLExpr parameter) {
            if (parameter == null) {
                return;
            }
            setChildParent(parameter);
            this.parameters.add(parameter);
        }
    }

    /**
     * VARRAY varray ( parameter [ parameter...])
     */
    class SQLVarrayClause extends AbstractSQLExpr implements SQLPartitionAttribute {
        protected SQLExpr name;
        protected final List<SQLExpr> parameters = new ArrayList<>();

        @Override
        protected void accept0(SQLASTVisitor visitor) {
            if (visitor.visit(this)) {
                this.acceptChild(visitor, parameters);
            }
        }

        @Override
        public SQLLobClause clone() {
            SQLLobClause x = new SQLLobClause();
            return x;
        }

        public SQLExpr getName() {
            return name;
        }

        public void setName(SQLExpr name) {
            setChildParent(name);
            this.name = name;
        }

        public List<SQLExpr> getParameters() {
            return parameters;
        }

        public void addParameter(SQLExpr parameter) {
            if (parameter == null) {
                return;
            }
            setChildParent(parameter);
            this.parameters.add(parameter);
        }
    }
}
