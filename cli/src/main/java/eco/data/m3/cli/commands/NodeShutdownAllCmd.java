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

package eco.data.m3.cli.commands;

import eco.data.m3.routing.api.rest.RestClient;
import eco.data.m3.routing.api.rest.request.ShutdownAllNodesService;
import eco.data.m3.routing.api.rest.response.ShutdownAllNodesResponse;

import picocli.CommandLine.Command;

/**
* @Author: xquan
* @Description: Shutdown All Nodes Command.
* @Date: Created in 2018-6-30
**/
@Command(name = "nshutall", description="Shutdown All node.")
public class NodeShutdownAllCmd implements Runnable {

	@Override
	public void run() {
		RestClient client = new RestClient();
		ShutdownAllNodesService req = new ShutdownAllNodesService();
		ShutdownAllNodesResponse resp = (ShutdownAllNodesResponse) client.doRequest(req);
		if(resp!=null)		
			System.out.println(resp.Code);
	}

}