package com.aliyun.gumiho.sql.dialect.oracle.ast.element.expr.common;

import com.aliyun.gumiho.sql.basic.ast.element.expr.SQLExpr;
import com.aliyun.gumiho.sql.dialect.oracle.ast.element.expr.AbstractOracleSQLExpr;
import com.aliyun.gumiho.sql.dialect.oracle.visitor.OracleSQLASTVisitor;

import java.util.ArrayList;
import java.util.List;

/**
 * LOB LEFT_PAREN nameIdentifier (COMMA nameIdentifier)* RIGHT_PAREN STORE AS lobStorageClauseParameter+
 * lobStorageClauseParameter: SECUREFILE | BASICFILE | lob_segname | LEFT_PAREN lobStorageParameter+ RIGHT_PAREN
 * <p>
 * <p>
 * https://docs.oracle.com/en/database/oracle/oracle-database/18/sqlrf/CREATE-TABLE.html#GUID-F9CE0CC3-13AE-4744-A43C-EAC7A71AAAB6
 *
 * @author kongtong.ouyang on 2018/6/25.
 */
public class OracleSQLLobStorageClause extends AbstractOracleSQLExpr {

    protected final List<SQLExpr> items = new ArrayList<>();
    protected final List<SQLExpr> parameters = new ArrayList<>();

    @Override
    public void accept0(OracleSQLASTVisitor visitor) {
        if (visitor.visit(this)) {
            this.acceptChild(visitor, items);
            this.acceptChild(visitor, parameters);
        }
    }

    @Override
    public OracleSQLLobStorageClause clone() {
        super.clone();
        return null;
    }

    @Override
    public boolean replace(SQLExpr source, SQLExpr target) {
        boolean replace = replaceInList(items, source, target, this);
        if (replace) {
            return true;
        }

        replace = replaceInList(parameters, source, target, this);
        if (replace) {
            return true;
        }

        return false;
    }

    public List<SQLExpr> getItems() {
        return items;
    }

    public void addItem(SQLExpr item) {
        if (item == null) {
            return;
        }
        setChildParent(item);
        items.add(item);
    }

    public List<SQLExpr> getParameters() {
        return parameters;
    }

    public void addParameter(SQLExpr parameter) {
        if (parameter == null) {
            return;
        }
        setChildParent(parameter);
        parameters.add(parameter);
    }


}
