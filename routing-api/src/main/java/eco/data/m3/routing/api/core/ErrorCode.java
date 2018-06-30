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

package eco.data.m3.routing.api.core;

/**
 * @Author: xquan
 * @Description: Error code when communicate between Server Node and Client.
 * @Date: Created in 2018-6-29
 **/
public enum ErrorCode {

	Success,

	ParameterError,
	
	NameAlreadyExsit,
	PortAlreadyBind,
	NodeNotFound,
	NodeParentNotFound,
	ServiceError,
	RoutingError,
	UnknownHost,
	NoSuchElement,
	ContentNotFound,
}