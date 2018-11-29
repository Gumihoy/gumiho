package com.aliyun.gumiho.sql.basic.ast.statement.ddl.packages;

import com.aliyun.gumiho.sql.basic.ast.element.expr.SQLExpr;
import com.aliyun.gumiho.sql.basic.ast.element.expr.SQLSharingClause;
import com.aliyun.gumiho.sql.basic.ast.element.identifier.SQLName;
import com.aliyun.gumiho.sql.basic.ast.enums.SQLASType;
import com.aliyun.gumiho.sql.basic.ast.enums.SQLEditionAbleType;
import com.aliyun.gumiho.sql.basic.ast.statement.AbstractSQLStatement;
import com.aliyun.gumiho.sql.basic.ast.statement.ddl.SQLCreateStatement;
import com.aliyun.gumiho.sql.basic.visitor.SQLASTVisitor;
import com.aliyun.gumiho.sql.enums.DBType;
import com.aliyun.gumiho.sql.enums.SQLObjectType;

import java.util.ArrayList;
import java.util.List;

/**
 * CREATE [ OR REPLACE ] PACKAGE name
 * [ AUTHID { DEFINER | CURRENT_USER } ]
 * { IS | AS }
 * [ declaration; ] [, ...]
 * [ { PROCEDURE proc_name [ (argname [ IN | IN OUT | OUT ] argtype [ DEFAULT value ] [, ...]) ];
 * [ PRAGMA RESTRICT_REFERENCES(name, { RNDS | RNPS | TRUST | WNDS | WNPS } [, ... ] ); ]
 * | FUNCTION func_name [ (argname [ IN | IN OUT | OUT ] argtype [ DEFAULT value ] [, ...]) ] RETURN rettype [ DETERMINISTIC ];
 * [ PRAGMA RESTRICT_REFERENCES(name, { RNDS | RNPS | TRUST | WNDS | WNPS } [, ... ] ); ] } ] [, ...]
 * END [ name ]
 * <p>
 * <p>
 * <p>
 * CREATE [ OR REPLACE ] [ EDITIONABLE | NONEDITIONABLE ]
 * PACKAGE [ schema. ] package_name [ sharing_clause ]
 * [ { default_collation_clause | invoker_rights_clause | accessible_by_clause }... ]
 * { IS | AS }
 * package_item_list
 * END [ package_name ] ;
 * https://docs.oracle.com/en/database/oracle/oracle-database/18/lnpls/CREATE-PACKAGE-statement.html#GUID-03A70A54-90FF-4293-B6B8-F0B35E184AC5
 *
 * @author kongtong.ouyang on 2018/5/31.
 */
public class SQLCreatePackageStatement extends AbstractSQLStatement implements SQLCreateStatement {

    protected boolean orReplace;

    protected SQLEditionAbleType editionAbleType;

    protected SQLName name;

    protected SQLSharingClause sharingClause;

    protected final List<SQLExpr> options = new ArrayList<>();

    protected SQLASType as = SQLASType.AS;

    protected final List<SQLExpr> items = new ArrayList<>();

    protected SQLName endName;

    public SQLCreatePackageStatement(DBType dbType) {
        super(dbType);
    }

    @Override
    protected void accept0(SQLASTVisitor visitor) {
        if (visitor.visit(this)) {
            this.acceptChild(visitor, name);
            this.acceptChild(visitor, sharingClause);
            this.acceptChild(visitor, options);
            this.acceptChild(visitor, items);
            this.acceptChild(visitor, endName);
        }
    }


    @Override
    public boolean replace(SQLExpr source, SQLExpr target) {
        if (source == name) {
            this.setName((SQLName) target);
            return true;
        }

        if (source == endName) {
            this.setEndName((SQLName) target);
            return true;
        }
        return false;
    }

    @Override
    public SQLObjectType getObjectType() {
        return SQLObjectType.CREATE_PACKAGE;
    }



    public boolean isOrReplace() {
        return orReplace;
    }

    public void setOrReplace(boolean orReplace) {
        this.orReplace = orReplace;
    }

    public SQLEditionAbleType getEditionAbleType() {
        return editionAbleType;
    }

    public void setEditionAbleType(SQLEditionAbleType editionAbleType) {
        this.editionAbleType = editionAbleType;
    }

    public SQLName getName() {
        return name;
    }

    public String getPackgeName() {
        return name.getName();
    }

    public void setName(SQLName name) {
        setChildParent(name);
        this.name = name;
    }

    public SQLSharingClause getSharingClause() {
        return sharingClause;
    }

    public void setSharingClause(SQLSharingClause sharingClause) {
        this.sharingClause = sharingClause;
    }

    public List<SQLExpr> getOptions() {
        return options;
    }

    public void addOption(SQLExpr option) {
        if (option == null) {
            return;
        }
        setChildParent(option);
        this.options.add(option);
    }

    public SQLASType getAs() {
        return as;
    }

    public void setAs(SQLASType as) {
        this.as = as;
    }

    public List<SQLExpr> getItems() {
        return items;
    }

    public void addItem(SQLExpr item) {
        if (item == null) {
            return;
        }
        setChildParent(item);
        this.items.add(item);
    }

    public SQLName getEndName() {
        return endName;
    }

    public void setEndName(SQLName endName) {
        this.endName = endName;
    }

}
