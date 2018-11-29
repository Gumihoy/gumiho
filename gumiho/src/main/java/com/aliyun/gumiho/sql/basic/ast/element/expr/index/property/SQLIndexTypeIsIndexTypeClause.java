package com.aliyun.gumiho.sql.basic.ast.element.expr.index.property;

import com.aliyun.gumiho.sql.basic.ast.element.expr.AbstractSQLExpr;
import com.aliyun.gumiho.sql.basic.ast.element.expr.SQLExpr;
import com.aliyun.gumiho.sql.basic.ast.element.expr.SQLParametersClause;
import com.aliyun.gumiho.sql.basic.ast.element.expr.index.SQLLocalPartitionIndex;
import com.aliyun.gumiho.sql.basic.ast.element.identifier.SQLName;
import com.aliyun.gumiho.sql.basic.visitor.SQLASTVisitor;

/**
 * INDEXTYPE IS nameIdentifier localPartitionedIndex? parallelClause? parametersClause?
 * <p>
 * index_properties
 * https://docs.oracle.com/en/database/oracle/oracle-database/18/sqlrf/CREATE-INDEX.html#GUID-1F89BBC0-825F-4215-AF71-7588E31D8BFE
 *
 * @author kongtong.ouyang on 2018/7/9.
 */
public class SQLIndexTypeIsIndexTypeClause extends AbstractSQLExpr implements ISQLIndexProperty {

    protected SQLName name;
    protected SQLLocalPartitionIndex partitionedIndex;
    protected SQLExpr parallelClause;
    protected SQLParametersClause parametersClause;


    @Override
    protected void accept0(SQLASTVisitor visitor) {
        if (visitor.visit(this)) {
            this.acceptChild(visitor, name);
            this.acceptChild(visitor, partitionedIndex);
            this.acceptChild(visitor, parallelClause);
            this.acceptChild(visitor, parametersClause);
        }
    }

    @Override
    public SQLIndexTypeIsIndexTypeClause clone() {
        SQLIndexTypeIsIndexTypeClause x = new SQLIndexTypeIsIndexTypeClause();

        SQLName nameClone = this.name.clone();
        x.setName(nameClone);

        if (this.partitionedIndex != null) {
            SQLLocalPartitionIndex partitionedIndexClone = this.partitionedIndex.clone();
            x.setPartitionedIndex(partitionedIndexClone);
        }

        if (this.parallelClause != null) {
            SQLExpr parallelClauseClone = this.parallelClause.clone();
            x.setParallelClause(parallelClauseClone);
        }

        if (this.parametersClause != null) {
            SQLParametersClause parametersClauseClone = this.parametersClause.clone();
            x.setParametersClause(parametersClauseClone);
        }

        return x;
    }

    public SQLName getName() {
        return name;
    }

    public void setName(SQLName name) {
        setChildParent(name);
        this.name = name;
    }

    public SQLLocalPartitionIndex getPartitionedIndex() {
        return partitionedIndex;
    }

    public void setPartitionedIndex(SQLLocalPartitionIndex partitionedIndex) {
        setChildParent(partitionedIndex);
        this.partitionedIndex = partitionedIndex;
    }

    public SQLExpr getParallelClause() {
        return parallelClause;
    }

    public void setParallelClause(SQLExpr parallelClause) {
        setChildParent(parallelClause);
        this.parallelClause = parallelClause;
    }

    public SQLParametersClause getParametersClause() {
        return parametersClause;
    }

    public void setParametersClause(SQLParametersClause parametersClause) {
        setChildParent(parametersClause);
        this.parametersClause = parametersClause;
    }
}
