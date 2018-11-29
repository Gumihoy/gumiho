package com.aliyun.gumiho.sql.dialect.oracle.ast.element.expr.common;

import com.aliyun.gumiho.sql.basic.ast.element.expr.SQLExpr;
import com.aliyun.gumiho.sql.basic.ast.element.identifier.SQLName;
import com.aliyun.gumiho.sql.dialect.oracle.ast.element.expr.AbstractOracleSQLExpr;
import com.aliyun.gumiho.sql.dialect.oracle.visitor.OracleSQLASTVisitor;

import java.util.ArrayList;
import java.util.List;

/**
 * ([ TYPE access_driver_type ] [ external_table_data_props ] ) [ REJECT LIMIT { integer | UNLIMITED } ] [ inmemory_table_clause ]
 * <p>
 * external_table_clause
 * https://docs.oracle.com/en/database/oracle/oracle-database/18/sqlrf/CREATE-TABLE.html#GUID-F9CE0CC3-13AE-4744-A43C-EAC7A71AAAB6
 *
 * @author kongtong.ouyang on 2018/6/25.
 */
public class OracleSQLExternalTableClause extends AbstractOracleSQLExpr {

    protected SQLName accessDriverType;
    protected final List<SQLExpr> externalTableDataProps = new ArrayList<>();
    protected SQLExpr rejectLimit;
    protected OracleSQLInMemoryTableClause inMemoryTableClause;

    @Override
    public void accept0(OracleSQLASTVisitor visitor) {
        if (visitor.visit(this)) {
            this.acceptChild(visitor, accessDriverType);
            this.acceptChild(visitor, externalTableDataProps);
            this.acceptChild(visitor, rejectLimit);
            this.acceptChild(visitor, inMemoryTableClause);
        }
    }

    @Override
    public OracleSQLExternalTableClause clone() {
        OracleSQLExternalTableClause x = new OracleSQLExternalTableClause();

        return x;
    }

    public SQLName getAccessDriverType() {
        return accessDriverType;
    }

    public void setAccessDriverType(SQLName accessDriverType) {
        setChildParent(accessDriverType);
        this.accessDriverType = accessDriverType;
    }

    public List<SQLExpr> getExternalTableDataProps() {
        return externalTableDataProps;
    }

    public void addExternalTableDataProp(SQLExpr externalTableDataProp) {
        if (externalTableDataProp == null) {
            return;
        }
        setChildParent(externalTableDataProp);
        this.externalTableDataProps.add(externalTableDataProp);
    }

    public SQLExpr getRejectLimit() {
        return rejectLimit;
    }

    public void setRejectLimit(SQLExpr rejectLimit) {
        setChildParent(rejectLimit);
        this.rejectLimit = rejectLimit;
    }

    public OracleSQLInMemoryTableClause getInMemoryTableClause() {
        return inMemoryTableClause;
    }

    public void setInMemoryTableClause(OracleSQLInMemoryTableClause inMemoryTableClause) {
        setChildParent(inMemoryTableClause);
        this.inMemoryTableClause = inMemoryTableClause;
    }
}
