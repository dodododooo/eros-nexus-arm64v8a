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
package com.taobao.weex.ui.component;

import android.view.ViewGroup;
import com.taobao.weex.WXSDKInstance;

/**
 * Created by sospartan on 8/24/16.
 */
public interface NestedContainer {
  void setOnNestEventListener(OnNestedInstanceEventListener listener);

  ViewGroup getViewContainer();

  void renderNewURL(String url);

  void reload();

  interface OnNestedInstanceEventListener {
    void onException(NestedContainer comp, String errCode, String msg);

    /**
     *
     * @param comp
     * @param src
     * @return true if keep load
     */
    boolean onPreCreate(NestedContainer comp, String src);

    String transformUrl(String origin);

    void onCreated(NestedContainer comp, WXSDKInstance nestedInstance);
  }
}
