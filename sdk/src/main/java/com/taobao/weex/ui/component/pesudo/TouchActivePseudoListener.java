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
package com.taobao.weex.ui.component.pesudo;

import android.annotation.SuppressLint;
import android.view.MotionEvent;
import android.view.View;

/**
 * Created by sospartan on 05/01/2017.
 */
public class TouchActivePseudoListener implements View.OnTouchListener {
  private OnActivePseudoListner mOnActivePseudoListner;
  private boolean mIsConsumeOnTouch;

  public TouchActivePseudoListener(OnActivePseudoListner l, boolean consumeInTouch) {
    mOnActivePseudoListner = l;
    mIsConsumeOnTouch = consumeInTouch;
  }

  @SuppressLint("ClickableViewAccessibility")
  @Override
  public boolean onTouch(View v, MotionEvent event) {
    int action = event.getAction();
    if (mOnActivePseudoListner != null) {
      if (action == MotionEvent.ACTION_DOWN || action == MotionEvent.ACTION_POINTER_DOWN) {
        mOnActivePseudoListner.updateActivePseudo(true);
      } else if (action == MotionEvent.ACTION_CANCEL || action == MotionEvent.ACTION_UP || action == MotionEvent.ACTION_POINTER_UP) {
        mOnActivePseudoListner.updateActivePseudo(false);
      }
    }
    return mIsConsumeOnTouch;
  }
}
