package com.aliyun.gumiho.sql.basic.ast.element.expr.table;

import com.aliyun.gumiho.sql.basic.ast.element.expr.AbstractSQLExpr;
import com.aliyun.gumiho.sql.basic.ast.element.expr.SQLExpr;
import com.aliyun.gumiho.sql.basic.ast.element.identifier.SQLName;
import com.aliyun.gumiho.sql.basic.ast.enums.ISQLEnum;
import com.aliyun.gumiho.sql.basic.ast.enums.SQLReserved;
import com.aliyun.gumiho.sql.basic.ast.enums.SQLYesType;
import com.aliyun.gumiho.sql.basic.visitor.SQLASTVisitor;

import java.util.ArrayList;
import java.util.List;

/**
 * CLUSTERING [ clustering_join ] cluster_clause [ clustering_when ] [ zonemap_clause ]
 * <p>
 * <p>
 * clustering_join：   [ schema. ] table JOIN [ schema. ] table ON ( equijoin_condition )
 * [, JOIN [ schema. ] table ON ( equijoin_condition ) ]...
 * <p>
 * cluster_clause : BY [ LINEAR | INTERLEAVED ] ORDER clustering_columns
 * attribute_clustering_clause
 * https://docs.oracle.com/en/database/oracle/oracle-database/18/sqlrf/CREATE-TABLE.html#GUID-F9CE0CC3-13AE-4744-A43C-EAC7A71AAAB6
 *
 * @author kongtong.ouyang on 2018/7/10.
 */
public class SQLAttributeClusteringClause extends AbstractSQLExpr {

    protected SQLClusteringJoin clusteringJoin;
    protected SQLClusterClause clusterClause;
    protected SQLClusteringWhen clusteringWhen;
    protected SQLZoneMapClause zoneMapClause;


    @Override
    protected void accept0(SQLASTVisitor visitor) {
        if (visitor.visit(this)) {
            this.acceptChild(visitor, clusteringJoin);
            this.acceptChild(visitor, clusterClause);
            this.acceptChild(visitor, clusteringWhen);
            this.acceptChild(visitor, zoneMapClause);
        }
    }

    @Override
    public SQLAttributeClusteringClause clone() {
        SQLAttributeClusteringClause x = new SQLAttributeClusteringClause();
        return x;
    }

    public SQLClusteringJoin getClusteringJoin() {
        return clusteringJoin;
    }

    public void setClusteringJoin(SQLClusteringJoin clusteringJoin) {
        setChildParent(clusteringJoin);
        this.clusteringJoin = clusteringJoin;
    }

    public SQLClusterClause getClusterClause() {
        return clusterClause;
    }

    public void setClusterClause(SQLClusterClause clusterClause) {
        setChildParent(clusterClause);
        this.clusterClause = clusterClause;
    }

    public SQLClusteringWhen getClusteringWhen() {
        return clusteringWhen;
    }

    public void setClusteringWhen(SQLClusteringWhen clusteringWhen) {
        setChildParent(clusteringWhen);
        this.clusteringWhen = clusteringWhen;
    }

    public SQLZoneMapClause getZoneMapClause() {
        return zoneMapClause;
    }

    public void setZoneMapClause(SQLZoneMapClause zoneMapClause) {
        setChildParent(zoneMapClause);
        this.zoneMapClause = zoneMapClause;
    }

    /**
     * nameIdentifier clusteringJoinItem (COMMA clusteringJoinItem)*
     *
     * clustering_join
     * https://docs.oracle.com/en/database/oracle/oracle-database/18/sqlrf/CREATE-TABLE.html#GUID-F9CE0CC3-13AE-4744-A43C-EAC7A71AAAB6
     */
    public static class SQLClusteringJoin extends AbstractSQLExpr {

        protected SQLName name;
        protected final List<SQLClusteringJoinItem> items = new ArrayList<>();

        @Override
        protected void accept0(SQLASTVisitor visitor) {
            if (visitor.visit(this)) {
                this.acceptChild(visitor, name);
                this.acceptChild(visitor, items);
            }
        }

        @Override
        public SQLClusteringJoin clone() {
            SQLClusteringJoin x = new SQLClusteringJoin();
            return x;
        }

        public SQLName getName() {
            return name;
        }

        public void setName(SQLName name) {
            setChildParent(name);
            this.name = name;
        }

        public List<SQLClusteringJoinItem> getItems() {
            return items;
        }

        public void addItem(SQLClusteringJoinItem item) {
            if(item == null) {
                return;
            }
            setChildParent(item);
            this.items.add(item);
        }
    }

    /**
     * JOIN [ schema. ] table ON ( equijoin_condition )
     */
    public static class SQLClusteringJoinItem extends AbstractSQLExpr {
        protected SQLName name;
        protected SQLExpr condition;

        @Override
        protected void accept0(SQLASTVisitor visitor) {
            if (visitor.visit(this)) {
                this.acceptChild(visitor, name);
                this.acceptChild(visitor, condition);
            }
        }

        @Override
        public SQLExpr clone() {
            return super.clone();
        }

        public SQLName getName() {
            return name;
        }

        public void setName(SQLName name) {
            setChildParent(name);
            this.name = name;
        }

        public SQLExpr getCondition() {
            return condition;
        }

        public void setCondition(SQLExpr condition) {
            setChildParent(condition);
            this.condition = condition;
        }
    }


    /**
     * BY [ LINEAR | INTERLEAVED ] ORDER clustering_columns
     * cluster_clause
     * https://docs.oracle.com/en/database/oracle/oracle-database/18/sqlrf/CREATE-TABLE.html#GUID-F9CE0CC3-13AE-4744-A43C-EAC7A71AAAB6
     */
    public static class SQLClusterClause extends AbstractSQLExpr {

        protected SQLLinearType linear;
        protected final List<SQLExpr> columns = new ArrayList<>();

        @Override
        protected void accept0(SQLASTVisitor visitor) {
            if (visitor.visit(this)) {
                this.acceptChild(visitor, columns);
            }
        }

        @Override
        public SQLExpr clone() {
            return super.clone();
        }

        public SQLLinearType getLinear() {
            return linear;
        }

        public void setLinear(SQLLinearType linear) {
            this.linear = linear;
        }

        public List<SQLExpr> getColumns() {
            return columns;
        }

        public void addColumn(SQLExpr column) {
            if (column == null) {
                return;
            }
            setChildParent(column);
            this.columns.add(column);
        }
    }


    /**
     * BY [ LINEAR | INTERLEAVED ] ORDER clustering_columns
     * cluster_clause
     * https://docs.oracle.com/en/database/oracle/oracle-database/18/sqlrf/CREATE-TABLE.html#GUID-F9CE0CC3-13AE-4744-A43C-EAC7A71AAAB6
     */
    public static class SQLClusteringWhen extends AbstractSQLExpr {

        protected SQLYesType onLoad;
        protected SQLYesType onDataMovement;

        @Override
        protected void accept0(SQLASTVisitor visitor) {
            if (visitor.visit(this)) {
            }
        }

        @Override
        public SQLExpr clone() {
            return super.clone();
        }

        public SQLYesType getOnLoad() {
            return onLoad;
        }

        public void setOnLoad(SQLYesType onLoad) {
            this.onLoad = onLoad;
        }

        public SQLYesType getOnDataMovement() {
            return onDataMovement;
        }

        public void setOnDataMovement(SQLYesType onDataMovement) {
            this.onDataMovement = onDataMovement;
        }
    }

    /**
     * https://docs.oracle.com/en/database/oracle/oracle-database/18/sqlrf/CREATE-TABLE.html#GUID-F9CE0CC3-13AE-4744-A43C-EAC7A71AAAB6
     */
    public interface SQLZoneMapClause extends SQLExpr {
        @Override
        SQLZoneMapClause clone();
    }

    /**
     * WITH MATERIALIZED ZONEMAP (LEFT_PAREN nameIdentifier RIGHT_PAREN)?
     */
    public static class SQLWithMaterializedZoneMapClause extends AbstractSQLExpr implements SQLZoneMapClause{
        protected SQLName name;
        @Override
        protected void accept0(SQLASTVisitor visitor) {
            if (visitor.visit(this)) {
                this.acceptChild(visitor, name);
            }
        }

        @Override
        public SQLWithMaterializedZoneMapClause clone() {
            return null;
        }

        @Override
        public boolean replace(SQLExpr source, SQLExpr target) {
            if(source == name
                    && target instanceof SQLName) {
                setName((SQLName)target);
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
     * WITHOUT MATERIALIZED ZONEMAP
     */
    public static class SQLWithoutMaterializedZoneMapClause extends AbstractSQLExpr implements SQLZoneMapClause{
        @Override
        protected void accept0(SQLASTVisitor visitor) {
            visitor.visit(this);
        }

        @Override
        public SQLWithMaterializedZoneMapClause clone() {
            return new SQLWithMaterializedZoneMapClause();
        }
    }




    public enum SQLLinearType implements ISQLEnum {

        LINEAR(SQLReserved.LINEAR),
        INTERLEAVED(SQLReserved.INTERLEAVED);

        public final SQLReserved name;

        SQLLinearType(SQLReserved name) {
            this.name = name;
        }


        @Override
        public SQLReserved getName() {
            return name;
        }
    }

}
