/**
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
package com.taobao.weex.ui.action;

import com.alibaba.fastjson.JSONArray;
import com.taobao.weex.ui.component.WXComponent;
import com.taobao.weex.WXSDKManager;
import com.taobao.weex.utils.WXLogUtils;

/**
 * Created by listen on 18/01/10.
 */
public class ActionInvokeMethod implements IExecutable {

  private static final String TAG = "ActionInvokeMethod";

  private final String mMethod;
  private final JSONArray mArgs;
  private String mPageId;
  private String mRef;

  public ActionInvokeMethod(String pageId, String ref, String method, JSONArray args) {
    this.mPageId = pageId;
    this.mRef = ref;
    this.mMethod = method;
    this.mArgs = args;
  }

  @Override
  public void executeAction() {
    WXComponent component = WXSDKManager
        .getInstance().getWXRenderManager().getWXComponent(mPageId, mRef);
    if(component == null){
      WXLogUtils.e(TAG,"target component not found.");
      return;
    }
    component.invoke(mMethod,mArgs);
  }
}
