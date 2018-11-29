package com.aliyun.gumiho.sql.basic.ast.element.datatype.string;

import com.aliyun.gumiho.sql.basic.ast.element.datatype.AbstractSQLDataType;
import com.aliyun.gumiho.sql.basic.ast.element.expr.SQLCharacterSetOptionExpr;
import com.aliyun.gumiho.sql.basic.ast.element.expr.SQLCollateOptionExpr;
import com.aliyun.gumiho.sql.basic.ast.element.identifier.SQLName;

/**
 * https://ronsavage.github.io/SQL/sql-2003-2.bnf.html#predefined%20type
 * <p>
 * https://dev.mysql.com/doc/refman/5.7/en/string-type-overview.html
 * <p>
 * https://docs.oracle.com/en/database/oracle/oracle-database/12.2/sqlrf/Data-Types.html#GUID-A3C0D836-BADB-44E5-A5D4-265BA5968483
 *
 * @author kongtong.ouyang on 2018/4/19.
 */
public abstract class AbstractSQLTextDataType extends AbstractSQLDataType implements ISQLStringDataType {

    protected SQLCharacterSetOptionExpr characterSetExpr;
    protected SQLCollateOptionExpr collateClause;


    public AbstractSQLTextDataType(String name) {
        super(name);
    }

    public AbstractSQLTextDataType(SQLName name) {
        super(name);
    }

    @Override
    public String getCharacterSetName() {
        return characterSetExpr.getValue().toString();
    }

    @Override
    public String getCollationName() {
        return collateClause.getValue().toString();
    }

    public SQLCharacterSetOptionExpr getCharacterSetExpr() {
        return characterSetExpr;
    }

    public void setCharacterSetExpr(SQLCharacterSetOptionExpr characterSetExpr) {
        setChildParent(characterSetExpr);
        this.characterSetExpr = characterSetExpr;
    }

    public SQLCollateOptionExpr getCollateClause() {
        return collateClause;
    }

    public void setCollateClause(SQLCollateOptionExpr collateClause) {
        setChildParent(collateClause);
        this.collateClause = collateClause;
    }
}
