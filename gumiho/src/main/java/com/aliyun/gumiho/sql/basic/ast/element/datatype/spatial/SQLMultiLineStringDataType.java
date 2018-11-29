package com.aliyun.gumiho.sql.basic.ast.element.datatype.spatial;

import com.aliyun.gumiho.sql.basic.ast.element.datatype.AbstractSQLDataType;
import com.aliyun.gumiho.sql.basic.ast.enums.SQLReserved;
import com.aliyun.gumiho.sql.basic.visitor.SQLASTVisitor;

/**
 * MULTILINESTRING
 * https://dev.mysql.com/doc/refman/8.0/en/spatial-type-overview.html
 *
 * @author kongtong.ouyang on 2018/7/23.
 */
public class SQLMultiLineStringDataType extends AbstractSQLDataType implements SQLSpatialDataType {

    public SQLMultiLineStringDataType() {
        super(SQLReserved.MULTILINESTRING.ofExpr());
    }

    @Override
    protected void accept0(SQLASTVisitor visitor) {
        visitor.visit(this);
    }

    @Override
    public SQLMultiLineStringDataType clone() {
        return new SQLMultiLineStringDataType();
    }
}
