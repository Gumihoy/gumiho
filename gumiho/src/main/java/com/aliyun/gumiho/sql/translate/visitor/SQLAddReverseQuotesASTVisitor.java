package com.aliyun.gumiho.sql.translate.visitor;

import com.aliyun.gumiho.sql.basic.ast.SQLObject;
import com.aliyun.gumiho.sql.basic.ast.element.datatype.SQLDataType;
import com.aliyun.gumiho.sql.basic.ast.element.expr.SQLExpr;
import com.aliyun.gumiho.sql.basic.ast.element.expr.select.SQLObjectNameTableReference;
import com.aliyun.gumiho.sql.basic.ast.element.function.SQLMethodInvocation;
import com.aliyun.gumiho.sql.basic.ast.element.identifier.SQLDBLinkExpr;
import com.aliyun.gumiho.sql.basic.ast.element.identifier.SQLDoubleQuoteIdentifier;
import com.aliyun.gumiho.sql.basic.ast.element.identifier.SQLIdentifierImpl;
import com.aliyun.gumiho.sql.basic.ast.element.identifier.SQLReverseQuoteIdentifier;
import com.aliyun.gumiho.sql.basic.ast.enums.SQLReserved;
import com.aliyun.gumiho.sql.translate.SQLTransformConfig;
import com.aliyun.gumiho.sql.util.SQLUtils;

import java.util.List;

/**
 * Add Reverse visitor
 * 添加 反引号(`)
 *
 * @author kongtong.ouyang on 2018/5/18.
 */
public class SQLAddReverseQuotesASTVisitor extends SQLASTTransformVisitor {

    public SQLAddReverseQuotesASTVisitor() {
    }

    public SQLAddReverseQuotesASTVisitor(SQLTransformConfig config) {
        super(config);
    }

    @Override
    public boolean visit(SQLDoubleQuoteIdentifier x) {
        SQLReverseQuoteIdentifier target = new SQLReverseQuoteIdentifier(x.getName());
        boolean replace = SQLUtils.replaceInParent(x, target);
        return true;
    }

    @Override
    public boolean visit(SQLIdentifierImpl x) {
        long nameLowerHash = x.lowerHash();
        SQLObject parent = x.getParent();

        // 数据类型
        if ((parent instanceof SQLDataType
                && ((SQLDataType) parent).getNameExpr() == x)) {
            return true;
        }

        // 方法
        // 1. 方法name
        // 2. mysql Funciton TIMESTAMPADD/TIMESTAMPDIFF 参数
        if (parent instanceof SQLMethodInvocation) {
            SQLMethodInvocation method = (SQLMethodInvocation) parent;
            List<SQLExpr> arguments = method.getArguments();
            int size = arguments.size();

            long methodNameLowerHash = method.lowerHash();
            if (method.getNameExpr() == x) {
                return true;
            }
        }

        // mysql 中 表名 dual 不能加
        if (nameLowerHash == SQLReserved.DUAL.lowerHashCode64
                && parent instanceof SQLObjectNameTableReference) {
            return true;
        }

        // DBLink 不能加
        if (parent instanceof SQLDBLinkExpr) {
            return true;
        }

        SQLReverseQuoteIdentifier target = new SQLReverseQuoteIdentifier(x.getName());
        boolean replace = SQLUtils.replaceInParent(x, target);
        return true;
    }

}
