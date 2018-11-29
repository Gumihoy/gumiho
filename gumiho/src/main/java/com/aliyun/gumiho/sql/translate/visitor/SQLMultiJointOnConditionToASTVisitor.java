package com.aliyun.gumiho.sql.translate.visitor;

import com.aliyun.gumiho.sql.basic.ast.element.expr.select.SQLJoinTableReference;
import com.aliyun.gumiho.sql.translate.SQLTransformConfig;

import java.util.List;

/**
 * xx Join yy Join zz On condition ON condition => xx Join yy On condition Join zz On condition
 *
 * @author kongtong.ouyang on 2018/5/18.
 */
public class SQLMultiJointOnConditionToASTVisitor extends SQLASTTransformVisitor {

    public SQLMultiJointOnConditionToASTVisitor() {
    }

    public SQLMultiJointOnConditionToASTVisitor(SQLTransformConfig config) {
        super(config);
    }


    @Override
    public boolean visit(SQLJoinTableReference x) {
        if (x.getConditions() != null
                && x.getConditions().size() > 1) {
            List<SQLJoinTableReference.ISQLJoinCondition> onConditions = x.getConditions();

        }
        return true;
    }


}
