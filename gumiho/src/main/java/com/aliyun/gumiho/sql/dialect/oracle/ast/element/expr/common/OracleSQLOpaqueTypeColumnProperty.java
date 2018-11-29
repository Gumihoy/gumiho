package com.aliyun.gumiho.sql.dialect.oracle.ast.element.expr.common;

import com.aliyun.gumiho.sql.basic.ast.element.expr.SQLColumnProperty;
import com.aliyun.gumiho.sql.basic.ast.element.identifier.SQLName;
import com.aliyun.gumiho.sql.dialect.oracle.ast.element.expr.AbstractOracleSQLExpr;
import com.aliyun.gumiho.sql.dialect.oracle.visitor.OracleSQLASTVisitor;

import java.util.ArrayList;
import java.util.List;

/**
 * OPAQUE TYPE name [ (LOB_partition_storage [, LOB_partition_storage ]...) ]
 *
 * https://docs.oracle.com/cd/B28359_01/server.111/b28286/statements_6002.htm#i2116664
 * @author kongtong.ouyang on 2018/6/28.
 */
public class OracleSQLOpaqueTypeColumnProperty extends AbstractOracleSQLExpr implements SQLColumnProperty {

    protected SQLName name;
    protected OracleSQLVarrayStorageClause varrayStorageClause;

    @Override
    public void accept0(OracleSQLASTVisitor visitor) {
        if (visitor.visit(this)) {
            this.acceptChild(visitor, name);
            this.acceptChild(visitor, varrayStorageClause);
        }
    }

    @Override
    public OracleSQLOpaqueTypeColumnProperty clone() {
        return null;
    }

    public SQLName getName() {
        return name;
    }

    public void setName(SQLName name) {
        this.name = name;
    }

    public OracleSQLVarrayStorageClause getVarrayStorageClause() {
        return varrayStorageClause;
    }

    public void setVarrayStorageClause(OracleSQLVarrayStorageClause varrayStorageClause) {
        this.varrayStorageClause = varrayStorageClause;
    }
}
