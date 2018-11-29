package com.aliyun.gumiho.sql.basic.ast.element.expr.index.alter.partition;

import com.aliyun.gumiho.sql.basic.ast.element.expr.AbstractSQLExpr;
import com.aliyun.gumiho.sql.basic.ast.element.expr.SQLExpr;
import com.aliyun.gumiho.sql.basic.ast.element.expr.SQLTablespaceOptionExpr;
import com.aliyun.gumiho.sql.basic.ast.element.expr.parallel.ISQLParallelClause;
import com.aliyun.gumiho.sql.basic.ast.element.identifier.SQLName;
import com.aliyun.gumiho.sql.basic.visitor.SQLASTVisitor;
//import com.aliyun.gumiho.sql.dialect.oracle.ast.element.expr.common.IOracleSQLIndexCompression;

/**
 * ADD PARTITION [ partition_name ] [ TABLESPACE tablespace_name ] [ index_compression ] [ parallel_clause ]
 *
 *
 * modify_index_default_attrs
 * https://docs.oracle.com/en/database/oracle/oracle-database/18/sqlrf/ALTER-INDEX.html#GUID-D8F648E7-8C07-4C89-BB71-862512536558
 * @author kongtong.ouyang on 2018/7/10.
 */
public class SQLAlterIndexAddPartitionAction extends AbstractSQLExpr implements ISQLAlterIndexPartitionAction {

    protected SQLExpr name;
    protected SQLTablespaceOptionExpr tableSpaceClause;
//    protected IOracleSQLIndexCompression indexCompression;
    protected ISQLParallelClause parallelClause;

    @Override
    protected void accept0(SQLASTVisitor visitor) {
        if (visitor.visit(this)) {
            this.acceptChild(visitor, name);
            this.acceptChild(visitor, tableSpaceClause);
//            this.acceptChild(visitor, indexCompression);
            this.acceptChild(visitor, parallelClause);
        }
    }

    @Override
    public SQLAlterIndexAddPartitionAction clone() {
        SQLAlterIndexAddPartitionAction x = new SQLAlterIndexAddPartitionAction();
        return x;
    }

    @Override
    public boolean replace(SQLExpr source, SQLExpr target) {
        if (source == name) {
            setName(target);
            return true;
        }
        return false;
    }

    public SQLExpr getName() {
        return name;
    }

    public String getPartitionName() {
        if (name instanceof SQLName) {
            return ((SQLName) name).getName();
        }
        return null;
    }

    public void setName(SQLExpr name) {
        setChildParent(name);
        this.name = name;
    }

    public SQLTablespaceOptionExpr getTableSpaceClause() {
        return tableSpaceClause;
    }

    public void setTableSpaceClause(SQLTablespaceOptionExpr tableSpaceClause) {
        setChildParent(tableSpaceClause);
        this.tableSpaceClause = tableSpaceClause;
    }

//    public IOracleSQLIndexCompression getIndexCompression() {
//        return indexCompression;
//    }
//
//    public void setIndexCompression(IOracleSQLIndexCompression indexCompression) {
//        setChildParent(indexCompression);
//        this.indexCompression = indexCompression;
//    }

    public ISQLParallelClause getParallelClause() {
        return parallelClause;
    }

    public void setParallelClause(ISQLParallelClause parallelClause) {
        setChildParent(parallelClause);
        this.parallelClause = parallelClause;
    }
}
