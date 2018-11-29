package com.aliyun.gumiho.sql.basic.ast.element.expr.table;

import com.aliyun.gumiho.sql.basic.ast.element.expr.SQLExpr;

/**
 * FLASHBACK ARCHIVE [flashback_archive] | NO FLASHBACK ARCHIVE
 *
 *
 * flashback_archive_clause
 * https://docs.oracle.com/en/database/oracle/oracle-database/18/sqlrf/CREATE-TABLE.html#GUID-F9CE0CC3-13AE-4744-A43C-EAC7A71AAAB6
 * @author kongtong.ouyang on 2018/7/10.
 */
public interface ISQLFlashbackArchiveClause extends SQLExpr {

    @Override
    ISQLFlashbackArchiveClause clone();
}
