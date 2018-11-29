package com.aliyun.gumiho.sql.basic.ast.element.hint;

/**
 * USE {INDEX|KEY} [FOR {JOIN|ORDER BY|GROUP BY}] ([index_list])
 * | IGNORE {INDEX|KEY} [FOR {JOIN|ORDER BY|GROUP BY}] (index_list)
 * | FORCE {INDEX|KEY} [FOR {JOIN|ORDER BY|GROUP BY}] (index_list)
 * <p>
 * https://dev.mysql.com/doc/refman/5.7/en/index-hints.html
 * https://dev.mysql.com/doc/refman/5.7/en/join.html
 *
 * @author kongtong.ouyang on 2018/8/28.
 */
public interface SQLIndexHint extends SQLHint {
    @Override
    SQLIndexHint clone();
}
