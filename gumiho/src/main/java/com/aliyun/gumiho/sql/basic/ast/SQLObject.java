package com.aliyun.gumiho.sql.basic.ast;

import com.aliyun.gumiho.sql.basic.visitor.SQLASTVisitor;
import com.aliyun.gumiho.sql.enums.DBType;
import com.aliyun.gumiho.sql.enums.SQLObjectType;

/**
 * @author kongtong.ouyang on 2018/10/30.
 */
public interface SQLObject extends Cloneable {

    DBType getDbType();

    void setDbType(DBType dbType);

    DBType getTargetDBType();

    void setTargetDBType(DBType dbType);

    SQLObjectType getObjectType();

    void accept(SQLASTVisitor visitor);

    SQLObject clone();

    <T extends SQLObject> void cloneTo(T x);

    SQLObject getParent();

    void setParent(SQLObject parent);


    boolean isAfterSemi();

    void setAfterSemi(boolean afterSemi);
}
