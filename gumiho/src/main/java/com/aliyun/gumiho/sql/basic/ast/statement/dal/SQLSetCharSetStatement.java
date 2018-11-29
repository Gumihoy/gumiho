package com.aliyun.gumiho.sql.basic.ast.statement.dal;

import com.aliyun.gumiho.sql.basic.visitor.SQLASTVisitor;
import com.aliyun.gumiho.sql.enums.DBType;
import com.aliyun.gumiho.sql.enums.SQLObjectType;

/**
 * SET CHARSET {'charset_name' | DEFAULT}
 * <p>
 * https://dev.mysql.com/doc/refman/8.0/en/set-character-set.html
 *
 * @author kongtong.ouyang on 2018/7/26.
 */
public class SQLSetCharSetStatement extends AbstractSQLCharacterSetStatement {

    public SQLSetCharSetStatement(DBType dbType) {
        super(dbType);
    }

    @Override
    protected void accept0(SQLASTVisitor visitor) {
        if (visitor.visit(this)) {
//            this.acceptChild(visitor, name);
        }
    }

    @Override
    public SQLSetCharSetStatement clone() {
        SQLSetCharSetStatement x = new SQLSetCharSetStatement(this.dbType);
        this.cloneTo(x);
        return x;
    }


    @Override
    public SQLObjectType getObjectType() {
        return SQLObjectType.SET_CHARSET;
    }


}
