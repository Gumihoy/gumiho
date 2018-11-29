package com.aliyun.gumiho.sql.translate.visitor.oracle2.ppas;

import com.aliyun.gumiho.sql.basic.ast.element.identifier.SQLDoubleQuoteIdentifier;
import com.aliyun.gumiho.sql.basic.ast.element.identifier.SQLIdentifierImpl;
import com.aliyun.gumiho.sql.translate.visitor.SQLASTTransformVisitor;
import com.aliyun.gumiho.sql.translate.SQLTransformConfig;
import com.aliyun.gumiho.sql.util.SQLUtils;

/**
 * Remove Double Quotes
 * 1、有小写字母保留双引号
 * 2、数字开头保留双引号
 * 3、特殊字符保留双引号
 *
 * @author kongtong.ouyang on 2018/5/18.
 */
public class Oracle2PPASSQLMixRemoveDoubleQuotesASTVisitor extends SQLASTTransformVisitor {

    public Oracle2PPASSQLMixRemoveDoubleQuotesASTVisitor() {
    }

    public Oracle2PPASSQLMixRemoveDoubleQuotesASTVisitor(SQLTransformConfig config) {
        super(config);
    }

    @Override
    public boolean visit(SQLDoubleQuoteIdentifier x) {
        String name = x.getName();

        if (SQLUtils.isStartWithNumber(name)
                || SQLUtils.containsSpecialCharacter(name)
                || SQLUtils.hasLowerLetter(name)) {
            return true;
        }

        SQLIdentifierImpl target = new SQLIdentifierImpl(name);
        boolean replace = SQLUtils.replaceInParent(x, target);
        if (replace) {

        }
        return true;
    }


}
