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
package com.aliyun.gumiho.sql.bvt.dialect.oracle.ddl.view.create;

import com.aliyun.gumiho.sql.enums.DBType;
import com.aliyun.gumiho.sql.util.SQLUtils;
import org.junit.Assert;
import org.junit.Test;

/**
 * @author kongtong.ouyang on 2018/3/15.
 */
public class OracleCreateViewTest_0 {

    @Test
    public void test_0() {
        String s = "CREATE OR REPLACE VIEW emp_view AS \n" +
                "   SELECT last_name, salary*12 annual_salary\n" +
                "   FROM employees \n" +
                "   WHERE department_id = 20; ";


        String formatSQL = SQLUtils.format(s, DBType.Oracle);
        System.out.println(s);
        System.out.println("------------------");
        System.out.println(formatSQL);
        Assert.assertEquals("CREATE OR REPLACE VIEW emp_view\n" +
                "AS\n" +
                "\tSELECT last_name, salary * 12 annual_salary\n" +
                "\tFROM employees\n" +
                "\tWHERE department_id = 20;", formatSQL);
    }


    @Test
    public void test_1() {
        String s = "CREATE OR REPLACE VIEW \"LC0019999\".\"VIEW_COSTCENTERPRODUCT\" (\"CCRRCODE\", \"CCRRNAME\", \"CCRRID\", \"CCNAME\", \"CCCODE\", \"CCBID\", \"UNITCODE\", \"UNITNAME\", \"MATERIALID\", \"MATERIALCODE\", \"MATERIALNAME\", \"MATERIALENGNAME\", \"KEYWORD\", \"BARCODE\", \"SPECS\", \"DIVISIONID\", \"KIND\", \"MATERIALSORTID\", \"MATERIALSORTPATH\", \"PRIMARYUNITID\", \"SECONDARYUNITID\", \"SALESUNITID\", \"SECSALESUNITID\", \"IMUNITID\", \"SECIMUNITID\", \"PURUNITID\", \"SECPURUNITID\", \"ARUNITID\", \"SECARUNITID\", \"APUNITID\", \"SECAPUNITID\", \"PRIMARYPRECISION\", \"SECONDARYPRECISION\", \"MATERIALNOTE\", \"REPORTUNITID\", \"EACHWEIGHT\", \"WEIGHTUNITID\", \"EACHVOLUME\", \"VOLUMEUNITID\", \"CUSTOMFIELD1\", \"CUSTOMFIELD2\", \"CUSTOMFIELD3\", \"CUSTOMFIELD4\", \"CUSTOMFIELD5\", \"CUSTOMFIELD6\", \"CUSTOMFIELD7\", \"CUSTOMFIELD8\", \"MATERIALTYPEID\", \"ISPURCHASE\", \"ISINVENTORY\", \"ISSALES\", \"ISSERIALMGR\", \"STOPFLAG\", \"STOPDATE\", \"CREATECOMPANYID\", \"MATERIALCREATEDATE\", \"MATERIALCREATOR\", \"MVFIELD1\", \"MVFIELD2\", \"MVFIELD3\", \"MVFIELD4\", \"MVFIELD5\", \"ISATTACHED\", \"PRISECCONVRATE\", \"SALESPRECISION\", \"SECSALESPRECISION\", \"PRISALESCONVRATE\", \"PRISALESCOMPFLAG\", \"SECSALESCONVRATE\", \"SECSALESCOMPFLAG\", \"IMPRECISION\", \"SECIMPRECISION\", \"PRIIMCONVRATE\", \"PRIIMCOMPFLAG\", \"SECIMCONVRATE\", \"SECIMCOMPFLAG\", \"PURPRECISION\", \"SECPURPRECISION\", \"PRIPURCONVRATE\", \"PRIPURCOMPFLAG\", \"SECPURCONVRATE\", \"SECPURCOMPFLAG\", \"REPORTPRECISION\", \"PRIREPORTCONVRATE\", \"PRIREPORTCOMPFLAG\", \"CONVERSIONFLAG\", \"CTUNITID\", \"FFSCHEMAID\", \"CCID\", \"PID\", \"FLEXFIELD1\", \"FLEXFIELD2\", \"FLEXFIELD3\", \"FLEXFIELD4\", \"FLEXFIELD5\", \"FLEXFIELD1NAME\", \"FLEXFIELD2NAME\", \"FLEXFIELD3NAME\", \"FLEXFIELD4NAME\", \"FLEXFIELD5NAME\", \"FLEXFIELD2CODE\", \"FLEXFIELD1CODE\", \"FLEXFIELD3CODE\", \"FLEXFIELD4CODE\", \"FLEXFIELD5CODE\", \"CCRRGAME\", \"PERIOD\", \"RECQTY\", \"INITIALQTY\", \"INITIALCOST\", \"INPUTQTY\", \"INPUTCOST\", \"BATCHNUMCODE\", \"RECCOST\", \"BALANCEQTY\", \"BALANCECOST\", \"CCRRSTATE\") AS\n" +
                "    SELECT     CCRecoveryRange.CCRRCode, CCRecoveryRange.CCRRName, CCRecoveryRangeCC.CCRRID, CCCostCenter.CCName,\n" +
                "    CCCostCenter.CCCode, CCBill.CCBID, MeasureUnits.UnitCode, MeasureUnits.UnitName, Materials.MaterialID,\n" +
                "    Materials.MaterialCode, Materials.MaterialName, Materials.MaterialEngName, Materials.KeyWord,\n" +
                "    Materials.BarCode, Materials.Specs, Materials.DivisionID, Materials.Kind, Materials.MaterialSortID,\n" +
                "    Materials.MaterialSortPath, Materials.PrimaryUnitID, Materials.SecondaryUnitID, Materials.SalesUnitID,\n" +
                "    Materials.SecSalesUnitID, Materials.IMUnitID, Materials.SecIMUnitID, Materials.PurUnitID,\n" +
                "    Materials.SecPurUnitID, Materials.ARUnitID, Materials.SecARUnitID, Materials.APUnitID, Materials.SecAPUnitID,\n" +
                "    Materials.PrimaryPrecision, Materials.SecondaryPrecision, Materials.MaterialNote, Materials.ReportUnitID,\n" +
                "    Materials.EachWeight, Materials.WeightUnitID, Materials.EachVolume, Materials.VolumeUnitID,\n" +
                "    Materials.CustomField1, Materials.CustomField2, Materials.CustomField3, Materials.CustomField4,\n" +
                "    Materials.CustomField5, Materials.CustomField6, Materials.CustomField7, Materials.CustomField8,\n" +
                "    Materials.MaterialTypeID, Materials.IsPurchase, Materials.IsInventory, Materials.IsSales, Materials.IsSerialMgr,\n" +
                "    Materials.StopFlag, Materials.StopDate, Materials.CreateCompanyID, Materials.MaterialCreateDate,\n" +
                "    Materials.MaterialCreator, Materials.MVField1, Materials.MVField2, Materials.MVField3, Materials.MVField4,\n" +
                "    Materials.MVField5, Materials.IsAttached, Materials.PriSecConvRate, Materials.SalesPrecision,\n" +
                "    Materials.SecSalesPrecision, Materials.PriSalesConvRate, Materials.PriSalesCompFlag, Materials.SecSalesConvRate,\n" +
                "    Materials.SecSalesCompFlag, Materials.IMPrecision, Materials.SecIMPrecision, Materials.PriIMConvRate,\n" +
                "    Materials.PriIMCompFlag, Materials.SecIMConvRate, Materials.SecIMCompFlag, Materials.PurPrecision,\n" +
                "    Materials.SecPurPrecision, Materials.PriPurConvRate, Materials.PriPurCompFlag, Materials.SecPurConvRate,\n" +
                "    Materials.SecPurCompFlag, Materials.ReportPrecision, Materials.PriReportConvRate, Materials.PriReportCompFlag,\n" +
                "    Materials.ConversionFlag, Materials.CTUnitID, Materials.FFSchemaID, CCRecoveryRangeCC.CCID, CCBill.PID,\n" +
                "    CCBill.FlexField1, CCBill.FlexField2, CCBill.FlexField3, CCBill.FlexField4, CCBill.FlexField5,\n" +
                "    CCBill.FlexField1Name, CCBill.FlexField2Name, CCBill.FlexField3Name, CCBill.FlexField4Name,\n" +
                "    CCBill.FlexField5Name, CCBill.FlexField2Code, CCBill.FlexField1Code, CCBill.FlexField3Code,\n" +
                "    CCBill.FlexField4Code, CCBill.FlexField5Code, CCRecoveryRange.CCRRGame, CCBill.Period, CCBill.RecQty,\n" +
                "    CCBill.InitialQty, CCBill.InitialCost, CCBill.InputQty, CCBill.InputCost, CCBill.BatchNumCode,\n" +
                "    CCBill.RecCost, CCBill.BalanceQty, CCBill.BalanceCost,CCRecoveryRange.CCRRSTATE\n" +
                "    FROM         CCRecoveryRange LEFT OUTER JOIN\n" +
                "    CCRecoveryRangeCC INNER JOIN\n" +
                "    CCCostCenter ON CCRecoveryRangeCC.CCID = CCCostCenter.CCID LEFT OUTER JOIN\n" +
                "    CCBill INNER JOIN\n" +
                "    Materials ON CCBill.PID = Materials.MaterialID LEFT JOIN\n" +
                "    MeasureUnits ON Materials.CTUnitID = MeasureUnits.UnitID ON CCRecoveryRangeCC.CCID = CCBill.CCID ON\n" +
                "    CCRecoveryRange.CCRRID = CCRecoveryRangeCC.CCRRID";


        String formatSQL = SQLUtils.format(s, DBType.Oracle);
        System.out.println(s);
        System.out.println("------------------");
        System.out.println(formatSQL);
        Assert.assertEquals("CREATE OR REPLACE VIEW \"LC0019999\".\"VIEW_COSTCENTERPRODUCT\" (\n" +
                "\t\"CCRRCODE\",\n" +
                "\t\"CCRRNAME\",\n" +
                "\t\"CCRRID\",\n" +
                "\t\"CCNAME\",\n" +
                "\t\"CCCODE\",\n" +
                "\t\"CCBID\",\n" +
                "\t\"UNITCODE\",\n" +
                "\t\"UNITNAME\",\n" +
                "\t\"MATERIALID\",\n" +
                "\t\"MATERIALCODE\",\n" +
                "\t\"MATERIALNAME\",\n" +
                "\t\"MATERIALENGNAME\",\n" +
                "\t\"KEYWORD\",\n" +
                "\t\"BARCODE\",\n" +
                "\t\"SPECS\",\n" +
                "\t\"DIVISIONID\",\n" +
                "\t\"KIND\",\n" +
                "\t\"MATERIALSORTID\",\n" +
                "\t\"MATERIALSORTPATH\",\n" +
                "\t\"PRIMARYUNITID\",\n" +
                "\t\"SECONDARYUNITID\",\n" +
                "\t\"SALESUNITID\",\n" +
                "\t\"SECSALESUNITID\",\n" +
                "\t\"IMUNITID\",\n" +
                "\t\"SECIMUNITID\",\n" +
                "\t\"PURUNITID\",\n" +
                "\t\"SECPURUNITID\",\n" +
                "\t\"ARUNITID\",\n" +
                "\t\"SECARUNITID\",\n" +
                "\t\"APUNITID\",\n" +
                "\t\"SECAPUNITID\",\n" +
                "\t\"PRIMARYPRECISION\",\n" +
                "\t\"SECONDARYPRECISION\",\n" +
                "\t\"MATERIALNOTE\",\n" +
                "\t\"REPORTUNITID\",\n" +
                "\t\"EACHWEIGHT\",\n" +
                "\t\"WEIGHTUNITID\",\n" +
                "\t\"EACHVOLUME\",\n" +
                "\t\"VOLUMEUNITID\",\n" +
                "\t\"CUSTOMFIELD1\",\n" +
                "\t\"CUSTOMFIELD2\",\n" +
                "\t\"CUSTOMFIELD3\",\n" +
                "\t\"CUSTOMFIELD4\",\n" +
                "\t\"CUSTOMFIELD5\",\n" +
                "\t\"CUSTOMFIELD6\",\n" +
                "\t\"CUSTOMFIELD7\",\n" +
                "\t\"CUSTOMFIELD8\",\n" +
                "\t\"MATERIALTYPEID\",\n" +
                "\t\"ISPURCHASE\",\n" +
                "\t\"ISINVENTORY\",\n" +
                "\t\"ISSALES\",\n" +
                "\t\"ISSERIALMGR\",\n" +
                "\t\"STOPFLAG\",\n" +
                "\t\"STOPDATE\",\n" +
                "\t\"CREATECOMPANYID\",\n" +
                "\t\"MATERIALCREATEDATE\",\n" +
                "\t\"MATERIALCREATOR\",\n" +
                "\t\"MVFIELD1\",\n" +
                "\t\"MVFIELD2\",\n" +
                "\t\"MVFIELD3\",\n" +
                "\t\"MVFIELD4\",\n" +
                "\t\"MVFIELD5\",\n" +
                "\t\"ISATTACHED\",\n" +
                "\t\"PRISECCONVRATE\",\n" +
                "\t\"SALESPRECISION\",\n" +
                "\t\"SECSALESPRECISION\",\n" +
                "\t\"PRISALESCONVRATE\",\n" +
                "\t\"PRISALESCOMPFLAG\",\n" +
                "\t\"SECSALESCONVRATE\",\n" +
                "\t\"SECSALESCOMPFLAG\",\n" +
                "\t\"IMPRECISION\",\n" +
                "\t\"SECIMPRECISION\",\n" +
                "\t\"PRIIMCONVRATE\",\n" +
                "\t\"PRIIMCOMPFLAG\",\n" +
                "\t\"SECIMCONVRATE\",\n" +
                "\t\"SECIMCOMPFLAG\",\n" +
                "\t\"PURPRECISION\",\n" +
                "\t\"SECPURPRECISION\",\n" +
                "\t\"PRIPURCONVRATE\",\n" +
                "\t\"PRIPURCOMPFLAG\",\n" +
                "\t\"SECPURCONVRATE\",\n" +
                "\t\"SECPURCOMPFLAG\",\n" +
                "\t\"REPORTPRECISION\",\n" +
                "\t\"PRIREPORTCONVRATE\",\n" +
                "\t\"PRIREPORTCOMPFLAG\",\n" +
                "\t\"CONVERSIONFLAG\",\n" +
                "\t\"CTUNITID\",\n" +
                "\t\"FFSCHEMAID\",\n" +
                "\t\"CCID\",\n" +
                "\t\"PID\",\n" +
                "\t\"FLEXFIELD1\",\n" +
                "\t\"FLEXFIELD2\",\n" +
                "\t\"FLEXFIELD3\",\n" +
                "\t\"FLEXFIELD4\",\n" +
                "\t\"FLEXFIELD5\",\n" +
                "\t\"FLEXFIELD1NAME\",\n" +
                "\t\"FLEXFIELD2NAME\",\n" +
                "\t\"FLEXFIELD3NAME\",\n" +
                "\t\"FLEXFIELD4NAME\",\n" +
                "\t\"FLEXFIELD5NAME\",\n" +
                "\t\"FLEXFIELD2CODE\",\n" +
                "\t\"FLEXFIELD1CODE\",\n" +
                "\t\"FLEXFIELD3CODE\",\n" +
                "\t\"FLEXFIELD4CODE\",\n" +
                "\t\"FLEXFIELD5CODE\",\n" +
                "\t\"CCRRGAME\",\n" +
                "\t\"PERIOD\",\n" +
                "\t\"RECQTY\",\n" +
                "\t\"INITIALQTY\",\n" +
                "\t\"INITIALCOST\",\n" +
                "\t\"INPUTQTY\",\n" +
                "\t\"INPUTCOST\",\n" +
                "\t\"BATCHNUMCODE\",\n" +
                "\t\"RECCOST\",\n" +
                "\t\"BALANCEQTY\",\n" +
                "\t\"BALANCECOST\",\n" +
                "\t\"CCRRSTATE\"\n" +
                ")\n" +
                "AS\n" +
                "\tSELECT CCRecoveryRange.CCRRCode, CCRecoveryRange.CCRRName,\n" +
                "\t\tCCRecoveryRangeCC.CCRRID, CCCostCenter.CCName,\n" +
                "\t\tCCCostCenter.CCCode, CCBill.CCBID, MeasureUnits.UnitCode,\n" +
                "\t\tMeasureUnits.UnitName, Materials.MaterialID,\n" +
                "\t\tMaterials.MaterialCode, Materials.MaterialName,\n" +
                "\t\tMaterials.MaterialEngName, Materials.KeyWord, Materials.BarCode,\n" +
                "\t\tMaterials.Specs, Materials.DivisionID, Materials.Kind,\n" +
                "\t\tMaterials.MaterialSortID, Materials.MaterialSortPath,\n" +
                "\t\tMaterials.PrimaryUnitID, Materials.SecondaryUnitID,\n" +
                "\t\tMaterials.SalesUnitID, Materials.SecSalesUnitID,\n" +
                "\t\tMaterials.IMUnitID, Materials.SecIMUnitID, Materials.PurUnitID,\n" +
                "\t\tMaterials.SecPurUnitID, Materials.ARUnitID,\n" +
                "\t\tMaterials.SecARUnitID, Materials.APUnitID, Materials.SecAPUnitID,\n" +
                "\t\tMaterials.PrimaryPrecision, Materials.SecondaryPrecision,\n" +
                "\t\tMaterials.MaterialNote, Materials.ReportUnitID,\n" +
                "\t\tMaterials.EachWeight, Materials.WeightUnitID,\n" +
                "\t\tMaterials.EachVolume, Materials.VolumeUnitID,\n" +
                "\t\tMaterials.CustomField1, Materials.CustomField2,\n" +
                "\t\tMaterials.CustomField3, Materials.CustomField4,\n" +
                "\t\tMaterials.CustomField5, Materials.CustomField6,\n" +
                "\t\tMaterials.CustomField7, Materials.CustomField8,\n" +
                "\t\tMaterials.MaterialTypeID, Materials.IsPurchase,\n" +
                "\t\tMaterials.IsInventory, Materials.IsSales, Materials.IsSerialMgr,\n" +
                "\t\tMaterials.StopFlag, Materials.StopDate,\n" +
                "\t\tMaterials.CreateCompanyID, Materials.MaterialCreateDate,\n" +
                "\t\tMaterials.MaterialCreator, Materials.MVField1,\n" +
                "\t\tMaterials.MVField2, Materials.MVField3, Materials.MVField4,\n" +
                "\t\tMaterials.MVField5, Materials.IsAttached,\n" +
                "\t\tMaterials.PriSecConvRate, Materials.SalesPrecision,\n" +
                "\t\tMaterials.SecSalesPrecision, Materials.PriSalesConvRate,\n" +
                "\t\tMaterials.PriSalesCompFlag, Materials.SecSalesConvRate,\n" +
                "\t\tMaterials.SecSalesCompFlag, Materials.IMPrecision,\n" +
                "\t\tMaterials.SecIMPrecision, Materials.PriIMConvRate,\n" +
                "\t\tMaterials.PriIMCompFlag, Materials.SecIMConvRate,\n" +
                "\t\tMaterials.SecIMCompFlag, Materials.PurPrecision,\n" +
                "\t\tMaterials.SecPurPrecision, Materials.PriPurConvRate,\n" +
                "\t\tMaterials.PriPurCompFlag, Materials.SecPurConvRate,\n" +
                "\t\tMaterials.SecPurCompFlag, Materials.ReportPrecision,\n" +
                "\t\tMaterials.PriReportConvRate, Materials.PriReportCompFlag,\n" +
                "\t\tMaterials.ConversionFlag, Materials.CTUnitID,\n" +
                "\t\tMaterials.FFSchemaID, CCRecoveryRangeCC.CCID, CCBill.PID,\n" +
                "\t\tCCBill.FlexField1, CCBill.FlexField2, CCBill.FlexField3,\n" +
                "\t\tCCBill.FlexField4, CCBill.FlexField5, CCBill.FlexField1Name,\n" +
                "\t\tCCBill.FlexField2Name, CCBill.FlexField3Name,\n" +
                "\t\tCCBill.FlexField4Name, CCBill.FlexField5Name,\n" +
                "\t\tCCBill.FlexField2Code, CCBill.FlexField1Code,\n" +
                "\t\tCCBill.FlexField3Code, CCBill.FlexField4Code,\n" +
                "\t\tCCBill.FlexField5Code, CCRecoveryRange.CCRRGame, CCBill.Period,\n" +
                "\t\tCCBill.RecQty, CCBill.InitialQty, CCBill.InitialCost,\n" +
                "\t\tCCBill.InputQty, CCBill.InputCost, CCBill.BatchNumCode,\n" +
                "\t\tCCBill.RecCost, CCBill.BalanceQty, CCBill.BalanceCost,\n" +
                "\t\tCCRecoveryRange.CCRRSTATE\n" +
                "\tFROM CCRecoveryRange\n" +
                "\t\tLEFT OUTER JOIN CCRecoveryRangeCC\n" +
                "\t\tINNER JOIN CCCostCenter ON CCRecoveryRangeCC.CCID = CCCostCenter.CCID\n" +
                "\t\tLEFT OUTER JOIN CCBill\n" +
                "\t\tINNER JOIN Materials ON CCBill.PID = Materials.MaterialID\n" +
                "\t\tLEFT JOIN MeasureUnits ON Materials.CTUnitID = MeasureUnits.UnitID ON CCRecoveryRangeCC.CCID = CCBill.CCID ON CCRecoveryRange.CCRRID = CCRecoveryRangeCC.CCRRID", formatSQL);
    }

}
