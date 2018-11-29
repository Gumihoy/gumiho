/*
 * Copyright (C) 2017-2018 kent(kent.bohai@gmail.com).
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.aliyun.gumiho.sql.bvt.dialect.oracle.ddl.tyepbody.create;

import com.aliyun.gumiho.sql.enums.DBType;
import com.aliyun.gumiho.sql.util.SQLUtils;
import org.junit.Assert;
import org.junit.Test;

/**
 * @author kongtong.ouyang on 2018/3/15.
 */
public class OracleCreateTypeBodyTest_2 {

    @Test
    public void test() {
        String s = "CREATE TYPE BODY \"af\".\"rational\"\n" +
                "  IS\n" +
                "   MAP MEMBER FUNCTION rat_to_real RETURN REAL IS\n" +
                "      BEGIN\n" +
                "         RETURN numerator/denominator;\n" +
                "      END;\n" +
                "\n" +
                "   MEMBER PROCEDURE normalize IS\n" +
                "      gcd NUMBER := integer_operations.greatest_common_divisor\n" +
                "                     (numerator, denominator);\n" +
                "      BEGIN\n" +
                "         numerator := numerator/gcd;\n" +
                "         denominator := denominator/gcd;\n" +
                "      END;\n" +
                "\n" +
                "   MEMBER FUNCTION plus(x rational) RETURN rational IS\n" +
                "      r rational := rational_operations.make_rational\n" +
                "                      (numerator*x.denominator +\n" +
                "                       x.numerator*denominator,\n" +
                "                       denominator*x.denominator);\n" +
                "      BEGIN\n" +
                "         RETURN r;\n" +
                "      END;\n" +
                "\n" +
                "   END;";


        String formatSQL = SQLUtils.format(s, DBType.Oracle);
        System.out.println(s);
        System.out.println("------------------");
        System.out.println(formatSQL);
        Assert.assertEquals("CREATE TYPE BODY \"af\".\"rational\" IS\n" +
                "\tMAP MEMBER FUNCTION rat_to_real RETURN REAL IS\n" +
                "\t\tBEGIN\n" +
                "\t\t\tRETURN numerator / denominator;\n" +
                "\t\tEND;\n" +
                "\tMEMBER PROCEDURE normalize IS\n" +
                "\t\tgcd NUMBER := integer_operations.greatest_common_divisor(numerator, denominator);\n" +
                "\t\tBEGIN\n" +
                "\t\t\tnumerator := numerator / gcd;\n" +
                "\t\t\tdenominator := denominator / gcd;\n" +
                "\t\tEND;\n" +
                "\tMEMBER FUNCTION plus (\n" +
                "\t\tx rational\n" +
                "\t) RETURN rational IS\n" +
                "\t\tr rational := rational_operations.make_rational(numerator * x.denominator + x.numerator * denominator, denominator * x.denominator);\n" +
                "\t\tBEGIN\n" +
                "\t\t\tRETURN r;\n" +
                "\t\tEND;\n" +
                "END;", formatSQL);
    }
}
