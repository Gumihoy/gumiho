package com.aliyun.gumiho.sql.dialect.oracle.ast.element.expr.table.alter.partition;

import com.aliyun.gumiho.sql.basic.ast.element.expr.ISQLLobParameter;
import com.aliyun.gumiho.sql.basic.ast.element.expr.ISQLSegmentAttributesClause;
import com.aliyun.gumiho.sql.basic.ast.element.expr.SQLExpr;
import com.aliyun.gumiho.sql.basic.ast.element.expr.table.alter.partition.ISQLAlterTablePartitionAction;
import com.aliyun.gumiho.sql.basic.ast.element.identifier.SQLName;
import com.aliyun.gumiho.sql.basic.ast.enums.SQLIndexingOnType;
import com.aliyun.gumiho.sql.basic.ast.enums.SQLReadOnlyType;
import com.aliyun.gumiho.sql.dialect.oracle.ast.element.expr.AbstractOracleSQLExpr;
import com.aliyun.gumiho.sql.dialect.oracle.ast.element.expr.common.*;
import com.aliyun.gumiho.sql.dialect.oracle.visitor.OracleSQLASTVisitor;

import java.util.ArrayList;
import java.util.List;

/**
 * MODIFY DEFAULT ATTRIBUTES
 * [ FOR partition_extended_name ]
 * [ deferred_segment_creation ]
 * [ read_only_clause ]
 * [ indexing_clause ]
 * [ segment_attributes_clause ]
 * [ table_compression ]
 * [ inmemory_clause ]
 * [ PCTTHRESHOLD integer ]
 * [ prefix_compression ]
 * [ alter_overflow_clause ]
 * [ { LOB (LOB_item) | VARRAY varray } (LOB_parameters) ]...
 * <p>
 * modify_table_default_attrs
 * https://docs.oracle.com/en/database/oracle/oracle-database/18/sqlrf/ALTER-TABLE.html#GUID-552E7373-BF93-477D-9DA3-B2C9386F2877
 *
 * @author kongtong.ouyang on 2018/7/14.
 */
public class OracleSQLAlterTableModifyDefaultAttrsAction extends AbstractOracleSQLExpr implements ISQLAlterTablePartitionAction {


    protected ISQLForPartition forPartition;
    protected OracleSQLDeferredSegmentCreation deferredSegmentCreation;
    protected SQLReadOnlyType readOnly;
    protected SQLIndexingOnType indexingOn;
    protected final List<ISQLSegmentAttributesClause> segmentAttributes = new ArrayList<>();
    protected IOracleSQLTableCompression tableCompression;
    protected OracleSQLInMemoryClause inMemoryClause;
    protected OracleSQLPctthresholdClause pctthresholdClause;
    protected IOracleSQLPrefixCompression prefixCompression;

    @Override
    public void accept0(OracleSQLASTVisitor visitor) {
        if (visitor.visit(this)) {
            this.acceptChild(visitor, forPartition);
            this.acceptChild(visitor, deferredSegmentCreation);
        }
    }

    @Override
    public OracleSQLAlterTableModifyDefaultAttrsAction clone() {
        OracleSQLAlterTableModifyDefaultAttrsAction x = new OracleSQLAlterTableModifyDefaultAttrsAction();
        return x;
    }


    public interface ISQLForPartition extends SQLExpr {
        @Override
        SQLExpr clone();
    }

    /**
     * FOR PARTITION expr
     */
    public static class SQLForPartition extends AbstractOracleSQLExpr implements ISQLForPartition {
        protected SQLName name;

        @Override
        public void accept0(OracleSQLASTVisitor visitor) {
            if (visitor.visit(this)) {
                this.acceptChild(visitor, name);
            }
        }

        @Override
        public OracleSQLAlterTableModifyDefaultAttrsAction clone() {
            OracleSQLAlterTableModifyDefaultAttrsAction x = new OracleSQLAlterTableModifyDefaultAttrsAction();
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

    public static class SQLForPartitionFor extends AbstractOracleSQLExpr {
        protected final List<SQLExpr> names = new ArrayList<>();

        @Override
        public void accept0(OracleSQLASTVisitor visitor) {
            if (visitor.visit(this)) {
                this.acceptChild(visitor, names);
            }
        }

        @Override
        public OracleSQLAlterTableModifyDefaultAttrsAction clone() {
            OracleSQLAlterTableModifyDefaultAttrsAction x = new OracleSQLAlterTableModifyDefaultAttrsAction();
            return x;
        }


        @Override
        public boolean replace(SQLExpr source, SQLExpr target) {
            boolean replace = replaceInList(names, source, target, this);
            if (replace) {
                return true;
            }
            return false;
        }

        public List<SQLExpr> getNames() {
            return names;
        }

        public void addName(SQLExpr name) {
            if (name == null) {
                return;
            }
            setChildParent(name);
            this.names.add(name);
        }
    }


    /**
     * { LOB (LOB_item) | VARRAY varray } (LOB_parameters)
     * https://docs.oracle.com/en/database/oracle/oracle-database/18/sqlrf/ALTER-TABLE.html#GUID-552E7373-BF93-477D-9DA3-B2C9386F2877
     */
    interface Item extends SQLExpr {
        @Override
        SQLExpr clone();
    }

    public static abstract class AbstractItem extends AbstractOracleSQLExpr implements SQLExpr {
        protected SQLExpr expr;
        protected final List<ISQLLobParameter> parameters = new ArrayList<>();

        @Override
        public AbstractItem clone() {
            throw new UnsupportedOperationException(getClass().getName());
        }

        @Override
        public boolean replace(SQLExpr source, SQLExpr target) {
            if (source == expr) {
                setExpr(target);
                return true;
            }

            return false;
        }

        public SQLExpr getExpr() {
            return expr;
        }

        public void setExpr(SQLExpr expr) {
            setChildParent(expr);
            this.expr = expr;
        }

        public List<ISQLLobParameter> getParameters() {
            return parameters;
        }

        public void addParameter(ISQLLobParameter parameter) {
            if (parameter == null) {
                return;
            }
            setChildParent(parameter);
            this.parameters.add(parameter);
        }
    }

    /**
     * LOB (LOB_item) (LOB_parameters)
     */
    public static class LobItem extends AbstractItem {
        @Override
        public void accept0(OracleSQLASTVisitor visitor) {
            if (visitor.visit(this)) {
                this.acceptChild(visitor, expr);
                this.acceptChild(visitor, parameters);
            }
        }
    }


    /**
     * VARRAY varray (LOB_parameters)
     */
    public static class VarrayItem extends AbstractItem {
        @Override
        public void accept0(OracleSQLASTVisitor visitor) {
            if (visitor.visit(this)) {
                this.acceptChild(visitor, expr);
                this.acceptChild(visitor, parameters);
            }
        }
    }

}
