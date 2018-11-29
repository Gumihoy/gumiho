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
package com.aliyun.gumiho.sql.hash;

/**
 * @author kongtong.ouyang onCondition 2018/3/13.
 * @see {https://en.wikipedia.org/wiki/Fowler%E2%80%93Noll%E2%80%93Vo_hash_function}
 */
public final class FNVHash {

    public final static long FNV_1A_64_OFFSET_BASIC = 0xcbf29ce484222325L;
    public final static long FNV_1A_64_PRIME = 0x100000001b3L;

    public static long fnv1a_64(String input) {
        if (input == null) {
            return 0;
        }

        long hash = FNV_1A_64_OFFSET_BASIC;
        for (char c : input.toCharArray()) {
            hash ^= c;
            hash *= FNV_1A_64_PRIME;
        }

        return hash;
    }

    public static long fnv1a_64_lower(String input) {
        if (input == null) {
            return 0;
        }

        long hash = FNV_1A_64_OFFSET_BASIC;
        for (char c : input.toCharArray()) {
            if (c >= 'A' && c <= 'Z') {
                c += 32;
            }
            hash ^= c;
            hash *= FNV_1A_64_PRIME;
        }

        return hash;
    }

    public static long fnv1a_64_upper(String input) {
        if (input == null) {
            return 0;
        }

        long hash = FNV_1A_64_OFFSET_BASIC;
        for (char c : input.toCharArray()) {
            if (c >= 'a' && c <= 'z') {
                c -= 32;
            }
            hash ^= c;
            hash *= FNV_1A_64_PRIME;
        }

        return hash;
    }

}
