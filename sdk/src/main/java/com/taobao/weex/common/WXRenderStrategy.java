/*
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied.  See the License for the
 * specific language governing permissions and limitations
 * under the License.
 */
package com.taobao.weex.common;

public enum WXRenderStrategy {
  APPEND_ASYNC("APPEND_ASYNC"),
  APPEND_ONCE("APPEND_ONCE"),
  DATA_RENDER("DATA_RENDER"),
  DATA_RENDER_BINARY("DATA_RENDER_BINARY"),
  JSON_RENDER("JSON_RENDER");


  private String flag;

  WXRenderStrategy(String flag) {
    this.flag = flag;
  }

  public String getFlag() {
    return flag;
  }
}

