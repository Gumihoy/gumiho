package com.aliyun.gumiho.sql.basic.ast.element.expr;

import com.aliyun.gumiho.sql.basic.ast.element.identifier.SQLName;
import com.aliyun.gumiho.sql.basic.visitor.SQLASTVisitor;

import java.util.ArrayList;
import java.util.List;

/**
 * REBUILD
 * [ { PARTITION partition
 * | SUBPARTITION subpartition
 * }
 * | { REVERSE | NOREVERSE }
 * ]
 * [ parallel_clause
 * | TABLESPACE tablespace
 * | PARAMETERS ( 'ODCI_parameters' )
 * | XMLIndex_parameters_clause
 * | ONLINE
 * | physical_attributes_clause
 * | index_compression
 * | logging_clause
 * | partial_index_clause
 * ]...
 * <p>
 * https://docs.oracle.com/en/database/oracle/oracle-database/18/sqlrf/ALTER-INDEX.html#GUID-D8F648E7-8C07-4C89-BB71-862512536558
 *
 * @author kongtong.ouyang on 2018/9/10.
 */
public class SQLRebuildClause extends AbstractSQLExpr {

    protected SQLExpr expr;
    protected final List<SQLExpr> properties = new ArrayList<>();

    @Override
    protected void accept0(SQLASTVisitor visitor) {
        if (visitor.visit(this)) {
            this.acceptChild(visitor, expr);
            this.acceptChild(visitor, properties);
        }
    }

    @Override
    public SQLExpr clone() {
        return super.clone();
    }


    public SQLExpr getExpr() {
        return expr;
    }

    public void setExpr(SQLExpr expr) {
        setChildParent(expr);
        this.expr = expr;
    }

    public List<SQLExpr> getProperties() {
        return properties;
    }

    public void addProperty(SQLExpr property) {
        if (property == null) {
            return;
        }
        setChildParent(property);
        this.properties.add(property);
    }

    /**
     * PARTITION expr
     */
    public static class SQLPartitionItem extends AbstractSQLExpr {
        protected SQLName name;

        @Override
        protected void accept0(SQLASTVisitor visitor) {
            if (visitor.visit(this)) {
                this.acceptChild(visitor, name);
            }
        }

        @Override
        public SQLPartitionItem clone() {
            SQLPartitionItem x = new SQLPartitionItem();
            super.cloneTo(x);


            return x;
        }

        @Override
        public boolean replace(SQLExpr source, SQLExpr target) {
            if (source == name
                    && target instanceof SQLName) {
                setName((SQLName) target);
                return true;
            }
            return false;
        }

        public SQLName getName() {
            return name;
        }

        public void setName(SQLName name) {
            setChildParent(name);
            this.name = name;
        }
    }

    /**
     * SUBPARTITION expr
     */
    public static class SQLSubPartitionItem extends AbstractSQLExpr {
        protected SQLName name;

        @Override
        protected void accept0(SQLASTVisitor visitor) {
            if (visitor.visit(this)) {
                this.acceptChild(visitor, name);
            }
        }

        @Override
        public SQLSubPartitionItem clone() {
            SQLSubPartitionItem x = new SQLSubPartitionItem();
            super.cloneTo(x);


            return x;
        }

        @Override
        public boolean replace(SQLExpr source, SQLExpr target) {
            if (source == name
                    && target instanceof SQLName) {
                setName((SQLName) target);
                return true;
            }
            return false;
        }

        public SQLName getName() {
            return name;
        }

        public void setName(SQLName name) {
            setChildParent(name);
            this.name = name;
        }
    }

    /**
     * REVERSE
     */
    public static class SQLReverseItem extends AbstractSQLExpr {
        @Override
        protected void accept0(SQLASTVisitor visitor) {
            visitor.visit(this);
        }

        @Override
        public SQLReverseItem clone() {
            return new SQLReverseItem();
        }
    }

    /**
     * NOREVERSE
     */
    public static class SQLNoReverseItem extends AbstractSQLExpr {

        @Override
        protected void accept0(SQLASTVisitor visitor) {
            visitor.visit(this);
        }

        @Override
        public SQLNoReverseItem clone() {
            return new SQLNoReverseItem();
        }
    }

}
