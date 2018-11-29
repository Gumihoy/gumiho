package com.aliyun.gumiho.sql.dialect.oracle.ast.element.expr.common;

import com.aliyun.gumiho.sql.basic.ast.element.expr.ISQLLobParameter;
import com.aliyun.gumiho.sql.basic.ast.element.expr.SQLEncryptionSpec;
import com.aliyun.gumiho.sql.dialect.oracle.ast.element.expr.AbstractOracleSQLExpr;
import com.aliyun.gumiho.sql.dialect.oracle.visitor.OracleSQLASTVisitor;

/**
 * ENCRYPT encryption_spec
 * https://docs.oracle.com/en/database/oracle/oracle-database/18/sqlrf/CREATE-TABLE.html#GUID-F9CE0CC3-13AE-4744-A43C-EAC7A71AAAB6
 *
 * @author kongtong.ouyang on 2018/6/22.
 */
public class OracleSQLLobParameterEncrypt extends AbstractOracleSQLExpr implements ISQLLobParameter {

    protected SQLEncryptionSpec encryptionSpec;


    @Override
    public void accept0(OracleSQLASTVisitor visitor) {
        if (visitor.visit(this)) {
            this.acceptChild(visitor, encryptionSpec);
        }
    }

    @Override
    public OracleSQLLobParameterEncrypt clone() {
        OracleSQLLobParameterEncrypt x = new OracleSQLLobParameterEncrypt();
        SQLEncryptionSpec encryptionSpecClone = this.encryptionSpec.clone();
        x.setEncryptionSpec(encryptionSpecClone);
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
