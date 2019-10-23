/*
 * Copyright (C) 2016-2019 the original author or authors. 
 * 
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <https://www.gnu.org/licenses/>.
 */

package com.viglet.turing.onstartup;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.viglet.turing.onstartup.system.TurConfigVarOnStartup;
import com.viglet.turing.onstartup.xmpp.TurXMPPStartup;
import com.viglet.turing.persistence.repository.system.TurConfigVarRepository;

@Component
@Transactional
public class TurOnStartup implements ApplicationRunner {

	@Autowired
	private TurConfigVarRepository turConfigVarRepository;
	@Autowired
	private TurXMPPStartup turXMPPStartup;
	@Autowired
	private TurConfigVarOnStartup turConfigVarOnStartup;
	@Override
	public void run(ApplicationArguments arg0) throws Exception {
		final String FIRST_TIME = "FIRST_TIME";

		if (!turConfigVarRepository.findById(FIRST_TIME).isPresent()) {

			System.out.println("First Time Configuration ...");

			turXMPPStartup.createDefaultRows();
			turConfigVarOnStartup.createDefaultRows();

			System.out.println("Configuration finished.");
		}

	}

}