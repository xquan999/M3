/*
 * Copyright (C) 2018 Blockchain Data Foundation
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package eco.data.m3.web.service.node;

import java.util.HashMap;

import eco.data.m3.routing.api.domain.KadService;
import eco.data.m3.web.service.BaseServlet;
import eco.data.m3.web.service.RequestResult;

/**
 * @author: xquan
 * Shutdown All Nodes Service.
 * Shutdown All Nodes on this host.
 * @since: Created in 2018-7-3
 **/
public class ShutdownAllNodesService extends BaseServlet{
	
	@Override
	public RequestResult handleRequest(HashMap<String, Object> req) {
		RequestResult rt = new RequestResult();

		Boolean saveState =  (Boolean) req.get("saveState");			
		
		if(saveState==null)
			saveState = true;
		
		rt.Code = KadService.getInstance().shutdownAllNodes(saveState);		
		return rt;
	}

}
