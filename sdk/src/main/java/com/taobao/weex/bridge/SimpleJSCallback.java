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
package com.taobao.weex.bridge;

/**
 * Created by sospartan on 27/10/2016.
 */
public class SimpleJSCallback implements JSCallback {

  String mInstanceId;
  String mCallbackId;

  private InvokerCallback mInvokerCallback;

  public void setInvokerCallback(InvokerCallback callback) {
    this.mInvokerCallback = callback;
  }

  interface InvokerCallback {
    void onInvokeSuccess();
  }

  public String getCallbackId() {
    return mCallbackId;
  }

  public SimpleJSCallback(String instanceId, String callbackId) {
    this.mCallbackId = callbackId;
    this.mInstanceId = instanceId;
  }


  @Override
  public void invoke(Object data) {
    WXBridgeManager.getInstance().callbackJavascript(mInstanceId, mCallbackId, data, false);
    if (mInvokerCallback != null) {
      mInvokerCallback.onInvokeSuccess();
    }
  }

  @Override
  public void invokeAndKeepAlive(Object data) {
    WXBridgeManager.getInstance().callbackJavascript(mInstanceId, mCallbackId, data, true);
  }
}
