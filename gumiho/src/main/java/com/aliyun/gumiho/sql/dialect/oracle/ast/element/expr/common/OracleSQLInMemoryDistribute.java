package com.aliyun.gumiho.sql.dialect.oracle.ast.element.expr.common;

import com.aliyun.gumiho.sql.basic.ast.element.expr.SQLExpr;
import com.aliyun.gumiho.sql.dialect.oracle.ast.element.expr.AbstractOracleSQLExpr;
import com.aliyun.gumiho.sql.dialect.oracle.visitor.OracleSQLASTVisitor;

/**
 * DISTRIBUTE [ AUTO | BY { ROWID RANGE | PARTITION | SUBPARTITION } ]
 [ FOR SERVICE { DEFAULT | ALL | service_name | NONE } ]
 * <p>
 * https://docs.oracle.com/en/database/oracle/oracle-database/18/sqlrf/CREATE-TABLE.html#GUID-F9CE0CC3-13AE-4744-A43C-EAC7A71AAAB6
 *
 * @author kongtong.ouyang on 2018/6/25.
 */
public class OracleSQLInMemoryDistribute extends AbstractOracleSQLExpr {

    protected SQLExpr distribute;

    protected SQLExpr forServiceOption;

    @Override
    public void accept0(OracleSQLASTVisitor visitor) {
        if(visitor.visit(this)) {
            this.acceptChild(visitor, distribute);
            this.acceptChild(visitor, forServiceOption);
        }
    }

    @Override
    public OracleSQLInMemoryDistribute clone() {
        OracleSQLInMemoryDistribute x = new OracleSQLInMemoryDistribute();

        if (this.distribute!=null) {
            SQLExpr distributeClone = this.distribute.clone();
            x.setDistribute(distributeClone);
        }
        if (this.forServiceOption!=null) {
            SQLExpr forServiceOptionClone = this.forServiceOption.clone();
            x.setForServiceOption(forServiceOptionClone);
        }
        return x;
    }


    public SQLExpr getDistribute() {
        return distribute;
    }

    public void setDistribute(SQLExpr distribute) {
        setChildParent(distribute);
        this.distribute = distribute;
    }

    public SQLExpr getForServiceOption() {
        return forServiceOption;
    }

    public void setForServiceOption(SQLExpr forServiceOption) {
        setChildParent(forServiceOption);
        this.forServiceOption = forServiceOption;
    }
}
