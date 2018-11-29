package com.aliyun.gumiho.sql.basic.ast.element.datatype.string;

import com.aliyun.gumiho.sql.basic.ast.enums.SQLReserved;
import com.aliyun.gumiho.sql.basic.visitor.SQLASTVisitor;

/**
 * TEXT[(M)] [CHARACTER SET charset_name] [COLLATE collation_name]
 * <p>
 * https://ronsavage.github.io/SQL/sql-2003-2.bnf.html#predefined%20type
 * <p>
 * https://dev.mysql.com/doc/refman/5.7/en/string-type-overview.html
 *
 * @author kongtong.ouyang on 2018/4/19.
 */
public class SQLTextDataType extends AbstractSQLTextDataType {


    public SQLTextDataType() {
        super(SQLReserved.TEXT.ofExpr());
    }

    public static SQLTextDataType of() {
        return new SQLTextDataType();
    }

    @Override
    protected void accept0(SQLASTVisitor visitor) {
        if (visitor.visit(this)) {
            this.acceptChild(visitor, arguments);
            this.acceptChild(visitor, characterSetExpr);
            this.acceptChild(visitor, collateClause);
        }
    }


}
