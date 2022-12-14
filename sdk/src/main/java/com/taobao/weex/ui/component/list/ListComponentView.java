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
package com.taobao.weex.ui.component.list;

import com.taobao.weex.ui.view.listview.adapter.RecyclerViewBaseAdapter;
import com.taobao.weex.ui.view.listview.WXRecyclerView;

/**
 * Created by sospartan on 13/12/2016.
 */

public interface ListComponentView {
  WXRecyclerView getInnerView();
  void setRecyclerViewBaseAdapter(RecyclerViewBaseAdapter adapter);
  void notifyStickyShow(WXCell component);
  void notifyStickyRemove(WXCell component);
  void updateStickyView(int currentStickyPos);
  RecyclerViewBaseAdapter getRecyclerViewBaseAdapter();
}
