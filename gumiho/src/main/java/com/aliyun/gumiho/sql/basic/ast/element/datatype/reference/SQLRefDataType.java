package com.aliyun.gumiho.sql.basic.ast.element.datatype.reference;


import com.aliyun.gumiho.sql.basic.ast.element.datatype.AbstractSQLDataType;
import com.aliyun.gumiho.sql.basic.ast.element.identifier.SQLName;
import com.aliyun.gumiho.sql.basic.ast.enums.SQLReserved;
import com.aliyun.gumiho.sql.basic.visitor.SQLASTVisitor;

/**
 * REF <left paren> <referenced type> <right paren> [ scope tableName]
 * <p>
 * https://ronsavage.github.io/SQL/sql-2003-2.bnf.html#reference%20type
 * <p>
 * REF name
 * https://docs.oracle.com/en/database/oracle/oracle-database/12.2/sqlrf/Data-Types.html#GUID-1E278F1C-0EC1-4626-8D93-80D8230AB8F1
 * https://docs.oracle.com/en/database/oracle/oracle-database/18/lnpls/datatype-attribute.html#GUID-B4A364AB-7CC2-4B3F-AF52-09A752029C8E
 *
 * @author kongtong.ouyang on 2018/4/19.
 */
public class SQLRefDataType extends AbstractSQLDataType implements ISQLRefDataType {

    protected SQLName tableName;

    public SQLRefDataType() {
        super(SQLReserved.REF.ofExpr());
    }

    @Override
    protected void accept0(SQLASTVisitor visitor) {
        if (visitor.visit(this)) {
            this.acceptChild(visitor, arguments);
            this.acceptChild(visitor, tableName);
        }
    }


    public SQLName getTableName() {
        return tableName;
    }

    public void setTableName(SQLName tableName) {
        setChildParent(tableName);
        this.tableName = tableName;
    }

}
