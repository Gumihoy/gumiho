package com.aliyun.gumiho.sql.dialect.oracle.ast.element.expr.common;

import com.aliyun.gumiho.sql.basic.ast.element.expr.SQLColumnProperty;
import com.aliyun.gumiho.sql.basic.ast.element.expr.SQLExpr;
import com.aliyun.gumiho.sql.basic.ast.enums.SQLLocalType;
import com.aliyun.gumiho.sql.basic.ast.enums.SQLReserved;
import com.aliyun.gumiho.sql.dialect.oracle.ast.element.expr.AbstractOracleSQLExpr;
import com.aliyun.gumiho.sql.dialect.oracle.visitor.OracleSQLASTVisitor;

import java.util.ArrayList;
import java.util.List;

/**
 * NESTED TABLE
 * { nested_item | COLUMN_VALUE }
 * [ substitutable_column_clause ]
 * [ LOCAL | GLOBAL ]
 * STORE AS storage_table
 * [ ( { (object_properties)
 * | [ physical_properties ]
 * | [ column_properties ]
 * }...
 * )
 * ]
 * [ RETURN [ AS ]  { LOCATOR | VALUE } ]
 * <p>
 * <p>
 * nested_table_col_properties
 * https://docs.oracle.com/en/database/oracle/oracle-database/18/sqlrf/CREATE-MATERIALIZED-VIEW.html#GUID-EE262CA4-01E5-4618-B659-6165D993CA1B
 *
 * @author kongtong.ouyang on 2018/6/22.
 */
public class OracleSQLNestedTableColProperty extends AbstractOracleSQLExpr implements SQLColumnProperty {

    protected SQLExpr nestedItem;
    protected IOracleSQLSubstitutableColumnClause substitutableColumnClause;

    protected SQLLocalType localType;

    protected SQLExpr storageTable;

    protected final List<SQLExpr> storeAsItems = new ArrayList<>();

    protected ReturnOption returnOption;


    @Override
    public void accept0(OracleSQLASTVisitor visitor) {
        if (visitor.visit(this)) {
            this.acceptChild(visitor, nestedItem);
            this.acceptChild(visitor, substitutableColumnClause);
            this.acceptChild(visitor, storageTable);
            this.acceptChild(visitor, storeAsItems);
        }
    }

    @Override
    public OracleSQLNestedTableColProperty clone() {
        OracleSQLNestedTableColProperty x = new OracleSQLNestedTableColProperty();
        return x;
    }


    public SQLExpr getNestedItem() {
        return nestedItem;
    }

    public void setNestedItem(SQLExpr nestedItem) {
        setChildParent(nestedItem);
        this.nestedItem = nestedItem;
    }

    public IOracleSQLSubstitutableColumnClause getSubstitutableColumnClause() {
        return substitutableColumnClause;
    }

    public void setSubstitutableColumnClause(IOracleSQLSubstitutableColumnClause substitutableColumnClause) {
        setChildParent(substitutableColumnClause);
        this.substitutableColumnClause = substitutableColumnClause;
    }

    public SQLLocalType getLocalType() {
        return localType;
    }

    public void setLocalType(SQLLocalType localType) {
        this.localType = localType;
    }

    public SQLExpr getStorageTable() {
        return storageTable;
    }

    public void setStorageTable(SQLExpr storageTable) {
        setChildParent(storageTable);
        this.storageTable = storageTable;
    }

    public List<SQLExpr> getStoreAsItems() {
        return storeAsItems;
    }

    public void addStoreAsItem(SQLExpr storeAsItem) {
        if (storeAsItem == null) {
            return;
        }
        setChildParent(storeAsItem);
        this.storeAsItems.add(storeAsItem);
    }


    public ReturnOption getReturnOption() {
        return returnOption;
    }

    public void setReturnOption(ReturnOption returnOption) {
        this.returnOption = returnOption;
    }

    /**
     * COLUMN_VALUE
     */
    public static class SQLColumnValue extends AbstractOracleSQLExpr {
        public static SQLColumnValue of() {
            return new SQLColumnValue();
        }

        @Override
        public void accept0(OracleSQLASTVisitor visitor) {
            visitor.visit(this);
        }

        @Override
        public SQLColumnValue clone() {
            SQLColumnValue x = new SQLColumnValue();
            return x;
        }
    }

    public enum ReturnOption {

        RETURN_LOCATOR(SQLReserved.RETURN_LOCATOR),
        RETURN_AS_LOCATOR(SQLReserved.RETURN_AS_LOCATOR),
        RETURN_VALUE(SQLReserved.RETURN_VALUE),
        RETURN_AS_VALUE(SQLReserved.RETURN_AS_VALUE),;

        public final SQLReserved name;

        ReturnOption(SQLReserved name) {
            this.name = name;
        }

        @Override
        public String toString() {
            return name.upper;
        }
    }
}
