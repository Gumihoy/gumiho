package com.aliyun.gumiho.sql.basic.ast.element.expr;

import com.aliyun.gumiho.sql.basic.ast.element.identifier.SQLName;
import com.aliyun.gumiho.sql.basic.ast.enums.SQLBasicFileType;
import com.aliyun.gumiho.sql.basic.visitor.SQLASTVisitor;

/**
 * VARRAY varray_item STORE AS [SECUREFILE | BASICFILE] LOB LOB_segname
 * <p>
 * partitioning_storage_clause
 * https://docs.oracle.com/en/database/oracle/oracle-database/18/sqlrf/CREATE-INDEX.html#GUID-1F89BBC0-825F-4215-AF71-7588E31D8BFE
 *
 * @author kongtong.ouyang on 2018/7/9.
 */
public class SQLVarrayStorageAsClause extends AbstractSQLExpr implements ISQLPartitioningStorageClause {

    protected SQLExpr item;

    protected SQLBasicFileType fileType;

    protected SQLName lobName;

    @Override
    protected void accept0(SQLASTVisitor visitor) {
        if (visitor.visit(this)) {
            this.acceptChild(visitor, item);
            this.acceptChild(visitor, lobName);
        }
    }

    @Override
    public SQLVarrayStorageAsClause clone() {
        SQLVarrayStorageAsClause x = new SQLVarrayStorageAsClause();
        return x;
    }

    public SQLExpr getItem() {
        return item;
    }

    public void setItem(SQLExpr item) {
        setChildParent(item);
        this.item = item;
    }

    public SQLBasicFileType getFileType() {
        return fileType;
    }

    public void setFileType(SQLBasicFileType fileType) {
        this.fileType = fileType;
    }

    public SQLName getLobName() {
        return lobName;
    }

    public void setLobName(SQLName lobName) {
        setChildParent(lobName);
        this.lobName = lobName;
    }
}
