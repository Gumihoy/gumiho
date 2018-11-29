package com.aliyun.gumiho.sql.dialect.oracle.ast.element.expr.common;

import com.aliyun.gumiho.sql.basic.ast.element.expr.SQLExpr;
import com.aliyun.gumiho.sql.dialect.oracle.ast.element.expr.AbstractOracleSQLExpr;
import com.aliyun.gumiho.sql.basic.ast.enums.SQLBasicFileType;
import com.aliyun.gumiho.sql.dialect.oracle.visitor.OracleSQLASTVisitor;

/**
 * STORE AS [SECUREFILE | BASICFILE] LOB { [LOB_segname] ( LOB_storage_parameters ) | LOB_segname }
 * <p>
 * varray_storage_clause
 * https://docs.oracle.com/en/database/oracle/oracle-database/18/sqlrf/CREATE-MATERIALIZED-VIEW.html#GUID-EE262CA4-01E5-4618-B659-6165D993CA1B
 *
 * @author kongtong.ouyang on 2018/6/27.
 */
public class OracleSQLVarrayStorageClause extends AbstractOracleSQLExpr {

    protected SQLBasicFileType storeAsType;

    protected SQLExpr segName;

    protected OracleSQLLobStorageParameters lobStorageParameters;

    @Override
    public void accept0(OracleSQLASTVisitor visitor) {
        if (visitor.visit(this)) {
            this.acceptChild(visitor, segName);
            this.acceptChild(visitor, lobStorageParameters);
        }
    }

    @Override
    public OracleSQLVarrayStorageClause clone() {
        OracleSQLVarrayStorageClause x = new OracleSQLVarrayStorageClause();
        return x;
    }

    public SQLBasicFileType getStoreAsType() {
        return storeAsType;
    }

    public void setStoreAsType(SQLBasicFileType storeAsType) {
        this.storeAsType = storeAsType;
    }

    public SQLExpr getSegName() {
        return segName;
    }

    public void setSegName(SQLExpr segName) {
        setChildParent(segName);
        this.segName = segName;
    }

    public OracleSQLLobStorageParameters getLobStorageParameters() {
        return lobStorageParameters;
    }

    public void setLobStorageParameters(OracleSQLLobStorageParameters lobStorageParameters) {
        setChildParent(lobStorageParameters);
        this.lobStorageParameters = lobStorageParameters;
    }
}
