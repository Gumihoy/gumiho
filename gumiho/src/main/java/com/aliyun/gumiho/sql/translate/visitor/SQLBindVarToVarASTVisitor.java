package com.aliyun.gumiho.sql.translate.visitor;

import com.aliyun.gumiho.sql.basic.ast.element.expr.SQLBindVariableExpr;
import com.aliyun.gumiho.sql.basic.ast.element.expr.SQLVariableExpr;
import com.aliyun.gumiho.sql.translate.SQLTransformConfig;
import com.aliyun.gumiho.sql.util.SQLUtils;

/**
 * bindVar -> var (:xxx -> ?)
 *
 * @author kongtong.ouyang on 2018/5/18.
 */
public class SQLBindVarToVarASTVisitor extends SQLASTTransformVisitor {

    public SQLBindVarToVarASTVisitor() {
    }

    public SQLBindVarToVarASTVisitor(SQLTransformConfig config) {
        super(config);
    }

    @Override
    public boolean visit(SQLBindVariableExpr x) {
        SQLVariableExpr target = new SQLVariableExpr();
        SQLUtils.replaceInParent(x, target);
        return true;
    }
}
