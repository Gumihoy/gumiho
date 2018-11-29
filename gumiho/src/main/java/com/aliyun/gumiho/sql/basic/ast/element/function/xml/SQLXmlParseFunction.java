package com.aliyun.gumiho.sql.basic.ast.element.function.xml;

import com.aliyun.gumiho.sql.basic.ast.element.function.AbstractSQLFunction;
import com.aliyun.gumiho.sql.basic.ast.enums.SQLReserved;
import com.aliyun.gumiho.sql.basic.visitor.SQLASTVisitor;

/**
 * XMLPARSE({ DOCUMENT | CONTENT } value_expr [ WELLFORMED ])
 * <p>
 * https://docs.oracle.com/en/database/oracle/oracle-database/18/sqlrf/XMLPARSE.html#GUID-39A93E58-F06E-4633-A7BF-6CF27A53D9B6
 *
 * @author kongtong.ouyang on 2018/5/24.
 */
public class SQLXmlParseFunction extends AbstractSQLFunction {

    protected SQLReserved content;

    protected boolean wellFormed;

    public SQLXmlParseFunction() {
        super(SQLReserved.XMLCAST.ofExpr());
    }

    @Override
    protected void accept0(SQLASTVisitor visitor) {
        if (visitor.visit(this)) {
            this.acceptChild(visitor, arguments);
        }
    }

    public SQLReserved getContent() {
        return content;
    }

    public void setContent(SQLReserved content) {
        this.content = content;
    }

    public boolean isWellFormed() {
        return wellFormed;
    }

    public void setWellFormed(boolean wellFormed) {
        this.wellFormed = wellFormed;
    }
}
