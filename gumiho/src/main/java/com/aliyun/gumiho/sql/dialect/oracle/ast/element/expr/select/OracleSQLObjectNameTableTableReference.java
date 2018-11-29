package com.aliyun.gumiho.sql.dialect.oracle.ast.element.expr.select;

import com.aliyun.gumiho.sql.basic.ast.element.expr.SQLExpr;
import com.aliyun.gumiho.sql.basic.ast.element.expr.select.SQLObjectNameTableReference;
import com.aliyun.gumiho.sql.basic.ast.element.identifier.SQLIdentifier;
import com.aliyun.gumiho.sql.basic.ast.element.identifier.SQLName;
import com.aliyun.gumiho.sql.basic.ast.enums.SQLReserved;
import com.aliyun.gumiho.sql.basic.visitor.SQLASTVisitor;
import com.aliyun.gumiho.sql.dialect.oracle.ast.element.expr.AbstractOracleSQLExpr;
import com.aliyun.gumiho.sql.dialect.oracle.visitor.OracleSQLASTVisitor;

import java.util.ArrayList;
import java.util.List;

/**
 * name [option] [sampleClause] [flashbackQueryClause] [pivot] [as？ alias]
 * ONLY (name [option]  [sampleClause])  [flashbackQueryClause] [pivot] [as？ alias]
 * <p>
 * https://docs.oracle.com/cd/B28359_01/server.111/b28286/statements_10002.htm#i2112818
 * <p>
 * https://docs.oracle.com/en/database/oracle/oracle-database/18/sqlrf/SELECT.html#GUID-CFA006CA-6FF1-4972-821E-6996142A51C6
 *
 * @author kongtong.ouyang on 2018/5/4.
 */
public class OracleSQLObjectNameTableTableReference extends SQLObjectNameTableReference implements IOracleSQLTableReference {

    protected OracleSQLSampleClause oracleSQLSampleClause;

    protected final List<OracleSQLFlashbackQueryClause> flashbackQueryClauses = new ArrayList<>();

    protected SQLExpr pivot;

    public OracleSQLObjectNameTableTableReference(String name) {
        super(name);
    }

    public OracleSQLObjectNameTableTableReference(SQLName name) {
        super(name);
    }

    @Override
    protected void accept0(SQLASTVisitor visitor) {
        if (visitor instanceof OracleSQLASTVisitor) {
            this.accept0((OracleSQLASTVisitor) visitor);
        } else {
            throw new UnsupportedOperationException(getClass().getName());
        }
    }

    @Override
    public void accept0(OracleSQLASTVisitor visitor) {
        if (visitor.visit(this)) {
            this.acceptChild(visitor, name);
            this.acceptChild(visitor, option);
            this.acceptChild(visitor, oracleSQLSampleClause);
            this.acceptChild(visitor, flashbackQueryClauses);
            this.acceptChild(visitor, pivot);
            this.acceptChild(visitor, alias);
        }
    }

    @Override
    public OracleSQLObjectNameTableTableReference clone() {
        SQLName nameClone = this.name.clone();
        OracleSQLObjectNameTableTableReference x = new OracleSQLObjectNameTableTableReference(nameClone);

        this.cloneTo(x);
        return x;
    }


    public void cloneTo(OracleSQLObjectNameTableTableReference x) {
        super.cloneTo(x);

        if (this.oracleSQLSampleClause != null) {
            OracleSQLSampleClause oracleSQLSampleClauseClone = this.oracleSQLSampleClause.clone();
            x.setOracleSQLSampleClause(oracleSQLSampleClauseClone);
        }

        for (OracleSQLFlashbackQueryClause flashbackQueryClause : this.flashbackQueryClauses) {
            OracleSQLFlashbackQueryClause flashbackQueryClauseClone = flashbackQueryClause.clone();
            x.addFlashbackQueryClause(flashbackQueryClauseClone);
        }

        if (this.pivot != null) {
            SQLExpr pivotClone = this.pivot.clone();
            x.setPivot(pivotClone);
        }
    }

    @Override
    public boolean replace(SQLExpr source, SQLExpr target) {
        if (source == name) {
            this.setName((SQLName)target);
            return true;
        }

        if (source == alias) {
            this.setAlias((SQLIdentifier)target);
            return true;
        }

        return false;
    }

    public OracleSQLSampleClause getOracleSQLSampleClause() {
        return oracleSQLSampleClause;
    }

    public void setOracleSQLSampleClause(OracleSQLSampleClause oracleSQLSampleClause) {
        setChildParent(oracleSQLSampleClause);
        this.oracleSQLSampleClause = oracleSQLSampleClause;
    }

    public List<OracleSQLFlashbackQueryClause> getFlashbackQueryClauses() {
        return flashbackQueryClauses;
    }

    public void addFlashbackQueryClause(OracleSQLFlashbackQueryClause flashbackQueryClause) {
        if (flashbackQueryClause == null) {
            return;
        }
        setChildParent(flashbackQueryClause);
        this.flashbackQueryClauses.add(flashbackQueryClause);
    }


    public SQLExpr getPivot() {
        return pivot;
    }

    public void setPivot(SQLExpr pivot) {
        setChildParent(pivot);
        this.pivot = pivot;
    }

    /**
     * EXTERNAL MODIFY modify_external_table_properties
     * modify_external_table_properties:
     * DEFAULT DIRECTORY directory
     * [ LOCATION '(' directory ':' ''' location_specifier ''' ')' ]
     * [ ACCESS PARAMETERS
     * [ BADFILE filename ]
     * [ LOGFILE filename ]
     * [ DISCARDFILE filename ] ]
     * [ REJECT LIMIT { integer | UNLIMITED ]
     */
    public static class OracleSQLModifiedExternalTableClause extends AbstractOracleSQLExpr {

        protected SQLExpr directory;

        protected final List<SQLExpr> locationItems = new ArrayList<>();

        protected SQLReserved fileType;
        protected SQLExpr fileName;

        protected SQLExpr rejectLimit;

        @Override
        public void accept0(OracleSQLASTVisitor visitor) {
            if (visitor.visit(this)) {
                this.acceptChild(visitor, directory);
                this.acceptChild(visitor, fileName);
                this.acceptChild(visitor, rejectLimit);
            }
        }



        public SQLExpr getDirectory() {
            return directory;
        }

        public void setDirectory(SQLExpr directory) {
            setChildParent(directory);
            this.directory = directory;
        }

        public List<SQLExpr> getLocationItems() {
            return locationItems;
        }

        public SQLReserved getFileType() {
            return fileType;
        }

        public void setFileType(SQLReserved fileType) {
            this.fileType = fileType;
        }

        public SQLExpr getFileName() {
            return fileName;
        }

        public void setFileName(SQLExpr fileName) {
            setChildParent(fileName);
            this.fileName = fileName;
        }

        public SQLExpr getRejectLimit() {
            return rejectLimit;
        }

        public void setRejectLimit(SQLExpr rejectLimit) {
            setChildParent(rejectLimit);
            this.rejectLimit = rejectLimit;
        }
    }


    /**
     * SAMPLE [ BLOCK ] (sample_percent) [ SEED (seed_value) ]
     */
    public static class OracleSQLSampleClause extends AbstractOracleSQLExpr {

        protected boolean block;
        protected SQLExpr percent;
        protected SQLExpr seedValue;

        @Override
        public void accept0(OracleSQLASTVisitor visitor) {
            if (visitor.visit(this)) {
                this.acceptChild(visitor, percent);
                this.acceptChild(visitor, seedValue);
            }
        }

        @Override
        public OracleSQLSampleClause clone() {
            OracleSQLSampleClause x =new OracleSQLSampleClause();
            x.block = this.block;

            if (this.percent != null) {
                SQLExpr percentClone = percent.clone();
                x.setPercent(percentClone);
            }

            if (this.seedValue != null) {
                SQLExpr seedValueClone = seedValue.clone();
                x.setSeedValue(seedValueClone);
            }

            return x;
        }

        public boolean isBlock() {
            return block;
        }

        public void setBlock(boolean block) {
            this.block = block;
        }

        public SQLExpr getPercent() {
            return percent;
        }

        public void setPercent(SQLExpr percent) {
            setChildParent(percent);
            this.percent = percent;
        }

        public SQLExpr getSeedValue() {
            return seedValue;
        }

        public void setSeedValue(SQLExpr seedValue) {
            setChildParent(seedValue);
            this.seedValue = seedValue;
        }
    }
}
