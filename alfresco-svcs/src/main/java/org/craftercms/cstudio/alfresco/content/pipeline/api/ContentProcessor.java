/*******************************************************************************
 * Crafter Studio Web-content authoring solution
 *     Copyright (C) 2007-2013 Crafter Software Corporation.
 * 
 *     This program is free software: you can redistribute it and/or modify
 *     it under the terms of the GNU General Public License as published by
 *     the Free Software Foundation, either version 3 of the License, or
 *     (at your option) any later version.
 * 
 *     This program is distributed in the hope that it will be useful,
 *     but WITHOUT ANY WARRANTY; without even the implied warranty of
 *     MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 *     GNU General Public License for more details.
 * 
 *     You should have received a copy of the GNU General Public License
 *     along with this program.  If not, see <http://www.gnu.org/licenses/>.
 ******************************************************************************/
package org.craftercms.cstudio.alfresco.content.pipeline.api;

import org.craftercms.cstudio.alfresco.service.exception.ContentProcessException;
import org.craftercms.cstudio.alfresco.to.ResultTO;

/**
 * interface for processing wcm content upon creating or updating the content
 * 
 * @author hyanghee
 *
 */
public interface ContentProcessor {

	/**
	 * process the content at the given path. 
	 * 
	 * @param content
	 * 			content to process
	 * @param result 
	 * 			result to return
	 * @throws ContentProcessException 
	 */
	public void process(PipelineContent content, ResultTO result) throws ContentProcessException;
	
	/**
	 * determines if the content is processable by the given parameters
	 * 
	 * @param content
	 */
	public boolean isProcessable(PipelineContent content);

	/**
	 * get the name of this processor
	 * 
	 * @return processor name
	 */
	public String getName();
	
}
