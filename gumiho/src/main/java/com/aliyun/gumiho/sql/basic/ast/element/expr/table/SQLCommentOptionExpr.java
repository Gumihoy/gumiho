package com.aliyun.gumiho.sql.basic.ast.element.expr.table;

import com.aliyun.gumiho.sql.basic.ast.element.expr.SQLExpr;
import com.aliyun.gumiho.sql.basic.ast.element.expr.SQLSetOptionExpr;
import com.aliyun.gumiho.sql.basic.ast.enums.SQLReserved;

/**
 * COMMENT [=] 'string'
 *
 * @author kongtong.ouyang on 2018/7/30.
 */
public class SQLCommentOptionExpr extends SQLSetOptionExpr {

    public SQLCommentOptionExpr() {
        super(SQLReserved.COMMENT.ofExpr());
    }

    public SQLCommentOptionExpr(SQLExpr value) {
        super(SQLReserved.COMMENT.ofExpr(), value);
    }

    public SQLCommentOptionExpr(boolean equalSign, SQLExpr value) {
        super(SQLReserved.COMMENT.ofExpr(), equalSign, value);
    }

    public static SQLCommentOptionExpr of(SQLExpr value) {
        return new SQLCommentOptionExpr(value);
    }

}
