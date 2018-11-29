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
public class OracleCreateTypeBodyTest_1 {

    @Test
    public void test() {
        String s = "create or replace TYPE BODY           \"JSON_LIST\" as\n" +
                "  constructor function json_list return self as result as\n" +
                "  begin\n" +
                "    self.list_data := json_value_array();\n" +
                "    return;\n" +
                "  end;\n" +
                "  constructor function json_list(str varchar2) return self as result as\n" +
                "  begin\n" +
                "    self := json_parser.parse_list(str);\n" +
                "    return;\n" +
                "  end;\n" +
                "  constructor function json_list(str clob) return self as result as\n" +
                "  begin\n" +
                "    self := json_parser.parse_list(str);\n" +
                "    return;\n" +
                "  end;\n" +
                "  constructor function json_list(cast json_value) return self as result as\n" +
                "    x number;\n" +
                "  begin\n" +
                "    x := cast.object_or_array.getobject(self);\n" +
                "    return;\n" +
                "  end;\n" +
                "  member procedure append(self in out nocopy json_list, elem json_value, position pls_integer default null) as\n" +
                "    indx pls_integer;\n" +
                "    insert_value json_value := NVL(elem, json_value);\n" +
                "  begin\n" +
                "    if(position is null or position > self.count) then --end of list\n" +
                "      indx := self.count + 1;\n" +
                "      self.list_data.extend(1);\n" +
                "      self.list_data(indx) := insert_value;\n" +
                "    elsif(position < 1) then --new first\n" +
                "      indx := self.count;\n" +
                "      self.list_data.extend(1);\n" +
                "      for x in reverse 1 .. indx loop\n" +
                "        self.list_data(x+1) := self.list_data(x);\n" +
                "      end loop;\n" +
                "      self.list_data(1) := insert_value;\n" +
                "    else\n" +
                "      indx := self.count;\n" +
                "      self.list_data.extend(1);\n" +
                "      for x in reverse position .. indx loop\n" +
                "        self.list_data(x+1) := self.list_data(x);\n" +
                "      end loop;\n" +
                "      self.list_data(position) := insert_value;\n" +
                "    end if;\n" +
                "  end;\n" +
                "  member procedure append(self in out nocopy json_list, elem varchar2, position pls_integer default null) as\n" +
                "  begin\n" +
                "    append(json_value(elem), position);\n" +
                "  end;\n" +
                "  member procedure append(self in out nocopy json_list, elem number, position pls_integer default null) as\n" +
                "  begin\n" +
                "    if(elem is null) then\n" +
                "      append(json_value(), position);\n" +
                "    else\n" +
                "      append(json_value(elem), position);\n" +
                "    end if;\n" +
                "  end;\n" +
                "  member procedure append(self in out nocopy json_list, elem boolean, position pls_integer default null) as\n" +
                "  begin\n" +
                "    if(elem is null) then\n" +
                "      append(json_value(), position);\n" +
                "    else\n" +
                "      append(json_value(elem), position);\n" +
                "    end if;\n" +
                "  end;\n" +
                "  member procedure append(self in out nocopy json_list, elem json_list, position pls_integer default null) as\n" +
                "  begin\n" +
                "    if(elem is null) then\n" +
                "      append(json_value(), position);\n" +
                "    else\n" +
                "      append(elem.to_json_value, position);\n" +
                "    end if;\n" +
                "  end;\n" +
                " member procedure replace(self in out nocopy json_list, position pls_integer, elem json_value) as\n" +
                "    insert_value json_value := NVL(elem, json_value);\n" +
                "    indx number;\n" +
                "  begin\n" +
                "    if(position > self.count) then --end of list\n" +
                "      indx := self.count + 1;\n" +
                "      self.list_data.extend(1);\n" +
                "      self.list_data(indx) := insert_value;\n" +
                "    elsif(position < 1) then --maybe an error message here\n" +
                "      null;\n" +
                "    else\n" +
                "      self.list_data(position) := insert_value;\n" +
                "    end if;\n" +
                "  end;\n" +
                "  member procedure replace(self in out nocopy json_list, position pls_integer, elem varchar2) as\n" +
                "  begin\n" +
                "    replace(position, json_value(elem));\n" +
                "  end;\n" +
                "  member procedure replace(self in out nocopy json_list, position pls_integer, elem number) as\n" +
                "  begin\n" +
                "    if(elem is null) then\n" +
                "      replace(position, json_value());\n" +
                "    else\n" +
                "      replace(position, json_value(elem));\n" +
                "    end if;\n" +
                "  end;\n" +
                "  member procedure replace(self in out nocopy json_list, position pls_integer, elem boolean) as\n" +
                "  begin\n" +
                "    if(elem is null) then\n" +
                "      replace(position, json_value());\n" +
                "    else\n" +
                "      replace(position, json_value(elem));\n" +
                "    end if;\n" +
                "  end;\n" +
                "  member procedure replace(self in out nocopy json_list, position pls_integer, elem json_list) as\n" +
                "  begin\n" +
                "    if(elem is null) then\n" +
                "      replace(position, json_value());\n" +
                "    else\n" +
                "      replace(position, elem.to_json_value);\n" +
                "    end if;\n" +
                "  end;\n" +
                "  member function count return number as\n" +
                "  begin\n" +
                "    return self.list_data.count;\n" +
                "  end;\n" +
                "  member procedure remove(self in out nocopy json_list, position pls_integer) as\n" +
                "  begin\n" +
                "    if(position is null or position < 1 or position > self.count) then return; end if;\n" +
                "    for x in (position+1) .. self.count loop\n" +
                "      self.list_data(x-1) := self.list_data(x);\n" +
                "    end loop;\n" +
                "    self.list_data.trim(1);\n" +
                "  end;\n" +
                "  member procedure remove_first(self in out nocopy json_list) as\n" +
                "  begin\n" +
                "    for x in 2 .. self.count loop\n" +
                "      self.list_data(x-1) := self.list_data(x);\n" +
                "    end loop;\n" +
                "    if(self.count > 0) then\n" +
                "      self.list_data.trim(1);\n" +
                "    end if;\n" +
                "  end;\n" +
                "  member procedure remove_last(self in out nocopy json_list) as\n" +
                "  begin\n" +
                "    if(self.count > 0) then\n" +
                "      self.list_data.trim(1);\n" +
                "    end if;\n" +
                "  end;\n" +
                "  member function get(position pls_integer) return json_value as\n" +
                "  begin\n" +
                "    if(self.count >= position and position > 0) then\n" +
                "      return self.list_data(position);\n" +
                "    end if;\n" +
                "    return null; -- do not throw error, just return null\n" +
                "  end;\n" +
                "  member function head return json_value as\n" +
                "  begin\n" +
                "    if(self.count > 0) then\n" +
                "      return self.list_data(self.list_data.first);\n" +
                "    end if;\n" +
                "    return null; -- do not throw error, just return null\n" +
                "  end;\n" +
                "  member function last return json_value as\n" +
                "  begin\n" +
                "    if(self.count > 0) then\n" +
                "      return self.list_data(self.list_data.last);\n" +
                "    end if;\n" +
                "    return null; -- do not throw error, just return null\n" +
                "  end;\n" +
                "  member function tail return json_list as\n" +
                "    t json_list;\n" +
                "  begin\n" +
                "    if(self.count > 0) then\n" +
                "      t := json_list(self.list_data);\n" +
                "      t.remove(1);\n" +
                "      return t;\n" +
                "    else return json_list(); end if;\n" +
                "  end;\n" +
                "  member function to_char(spaces boolean default true, chars_per_line number default 0) return varchar2 as\n" +
                "  begin\n" +
                "    if(spaces is null) then\n" +
                "      return json_printer.pretty_print_list(self, line_length => chars_per_line);\n" +
                "    else\n" +
                "      return json_printer.pretty_print_list(self, spaces, line_length => chars_per_line);\n" +
                "    end if;\n" +
                "  end;\n" +
                "  member procedure to_clob(self in json_list, buf in out nocopy clob, spaces boolean default false, chars_per_line number default 0, erase_clob boolean default true) as\n" +
                "  begin\n" +
                "    if(spaces is null) then\n" +
                "      json_printer.pretty_print_list(self, false, buf, line_length => chars_per_line, erase_clob => erase_clob);\n" +
                "    else\n" +
                "      json_printer.pretty_print_list(self, spaces, buf, line_length => chars_per_line, erase_clob => erase_clob);\n" +
                "    end if;\n" +
                "  end;\n" +
                "  member procedure print(self in json_list, spaces boolean default true, chars_per_line number default 8192, jsonp varchar2 default null) as --32512 is the real maximum in sqldeveloper\n" +
                "    my_clob clob;\n" +
                "  begin\n" +
                "    my_clob := empty_clob();\n" +
                "    dbms_lob.createtemporary(my_clob, true);\n" +
                "    json_printer.pretty_print_list(self, spaces, my_clob, case when (chars_per_line>32512) then 32512 else chars_per_line end);\n" +
                "    json_printer.dbms_output_clob(my_clob, json_printer.newline_char, jsonp);\n" +
                "    dbms_lob.freetemporary(my_clob);\n" +
                "  end;\n" +
                "  member procedure htp(self in json_list, spaces boolean default false, chars_per_line number default 0, jsonp varchar2 default null) as\n" +
                "    my_clob clob;\n" +
                "  begin\n" +
                "    my_clob := empty_clob();\n" +
                "    dbms_lob.createtemporary(my_clob, true);\n" +
                "    json_printer.pretty_print_list(self, spaces, my_clob, chars_per_line);\n" +
                "    json_printer.htp_output_clob(my_clob, jsonp);\n" +
                "    dbms_lob.freetemporary(my_clob);\n" +
                "  end;\n" +
                "  /* json path */\n" +
                "  member function path(json_path varchar2, base number default 1) return json_value as\n" +
                "    cp json_list := self;\n" +
                "  begin\n" +
                "    return json_ext;\n" +
                "  end path;\n" +
                "  /* json path_put */\n" +
                "  member procedure path_put(self in out nocopy json_list, json_path varchar2, elem json_value, base number default 1) as\n" +
                "    objlist json;\n" +
                "    jp json_list := json_ext.parsePath(json_path, base);\n" +
                "  begin\n" +
                "    while(jp.head().get_number() > self.count) loop\n" +
                "      self.append(json_value());\n" +
                "    end loop;\n" +
                "    objlist := json(self);\n" +
                "    json_ext.put(objlist, json_path, elem, base);\n" +
                "    self := objlist.get_values;\n" +
                "  end path_put;\n" +
                "  member procedure path_put(self in out nocopy json_list, json_path varchar2, elem varchar2, base number default 1) as\n" +
                "    objlist json;\n" +
                "    jp json_list := json_ext.parsePath(json_path, base);\n" +
                "  begin\n" +
                "    while(jp.head().get_number() > self.count) loop\n" +
                "      self.append(json_value());\n" +
                "    end loop;\n" +
                "    objlist := json(self);\n" +
                "    json_ext.put(objlist, json_path, elem, base);\n" +
                "    self := objlist.get_values;\n" +
                "  end path_put;\n" +
                "  member procedure path_put(self in out nocopy json_list, json_path varchar2, elem number, base number default 1) as\n" +
                "    objlist json;\n" +
                "    jp json_list := json_ext.parsePath(json_path, base);\n" +
                "  begin\n" +
                "    while(jp.head().get_number() > self.count) loop\n" +
                "      self.append(json_value());\n" +
                "    end loop;\n" +
                "    objlist := json(self);\n" +
                "    if(elem is null) then\n" +
                "      json_ext.put(objlist, json_path, json_value, base);\n" +
                "    else\n" +
                "      json_ext.put(objlist, json_path, elem, base);\n" +
                "    end if;\n" +
                "    self := objlist.get_values;\n" +
                "  end path_put;\n" +
                "  member procedure path_put(self in out nocopy json_list, json_path varchar2, elem boolean, base number default 1) as\n" +
                "    objlist json;\n" +
                "    jp json_list := json_ext.parsePath(json_path, base);\n" +
                "  begin\n" +
                "    while(jp.head().get_number() > self.count) loop\n" +
                "      self.append(json_value());\n" +
                "    end loop;\n" +
                "    objlist := json(self);\n" +
                "    if(elem is null) then\n" +
                "      json_ext.put(objlist, json_path, json_value, base);\n" +
                "    else\n" +
                "      json_ext.put(objlist, json_path, elem, base);\n" +
                "    end if;\n" +
                "    self := objlist.get_values;\n" +
                "  end path_put;\n" +
                "  member procedure path_put(self in out nocopy json_list, json_path varchar2, elem json_list, base number default 1) as\n" +
                "    objlist json;\n" +
                "    jp json_list := json_ext.parsePath(json_path, base);\n" +
                "  begin\n" +
                "    while(jp.head().get_number() > self.count) loop\n" +
                "      self.append(json_value());\n" +
                "    end loop;\n" +
                "    objlist := json(self);\n" +
                "    if(elem is null) then\n" +
                "      json_ext.put(objlist, json_path, json_value, base);\n" +
                "    else\n" +
                "      json_ext.put(objlist, json_path, elem, base);\n" +
                "    end if;\n" +
                "    self := objlist.get_values;\n" +
                "  end path_put;\n" +
                "  /* json path_remove */\n" +
                "  member procedure path_remove(self in out nocopy json_list, json_path varchar2, base number default 1) as\n" +
                "    objlist json := json(self);\n" +
                "  begin\n" +
                "    json_ext.remove(objlist, json_path, base);\n" +
                "    self := objlist.get_values;\n" +
                "  end path_remove;\n" +
                "  member function to_json_value return json_value as\n" +
                "  begin\n" +
                "    return json_value(sys.anydata.convertobject(self));\n" +
                "  end;\n" +
                "  /*--backwards compatibility\n" +
                "  member procedure add_elem(self in out nocopy json_list, elem json_value, position pls_integer default null) as begin append(elem,position); end;\n" +
                "  member procedure add_elem(self in out nocopy json_list, elem varchar2, position pls_integer default null) as begin append(elem,position); end;\n" +
                "  member procedure add_elem(self in out nocopy json_list, elem number, position pls_integer default null) as begin append(elem,position); end;\n" +
                "  member procedure add_elem(self in out nocopy json_list, elem boolean, position pls_integer default null) as begin append(elem,position); end;\n" +
                "  member procedure add_elem(self in out nocopy json_list, elem json_list, position pls_integer default null) as begin append(elem,position); end;\n" +
                "  member procedure set_elem(self in out nocopy json_list, position pls_integer, elem json_value) as begin replace(position,elem); end;\n" +
                "  member procedure set_elem(self in out nocopy json_list, position pls_integer, elem varchar2) as begin replace(position,elem); end;\n" +
                "  member procedure set_elem(self in out nocopy json_list, position pls_integer, elem number) as begin replace(position,elem); end;\n" +
                "  member procedure set_elem(self in out nocopy json_list, position pls_integer, elem boolean) as begin replace(position,elem); end;\n" +
                "  member procedure set_elem(self in out nocopy json_list, position pls_integer, elem json_list) as begin replace(position,elem); end;\n" +
                "  member procedure remove_elem(self in out nocopy json_list, position pls_integer) as begin remove(position); end;\n" +
                "  member function get_elem(position pls_integer) return json_value as begin return get(position); end;\n" +
                "  member function get_first return json_value as begin return head(); end;\n" +
                "  member function get_last return json_value as begin return last(); end;\n" +
                "--  */\n" +
                "end;";


        String formatSQL = SQLUtils.format(s, DBType.Oracle);
        System.out.println(s);
        System.out.println("------------------");
        System.out.println(formatSQL);
        Assert.assertEquals("CREATE OR REPLACE TYPE BODY \"JSON_LIST\" AS\n" +
                "\tCONSTRUCTOR FUNCTION json_list RETURN SELF AS RESULT AS\n" +
                "\t\tBEGIN\n" +
                "\t\t\tself.list_data := json_value_array();\n" +
                "\t\t\treturn;\n" +
                "\t\tEND;\n" +
                "\tCONSTRUCTOR FUNCTION json_list (\n" +
                "\t\tstr VARCHAR2\n" +
                "\t ) RETURN SELF AS RESULT AS\n" +
                "\t\tBEGIN\n" +
                "\t\t\tself := json_parser.parse_list(str);\n" +
                "\t\t\treturn;\n" +
                "\t\tEND;\n" +
                "\tCONSTRUCTOR FUNCTION json_list (\n" +
                "\t\tstr CLOB\n" +
                "\t ) RETURN SELF AS RESULT AS\n" +
                "\t\tBEGIN\n" +
                "\t\t\tself := json_parser.parse_list(str);\n" +
                "\t\t\treturn;\n" +
                "\t\tEND;\n" +
                "\tCONSTRUCTOR FUNCTION json_list (\n" +
                "\t\tcast json_value\n" +
                "\t ) RETURN SELF AS RESULT AS\n" +
                "\t\tx NUMBER;\n" +
                "\t\tBEGIN\n" +
                "\t\t\tx := cast.object_or_array.getobject(self);\n" +
                "\t\t\treturn;\n" +
                "\t\tEND;\n" +
                "\tMEMBER PROCEDURE append (\n" +
                "\t\tself IN OUT NOCOPY json_list,\n" +
                "\t\telem json_value,\n" +
                "\t\tposition PLS_INTEGER DEFAULT NULL\n" +
                "\t) AS\n" +
                "\t\tindx PLS_INTEGER;\n" +
                "\t\tinsert_value json_value := NVL(elem, json_value);\n" +
                "\t\tBEGIN\n" +
                "\t\t\tIF (position IS NULL OR position > self.count) THEN\n" +
                "\t\t\t\tindx := self.count + 1;\n" +
                "\t\t\t\tself.list_data.EXTEND(1);\n" +
                "\t\t\t\tself.list_data(indx) := insert_value;\n" +
                "\t\t\tELSIF (position < 1) THEN\n" +
                "\t\t\t\tindx := self.count;\n" +
                "\t\t\t\tself.list_data.EXTEND(1);\n" +
                "\t\t\t\tFOR x IN REVERSE 1 .. indx LOOP\n" +
                "\t\t\t\t\tself.list_data(x + 1) := self.list_data(x);\n" +
                "\t\t\t\tEND LOOP;\n" +
                "\t\t\t\tself.list_data(1) := insert_value;\n" +
                "\t\t\tELSE\n" +
                "\t\t\t\tindx := self.count;\n" +
                "\t\t\t\tself.list_data.EXTEND(1);\n" +
                "\t\t\t\tFOR x IN REVERSE position .. indx LOOP\n" +
                "\t\t\t\t\tself.list_data(x + 1) := self.list_data(x);\n" +
                "\t\t\t\tEND LOOP;\n" +
                "\t\t\t\tself.list_data(position) := insert_value;\n" +
                "\t\t\tEND IF;\n" +
                "\t\tEND;\n" +
                "\tMEMBER PROCEDURE append (\n" +
                "\t\tself IN OUT NOCOPY json_list,\n" +
                "\t\telem VARCHAR2,\n" +
                "\t\tposition PLS_INTEGER DEFAULT NULL\n" +
                "\t) AS\n" +
                "\t\tBEGIN\n" +
                "\t\t\tappend(json_value(elem), position);\n" +
                "\t\tEND;\n" +
                "\tMEMBER PROCEDURE append (\n" +
                "\t\tself IN OUT NOCOPY json_list,\n" +
                "\t\telem NUMBER,\n" +
                "\t\tposition PLS_INTEGER DEFAULT NULL\n" +
                "\t) AS\n" +
                "\t\tBEGIN\n" +
                "\t\t\tIF (elem IS NULL) THEN\n" +
                "\t\t\t\tappend(json_value(), position);\n" +
                "\t\t\tELSE\n" +
                "\t\t\t\tappend(json_value(elem), position);\n" +
                "\t\t\tEND IF;\n" +
                "\t\tEND;\n" +
                "\tMEMBER PROCEDURE append (\n" +
                "\t\tself IN OUT NOCOPY json_list,\n" +
                "\t\telem BOOLEAN,\n" +
                "\t\tposition PLS_INTEGER DEFAULT NULL\n" +
                "\t) AS\n" +
                "\t\tBEGIN\n" +
                "\t\t\tIF (elem IS NULL) THEN\n" +
                "\t\t\t\tappend(json_value(), position);\n" +
                "\t\t\tELSE\n" +
                "\t\t\t\tappend(json_value(elem), position);\n" +
                "\t\t\tEND IF;\n" +
                "\t\tEND;\n" +
                "\tMEMBER PROCEDURE append (\n" +
                "\t\tself IN OUT NOCOPY json_list,\n" +
                "\t\telem json_list,\n" +
                "\t\tposition PLS_INTEGER DEFAULT NULL\n" +
                "\t) AS\n" +
                "\t\tBEGIN\n" +
                "\t\t\tIF (elem IS NULL) THEN\n" +
                "\t\t\t\tappend(json_value(), position);\n" +
                "\t\t\tELSE\n" +
                "\t\t\t\tappend(elem.to_json_value, position);\n" +
                "\t\t\tEND IF;\n" +
                "\t\tEND;\n" +
                "\tMEMBER PROCEDURE replace (\n" +
                "\t\tself IN OUT NOCOPY json_list,\n" +
                "\t\tposition PLS_INTEGER,\n" +
                "\t\telem json_value\n" +
                "\t) AS\n" +
                "\t\tinsert_value json_value := NVL(elem, json_value);\n" +
                "\t\tindx NUMBER;\n" +
                "\t\tBEGIN\n" +
                "\t\t\tIF (position > self.count) THEN\n" +
                "\t\t\t\tindx := self.count + 1;\n" +
                "\t\t\t\tself.list_data.EXTEND(1);\n" +
                "\t\t\t\tself.list_data(indx) := insert_value;\n" +
                "\t\t\tELSIF (position < 1) THEN\n" +
                "\t\t\t\tNULL;\n" +
                "\t\t\tELSE\n" +
                "\t\t\t\tself.list_data(position) := insert_value;\n" +
                "\t\t\tEND IF;\n" +
                "\t\tEND;\n" +
                "\tMEMBER PROCEDURE replace (\n" +
                "\t\tself IN OUT NOCOPY json_list,\n" +
                "\t\tposition PLS_INTEGER,\n" +
                "\t\telem VARCHAR2\n" +
                "\t) AS\n" +
                "\t\tBEGIN\n" +
                "\t\t\treplace(position, json_value(elem));\n" +
                "\t\tEND;\n" +
                "\tMEMBER PROCEDURE replace (\n" +
                "\t\tself IN OUT NOCOPY json_list,\n" +
                "\t\tposition PLS_INTEGER,\n" +
                "\t\telem NUMBER\n" +
                "\t) AS\n" +
                "\t\tBEGIN\n" +
                "\t\t\tIF (elem IS NULL) THEN\n" +
                "\t\t\t\treplace(position, json_value());\n" +
                "\t\t\tELSE\n" +
                "\t\t\t\treplace(position, json_value(elem));\n" +
                "\t\t\tEND IF;\n" +
                "\t\tEND;\n" +
                "\tMEMBER PROCEDURE replace (\n" +
                "\t\tself IN OUT NOCOPY json_list,\n" +
                "\t\tposition PLS_INTEGER,\n" +
                "\t\telem BOOLEAN\n" +
                "\t) AS\n" +
                "\t\tBEGIN\n" +
                "\t\t\tIF (elem IS NULL) THEN\n" +
                "\t\t\t\treplace(position, json_value());\n" +
                "\t\t\tELSE\n" +
                "\t\t\t\treplace(position, json_value(elem));\n" +
                "\t\t\tEND IF;\n" +
                "\t\tEND;\n" +
                "\tMEMBER PROCEDURE replace (\n" +
                "\t\tself IN OUT NOCOPY json_list,\n" +
                "\t\tposition PLS_INTEGER,\n" +
                "\t\telem json_list\n" +
                "\t) AS\n" +
                "\t\tBEGIN\n" +
                "\t\t\tIF (elem IS NULL) THEN\n" +
                "\t\t\t\treplace(position, json_value());\n" +
                "\t\t\tELSE\n" +
                "\t\t\t\treplace(position, elem.to_json_value);\n" +
                "\t\t\tEND IF;\n" +
                "\t\tEND;\n" +
                "\tMEMBER FUNCTION count RETURN NUMBER AS\n" +
                "\t\tBEGIN\n" +
                "\t\t\tRETURN self.list_data.count;\n" +
                "\t\tEND;\n" +
                "\tMEMBER PROCEDURE remove (\n" +
                "\t\tself IN OUT NOCOPY json_list,\n" +
                "\t\tposition PLS_INTEGER\n" +
                "\t) AS\n" +
                "\t\tBEGIN\n" +
                "\t\t\tIF (position IS NULL OR position < 1 OR position > self.count) THEN\n" +
                "\t\t\t\treturn;\n" +
                "\t\t\tEND IF;\n" +
                "\t\t\tFOR x IN (position + 1) .. self.count LOOP\n" +
                "\t\t\t\tself.list_data(x - 1) := self.list_data(x);\n" +
                "\t\t\tEND LOOP;\n" +
                "\t\t\tself.list_data.TRIM(1);\n" +
                "\t\tEND;\n" +
                "\tMEMBER PROCEDURE remove_first (\n" +
                "\t\tself IN OUT NOCOPY json_list\n" +
                "\t) AS\n" +
                "\t\tBEGIN\n" +
                "\t\t\tFOR x IN 2 .. self.count LOOP\n" +
                "\t\t\t\tself.list_data(x - 1) := self.list_data(x);\n" +
                "\t\t\tEND LOOP;\n" +
                "\t\t\tIF (self.count > 0) THEN\n" +
                "\t\t\t\tself.list_data.TRIM(1);\n" +
                "\t\t\tEND IF;\n" +
                "\t\tEND;\n" +
                "\tMEMBER PROCEDURE remove_last (\n" +
                "\t\tself IN OUT NOCOPY json_list\n" +
                "\t) AS\n" +
                "\t\tBEGIN\n" +
                "\t\t\tIF (self.count > 0) THEN\n" +
                "\t\t\t\tself.list_data.TRIM(1);\n" +
                "\t\t\tEND IF;\n" +
                "\t\tEND;\n" +
                "\tMEMBER FUNCTION get (\n" +
                "\t\tposition PLS_INTEGER\n" +
                "\t) RETURN json_value AS\n" +
                "\t\tBEGIN\n" +
                "\t\t\tIF (self.count >= position AND position > 0) THEN\n" +
                "\t\t\t\tRETURN self.list_data(position);\n" +
                "\t\t\tEND IF;\n" +
                "\t\t\tRETURN NULL;\n" +
                "\t\tEND;\n" +
                "\tMEMBER FUNCTION head RETURN json_value AS\n" +
                "\t\tBEGIN\n" +
                "\t\t\tIF (self.count > 0) THEN\n" +
                "\t\t\t\tRETURN self.list_data(self.list_data.first);\n" +
                "\t\t\tEND IF;\n" +
                "\t\t\tRETURN NULL;\n" +
                "\t\tEND;\n" +
                "\tMEMBER FUNCTION last RETURN json_value AS\n" +
                "\t\tBEGIN\n" +
                "\t\t\tIF (self.count > 0) THEN\n" +
                "\t\t\t\tRETURN self.list_data(self.list_data.last);\n" +
                "\t\t\tEND IF;\n" +
                "\t\t\tRETURN NULL;\n" +
                "\t\tEND;\n" +
                "\tMEMBER FUNCTION tail RETURN json_list AS\n" +
                "\t\tt json_list;\n" +
                "\t\tBEGIN\n" +
                "\t\t\tIF (self.count > 0) THEN\n" +
                "\t\t\t\tt := json_list(self.list_data);\n" +
                "\t\t\t\tt.remove(1);\n" +
                "\t\t\t\tRETURN t;\n" +
                "\t\t\tELSE\n" +
                "\t\t\t\tRETURN json_list();\n" +
                "\t\t\tEND IF;\n" +
                "\t\tEND;\n" +
                "\tMEMBER FUNCTION to_char (\n" +
                "\t\tspaces BOOLEAN DEFAULT TRUE,\n" +
                "\t\tchars_per_line NUMBER DEFAULT 0\n" +
                "\t) RETURN VARCHAR2 AS\n" +
                "\t\tBEGIN\n" +
                "\t\t\tIF (spaces IS NULL) THEN\n" +
                "\t\t\t\tRETURN json_printer.pretty_print_list(self, line_length => chars_per_line);\n" +
                "\t\t\tELSE\n" +
                "\t\t\t\tRETURN json_printer.pretty_print_list(self, spaces, line_length => chars_per_line);\n" +
                "\t\t\tEND IF;\n" +
                "\t\tEND;\n" +
                "\tMEMBER PROCEDURE to_clob (\n" +
                "\t\tself IN json_list,\n" +
                "\t\tbuf IN OUT NOCOPY CLOB,\n" +
                "\t\tspaces BOOLEAN DEFAULT FALSE,\n" +
                "\t\tchars_per_line NUMBER DEFAULT 0,\n" +
                "\t\terase_clob BOOLEAN DEFAULT TRUE\n" +
                "\t) AS\n" +
                "\t\tBEGIN\n" +
                "\t\t\tIF (spaces IS NULL) THEN\n" +
                "\t\t\t\tjson_printer.pretty_print_list(self, FALSE, buf, line_length => chars_per_line, erase_clob => erase_clob);\n" +
                "\t\t\tELSE\n" +
                "\t\t\t\tjson_printer.pretty_print_list(self, spaces, buf, line_length => chars_per_line, erase_clob => erase_clob);\n" +
                "\t\t\tEND IF;\n" +
                "\t\tEND;\n" +
                "\tMEMBER PROCEDURE print (\n" +
                "\t\tself IN json_list,\n" +
                "\t\tspaces BOOLEAN DEFAULT TRUE,\n" +
                "\t\tchars_per_line NUMBER DEFAULT 8192,\n" +
                "\t\tjsonp VARCHAR2 DEFAULT NULL\n" +
                "\t) AS\n" +
                "\t\tmy_clob CLOB;\n" +
                "\t\tBEGIN\n" +
                "\t\t\tmy_clob := empty_clob();\n" +
                "\t\t\tdbms_lob.createtemporary(my_clob, TRUE);\n" +
                "\t\t\tjson_printer.pretty_print_list(self, spaces, my_clob, CASE\n" +
                "\t\t\t\tWHEN (chars_per_line > 32512) THEN 32512\n" +
                "\t\t\t\tELSE chars_per_line\n" +
                "\t\t\tEND);\n" +
                "\t\t\tjson_printer.dbms_output_clob(my_clob, json_printer.newline_char, jsonp);\n" +
                "\t\t\tdbms_lob.freetemporary(my_clob);\n" +
                "\t\tEND;\n" +
                "\tMEMBER PROCEDURE htp (\n" +
                "\t\tself IN json_list,\n" +
                "\t\tspaces BOOLEAN DEFAULT FALSE,\n" +
                "\t\tchars_per_line NUMBER DEFAULT 0,\n" +
                "\t\tjsonp VARCHAR2 DEFAULT NULL\n" +
                "\t) AS\n" +
                "\t\tmy_clob CLOB;\n" +
                "\t\tBEGIN\n" +
                "\t\t\tmy_clob := empty_clob();\n" +
                "\t\t\tdbms_lob.createtemporary(my_clob, TRUE);\n" +
                "\t\t\tjson_printer.pretty_print_list(self, spaces, my_clob, chars_per_line);\n" +
                "\t\t\tjson_printer.htp_output_clob(my_clob, jsonp);\n" +
                "\t\t\tdbms_lob.freetemporary(my_clob);\n" +
                "\t\tEND;\n" +
                "\tMEMBER FUNCTION path (\n" +
                "\t\tjson_path VARCHAR2,\n" +
                "\t\tbase NUMBER DEFAULT 1\n" +
                "\t) RETURN json_value AS\n" +
                "\t\tcp json_list := self;\n" +
                "\t\tBEGIN\n" +
                "\t\t\tRETURN json_ext;\n" +
                "\t\tEND path;\n" +
                "\tMEMBER PROCEDURE path_put (\n" +
                "\t\tself IN OUT NOCOPY json_list,\n" +
                "\t\tjson_path VARCHAR2,\n" +
                "\t\telem json_value,\n" +
                "\t\tbase NUMBER DEFAULT 1\n" +
                "\t) AS\n" +
                "\t\tobjlist JSON;\n" +
                "\t\tjp json_list := json_ext.parsePath(json_path, base);\n" +
                "\t\tBEGIN\n" +
                "\t\t\tWHILE (jp.head().get_number() > self.count) LOOP\n" +
                "\t\t\t\tself.append(json_value());\n" +
                "\t\t\tEND LOOP;\n" +
                "\t\t\tobjlist := json(self);\n" +
                "\t\t\tjson_ext.put(objlist, json_path, elem, base);\n" +
                "\t\t\tself := objlist.get_values;\n" +
                "\t\tEND path_put;\n" +
                "\tMEMBER PROCEDURE path_put (\n" +
                "\t\tself IN OUT NOCOPY json_list,\n" +
                "\t\tjson_path VARCHAR2,\n" +
                "\t\telem VARCHAR2,\n" +
                "\t\tbase NUMBER DEFAULT 1\n" +
                "\t) AS\n" +
                "\t\tobjlist JSON;\n" +
                "\t\tjp json_list := json_ext.parsePath(json_path, base);\n" +
                "\t\tBEGIN\n" +
                "\t\t\tWHILE (jp.head().get_number() > self.count) LOOP\n" +
                "\t\t\t\tself.append(json_value());\n" +
                "\t\t\tEND LOOP;\n" +
                "\t\t\tobjlist := json(self);\n" +
                "\t\t\tjson_ext.put(objlist, json_path, elem, base);\n" +
                "\t\t\tself := objlist.get_values;\n" +
                "\t\tEND path_put;\n" +
                "\tMEMBER PROCEDURE path_put (\n" +
                "\t\tself IN OUT NOCOPY json_list,\n" +
                "\t\tjson_path VARCHAR2,\n" +
                "\t\telem NUMBER,\n" +
                "\t\tbase NUMBER DEFAULT 1\n" +
                "\t) AS\n" +
                "\t\tobjlist JSON;\n" +
                "\t\tjp json_list := json_ext.parsePath(json_path, base);\n" +
                "\t\tBEGIN\n" +
                "\t\t\tWHILE (jp.head().get_number() > self.count) LOOP\n" +
                "\t\t\t\tself.append(json_value());\n" +
                "\t\t\tEND LOOP;\n" +
                "\t\t\tobjlist := json(self);\n" +
                "\t\t\tIF (elem IS NULL) THEN\n" +
                "\t\t\t\tjson_ext.put(objlist, json_path, json_value, base);\n" +
                "\t\t\tELSE\n" +
                "\t\t\t\tjson_ext.put(objlist, json_path, elem, base);\n" +
                "\t\t\tEND IF;\n" +
                "\t\t\tself := objlist.get_values;\n" +
                "\t\tEND path_put;\n" +
                "\tMEMBER PROCEDURE path_put (\n" +
                "\t\tself IN OUT NOCOPY json_list,\n" +
                "\t\tjson_path VARCHAR2,\n" +
                "\t\telem BOOLEAN,\n" +
                "\t\tbase NUMBER DEFAULT 1\n" +
                "\t) AS\n" +
                "\t\tobjlist JSON;\n" +
                "\t\tjp json_list := json_ext.parsePath(json_path, base);\n" +
                "\t\tBEGIN\n" +
                "\t\t\tWHILE (jp.head().get_number() > self.count) LOOP\n" +
                "\t\t\t\tself.append(json_value());\n" +
                "\t\t\tEND LOOP;\n" +
                "\t\t\tobjlist := json(self);\n" +
                "\t\t\tIF (elem IS NULL) THEN\n" +
                "\t\t\t\tjson_ext.put(objlist, json_path, json_value, base);\n" +
                "\t\t\tELSE\n" +
                "\t\t\t\tjson_ext.put(objlist, json_path, elem, base);\n" +
                "\t\t\tEND IF;\n" +
                "\t\t\tself := objlist.get_values;\n" +
                "\t\tEND path_put;\n" +
                "\tMEMBER PROCEDURE path_put (\n" +
                "\t\tself IN OUT NOCOPY json_list,\n" +
                "\t\tjson_path VARCHAR2,\n" +
                "\t\telem json_list,\n" +
                "\t\tbase NUMBER DEFAULT 1\n" +
                "\t) AS\n" +
                "\t\tobjlist JSON;\n" +
                "\t\tjp json_list := json_ext.parsePath(json_path, base);\n" +
                "\t\tBEGIN\n" +
                "\t\t\tWHILE (jp.head().get_number() > self.count) LOOP\n" +
                "\t\t\t\tself.append(json_value());\n" +
                "\t\t\tEND LOOP;\n" +
                "\t\t\tobjlist := json(self);\n" +
                "\t\t\tIF (elem IS NULL) THEN\n" +
                "\t\t\t\tjson_ext.put(objlist, json_path, json_value, base);\n" +
                "\t\t\tELSE\n" +
                "\t\t\t\tjson_ext.put(objlist, json_path, elem, base);\n" +
                "\t\t\tEND IF;\n" +
                "\t\t\tself := objlist.get_values;\n" +
                "\t\tEND path_put;\n" +
                "\tMEMBER PROCEDURE path_remove (\n" +
                "\t\tself IN OUT NOCOPY json_list,\n" +
                "\t\tjson_path VARCHAR2,\n" +
                "\t\tbase NUMBER DEFAULT 1\n" +
                "\t) AS\n" +
                "\t\tobjlist JSON := json(self);\n" +
                "\t\tBEGIN\n" +
                "\t\t\tjson_ext.remove(objlist, json_path, base);\n" +
                "\t\t\tself := objlist.get_values;\n" +
                "\t\tEND path_remove;\n" +
                "\tMEMBER FUNCTION to_json_value RETURN json_value AS\n" +
                "\t\tBEGIN\n" +
                "\t\t\tRETURN json_value(sys.anydata.convertobject(self));\n" +
                "\t\tEND;\n" +
                "END;", formatSQL);
    }
}
