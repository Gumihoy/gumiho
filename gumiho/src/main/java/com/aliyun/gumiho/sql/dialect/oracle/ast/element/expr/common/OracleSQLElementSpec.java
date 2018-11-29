package com.aliyun.gumiho.sql.dialect.oracle.ast.element.expr.common;

import com.aliyun.gumiho.sql.basic.ast.element.expr.SQLExpr;
import com.aliyun.gumiho.sql.basic.ast.enums.ISQLEnum;
import com.aliyun.gumiho.sql.basic.ast.enums.SQLReserved;
import com.aliyun.gumiho.sql.dialect.oracle.ast.element.expr.AbstractOracleSQLExpr;
import com.aliyun.gumiho.sql.dialect.oracle.ast.element.expr.OracleSQLExpr;
import com.aliyun.gumiho.sql.dialect.oracle.visitor.OracleSQLASTVisitor;

import java.util.ArrayList;
import java.util.List;

/**
 * [ inheritance_clauses ] { subprogram_spec | constructor_spec | map_order_function_spec }... [, restrict_references_pragma ]
 * https://docs.oracle.com/en/database/oracle/oracle-database/18/lnpls/element-specification.html#GUID-20D95D8A-5C17-4C89-9AAB-1852CDB57CE2
 *
 * @author kongtong.ouyang on 2018/4/26.
 */
public class OracleSQLElementSpec extends AbstractOracleSQLExpr {

    protected final List<OracleSQLInheritanceType> inheritances = new ArrayList<>();

    protected final List<SQLExpr> items = new ArrayList<>();

    protected OracleSQLRestrictReferencesPragma restrictReferencesPragma;

    @Override
    public void accept0(OracleSQLASTVisitor visitor) {
        if (visitor.visit(this)) {
            this.acceptChild(visitor, items);
            this.acceptChild(visitor, restrictReferencesPragma);
        }
    }

    public List<OracleSQLInheritanceType> getInheritances() {
        return inheritances;
    }

    public void addInheritance(OracleSQLInheritanceType inheritance) {
        if (inheritance == null) {
            return;
        }
        this.inheritances.add(inheritance);
    }

    public List<SQLExpr> getItems() {
        return items;
    }

    public void addItem(SQLExpr item) {
        if (item == null) {
            return;
        }
        setChildParent(item);
        items.add(item);
    }

    public OracleSQLRestrictReferencesPragma getRestrictReferencesPragma() {
        return restrictReferencesPragma;
    }

    public void setRestrictReferencesPragma(OracleSQLRestrictReferencesPragma restrictReferencesPragma) {
        setChildParent(restrictReferencesPragma);
        this.restrictReferencesPragma = restrictReferencesPragma;
    }


    /**
     * EXTERNAL { VARIABLE NAME 'java_static_field_name' | NAME 'java_method_sig'}
     *
     * sqlj_object_type_sig
     * https://docs.oracle.com/database/121/LNPLS/create_type.htm#LNPLS01375
     */
    public interface ISQLExternalNameClause extends OracleSQLExpr {
        @Override
        ISQLExternalNameClause clone();
    }

    /**
     * EXTERNAL { VARIABLE NAME 'java_static_field_name' | NAME 'java_method_sig'}
     * sqlj_object_type_sig
     * https://docs.oracle.com/database/121/LNPLS/create_type.htm#LNPLS01375
     */
    public static abstract class AbstractSQLExternalNameClause extends AbstractOracleSQLExpr implements ISQLExternalNameClause {
        protected SQLExpr name;

        @Override
        public AbstractSQLExternalNameClause clone() {
            throw new UnsupportedOperationException(getClass().getName());
        }

        public void cloneTo(AbstractSQLExternalNameClause x) {
            super.cloneTo(x);
            SQLExpr nameClone = this.name.clone();
            x.setName(nameClone);
        }

        public SQLExpr getName() {
            return name;
        }

        public void setName(SQLExpr name) {
            setChildParent(name);
            this.name = name;
        }
    }


    /**
     * EXTERNAL NAME 'java_method_sig' { VARIABLE NAME 'java_static_field_name'
     */
    public static class SQLExternalNameClause extends AbstractSQLExternalNameClause {

        @Override
        public void accept0(OracleSQLASTVisitor visitor) {
            if (visitor.visit(this)) {
                this.acceptChild(visitor, name);
            }
        }

        @Override
        public SQLExternalNameClause clone() {
            SQLExternalNameClause x = new SQLExternalNameClause();
            this.cloneTo(x);
            return x;
        }

    }


    /**
     * EXTERNAL VARIABLE NAME 'java_static_field_name'
     */
    public static class SQLExternalVariableNameClause extends AbstractSQLExternalNameClause {
        @Override
        public void accept0(OracleSQLASTVisitor visitor) {
            if (visitor.visit(this)) {
                this.acceptChild(visitor, name);
            }
        }

        @Override
        public SQLExternalVariableNameClause clone() {
            SQLExternalVariableNameClause x = new SQLExternalVariableNameClause();
            this.cloneTo(x);
            return x;
        }

    }

    /**
     * https://docs.oracle.com/en/database/oracle/oracle-database/18/lnpls/element-specification.html#GUID-20D95D8A-5C17-4C89-9AAB-1852CDB57CE2
     */
    public enum OracleSQLInheritanceType implements ISQLEnum {

        OVERRIDING(SQLReserved.OVERRIDING),
        FINAL(SQLReserved.FINAL),
        INSTANTIABLE(SQLReserved.INSTANTIABLE),
        NOT_OVERRIDING(SQLReserved.NOT_OVERRIDING),
        NOT_FINAL(SQLReserved.NOT_FINAL),
        NOT_INSTANTIABLE(SQLReserved.NOT_INSTANTIABLE),;

        public final SQLReserved name;

        OracleSQLInheritanceType(SQLReserved name) {
            this.name = name;
        }

        @Override
        public String toString() {
            return name.upper;
        }

        @Override
        public SQLReserved getName() {
            return name;
        }
    }


}
