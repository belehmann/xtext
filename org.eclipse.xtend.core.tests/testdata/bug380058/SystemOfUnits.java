/*******************************************************************************
 * Copyright (c) 2013 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package bug380058;

import java.util.Set;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
public abstract class SystemOfUnits {
	public abstract Set<Unit<?>> getUnits();
}
