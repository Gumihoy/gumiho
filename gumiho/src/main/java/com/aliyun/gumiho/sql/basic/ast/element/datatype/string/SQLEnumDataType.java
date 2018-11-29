package com.aliyun.gumiho.sql.basic.ast.element.datatype.string;

import com.aliyun.gumiho.sql.basic.ast.enums.SQLReserved;
import com.aliyun.gumiho.sql.basic.visitor.SQLASTVisitor;

/**
 * ENUM('value1','value2',...) [CHARACTER SET charset_name] [COLLATE collation_name]
 * <p>
 * https://dev.mysql.com/doc/refman/8.0/en/string-type-overview.html
 *
 * @author kongtong.ouyang on 2018/6/17.
 */
public class SQLEnumDataType extends AbstractSQLTextDataType {

    public SQLEnumDataType() {
        super(SQLReserved.ENUM.ofExpr());
    }

    @Override
    protected void accept0(SQLASTVisitor visitor) {
        if (visitor.visit(this)) {
            this.acceptChild(visitor, arguments);
            this.acceptChild(visitor, characterSetExpr);
            this.acceptChild(visitor, collateClause);
        }
    }

    @Override
    public SQLEnumDataType clone() {
        SQLEnumDataType x = new SQLEnumDataType();
        this.cloneTo(x);
        return x;
    }
}
