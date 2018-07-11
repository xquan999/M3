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

package eco.data.m3.routing.api.rest.request;

import eco.data.m3.routing.api.rest.BaseRequest;

/**
* @author: xquan
* Rest Request
	Shutdown a specified node on a host.
* @since: Created in 2018-6-29
**/
public class ShutdownNodeService extends BaseRequest{

	private String nodeName ;
	
	private Boolean saveState ;

	public String getNodeName() {
		return nodeName;
	}

	public void setNodeName(String nodeName) {
		this.nodeName = nodeName;
	}

	public Boolean getSaveState() {
		return saveState;
	}

	public void setSaveState(Boolean saveState) {
		this.saveState = saveState;
	}	
	
}
