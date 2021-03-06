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
package fr.univlorraine.ecandidat.utils.bean.mail;

import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * Class pour l'envoie de mail pôur les compteMinima
 * 
 * @author Kevin
 */
@Data
@EqualsAndHashCode(callSuper = false)
@SuppressWarnings("serial")
public class CptMinMailBean extends MailBean {

	private String prenom;
	private String nom;
	private String numDossierOpi;
	private String password;
	private String lienValidation;
	private String libelleCampagne;
	private String jourDestructionCptMin;

	public CptMinMailBean(final String prenom, final String nom,
			final String numDossierOpi, final String password, final String lienValidation,
			final String libelleCampagne, final String jourDestructionCptMin) {
		super();
		this.prenom = prenom;
		this.nom = nom;
		this.numDossierOpi = numDossierOpi;
		this.password = password;
		this.lienValidation = lienValidation;
		this.libelleCampagne = libelleCampagne;
		this.jourDestructionCptMin = jourDestructionCptMin;
	}
}
