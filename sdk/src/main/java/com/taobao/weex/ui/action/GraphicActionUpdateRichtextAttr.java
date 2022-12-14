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

import com.taobao.weex.ui.component.richtext.WXRichText;
import com.taobao.weex.WXSDKInstance;
import com.taobao.weex.WXSDKManager;

import java.util.HashMap;
import java.util.Map;

public class GraphicActionUpdateRichtextAttr extends BasicGraphicAction{

    public GraphicActionUpdateRichtextAttr(WXSDKInstance instance, String ref, HashMap<String, String> attrs, String parentRef, String richTextRef){
        super(instance, richTextRef);
        WXRichText richText =  (WXRichText) WXSDKManager.getInstance().getWXRenderManager()
                .getWXComponent(getPageId(), richTextRef);
        if(richText != null) {
            Map<String, Object> map = new HashMap<>();
            map.putAll(attrs);
            richText.updateChildNodeAttrs(ref, map);
        }
    }
    @Override
    public void executeAction() {
    }

}
