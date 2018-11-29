package com.aliyun.gumiho.sql.basic.ast.element.datatype.spatial;

import com.aliyun.gumiho.sql.basic.ast.element.datatype.AbstractSQLDataType;
import com.aliyun.gumiho.sql.basic.ast.enums.SQLReserved;
import com.aliyun.gumiho.sql.basic.visitor.SQLASTVisitor;

/**
 * POINT
 * https://dev.mysql.com/doc/refman/8.0/en/spatial-type-overview.html
 *
 * @author kongtong.ouyang on 2018/7/23.
 */
public class SQLPointDataType extends AbstractSQLDataType implements SQLSpatialDataType {

    public SQLPointDataType() {
        super(SQLReserved.POINT.ofExpr());
    }

    @Override
    protected void accept0(SQLASTVisitor visitor) {
        visitor.visit(this);
    }

    @Override
    public SQLPointDataType clone() {
        return new SQLPointDataType();
    }
}
