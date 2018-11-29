package com.aliyun.gumiho.sql.basic.ast.element.function.xml;

import com.aliyun.gumiho.sql.basic.ast.element.function.AbstractSQLFunction;
import com.aliyun.gumiho.sql.basic.ast.enums.SQLReserved;
import com.aliyun.gumiho.sql.basic.visitor.SQLASTVisitor;

/**
 * XMLEXISTS ( XQuery_string [ XML_passing_clause ] )
 * <p>
 * https://docs.oracle.com/en/database/oracle/oracle-database/18/sqlrf/XMLCAST.html#GUID-06563B93-1247-4F0C-B6BE-42DB3B1DB069
 *
 * @author kongtong.ouyang on 2018/5/24.
 */
public class SQLXmlExistsFunction extends AbstractSQLFunction {

    protected SQLXmlPassingClause passingClause;


    public SQLXmlExistsFunction() {
        super(SQLReserved.XMLEXISTS.ofExpr());
    }

    @Override
    protected void accept0(SQLASTVisitor visitor) {
        if (visitor.visit(this)) {
            this.acceptChild(visitor, arguments);
        }
    }

    public SQLXmlPassingClause getPassingClause() {
        return passingClause;
    }

    public void setPassingClause(SQLXmlPassingClause passingClause) {
        setChildParent(passingClause);
        this.passingClause = passingClause;
    }
}
