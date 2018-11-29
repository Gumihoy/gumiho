package com.aliyun.gumiho.sql.basic.ast.element.expr;

import com.aliyun.gumiho.sql.basic.ast.enums.SQLReserved;
import com.aliyun.gumiho.sql.basic.visitor.SQLASTVisitor;

/**
 * [ USING 'encrypt_algorithm' ] [ IDENTIFIED BY password ] [ 'integrity_algorithm' ] [ [ NO ] SALT ]
 * encryption_spec
 * https://docs.oracle.com/en/database/oracle/oracle-database/18/sqlrf/CREATE-TABLE.html#GUID-F9CE0CC3-13AE-4744-A43C-EAC7A71AAAB6
 *
 * @author kongtong.ouyang on 2018/6/22.
 */
public class SQLEncryptionSpec extends AbstractSQLExpr {

    protected SQLExpr encrypt;
    protected SQLExpr password;
    protected SQLExpr integrity;

    protected SQLSaltType saltType;

    @Override
    public void accept0(SQLASTVisitor visitor) {
        if (visitor.visit(this)) {
            this.acceptChild(visitor, encrypt);
            this.acceptChild(visitor, password);
            this.acceptChild(visitor, integrity);
        }
    }

    @Override
    public SQLEncryptionSpec clone() {
        SQLEncryptionSpec x = new SQLEncryptionSpec();

        if (this.encrypt != null) {
            SQLExpr encryptClone = this.encrypt.clone();
            x.setEncrypt(encryptClone);
        }

        if (this.password != null) {
            SQLExpr passwordClone = this.password.clone();
            x.setPassword(passwordClone);
        }

        if (this.integrity != null) {
            SQLExpr integrityClone = this.integrity.clone();
            x.setIntegrity(integrityClone);
        }

        x.saltType = this.saltType;
        return x;
    }

    @Override
    public boolean replace(SQLExpr source, SQLExpr target) {
        if (source == encrypt) {
            setEncrypt(target);
            return true;
        }

        if (source == password) {
            setPassword(target);
            return true;
        }

        if (source == integrity) {
            setIntegrity(target);
            return true;
        }
        return false;
    }

    public SQLExpr getEncrypt() {
        return encrypt;
    }

    public void setEncrypt(SQLExpr encrypt) {
        setChildParent(encrypt);
        this.encrypt = encrypt;
    }

    public SQLExpr getPassword() {
        return password;
    }

    public void setPassword(SQLExpr password) {
        setChildParent(password);
        this.password = password;
    }

    public SQLExpr getIntegrity() {
        return integrity;
    }

    public void setIntegrity(SQLExpr integrity) {
        setChildParent(integrity);
        this.integrity = integrity;
    }

    public SQLSaltType getSaltType() {
        return saltType;
    }

    public void setSaltType(SQLSaltType saltType) {
        this.saltType = saltType;
    }

    public enum SQLSaltType {
        SALT(SQLReserved.SALT),
        NO_SALT(SQLReserved.NO_SALT),;
        public final SQLReserved name;

        SQLSaltType(SQLReserved name) {
            this.name = name;
        }

        @Override
        public String toString() {
            return name.upper;
        }
    }
}
