package com.aliyun.gumiho.sql.basic.ast.element.expr;

import com.aliyun.gumiho.sql.basic.visitor.SQLASTVisitor;

/**
 * ENCRYPT [encryption_spec]
 * <p>
 * https://docs.oracle.com/en/database/oracle/oracle-database/18/sqlrf/CREATE-TABLE.html#GUID-F9CE0CC3-13AE-4744-A43C-EAC7A71AAAB6
 * https://docs.oracle.com/en/database/oracle/oracle-database/18/sqlrf/ALTER-TABLE.html#GUID-552E7373-BF93-477D-9DA3-B2C9386F2877
 *
 * @author kongtong.ouyang on 2018/6/25.
 */
public class SQLEncryptClause extends AbstractSQLExpr {

    protected SQLEncryptionSpec encryptionSpec;

    @Override
    protected void accept0(SQLASTVisitor visitor) {
        if (visitor.visit(this)) {
            this.acceptChild(visitor, encryptionSpec);
        }
    }

    @Override
    public SQLEncryptClause clone() {
        SQLEncryptClause x = new SQLEncryptClause();

        if (this.encryptionSpec != null) {
            SQLEncryptionSpec encryptionSpecClone = this.encryptionSpec.clone();
            x.setEncryptionSpec(encryptionSpecClone);
        }
        return x;
    }

    public SQLEncryptionSpec getEncryptionSpec() {
        return encryptionSpec;
    }

    public void setEncryptionSpec(SQLEncryptionSpec encryptionSpec) {
        setChildParent(encryptionSpec);
        this.encryptionSpec = encryptionSpec;
    }
}
