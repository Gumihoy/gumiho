package com.aliyun.gumiho.sql.dialect.oracle.ast.element.expr.common;

import com.aliyun.gumiho.sql.basic.ast.element.expr.ISQLSegmentAttributesClause;
import com.aliyun.gumiho.sql.basic.ast.element.identifier.SQLName;
import com.aliyun.gumiho.sql.dialect.oracle.ast.element.expr.AbstractOracleSQLExpr;
import com.aliyun.gumiho.sql.basic.ast.enums.SQLBasicFileType;
import com.aliyun.gumiho.sql.dialect.oracle.visitor.OracleSQLASTVisitor;

/**
 * LOB LEFT_PAREN nameIdentifier RIGHT_PAREN STORE AS (BASICFILE | SECUREFILE)? lobSegname=nameIdentifier? segmentAttributesClause?
 * <p>
 * LOB_partitioning_storage
 * https://docs.oracle.com/en/database/oracle/oracle-database/18/sqlrf/CREATE-TABLE.html#GUID-F9CE0CC3-13AE-4744-A43C-EAC7A71AAAB6
 *
 * @author kongtong.ouyang on 2018/6/22.
 */
public class OracleSQLLobPartitioningStorage extends AbstractOracleSQLExpr {

    protected SQLName item;
    protected SQLBasicFileType fileType;

    protected SQLName segName;
    protected ISQLSegmentAttributesClause segmentAttributesClause;


    @Override
    public void accept0(OracleSQLASTVisitor visitor) {
        if (visitor.visit(this)) {
            this.acceptChild(visitor, item);
            this.acceptChild(visitor, segName);
            this.acceptChild(visitor, segmentAttributesClause);
        }
    }

    @Override
    public OracleSQLLobPartitioningStorage clone() {
        OracleSQLLobPartitioningStorage x = new OracleSQLLobPartitioningStorage();
        this.cloneTo(x);

        return x;
    }


    public SQLName getItem() {
        return item;
    }

    public void setItem(SQLName item) {
        this.item = item;
    }

    public SQLBasicFileType getFileType() {
        return fileType;
    }

    public void setFileType(SQLBasicFileType fileType) {
        this.fileType = fileType;
    }

    public SQLName getSegName() {
        return segName;
    }

    public void setSegName(SQLName segName) {
        this.segName = segName;
    }

    public ISQLSegmentAttributesClause getSegmentAttributesClause() {
        return segmentAttributesClause;
    }

    public void setSegmentAttributesClause(ISQLSegmentAttributesClause segmentAttributesClause) {
        this.segmentAttributesClause = segmentAttributesClause;
    }
}
