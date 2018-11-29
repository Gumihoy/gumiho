package com.aliyun.gumiho.sql.dialect.oracle.ast.element.expr.common;

import com.aliyun.gumiho.sql.dialect.oracle.ast.element.expr.AbstractOracleSQLExpr;
import com.aliyun.gumiho.sql.dialect.oracle.visitor.OracleSQLASTVisitor;

/**
 * [ inmemory_memcompress ] [ inmemory_priority ] [ inmemory_distribute ] [ inmemory_duplicate ]
 *
 * https://docs.oracle.com/en/database/oracle/oracle-database/18/sqlrf/CREATE-TABLE.html#GUID-F9CE0CC3-13AE-4744-A43C-EAC7A71AAAB6
 * @author kongtong.ouyang on 2018/6/25.
 */
public class OracleSQLInMemoryAttributes extends AbstractOracleSQLExpr {

    protected IOracleSQLInMemoryMemCompressClause inMemoryMemCompress;
    protected OracleSQLInMemoryPriority inMemoryPriority;
    protected OracleSQLInMemoryDistribute inMemoryDistribute;
    protected IOracleSQLInMemoryDuplicateClause inMemoryDuplicate;

    @Override
    public void accept0(OracleSQLASTVisitor visitor) {
        if (visitor.visit(this)) {
            this.acceptChild(visitor, inMemoryMemCompress);
            this.acceptChild(visitor, inMemoryPriority);
            this.acceptChild(visitor, inMemoryDistribute);
            this.acceptChild(visitor, inMemoryDuplicate);
        }
    }

    @Override
    public OracleSQLInMemoryAttributes clone() {
        OracleSQLInMemoryAttributes x = new OracleSQLInMemoryAttributes();

        if (this.inMemoryMemCompress != null) {
            IOracleSQLInMemoryMemCompressClause inMemoryMemCompressClone = this.inMemoryMemCompress.clone();
            x.setInMemoryMemCompress(inMemoryMemCompressClone);
        }

        if (this.inMemoryPriority != null) {
            OracleSQLInMemoryPriority inMemoryPriorityClone = this.inMemoryPriority.clone();
            x.setInMemoryPriority(inMemoryPriorityClone);
        }

        if (this.inMemoryDistribute != null) {
            OracleSQLInMemoryDistribute inMemoryDistributeClone = this.inMemoryDistribute.clone();
            x.setInMemoryDistribute(inMemoryDistributeClone);
        }

        if (this.inMemoryDuplicate != null) {
            IOracleSQLInMemoryDuplicateClause inMemoryDuplicateClone = this.inMemoryDuplicate.clone();
            x.setInMemoryDuplicate(inMemoryDuplicateClone);
        }

        return x;
    }


    public IOracleSQLInMemoryMemCompressClause getInMemoryMemCompress() {
        return inMemoryMemCompress;
    }

    public void setInMemoryMemCompress(IOracleSQLInMemoryMemCompressClause inMemoryMemCompress) {
        this.inMemoryMemCompress = inMemoryMemCompress;
    }

    public OracleSQLInMemoryPriority getInMemoryPriority() {
        return inMemoryPriority;
    }

    public void setInMemoryPriority(OracleSQLInMemoryPriority inMemoryPriority) {
        this.inMemoryPriority = inMemoryPriority;
    }

    public OracleSQLInMemoryDistribute getInMemoryDistribute() {
        return inMemoryDistribute;
    }

    public void setInMemoryDistribute(OracleSQLInMemoryDistribute inMemoryDistribute) {
        this.inMemoryDistribute = inMemoryDistribute;
    }

    public IOracleSQLInMemoryDuplicateClause getInMemoryDuplicate() {
        return inMemoryDuplicate;
    }

    public void setInMemoryDuplicate(IOracleSQLInMemoryDuplicateClause inMemoryDuplicate) {
        this.inMemoryDuplicate = inMemoryDuplicate;
    }
}
