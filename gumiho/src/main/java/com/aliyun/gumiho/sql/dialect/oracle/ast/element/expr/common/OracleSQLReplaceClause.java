package com.aliyun.gumiho.sql.dialect.oracle.ast.element.expr.common;

import com.aliyun.gumiho.sql.basic.ast.element.expr.SQLAttributeDefinition;
import com.aliyun.gumiho.sql.basic.ast.element.expr.SQLExpr;
import com.aliyun.gumiho.sql.dialect.oracle.ast.element.expr.AbstractOracleSQLExpr;
import com.aliyun.gumiho.sql.dialect.oracle.visitor.OracleSQLASTVisitor;

import java.util.ArrayList;
import java.util.List;

/**
 * REPLACE
 * [ invoker_rights_clause [ accessible_by_clause ] |
 * accessible_by_clause | invoker_rights_clause ] ]
 * AS OBJECT  ( attribute datatype [, attribute datatype ]...
 * [, element_spec [, element_spec ]... ] )
 * <p>
 * type_replace_clause
 * https://docs.oracle.com/en/database/oracle/oracle-database/18/lnpls/ALTER-TYPE-statement.html#GUID-A8B449E7-E3A8-48F4-A4C6-5BB87B1841CD
 *
 * @author kongtong.ouyang on 2018/9/11.
 */
public class OracleSQLReplaceClause extends AbstractOracleSQLExpr {

    protected final List<SQLExpr> options = new ArrayList<>();
    protected final List<SQLExpr> items = new ArrayList<>();


    @Override
    public void accept0(OracleSQLASTVisitor visitor) {

    }

    @Override
    public OracleSQLReplaceClause clone() {
        OracleSQLReplaceClause x = new OracleSQLReplaceClause();
        return x;
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
}
