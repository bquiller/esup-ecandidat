/**
 *  ESUP-Portail eCandidat - Copyright (c) 2016 ESUP-Portail consortium
 *
 *
 *  Licensed under the Apache License, Version 2.0 (the "License");
 *  you may not use this file except in compliance with the License.
 *  You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 *  Unless required by applicable law or agreed to in writing, software
 *  distributed under the License is distributed on an "AS IS" BASIS,
 *  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *  See the License for the specific language governing permissions and
 *  limitations under the License.
 */
package fr.univlorraine.ecandidat.utils.bean.export;

import java.io.Serializable;

import fr.univlorraine.ecandidat.entities.ecandidat.DroitProfilInd;
import lombok.Data;

/**
 * Objet contenant les infos d'un membre pour l'export
 *
 * @author Kevin Hergalant
 */
@Data
@SuppressWarnings("serial")
public class ExportMembre implements Serializable {

	private String nomPrenom;
	private String profil;
	private String libCommission;

	public ExportMembre() {
		super();
	}

	public ExportMembre(final DroitProfilInd droitProfil) {
		super();
		nomPrenom = droitProfil.getIndividu().getLibelleInd();
		profil = droitProfil.getDroitProfil().getLibProfil();
	}
}
