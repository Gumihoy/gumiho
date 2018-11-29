package com.aliyun.gumiho.sql.dialect.oracle.ast.element.expr.common;

import com.aliyun.gumiho.sql.basic.ast.element.expr.ISQLLobStorageParameter;
import com.aliyun.gumiho.sql.dialect.oracle.ast.element.expr.AbstractOracleSQLExpr;
import com.aliyun.gumiho.sql.dialect.oracle.visitor.OracleSQLASTVisitor;

import java.util.ArrayList;
import java.util.List;

/**
 * ( lobStorageParameters )
 *
 * @author kongtong.ouyang on 2018/6/28.
 */
public class OracleSQLLobStorageParameters extends AbstractOracleSQLExpr {

    protected final List<ISQLLobStorageParameter> lobStorageParameters = new ArrayList<>();

    @Override
    public void accept0(OracleSQLASTVisitor visitor) {
        if (visitor.visit(this)) {
            this.acceptChild(visitor, lobStorageParameters);
        }
    }

    public List<ISQLLobStorageParameter> getLobStorageParameters() {
        return lobStorageParameters;
    }

    public void addLobStorageParameter(ISQLLobStorageParameter lobStorageParameter) {
        if (lobStorageParameter == null) {
            return;
        }
        setChildParent(lobStorageParameter);
        this.lobStorageParameters.add(lobStorageParameter);
    }
}
