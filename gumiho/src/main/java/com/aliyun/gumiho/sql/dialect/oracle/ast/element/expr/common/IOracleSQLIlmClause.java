package com.aliyun.gumiho.sql.dialect.oracle.ast.element.expr.common;

import com.aliyun.gumiho.sql.basic.ast.element.expr.ISQLPhysicalProperty;
import com.aliyun.gumiho.sql.basic.ast.element.expr.SQLExpr;
import com.aliyun.gumiho.sql.basic.ast.element.identifier.SQLName;
import com.aliyun.gumiho.sql.basic.ast.enums.SQLReserved;
import com.aliyun.gumiho.sql.dialect.oracle.ast.element.expr.AbstractOracleSQLExpr;
import com.aliyun.gumiho.sql.dialect.oracle.ast.element.expr.OracleSQLExpr;
import com.aliyun.gumiho.sql.dialect.oracle.visitor.OracleSQLASTVisitor;

/**
 * ILM { ADD POLICY ilm_policy_clause | { DELETE | ENABLE | DISABLE } POLICY ilm_policy_name | DELETE_ALL | ENABLE_ALL | DISABLE_ALL }
 * <p>
 * <p>
 * https://docs.oracle.com/en/database/oracle/oracle-database/18/sqlrf/CREATE-TABLE.html#GUID-F9CE0CC3-13AE-4744-A43C-EAC7A71AAAB6
 *
 * @author kongtong.ouyang on 2018/6/25.
 */
public interface IOracleSQLIlmClause extends OracleSQLExpr, ISQLPhysicalProperty {
    @Override
    IOracleSQLIlmClause clone();


    /**
     * ilm_policy_clause
     * https://docs.oracle.com/en/database/oracle/oracle-database/18/sqlrf/CREATE-TABLE.html#GUID-F9CE0CC3-13AE-4744-A43C-EAC7A71AAAB6
     */
    interface OracleSQLIlmPolicyClause extends OracleSQLExpr {
        @Override
        OracleSQLIlmPolicyClause clone();
    }


    /**
     * ilm_compression_policy
     */
    interface OracleSQLIlmCompressionPolicy extends OracleSQLIlmPolicyClause {
    }

    /**
     * table_compression
     */
    class OracleSQLIlmCompressionPolicyByTableCompression extends AbstractOracleSQLExpr implements OracleSQLIlmCompressionPolicy {
        protected IOracleSQLTableCompression tableCompression;
        protected SQLSegmentType segmentType;
        protected IlmPolicyOption option;

        @Override
        public void accept0(OracleSQLASTVisitor visitor) {
            if (visitor.visit(this)) {
                this.acceptChild(visitor, tableCompression);
                this.acceptChild(visitor, option);
            }
        }

        @Override
        public OracleSQLIlmCompressionPolicyByTableCompression clone() {
            OracleSQLIlmCompressionPolicyByTableCompression x = new OracleSQLIlmCompressionPolicyByTableCompression();
            return x;
        }

        public IOracleSQLTableCompression getTableCompression() {
            return tableCompression;
        }

        public void setTableCompression(IOracleSQLTableCompression tableCompression) {
            setChildParent(tableCompression);
            this.tableCompression = tableCompression;
        }

        public SQLSegmentType getSegmentType() {
            return segmentType;
        }

        public void setSegmentType(SQLSegmentType segmentType) {
            this.segmentType = segmentType;
        }

        public IlmPolicyOption getOption() {
            return option;
        }

        public void setOption(IlmPolicyOption option) {
            setChildParent(option);
            this.option = option;
        }
    }

    /**
     * ROW STORE COMPRESS ADVANCED ROW AFTER ilm_time_period OF NO MODIFICATION
     */
    class OracleSQLIlmCompressionPolicyByRowStoreCompression extends AbstractOracleSQLExpr implements OracleSQLIlmCompressionPolicy {
        protected OracleSQLIlmTimePeriod ilmTimePeriod;

        @Override
        public void accept0(OracleSQLASTVisitor visitor) {
            if (visitor.visit(this)) {
                this.acceptChild(visitor, ilmTimePeriod);
            }
        }

        @Override
        public OracleSQLIlmCompressionPolicyByRowStoreCompression clone() {
            OracleSQLIlmCompressionPolicyByRowStoreCompression x = new OracleSQLIlmCompressionPolicyByRowStoreCompression();
            OracleSQLIlmTimePeriod ilmTimePeriodClone = this.ilmTimePeriod.clone();
            x.setIlmTimePeriod(ilmTimePeriodClone);
            return x;
        }

        public OracleSQLIlmTimePeriod getIlmTimePeriod() {
            return ilmTimePeriod;
        }

        public void setIlmTimePeriod(OracleSQLIlmTimePeriod ilmTimePeriod) {
            setChildParent(ilmTimePeriod);
            this.ilmTimePeriod = ilmTimePeriod;
        }
    }

    /**
     * COLUMN STORE COMPRESS FOR QUERY  ROW AFTER ilm_time_period OF NO MODIFICATION
     */
    class OracleSQLIlmCompressionPolicyByColumnStoreCompression extends AbstractOracleSQLExpr implements OracleSQLIlmCompressionPolicy {

        protected OracleSQLIlmTimePeriod ilmTimePeriod;

        @Override
        public void accept0(OracleSQLASTVisitor visitor) {
            if (visitor.visit(this)) {
                this.acceptChild(visitor, ilmTimePeriod);
            }
        }

        @Override
        public OracleSQLIlmCompressionPolicyByColumnStoreCompression clone() {
            OracleSQLIlmCompressionPolicyByColumnStoreCompression x = new OracleSQLIlmCompressionPolicyByColumnStoreCompression();
            OracleSQLIlmTimePeriod ilmTimePeriodClone = this.ilmTimePeriod.clone();
            x.setIlmTimePeriod(ilmTimePeriodClone);
            return x;
        }

        public OracleSQLIlmTimePeriod getIlmTimePeriod() {
            return ilmTimePeriod;
        }

        public void setIlmTimePeriod(OracleSQLIlmTimePeriod ilmTimePeriod) {
            setChildParent(ilmTimePeriod);
            this.ilmTimePeriod = ilmTimePeriod;
        }
    }


    /**
     * ilm_tiering_policy
     * TIER TO tablespace [READ ONLY] [ SEGMENT | GROUP ] [AFTER ilm_time_period OF { NO ACCESS | NO MODIFICATION | CREATION } | ON function_name ] }
     */
    class OracleSQLIlmTieringPolicy extends AbstractOracleSQLExpr implements OracleSQLIlmPolicyClause {

        protected SQLName tablespace;
        protected boolean readOnly;
        protected IlmPolicyOption option;

        @Override
        public void accept0(OracleSQLASTVisitor visitor) {
            if (visitor.visit(this)) {
                this.acceptChild(visitor, tablespace);
                this.acceptChild(visitor, option);
            }
        }

        @Override
        public OracleSQLIlmTieringPolicy clone() {
            OracleSQLIlmTieringPolicy x = new OracleSQLIlmTieringPolicy();

            SQLName tablespaceClone = this.tablespace.clone();
            x.setTablespace(tablespaceClone);

            x.readOnly = this.readOnly;

            if (this.option != null) {
                IlmPolicyOption optionClone = this.option.clone();
                x.setOption(optionClone);
            }

            return x;
        }

        public SQLName getTablespace() {
            return tablespace;
        }

        public void setTablespace(SQLName tablespace) {
            setChildParent(tablespace);
            this.tablespace = tablespace;
        }

        public boolean isReadOnly() {
            return readOnly;
        }

        public void setReadOnly(boolean readOnly) {
            this.readOnly = readOnly;
        }

        public IlmPolicyOption getOption() {
            return option;
        }

        public void setOption(IlmPolicyOption option) {
            setChildParent(option);
            this.option = option;
        }
    }


    /**
     * ilm_inmemory_policy
     * { SET INMEMORY [ inmemory_attributes ] | MODIFY INMEMORY inmemory_memcompress | NO INMEMORY } [ SEGMENT ] { AFTER ilm_time_period OF { NO ACCESS | NO MODIFICATION | CREATION } | ON function_name }
     */
    class OracleSQLIlmInMemoryPolicy extends AbstractOracleSQLExpr implements OracleSQLIlmPolicyClause {
        protected SQLExpr action;
        protected boolean segment;
        protected IlmPolicyOption option;

        @Override
        public void accept0(OracleSQLASTVisitor visitor) {
            if (visitor.visit(this)) {
                this.acceptChild(visitor, action);
                this.acceptChild(visitor, option);
            }
        }

        @Override
        public OracleSQLIlmInMemoryPolicy clone() {
            OracleSQLIlmInMemoryPolicy x = new OracleSQLIlmInMemoryPolicy();

            if (this.action != null) {
                SQLExpr actionClone = this.action.clone();
                x.setAction(actionClone);
            }

            x.segment = this.segment;

            if (this.option != null) {
                IlmPolicyOption optionClone = this.option.clone();
                x.setOption(optionClone);
            }
            return x;
        }

        public SQLExpr getAction() {
            return action;
        }

        public void setAction(SQLExpr action) {
            setChildParent(action);
            this.action = action;
        }

        public boolean isSegment() {
            return segment;
        }

        public void setSegment(boolean segment) {
            this.segment = segment;
        }

        public IlmPolicyOption getOption() {
            return option;
        }

        public void setOption(IlmPolicyOption option) {
            setChildParent(option);
            this.option = option;
        }
    }

    /**
     * SET INMEMORY [ inmemory_attributes ]
     */
    class OracleSQLIlmInMemoryPolicyBySetInMemory extends AbstractOracleSQLExpr {
        protected OracleSQLInMemoryAttributes inMemoryAttributes;

        @Override
        public void accept0(OracleSQLASTVisitor visitor) {
            if (visitor.visit(this)) {
                this.acceptChild(visitor, inMemoryAttributes);
            }
        }

        public OracleSQLInMemoryAttributes getInMemoryAttributes() {
            return inMemoryAttributes;
        }

        public void setInMemoryAttributes(OracleSQLInMemoryAttributes inMemoryAttributes) {
            setChildParent(inMemoryAttributes);
            this.inMemoryAttributes = inMemoryAttributes;
        }
    }

    /**
     * MODIFY INMEMORY inmemory_memcompress
     */
    class OracleSQLIlmInMemoryPolicyByModifyInMemory extends AbstractOracleSQLExpr {
        protected IOracleSQLInMemoryMemCompressClause inMemoryMemCompress;

        @Override
        public void accept0(OracleSQLASTVisitor visitor) {
            if (visitor.visit(this)) {
                this.acceptChild(visitor, inMemoryMemCompress);
            }
        }

        public IOracleSQLInMemoryMemCompressClause getInMemoryMemCompress() {
            return inMemoryMemCompress;
        }

        public void setInMemoryMemCompress(IOracleSQLInMemoryMemCompressClause inMemoryMemCompress) {
            setChildParent(inMemoryMemCompress);
            this.inMemoryMemCompress = inMemoryMemCompress;
        }
    }

    /**
     * NO INMEMORY
     */
    class OracleSQLIlmInMemoryPolicyByNoInMemory extends AbstractOracleSQLExpr {
        @Override
        public void accept0(OracleSQLASTVisitor visitor) {
            visitor.visit(this);
        }

        @Override
        public OracleSQLIlmInMemoryPolicyByNoInMemory clone() {
            return new OracleSQLIlmInMemoryPolicyByNoInMemory();
        }
    }


    interface IlmPolicyOption extends OracleSQLExpr {
        @Override
        IlmPolicyOption clone();
    }

    /**
     * AFTER ilm_time_period OF { NO ACCESS | NO MODIFICATION | CREATION }
     */
    class AfterOfClause extends AbstractOracleSQLExpr implements IlmPolicyOption {
        protected OracleSQLIlmTimePeriod ilmTimePeriod;
        protected OfType ofType;

        @Override
        public void accept0(OracleSQLASTVisitor visitor) {
            if (visitor.visit(this)) {
                this.acceptChild(visitor, ilmTimePeriod);
            }
        }

        @Override
        public AfterOfClause clone() {
            AfterOfClause x = new AfterOfClause();
            OracleSQLIlmTimePeriod ilmTimePeriodClone = this.ilmTimePeriod.clone();
            x.setIlmTimePeriod(ilmTimePeriodClone);

            x.ofType = this.ofType;
            return x;
        }

        public OracleSQLIlmTimePeriod getIlmTimePeriod() {
            return ilmTimePeriod;
        }

        public void setIlmTimePeriod(OracleSQLIlmTimePeriod ilmTimePeriod) {
            this.ilmTimePeriod = ilmTimePeriod;
        }

        public OfType getOfType() {
            return ofType;
        }

        public void setOfType(OfType ofType) {
            this.ofType = ofType;
        }
    }

    enum OfType {
        NO_ACCESS(SQLReserved.NO_ACCESS),
        NO_MODIFICATION(SQLReserved.NO_MODIFICATION),
        CREATION(SQLReserved.CREATION);
        public final SQLReserved name;

        OfType(SQLReserved name) {
            this.name = name;
        }

        @Override
        public String toString() {
            return name.upper;
        }
    }

    /**
     * ON functionName
     */
    class OnClause extends AbstractOracleSQLExpr implements IlmPolicyOption {

        protected SQLName name;

        @Override
        public void accept0(OracleSQLASTVisitor visitor) {
            if (visitor.visit(this)) {
                this.acceptChild(visitor, name);
            }
        }

        @Override
        public OnClause clone() {
            OnClause x = new OnClause();
            SQLName nameClone = this.name.clone();
            x.setName(nameClone);
            return x;
        }

        public SQLName getName() {
            return name;
        }

        public String getFunctionName() {
            if (name != null) {
                return name.getName();
            }
            return null;
        }

        public void setName(SQLName name) {
            setChildParent(name);
            this.name = name;
        }
    }


    enum SQLSegmentType {
        SEGMENT(SQLReserved.SEGMENT),
        GROUP(SQLReserved.GROUP),;
        public SQLReserved name;

        SQLSegmentType(SQLReserved name) {
            this.name = name;
        }

        @Override
        public String toString() {
            return name.upper;
        }
    }
}
