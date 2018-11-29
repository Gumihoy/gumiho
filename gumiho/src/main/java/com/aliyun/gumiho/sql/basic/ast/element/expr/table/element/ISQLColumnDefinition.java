package com.aliyun.gumiho.sql.basic.ast.element.expr.table.element;

import com.aliyun.gumiho.sql.basic.ast.element.expr.table.element.constraint.column.ISQLColumnConstraint;
import com.aliyun.gumiho.sql.basic.ast.element.identifier.SQLName;

import java.util.List;

/**
 * @author kongtong.ouyang on 2018/7/14.
 */
public interface ISQLColumnDefinition extends SQLTableElement {
    @Override
    ISQLColumnDefinition clone();

    List<ISQLColumnConstraint> getColumnConstraints();

    boolean isReferencesColumn();

    List<SQLName> referencedTables();
}
